/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.modelo;

/**
 *
 * @author MarcoR
 */
public class HabitacionFactory {
        public static Habitacion crearHabitacion(String tipo, String numero) {
        if (tipo == null) {
            return null;
        }
        
        String tipoMinuscula = tipo.toLowerCase();
        
        if (tipoMinuscula.equals("individual")) {
            Habitacion habitacion = new HabitacionIndividual(numero);
            return habitacion;
        } else {
            if (tipoMinuscula.equals("doble")) {
                Habitacion habitacion = new HabitacionDoble(numero);
                return habitacion;
            } else {
                if (tipoMinuscula.equals("familiar")) {
                    Habitacion habitacion = new HabitacionFamiliar(numero);
                    return habitacion;
                } else {
                    return null;
                }
            }
        }
        }
}

