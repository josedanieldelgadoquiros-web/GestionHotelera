package vista;
import controlador.ControladorOperaciones;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


/**
 *
 * @author ElectrickS
 */
public class PanelDisponibilidadHabitaciones extends javax.swing.JPanel {
    private ControladorOperaciones controlador;


    public PanelDisponibilidadHabitaciones() {
        initComponents();
            controlador = new ControladorOperaciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        lblListado = new javax.swing.JLabel();
        txtHabitaciones = new javax.swing.JTextArea();

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 102));
        lblTitulo.setText("Consulta de disponibilidad");

        lblFecha.setText("Fecha (dd/MM/aaaa):");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);

        lblCantidad.setText("Habitaciones disponibles: -");

        lblListado.setText("Números de habitaciones disponibles:");

        txtHabitaciones.setEditable(false);
        txtHabitaciones.setColumns(32);
        txtHabitaciones.setRows(6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListado, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(12, 12, 12)
                .addComponent(lblCantidad)
                .addGap(12, 12, 12)
                .addComponent(lblListado)
                .addGap(12, 12, 12)
                .addComponent(txtHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
    java.time.format.DateTimeFormatter formato =
            java.time.format.DateTimeFormatter.ofPattern("dd/MM/uuuu");
    LocalDate fecha = LocalDate.parse(txtFecha.getText().trim(), formato);
    int cantidad = controlador.consultarCantidadDisponible(fecha);
    String numeros = controlador.consultarNumerosDisponibles(fecha);
    lblCantidad.setText("Habitaciones disponibles: " + cantidad);
    txtHabitaciones.setText(numeros);
} catch (DateTimeParseException error) {
    lblCantidad.setText("Fecha incorrecta. Use dd/MM/aaaa");
    txtHabitaciones.setText("");
}
    }//GEN-LAST:event_btnConsultarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblListado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextArea txtHabitaciones;
    // End of variables declaration//GEN-END:variables
}
