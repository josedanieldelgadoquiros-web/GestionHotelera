/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.controlador;

import java.util.ArrayList;
import registros.modelo.GestorHotel;
import registros.modelo.Huesped;

/**
 *
 * @author MarcoR
 */
public class RegistroControlador {
    public boolean agregarHuesped(String identificacion, String nombre, String telefono, String correo) {
        Huesped nuevoHuesped = new Huesped(identificacion, nombre, telefono, correo);

        if (nuevoHuesped.esValido() == false) {
            return false;
        }

        return GestorHotel.getInstancia().agregarHuesped(nuevoHuesped);
    }

    public ArrayList<Huesped> obtenerHuespedes() {
        return GestorHotel.getInstancia().getHuespedes();
    }
    
}