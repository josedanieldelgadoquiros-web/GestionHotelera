package controlador;

import hilos.SupervisorReservas;
import java.time.LocalDate;
import registros.modelo.GestorHotel;

public class ControladorInicioSesion {

    private GestorHotel gestor;

    public ControladorInicioSesion() {
        gestor = GestorHotel.getInstancia();
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        boolean recepcionistaUno = "recepcion1".equals(usuario)
                && "Hotel123".equals(contrasena);
        boolean recepcionistaDos = "recepcion2".equals(usuario)
                && "Hotel456".equals(contrasena);

        if (!recepcionistaUno && !recepcionistaDos) {
            return false;
        }

        synchronized (gestor) {
            gestor.setUsuarioActivo(usuario);
        }

        SupervisorReservas supervisor = new SupervisorReservas(gestor);
        int vencidas = supervisor.revisarVencidas(LocalDate.now());
        System.out.println("Sesión iniciada: " + usuario
                + ". Reservas vencidas: " + vencidas);
        return true;
    }

    public void cerrarSesion() {
        synchronized (gestor) {
            gestor.setUsuarioActivo("");
        }
    }

    public String getUsuarioActivo() {
        synchronized (gestor) {
            return gestor.getUsuarioActivo();
        }
    }
}

