/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.modelo;

/**
 *
 * @author MarcoR
 */
public class HabitacionDoble extends Habitacion {
    
    public HabitacionDoble(String numero) {
        super(numero);
    }
    @Override
    public String getTipo() {
        return "Doble";
    }

    @Override
    public int getCapacidadMaxima() {
        return 2;
    }

    @Override
    public long getTarifaPorNoche() {
        return 40000L;
    }
}
