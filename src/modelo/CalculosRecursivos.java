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
        long importe = 0;

        if (reserva.getEstado() == EstadoReserva.CONFIRMADA) {
            importe = reserva.getImporteTotal();
        }

        return importe + sumarIngresos(reservas, posicion + 1);
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

        Habitacion habitacion = habitaciones.get(posicion);
        int cantidad = 0;

        if (estaDisponible(habitacion, reservas, fecha)) {
            cantidad = 1;
        }

        return cantidad + contarDisponibles(
                habitaciones, reservas, fecha, posicion + 1);
    }

    private boolean estaDisponible(Habitacion habitacion,
            ArrayList<Reserva> reservas, LocalDate fecha) {

        for (Reserva reserva : reservas) {
            boolean bloquea = reserva.getEstado() == EstadoReserva.CONFIRMADA
                    || reserva.getEstado() == EstadoReserva.HOSPEDADO;

            boolean mismaHabitacion =
                    String.valueOf(reserva.getHabitacion().getNumero())
                    .equals(String.valueOf(habitacion.getNumero()));

            boolean ocupaLaFecha = !fecha.isBefore(reserva.getFechaEntrada())
                    && fecha.isBefore(reserva.getFechaSalida());

            if (bloquea && mismaHabitacion && ocupaLaFecha) {
                return false;
            }
        }

        return true;
    }
}
