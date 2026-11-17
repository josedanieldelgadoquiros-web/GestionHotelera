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
    
    private CalculosRecursivos calculos;
    private GestorHotel gestor;
    private ActualizadorIndicadores actualizador;
    private Thread hiloSupervisor;
    private Thread hiloIndicadores;

    public ControladorOperaciones() {
        calculos = new CalculosRecursivos();
        gestor = GestorHotel.getInstancia();
    }

    public int consultarCantidadDisponible(
            ArrayList<Habitacion> habitaciones,
            ArrayList<Reserva> reservas,
            LocalDate fecha) {

        return calculos.contarHabitacionesDisponibles(
                habitaciones, reservas, fecha);
    }

    public synchronized boolean ejecutarProcesos() {
        if (hiloSupervisor != null && hiloSupervisor.isAlive()) {
            return false;
        }

        if (hiloIndicadores != null && hiloIndicadores.isAlive()) {
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

    public IndicadoresHotel getIndicadores() {
        if (actualizador == null) {
            return null;
        }
        return actualizador.getIndicadores();
    }
}
