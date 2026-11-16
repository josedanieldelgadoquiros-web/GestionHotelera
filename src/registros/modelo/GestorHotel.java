/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MarcoR
 */
public class GestorHotel {
    private static GestorHotel instancia;
    
    private List<Habitacion> habitaciones;
    private List<Huesped> huespedes;
    private List<Reserva> reservas;
    private String usuarioActivo;

    private GestorHotel() {
        this.habitaciones = new ArrayList<>();
        this.huespedes = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.usuarioActivo = "";
    }

    public static GestorHotel getInstancia() {
        if (instancia == null) {
            instancia = new GestorHotel();
        }
        return instancia;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void agregarHuesped(Huesped huesped) {
        huespedes.add(huesped);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public String getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(String usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
}