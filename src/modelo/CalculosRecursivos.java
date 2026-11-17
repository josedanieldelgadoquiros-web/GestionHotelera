package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import registros.modelo.EstadoReserva;
import registros.modelo.Habitacion;
import registros.modelo.Reserva;

public class CalculosRecursivos {
    public long calcularIngresosEsperados(ArrayList<Reserva> reservas) {
        return sumarIngresos(reservas, 0);
    }

    private long sumarIngresos(ArrayList<Reserva> reservas, int posicion) {
        if (posicion == reservas.size()) {
            return 0;
        }

        Reserva reserva = reservas.get(posicion);
        long ingreso = 0;

        if (reserva.getEstado() == EstadoReserva.CONFIRMADA) {
            ingreso = reserva.getCostoTotal();
        }

        return ingreso + sumarIngresos(reservas, posicion + 1);
    }

    public int contarHabitacionesDisponibles(
            ArrayList<Habitacion> habitaciones,
            ArrayList<Reserva> reservas,
            LocalDate fecha) {

        return contarDisponibles(habitaciones, reservas, fecha, 0);
    }

    private int contarDisponibles(
            ArrayList<Habitacion> habitaciones,
            ArrayList<Reserva> reservas,
            LocalDate fecha,
            int posicion) {

        if (posicion == habitaciones.size()) {
            return 0;
        }

        int disponible = 0;

        if (estaDisponible(habitaciones.get(posicion), reservas, fecha)) {
            disponible = 1;
        }

        return disponible
                + contarDisponibles(habitaciones, reservas, fecha, posicion + 1);
    }

    public boolean estaDisponible(
            Habitacion habitacion,
            ArrayList<Reserva> reservas,
            LocalDate fecha) {

        for (Reserva reserva : reservas) {
            boolean bloquea = reserva.getEstado() == EstadoReserva.CONFIRMADA
                    || reserva.getEstado() == EstadoReserva.HOSPEDADO;

            boolean mismaHabitacion = reserva.getHabitacion().getNumero()
                    .equals(habitacion.getNumero());

            boolean ocupaFecha = !fecha.isBefore(reserva.getFechaInicio())
                    && fecha.isBefore(reserva.getFechaFin());

            if (bloquea && mismaHabitacion && ocupaFecha) {
                return false;
            }
        }

        return true;
    }
}
