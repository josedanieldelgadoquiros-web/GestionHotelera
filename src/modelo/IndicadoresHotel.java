package modelo;

/**
 *
 * @author ElectrickS
 */
public class IndicadoresHotel {
    
    private int totalHabitaciones;
    private int habitacionesOcupadas;
    private int habitacionesNoOcupadas;
    private int reservasConfirmadas;
    private int reservasVencidas;
    private long ingresosEsperados;

    public IndicadoresHotel(int totalHabitaciones, int habitacionesOcupadas,
            int habitacionesNoOcupadas, int reservasConfirmadas,
            int reservasVencidas, long ingresosEsperados) {

        this.totalHabitaciones = totalHabitaciones;
        this.habitacionesOcupadas = habitacionesOcupadas;
        this.habitacionesNoOcupadas = habitacionesNoOcupadas;
        this.reservasConfirmadas = reservasConfirmadas;
        this.reservasVencidas = reservasVencidas;
        this.ingresosEsperados = ingresosEsperados;
    }

    public int getTotalHabitaciones() {
        return totalHabitaciones;
    }

    public int getHabitacionesOcupadas() {
        return habitacionesOcupadas;
    }

    public int getHabitacionesNoOcupadas() {
        return habitacionesNoOcupadas;
    }

    public int getReservasConfirmadas() {
        return reservasConfirmadas;
    }

    public int getReservasVencidas() {
        return reservasVencidas;
    }

    public long getIngresosEsperados() {
        return ingresosEsperados;
    }
}

