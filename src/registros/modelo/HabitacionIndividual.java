/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.modelo;

/**
 *
 * @author MarcoR
 */
public class HabitacionIndividual extends Habitacion {
    public HabitacionIndividual(String numero) {
        super(numero);
    }

    @Override
    public String getTipo() {
        return "Individual";
    }

    @Override
    public int getCapacidadMaxima() {
        return 1;
    }

    @Override
    public long getTarifaPorNoche() {
        return 25000; 
    }
}