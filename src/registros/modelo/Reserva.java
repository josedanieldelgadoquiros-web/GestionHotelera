/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.modelo;

import java.time.LocalDate;

/**
 *
 * @author MarcoR
 */
public class Reserva {
    private String idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoReserva estado;

    public Reserva(String idReserva, Huesped huesped, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin, EstadoReserva estado) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoReserva.ACTIVA;
        
        private void validarFechas(LocalDate inicio, LocalDate fin) {
        if (inicio == null || fin == null) {
            throw new IllegalArgumentException("Las fechas de la reserva no pueden ser nulas.");
        }
        if (fin.isBefore(inicio) || fin.isEqual(inicio)) {
            throw new IllegalArgumentException("La fecha de salida debe ser estrictamente posterior a la de entrada.");
        }
    }
    }
    
    
    
}
