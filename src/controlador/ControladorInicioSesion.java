package controlador;

import hilos.SupervisorReservas;
import java.time.LocalDate;
import registros.modelo.GestorHotel;

/**
 *
 * @author ElectrickS
 */
public class ControladorInicioSesion {

    private GestorHotel gestor;

    public ControladorInicioSesion() {
        gestor = GestorHotel.getInstancia();
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
       if (usuario == null || contrasena == null) {
    return false;
       } synchronized (gestor) {
    if (!gestor.iniciarSesion(usuario, contrasena)) {
        return false;
    }

    int vencidas = gestor.actualizarReservasVencidas(LocalDate.now());

    System.out.println("Sesión iniciada: " + usuario
            + ". Reservas vencidas: " + vencidas);

    return true;
}
    }

    public void cerrarSesion() {
         synchronized (gestor) {
        gestor.cerrarSesion();
    }
}

public String getUsuarioActivo() {
    synchronized (gestor) {
        return gestor.getUsuarioActivo();
    }
}

}


