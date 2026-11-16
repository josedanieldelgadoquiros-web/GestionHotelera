package controlador;

import registros.modelo.GestorHotel;



public class ControladorInicioSesion {
      private GestorHotel gestor;

    public ControladorInicioSesion() {
        gestor = GestorHotel.getInstancia();
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        return gestor.iniciarSesion(usuario, contrasena);
    }

    public void cerrarSesion() {
        gestor.cerrarSesion();
    }
}

