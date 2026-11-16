package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import modelo.CalculosRecursivos;
import registros.modelo.Habitacion;
import registros.modelo.Reserva;

public class ControladorOperaciones {
    
    private CalculosRecursivos calculos;

    public ControladorOperaciones() {
        calculos = new CalculosRecursivos();
    }

    public int consultarCantidadDisponible(
            ArrayList<Habitacion> habitaciones,
            ArrayList<Reserva> reservas,
            LocalDate fecha) {

        return calculos.contarHabitacionesDisponibles(
                habitaciones, reservas, fecha);
    }

    public long consultarIngresosEsperados(ArrayList<Reserva> reservas) {
        return calculos.calcularIngresosEsperados(reservas);
    }

    
}
