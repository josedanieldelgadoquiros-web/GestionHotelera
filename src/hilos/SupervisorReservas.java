package hilos;

import java.time.LocalDate;
import registros.modelo.GestorHotel;


/**
 *
 * @author ElectrickS
 */
public class SupervisorReservas implements Runnable {
    private GestorHotel gestor;

    public SupervisorReservas(GestorHotel gestor) {
        this.gestor = gestor;
    }

    public int revisarVencidas(LocalDate fecha) {
        return gestor.actualizarReservasVencidas(fecha);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": inicia la revisión de reservas");

        for (int ciclo = 1; ciclo <= 5; ciclo++) {
            int cantidad = revisarVencidas(LocalDate.now());

            System.out.println(Thread.currentThread().getName() + ": vuelta " + ciclo + " de 5. Vencidas: " + cantidad);

            if (ciclo < 5) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {Thread.currentThread().interrupt();
                    System.out.println("Se detuvo la revisión de reservas");
                    return;
                }
            }
        }

        System.out.println(Thread.currentThread().getName()+ ": terminó la revisión de reservas");
    }
    
}
