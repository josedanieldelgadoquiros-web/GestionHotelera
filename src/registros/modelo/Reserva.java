/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registros.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    
    public Reserva(String idReserva, Huesped huesped, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        validarFechas(fechaInicio, fechaFin);
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoReserva.ACTIVA;
    }
    private void validarFechas(LocalDate inicio, LocalDate fin) {
        if (inicio == null || fin == null) {
            throw new IllegalArgumentException("Las fechas de la reserva no pueden estar vacías.");
        }
        
        if (fin.isBefore(inicio) || fin.isEqual(inicio)) {
            throw new IllegalArgumentException("La fecha de salida debe ser mayor a la fecha de entrada.");
        }
    }
    public int calcularNoches() {
        long diasLargo = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        int dias = (int) diasLargo;
        return dias;
    }
    public int calcularCostoTotal() {
        int cantidadNoches = calcularNoches();
        int tarifaPorNoche = (int) habitacion.getTarifaPorNoche();
        int total = cantidadNoches * tarifaPorNoche;
        return total;
}

    public String getIdReserva() {
        return idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public EstadoReserva getEstado() {
        return estado;
    }
    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
}
