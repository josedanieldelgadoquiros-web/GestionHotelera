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
    private int cantidadPersonas;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private LocalDate fechaSalidaReal;
    private int cantidadNoches;
    private long importeTotal;
    private EstadoReserva estado;
    private String recepcionista;

    public Reserva(Huesped huesped, Habitacion habitacion, int cantidadPersonas,
            LocalDate fechaEntrada, LocalDate fechaSalida, String recepcionista) {

        this.idReserva = "RES-" + contadorId;
        contadorId = contadorId + 1;

        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.fechaSalidaReal = null;

        this.cantidadNoches = (int) ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        this.importeTotal = this.cantidadNoches * habitacion.getTarifaPorNoche();

        this.estado = EstadoReserva.CONFIRMADA;
        this.recepcionista = recepcionista;
    }

    public boolean esValida() {
        if (huesped == null) {
            return false;
        }
        if (habitacion == null) {
            return false;
        }
        if (fechaEntrada == null || fechaSalida == null) {
            return false;
        }
        if (fechaEntrada.compareTo(LocalDate.now()) < 0) {
            return false;
        }
        if (fechaSalida.compareTo(fechaEntrada) <= 0) {
            return false;
        }
        if (cantidadPersonas <= 0) {
            return false;
        }
        if (cantidadPersonas > habitacion.getCapacidadMaxima()) {
            return false;
        }
        if (recepcionista == null || recepcionista.trim().equals("")) {
            return false;
        }
        return true;
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

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public LocalDate getFechaSalidaReal() {
        return fechaSalidaReal;
    }

    public void registrarSalidaReal(LocalDate fecha) {
        this.fechaSalidaReal = fecha;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public long getImporteTotal() {
        return importeTotal;
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

    public String toString() {
        return idReserva + " - " + huesped.getNombreCompleto() + " (" + habitacion.getNumero() + ") " + estado;
    }
}