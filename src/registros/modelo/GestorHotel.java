/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author MarcoR
 */
public class GestorHotel {
    private static GestorHotel instancia;

    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Huesped> huespedes;
    private ArrayList<Reserva> reservas;
    private String usuarioActivo;

    private GestorHotel() {
        habitaciones = new ArrayList<>();
        huespedes = new ArrayList<>();
        reservas = new ArrayList<>();
        usuarioActivo = "";
    }

    public static synchronized GestorHotel getInstancia() {
        if (instancia == null) {
            instancia = new GestorHotel();
        }
        return instancia;
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        if (usuario.equals("recepcion1") && contrasena.equals("Hotel123")) {
            usuarioActivo = usuario;
            return true;
        }
        if (usuario.equals("recepcion2") && contrasena.equals("Hotel456")) {
            usuarioActivo = usuario;
            return true;
        }
        return false;
    }

    public void cerrarSesion() {
        usuarioActivo = "";
    }

    public String getUsuarioActivo() {
        return usuarioActivo;
    }

    public synchronized boolean existeHuesped(String identificacion) {
        for (int i = 0; i < huespedes.size(); i++) {
            Huesped h = huespedes.get(i);
            if (h.getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean agregarHuesped(Huesped huesped) {
        if (existeHuesped(huesped.getIdentificacion())) {
            return false;
        }
        huespedes.add(huesped);
        return true;
    }

    public synchronized boolean existeHabitacion(String numero) {
        for (int i = 0; i < habitaciones.size(); i++) {
            Habitacion hab = habitaciones.get(i);
            if (hab.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean agregarHabitacion(Habitacion habitacion) {
        if (existeHabitacion(habitacion.getNumero())) {
            return false;
        }
        habitaciones.add(habitacion);
        return true;
    }

    public synchronized boolean seSolapan(Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);

            if (r.getHabitacion().getNumero().equals(habitacion.getNumero())) {
                if (r.getEstado() == EstadoReserva.CONFIRMADA || r.getEstado() == EstadoReserva.HOSPEDADO) {
                    if (fechaEntrada.compareTo(r.getFechaSalida()) < 0 && fechaSalida.compareTo(r.getFechaEntrada()) > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public synchronized boolean agregarReserva(Reserva reserva) {
        if (reserva.esValida() == false) {
            return false;
        }
        if (seSolapan(reserva.getHabitacion(), reserva.getFechaEntrada(), reserva.getFechaSalida())) {
            return false;
        }
        reservas.add(reserva);
        return true;
    }

    public synchronized int actualizarReservasVencidas(LocalDate fechaActual) {
        int cantidad = 0;
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            if (r.getEstado() == EstadoReserva.CONFIRMADA && r.getFechaEntrada().compareTo(fechaActual) < 0) {
                r.setEstado(EstadoReserva.VENCIDA);
                cantidad = cantidad + 1;
            }
        }
        return cantidad;
    }

    public synchronized Reserva buscarReservaPorCodigo(String codigo) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            if (r.getIdReserva().equals(codigo)) {
                return r;
            }
        }
        return null;
    }

    public synchronized boolean realizarCheckIn(String codigoReserva, LocalDate fechaActual) {
        Reserva reserva = buscarReservaPorCodigo(codigoReserva);

        if (reserva == null) {
            return false;
        }
        if (reserva.getEstado() != EstadoReserva.CONFIRMADA) {
            return false;
        }
        if (reserva.getFechaEntrada().compareTo(fechaActual) != 0) {
            return false;
        }

        reserva.setEstado(EstadoReserva.HOSPEDADO);
        return true;
    }

    public synchronized boolean realizarCheckOut(String codigoReserva, LocalDate fechaActual) {
        Reserva reserva = buscarReservaPorCodigo(codigoReserva);

        if (reserva == null) {
            return false;
        }
        if (reserva.getEstado() != EstadoReserva.HOSPEDADO) {
            return false;
        }

        reserva.registrarSalidaReal(fechaActual);
        reserva.setEstado(EstadoReserva.FINALIZADA);
        return true;
    }

    public synchronized ArrayList<Habitacion> getHabitaciones() {
        ArrayList<Habitacion> copia = new ArrayList<>();
        copia.addAll(habitaciones);
        return copia;
    }

    public synchronized ArrayList<Huesped> getHuespedes() {
        ArrayList<Huesped> copia = new ArrayList<>();
        copia.addAll(huespedes);
        return copia;
    }

    public synchronized ArrayList<Reserva> getReservas() {
        ArrayList<Reserva> copia = new ArrayList<>();
        copia.addAll(reservas);
        return copia;
    }
}