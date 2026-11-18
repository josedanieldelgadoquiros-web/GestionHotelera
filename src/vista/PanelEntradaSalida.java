package vista;
import controlador.ControladorOperaciones;


public class PanelEntradaSalida extends javax.swing.JPanel {
    private ControladorOperaciones controlador;


    public PanelEntradaSalida() {
        initComponents();
        cmbAccion.addItem("Check-in");
        cmbAccion.addItem("Check-out");
            controlador = new ControladorOperaciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblDetalle = new javax.swing.JLabel();
        txtDetalle = new javax.swing.JTextArea();
        lblAccion = new javax.swing.JLabel();
        cmbAccion = new javax.swing.JComboBox();
        btnProcesar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 102));
        lblTitulo.setText("Check-in / Check-out");

        lblCodigo.setText("Código de reserva:");

        txtCodigo.addActionListener(this::txtCodigoActionPerformed);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        lblDetalle.setText("Detalle de la reserva:");

        txtDetalle.setEditable(false);
        txtDetalle.setColumns(32);
        txtDetalle.setRows(6);

        lblAccion.setText("Operación:");

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(this::btnProcesarActionPerformed);

        lblMensaje.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cmbAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(12, 12, 12)
                .addComponent(lblDetalle)
                .addGap(12, 12, 12)
                .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccion)
                    .addComponent(cmbAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcesar))
                .addGap(12, 12, 12)
                .addComponent(lblMensaje)
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
String codigo = txtCodigo.getText().trim();
if (codigo.equals("")) {
    lblMensaje.setText("Escriba un código de reserva.");
    txtDetalle.setText("");
    return;
}
txtDetalle.setText(controlador.buscarReserva(codigo));
lblMensaje.setText(" ");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        String codigo = txtCodigo.getText().trim();
if (codigo.equals("")) {
    lblMensaje.setText("Escriba un código de reserva.");
    return;
}
boolean sePudo;
if (cmbAccion.getSelectedItem().equals("Check-in")) {
    sePudo = controlador.hacerCheckIn(codigo);
} else {
    sePudo = controlador.hacerCheckOut(codigo);
}
if (sePudo) {
    lblMensaje.setText("La operación se realizó correctamente.");
    txtDetalle.setText(controlador.buscarReserva(codigo));
} else {
    lblMensaje.setText("No se pudo realizar la operación.");
}
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox cmbAccion;
    private javax.swing.JLabel lblAccion;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables
}
