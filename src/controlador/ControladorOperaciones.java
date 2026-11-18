package controlador;

import hilos.ActualizadorIndicadores;
import hilos.SupervisorReservas;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.CalculosRecursivos;
import modelo.IndicadoresHotel;
import registros.modelo.GestorHotel;
import registros.modelo.Habitacion;
import registros.modelo.Reserva;

public class ControladorOperaciones {

    private GestorHotel gestor;
    private CalculosRecursivos calculos;
    private ActualizadorIndicadores actualizador;
    private Thread hiloSupervisor;
    private Thread hiloIndicadores;

    public ControladorOperaciones() {
        gestor = GestorHotel.getInstancia();
        calculos = new CalculosRecursivos();
    }

    public int consultarCantidadDisponible(LocalDate fecha) {
        synchronized (gestor) {
            return calculos.contarHabitacionesDisponibles(
                    gestor.getHabitaciones(), gestor.getReservas(), fecha);
        }
    }

    public String consultarNumerosDisponibles(LocalDate fecha) {
        String numeros = "";
        synchronized (gestor) {
            ArrayList<Reserva> reservas = gestor.getReservas();
            for (Habitacion habitacion : gestor.getHabitaciones()) {
                if (calculos.estaDisponible(habitacion, reservas, fecha)) {
                    if (!numeros.equals("")) {
                        numeros = numeros + ", ";
                    }
                    numeros = numeros + habitacion.getNumero();
                }
            }
        }
        return numeros;
    }

    public String buscarReserva(String codigo) {
        synchronized (gestor) {
            Reserva reserva = gestor.buscarReservaPorCodigo(codigo);
            if (reserva == null) {
                return "No se encontró la reserva.";
            }
            return reserva.toString();
        }
    }

    public boolean hacerCheckIn(String codigo) {
        return gestor.realizarCheckIn(codigo, LocalDate.now());
    }

    public boolean hacerCheckOut(String codigo) {
        return gestor.realizarCheckOut(codigo, LocalDate.now());
    }

    public synchronized boolean ejecutarProcesos() {
        if (procesosActivos()) {
            return false;
        }
        SupervisorReservas supervisor = new SupervisorReservas(gestor);
        hiloSupervisor = new Thread(supervisor, "SupervisorReservas");
        actualizador = new ActualizadorIndicadores(gestor, hiloSupervisor);
        hiloIndicadores = new Thread(actualizador, "ActualizadorIndicadores");
        hiloSupervisor.start();
        hiloIndicadores.start();
        return true;
    }

    public synchronized boolean procesosActivos() {
        if (hiloSupervisor != null && hiloSupervisor.isAlive()) {
            return true;
        }
        if (hiloIndicadores != null && hiloIndicadores.isAlive()) {
            return true;
        }
        return false;
    }

    public IndicadoresHotel getIndicadores() {
        if (actualizador == null) {
            return null;
        }
        return actualizador.getIndicadores();
    }
}
