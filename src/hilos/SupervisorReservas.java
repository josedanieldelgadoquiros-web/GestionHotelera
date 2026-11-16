package hilos;

import java.time.LocalDate;
import registros.modelo.GestorHotel;


public class SupervisorReservas implements Runnable {
    public SupervisorReservas(GestorHotel gestor) {
        this.gestor = gestor;
    }

    @Override
    public void run() {
        System.out.println("Inicia la revisión de reservas vencidas");

        for (int ciclo = 1; ciclo <= 5; ciclo++) {
            int cantidad = gestor.actualizarReservasVencidas(LocalDate.now());

            System.out.println("Revisando reservas, vuelta " + ciclo
                    + " de 5. Se actualizaron " + cantidad + " reservas");

            if (ciclo < 5) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Se detuvo la revisión de reservas");
                    return;
                }
            }
        }

        System.out.println("Terminó la revisión de reservas vencidas");
    }
    
}
