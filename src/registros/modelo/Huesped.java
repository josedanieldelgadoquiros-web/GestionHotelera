/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.modelo;

/**
 *
 * @author MarcoR
 */
public class Huesped {
    private String identificacion;
    private String nombreCompleto;
    private String telefono;
    private String correo;

    public Huesped(String identificacion, String nombre, String telefono, String correo) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public boolean esValido() {
        if (identificacion == null || identificacion.isEmpty()) {
            return false;
        }
        if (nombreCompleto == null || nombreCompleto.isEmpty()) {
            return false;
        }
        if (telefono == null || telefono.isEmpty()) {
            return false;
        }
        if (correo == null || correo.isEmpty()) {
            return false;
        }
        if (correoTieneFormatoValido() == false) {
            return false;
        }
        return true;
    }

    public boolean correoTieneFormatoValido() {
        int cantidadArrobas = 0;
        int posicionArroba = -1;

        for (int i = 0; i < correo.length(); i++) {
            char letra = correo.charAt(i);
            if (letra == '@') {
                cantidadArrobas = cantidadArrobas + 1;
                posicionArroba = i;
            }
        }

        if (cantidadArrobas != 1) {
            return false;
        }
        if (posicionArroba == 0) {
            return false;
        }
        if (posicionArroba == correo.length() - 1) {
            return false;
        }

        boolean tienePuntoDespues = false;
        for (int i = posicionArroba + 1; i < correo.length(); i++) {
            char letra = correo.charAt(i);
            if (letra == '.') {
                tienePuntoDespues = true;
            }
        }

        if (tienePuntoDespues == false) {
            return false;
        }

        return true;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return identificacion + " - " + nombreCompleto;
    }
}