package hilos;

public class ActualizadorIndicadores implements Runnable {
     @Override
    public void run() {
        System.out.println("Inicia la actualización de los indicadores");

        for (int ciclo = 1; ciclo <= 5; ciclo++) {
            System.out.println("Actualizando indicadores, vuelta " + ciclo + " de 5");

            if (ciclo < 5) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Se detuvo la actualización de los indicadores");
                    return;
                }
            }
        }

        System.out.println("Terminó la actualización de los indicadores");
    }
}
