/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import registros.modelo.GestorHotel;
import registros.modelo.Habitacion;
import registros.modelo.HabitacionFactory;
import registros.modelo.Huesped;
import registros.modelo.Reserva;

/**
 *
 * @author MarcoR
 */
public class ReservaControlador {
    public Habitacion crearHabitacion(String tipo, String numero) {
        return HabitacionFactory.crearHabitacion(tipo, numero);
    }

    public boolean registrarHabitacion(String tipo, String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            return false;
        }

        Habitacion nuevaHabitacion = crearHabitacion(tipo, numero.trim());

        if (nuevaHabitacion == null) {
            return false;
        }

        return GestorHotel.getInstancia().agregarHabitacion(nuevaHabitacion);
    }

    public boolean registrarReserva(Huesped huesped, Habitacion habitacion, int cantidadPersonas,
            LocalDate fechaEntrada, LocalDate fechaSalida, String recepcionista) {

        if (huesped == null || habitacion == null
                || fechaEntrada == null || fechaSalida == null) {
            return false;
        }

        Reserva nuevaReserva = new Reserva(huesped, habitacion, cantidadPersonas,
                fechaEntrada, fechaSalida, recepcionista);

        return GestorHotel.getInstancia().agregarReserva(nuevaReserva);
    }

    public ArrayList<Habitacion> obtenerHabitaciones() {
        return GestorHotel.getInstancia().getHabitaciones();
    }

    public ArrayList<Reserva> obtenerReservas() {
        return GestorHotel.getInstancia().getReservas();
    }
    public String obtenerUsuarioActivo() {
    return registros.modelo.GestorHotel.getInstancia().getUsuarioActivo();
}
}
