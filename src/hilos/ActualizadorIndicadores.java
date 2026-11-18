package hilos;

import java.util.ArrayList;
import modelo.CalculosRecursivos;
import modelo.IndicadoresHotel;
import registros.modelo.EstadoReserva;
import registros.modelo.GestorHotel;
import registros.modelo.Habitacion;
import registros.modelo.Reserva;

/**
 *
 * @author ElectrickS
 */
public class ActualizadorIndicadores implements Runnable {

    private GestorHotel gestor;
    private Thread hiloSupervisor;
    private CalculosRecursivos calculos;
    private IndicadoresHotel indicadores;

    public ActualizadorIndicadores(GestorHotel gestor, Thread hiloSupervisor) {
        this.gestor = gestor;
        this.hiloSupervisor = hiloSupervisor;
        this.calculos = new CalculosRecursivos();
    }

    public synchronized IndicadoresHotel getIndicadores() {
        return indicadores;
    }

    public IndicadoresHotel calcularAhora() {
        synchronized (gestor) {
            ArrayList<Habitacion> habitaciones =
                    new ArrayList<>(gestor.getHabitaciones());
            ArrayList<Reserva> reservas =
                    new ArrayList<>(gestor.getReservas());

            int ocupadas = 0;
            int confirmadas = 0;
            int vencidas = 0;

            for (Habitacion habitacion : habitaciones) {
                for (Reserva reserva : reservas) {
                    if (reserva.getEstado() == EstadoReserva.HOSPEDADO
                            && reserva.getHabitacion().getNumero()
                                    .equals(habitacion.getNumero())) {
                        ocupadas++;
                        break;
                    }
                }
            }

            for (Reserva reserva : reservas) {
                if (reserva.getEstado() == EstadoReserva.CONFIRMADA) {
                    confirmadas++;
                } else if (reserva.getEstado() == EstadoReserva.VENCIDA) {
                    vencidas++;
                }
            }

            long ingresos = calculos.calcularIngresosEsperados(reservas);
            IndicadoresHotel nuevosIndicadores = new IndicadoresHotel(
                    habitaciones.size(), ocupadas,
                    habitaciones.size() - ocupadas,
                    confirmadas, vencidas, ingresos);

            synchronized (this) {
                indicadores = nuevosIndicadores;
            }

            return nuevosIndicadores;
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + ": inicia la actualización de indicadores");

        for (int ciclo = 1; ciclo <= 5; ciclo++) {
            calcularAhora();
            System.out.println(Thread.currentThread().getName()
                    + ": vuelta " + ciclo + " de 5 completada");

            if (ciclo < 5) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println("Se detuvo la actualización de indicadores");
                    return;
                }
            }
        }

        try {
            hiloSupervisor.join();
            calcularAhora();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Se detuvo la actualización de indicadores");
            return;
        }

        System.out.println(Thread.currentThread().getName()
                + ": terminó la actualización de indicadores");
    }
}
