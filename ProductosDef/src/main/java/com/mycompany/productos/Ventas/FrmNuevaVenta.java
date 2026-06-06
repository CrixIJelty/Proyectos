/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.productos.Ventas;

import com.mycompany.productos.dao.VentaDAO;
import com.mycompany.productos.model.Venta;
import com.mycompany.productos.util.Conexion;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import com.mycompany.productos.dao.DetalleVentaDao;
import com.mycompany.productos.model.DetalleVenta;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author thecr
 */
public class FrmNuevaVenta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmNuevaVenta.class.getName());
    private VentaDAO dao;
    private DetalleVentaDao detalleDAO;

private DefaultTableModel modelo;

private String[] columnas = { "ID Producto","Cantidad","Precio" };
    /**
     * Creates new form FrmNuevaVenta
     */
    public FrmNuevaVenta() {
        initComponents();
        
       jGuardar.addActionListener(
            this::btnGuardarActionPerformed
    );

    jButton1.addActionListener(
            this::btnAgregarActionPerformed
    );

    try {

        dao = new VentaDAO(
                Conexion.obtenerConexion()
        );

        detalleDAO = new DetalleVentaDao(
                Conexion.obtenerConexion()
        );

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
                this,
                ex.getMessage()
        );
    }

    modelo = new DefaultTableModel(
            columnas,
            0
    );

    jTable1.setModel(modelo);
}
    
   private void btnGuardarActionPerformed(
        java.awt.event.ActionEvent evt) {

    try {

        // ======================
        // GUARDAR VENTA
        // ======================

        LocalDate fecha =
                LocalDate.parse(
                        txtFecha.getText().trim()
                );

        int idCliente =
                Integer.parseInt(
                        txtCliente.getText().trim()
                );

        Venta venta =
                new Venta(fecha, idCliente);

        dao.insertar(venta);

        // ID generado automáticamente
        int idVenta = venta.getId();

        // ======================
        // GUARDAR DETALLES
        // ======================

        for (int i = 0; i < modelo.getRowCount(); i++) {

            int idProducto =
                    Integer.parseInt(
                            modelo.getValueAt(i, 0).toString()
                    );

            int cantidad =
                    Integer.parseInt(
                            modelo.getValueAt(i, 1).toString()
                    );

            double precio =
                    Double.parseDouble(
                            modelo.getValueAt(i, 2).toString()
                    );

            DetalleVenta detalle =
                    new DetalleVenta();

            detalle.setIdVenta(idVenta);
            detalle.setIdProducto(idProducto);
            detalle.setCantidad(cantidad);
            detalle.setPrecio(precio);

            detalleDAO.insertar(detalle);
        }

        JOptionPane.showMessageDialog(
                this,
                "Venta registrada correctamente"
        );

        txtFecha.setText("");
        txtCliente.setText("");

        modelo.setRowCount(0);

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
                this,
                ex.getMessage()
        );
    }
}
   
   private void btnAgregarActionPerformed(
        java.awt.event.ActionEvent evt) {

    try {

        int idProducto =
                Integer.parseInt(
                        jTextField1.getText().trim()
                );

        int cantidad =
                Integer.parseInt(
                        jTextField2.getText().trim()
                );

        double precio =
                Double.parseDouble(
                        jTextField3.getText().trim()
                );

        modelo.addRow(new Object[]{

            idProducto,
            cantidad,
            precio
        });

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
                this,
                ex.getMessage()
        );
    }
}
    
    
    private void cargarDetallesVenta(int idVenta)
        throws Exception {

    // PASO 1
    DefaultTableModel modeloDetalle =
            new DefaultTableModel(
                    columnas,
                    0
            );

    // PASO 2
    DetalleVentaDao detalleDAO =
            new DetalleVentaDao(
                    Conexion.obtenerConexion()
            );

    List<DetalleVenta> lista =
            detalleDAO.buscarPorIdVenta(idVenta);

    // PASO 3
    int fila = 1;

    for (DetalleVenta d : lista) {

        Object[] rowData = {

            fila++,
            d.getIdProducto(),
            d.getCantidad(),
            d.getPrecio(),
            d.getCantidad() * d.getPrecio()
        };

        modeloDetalle.addRow(rowData);
    }

    // PASO 4
    jTable1.setModel(modeloDetalle);

    // PASO 5
    jTable1.getColumnModel()
            .getColumn(0)
            .setPreferredWidth(30);

    jTable1.getColumnModel()
            .getColumn(1)
            .setPreferredWidth(80);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        JFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jidCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JFecha.setText("Fecha");

        jidCliente.setText("idCliente");

        jGuardar.setText("Guardar");

        jLabel1.setText("Detalle Venta");

        jLabel3.setText("Venta");

        jLabel4.setText("Producto:");

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jLabel5.setText("Cantidad:");

        jLabel6.setText("Precio:");

        jButton1.setText("Agregar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                        .addComponent(JFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jidCliente))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFecha)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                                    .addGap(39, 39, 39)
                                    .addComponent(jGuardar))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jidCliente)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jGuardar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }
    private void btnAgregarActionPerfomed(
        java.awt.event.ActionEvent evt) {

    try {

        int idProducto =
                Integer.parseInt(   
      
                        jTextField1.getText().trim()
                );

        int cantidad =
                Integer.parseInt(
                        jTextField2.getText().trim()
                );

        double precio =
                Double.parseDouble(
                        jTextField3.getText().trim()
                );

        modelo.addRow(new Object[]{

            idProducto,
            cantidad,
            precio
        });

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
                this,
                ex.getMessage()
        );
    }
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmNuevaVenta().setVisible(true));
    }

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel jidCliente;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables

    //Registro de nombre Cliente y Fecha
}
