package vista;

import controlador.ControladorOperaciones;
import modelo.IndicadoresHotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PanelIndicadoresHotel extends javax.swing.JPanel {
    private ControladorOperaciones controlador;
private Timer reloj;

    public PanelIndicadoresHotel() {
        initComponents();
        controlador = new ControladorOperaciones();
    }
    private void mostrarIndicadores() {
    IndicadoresHotel datos = controlador.getIndicadores();

    if (datos == null) {
        return;
    }

    lblTotalValor.setText("" + datos.getTotalHabitaciones());
    lblOcupadasValor.setText("" + datos.getHabitacionesOcupadas());
    lblDisponiblesValor.setText("" + datos.getHabitacionesNoOcupadas());
    lblConfirmadasValor.setText("" + datos.getReservasConfirmadas());
    lblVencidasValor.setText("" + datos.getReservasVencidas());
    lblIngresosValor.setText("" + datos.getIngresosEsperados());
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblTotalTexto = new javax.swing.JLabel();
        lblTotalValor = new javax.swing.JLabel();
        lblOcupadasTexto = new javax.swing.JLabel();
        lblOcupadasValor = new javax.swing.JLabel();
        lblDisponiblesTexto = new javax.swing.JLabel();
        lblDisponiblesValor = new javax.swing.JLabel();
        lblConfirmadasTexto = new javax.swing.JLabel();
        lblConfirmadasValor = new javax.swing.JLabel();
        lblVencidasTexto = new javax.swing.JLabel();
        lblVencidasValor = new javax.swing.JLabel();
        lblIngresosTexto = new javax.swing.JLabel();
        lblIngresosValor = new javax.swing.JLabel();
        btnEjecutarProcesos = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 102));
        lblTitulo.setText("Indicadores del hotel");

        lblTotalTexto.setText("Total de habitaciones:");

        lblTotalValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalValor.setText("-");

        lblOcupadasTexto.setText("Habitaciones ocupadas:");

        lblOcupadasValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOcupadasValor.setText("-");

        lblDisponiblesTexto.setText("Habitaciones disponibles:");

        lblDisponiblesValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDisponiblesValor.setText("-");

        lblConfirmadasTexto.setText("Reservas confirmadas:");

        lblConfirmadasValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConfirmadasValor.setText("-");

        lblVencidasTexto.setText("Reservas vencidas:");

        lblVencidasValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVencidasValor.setText("-");

        lblIngresosTexto.setText("Ingresos esperados:");

        lblIngresosValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIngresosValor.setText("-");

        btnEjecutarProcesos.setText("Ejecutar procesos");
        btnEjecutarProcesos.addActionListener(this::btnEjecutarProcesosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEjecutarProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotalTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOcupadasTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblOcupadasValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDisponiblesTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblDisponiblesValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblConfirmadasTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblConfirmadasValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVencidasTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblVencidasValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIngresosTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblIngresosValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalTexto)
                    .addComponent(lblTotalValor))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOcupadasTexto)
                    .addComponent(lblOcupadasValor))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisponiblesTexto)
                    .addComponent(lblDisponiblesValor))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmadasTexto)
                    .addComponent(lblConfirmadasValor))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVencidasTexto)
                    .addComponent(lblVencidasValor))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresosTexto)
                    .addComponent(lblIngresosValor))
                .addGap(12, 12, 12)
                .addComponent(btnEjecutarProcesos)
                .addContainerGap(185, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEjecutarProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarProcesosActionPerformed
        if (controlador.ejecutarProcesos() == false) {
    return;
}

btnEjecutarProcesos.setEnabled(false);

reloj = new Timer(500, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evento) {
        mostrarIndicadores();

        if (controlador.procesosActivos() == false) {
            mostrarIndicadores();
            reloj.stop();
            btnEjecutarProcesos.setEnabled(true);
        }
    }
});

reloj.start();
    }//GEN-LAST:event_btnEjecutarProcesosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutarProcesos;
    private javax.swing.JLabel lblConfirmadasTexto;
    private javax.swing.JLabel lblConfirmadasValor;
    private javax.swing.JLabel lblDisponiblesTexto;
    private javax.swing.JLabel lblDisponiblesValor;
    private javax.swing.JLabel lblIngresosTexto;
    private javax.swing.JLabel lblIngresosValor;
    private javax.swing.JLabel lblOcupadasTexto;
    private javax.swing.JLabel lblOcupadasValor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalTexto;
    private javax.swing.JLabel lblTotalValor;
    private javax.swing.JLabel lblVencidasTexto;
    private javax.swing.JLabel lblVencidasValor;
    // End of variables declaration//GEN-END:variables
}
