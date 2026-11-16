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
    private static int contadorId = 1;
    
    private String idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidadDias;
    private int costoTotal;
    private EstadoReserva estado;
    private String recepcionista; 

    public Reserva(Huesped huesped, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin, String recepcionista) {
        this.idReserva = "RES-" + contadorId++; 
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadDias = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        this.costoTotal = this.cantidadDias * (int) habitacion.getTarifaPorNoche();
        this.estado = EstadoReserva.CONFIRMADA;
        this.recepcionista = recepcionista;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public String getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(String recepcionista) {
        this.recepcionista = recepcionista;
    }
}