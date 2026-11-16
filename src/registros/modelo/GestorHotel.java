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
    private List<Habitacion> habitaciones;
    private List<Huesped> huespedes;
    private List<Reserva> reservas;
    
    public GestorHotel() {
        this.habitaciones = new ArrayList<>();
        this.huespedes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    public void agregarHabitacion(Habitacion habitacion) {
        if (habitacion != null) {
            habitaciones.add(habitacion);
        }
    }
        public void registrarHuesped(Huesped huesped) {
        if (huesped != null) {
            huespedes.add(huesped);
        }
}
        public void agregarReserva(Reserva reserva) {
        if (reserva != null) {
            reservas.add(reserva);
        }
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
        
}
