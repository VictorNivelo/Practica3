/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ListaEnlazada.ListaEnlazada;
import Controlador.LocalController;
import Controlador.PosicionController;
import Modelo.Enum.Orientacion;
import Modelo.Locales;
import Modelo.Posicion;
import Vista.Utilidades.Utilidades;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class frmAgregarLocal extends javax.swing.JFrame {
    LocalController localC = new LocalController();
    PosicionController PosicionC = new PosicionController();
    public LinkedList<Locales> listaLocales = new LinkedList<>();

    /**
     * Creates new form frmAgregarLocal
     */
    public frmAgregarLocal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcionAgregar = new javax.swing.JTextField();
        txtNombreAgregar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDistanciaAgregar = new javax.swing.JTextField();
        btnAgregarLocal = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGREGAR LOCAL");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("INFORMACION DEL LOCAL");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descipcion:");

        txtDescripcionAgregar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNombreAgregar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Distancia:");

        txtDistanciaAgregar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDistanciaAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDistanciaAgregarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionAgregar)
                            .addComponent(txtNombreAgregar)
                            .addComponent(txtDistanciaAgregar))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDistanciaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarLocal.setText("AGREGAR LOCAL");
        btnAgregarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLocalActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarLocal)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarLocal)
                    .addComponent(btnRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmPrincipal abrir = new frmPrincipal();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLocalActionPerformed
        // TODO add your handling code here:
//        double latitud = Double.parseDouble(txtLatitud.getText());
//        double longitud = Double.parseDouble(txtLatitud.getText());
//        
//        Gson gson = new Gson();
//        
//        ListaEnlazada<Posicion> listaPosiciones = new ListaEnlazada<>();
//        Posicion posucion = new Posicion();
//        listaPosiciones.insertar(posucion);
//        
//        System.out.println(""+listaPosiciones);

//        Locales local = new Locales();
//        local.setNombreLocal(txtNombre.getText());
//        local.setDescripcion(txtDescripcion.getText());
//        local.setId(localC.getLocales().getSize() + 1);
//        
//        Posicion posi = new Posicion();
//
//        posi.setLatitud(Double.valueOf(txtLatitud.getText()));
//        posi.setLongitud(Double.valueOf(txtLongitud.getText()));
//        posi.setOrientacion(cbxOrientacion.getSelectedItem().toString());
//        
//
//        
//        localC.getLocales().insertar(local);
//        PosicionC.getPosiciones().insertar(posi);
//        
//        Utilidades.guardarArchivoJSON(localC);
//        Utilidades.guardarPosiciones(PosicionC);
//        
//        
//        System.out.println(""+local+" "+posi);

    String NombreLocal = txtNombreAgregar.getText();
    String DescipcionLocal = txtDescripcionAgregar.getText();
    String DistanciaLocal = txtDistanciaAgregar.getText();
    
    int i = 1;

    if(txtNombreAgregar.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Por favor llene el nombre", "CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
    }
    else if(txtDescripcionAgregar.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Por favor llene la descripcion", "CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
    }
    else if(txtDistanciaAgregar.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Por favor llene la latitud", "CAMPO VACIO", JOptionPane.WARNING_MESSAGE);
    }
    else{
        Locales locallist = new Locales(i++, NombreLocal, DescipcionLocal, DistanciaLocal);
        listaLocales.add(locallist);
        
        Gson guardarGson = new Gson();
        
//        String json = guardarGson.toJson(listaLocales);
        
        try (FileWriter writer = new FileWriter("ListaLocales.json")) {
            guardarGson.toJson(listaLocales, writer);
            System.out.println("Se ha guardado correctamente");
            JOptionPane.showMessageDialog(null, "Guardado correctamente", "GUARDADO", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    }//GEN-LAST:event_btnAgregarLocalActionPerformed

    private void txtDistanciaAgregarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistanciaAgregarKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtDistanciaAgregarKeyTyped

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAgregarLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgregarLocal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLocal;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtDescripcionAgregar;
    public static javax.swing.JTextField txtDistanciaAgregar;
    public static javax.swing.JTextField txtNombreAgregar;
    // End of variables declaration//GEN-END:variables
}
