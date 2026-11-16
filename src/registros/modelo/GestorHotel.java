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

    public static GestorHotel getInstancia() {
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

    public boolean existeHuesped(String identificacion) {
        for (int i = 0; i < huespedes.size(); i++) {
            Huesped h = huespedes.get(i);
            if (h.getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarHuesped(Huesped huesped) {
        if (existeHuesped(huesped.getIdentificacion())) {
            return false;
        }
        huespedes.add(huesped);
        return true;
    }

    public boolean existeHabitacion(String numero) {
        for (int i = 0; i < habitaciones.size(); i++) {
            Habitacion hab = habitaciones.get(i);
            if (hab.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarHabitacion(Habitacion habitacion) {
        if (existeHabitacion(habitacion.getNumero())) {
            return false;
        }
        habitaciones.add(habitacion);
        return true;
    }

    public boolean seSolapan(Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
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

    public boolean agregarReserva(Reserva reserva) {
        if (reserva.esValida() == false) {
            return false;
        }
        if (seSolapan(reserva.getHabitacion(), reserva.getFechaEntrada(), reserva.getFechaSalida())) {
            return false;
        }
        reservas.add(reserva);
        return true;
    }

    public int actualizarReservasVencidas(LocalDate fechaActual) {
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

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}