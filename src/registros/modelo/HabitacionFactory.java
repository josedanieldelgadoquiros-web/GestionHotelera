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
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar un tipo de habitación.");
        }
        switch (tipo.trim().toLowerCase()) {
            case "individual":
                return new HabitacionIndividual(numero);
            case "doble":
                return new HabitacionDoble(numero);
            case "familiar":
                return new HabitacionFamiliar(numero);
            default:
                throw new IllegalArgumentException("Tipo de habitación no válido: " + tipo);
        }
    }
}
