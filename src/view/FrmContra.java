/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import model.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Validacion;

public class FrmContra extends javax.swing.JInternalFrame {

  Validacion V =new Validacion();
  
     void cambiarpassword (String Usuario, String Pass){
     conexion con=new conexion ();
     Connection cn=con.conexion();
     String cap="";
     String cap2="";
     String sql="SELECT * FROM empleado WHERE EmpUsuario='"+Usuario+"'&& EmpContra='"+Pass+"'";
     try {
         Statement st=cn.createStatement();
         ResultSet rs=st.executeQuery(sql);
         while (rs.next()){
             cap=rs.getString("EmpUsuario");
             cap2=rs.getString("EmpContra");
             if (cap.equals(Usuario)&& cap2.equals(Pass)){
                   PreparedStatement pps=cn.prepareStatement("UPDATE empleado SET "
                   + "EmpContra='"+txtNuevaContra.getText()+"'"
                   + "WHERE EmpUsuario='"+txtUsuario.getText()+"'");
                   pps.executeUpdate();
                   JOptionPane.showMessageDialog(null, "La contraseña ha Cambiado");
                   txtUsuario.setText("");
                   txtNuevaContra.setText("");
                   txtContra.setText("");
             }else{
              JOptionPane.showMessageDialog(null,"Usuario o Password Errados");
             }      
         }
    }catch (SQLException ex){
        Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    public FrmContra() {
        initComponents();
        V.ValidarSoloLetras(txtUsuario);
    }

   
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNuevaContra = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        btnNewPass = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\SENA\\Desktop\\Gestion Cita ADSO 2\\Gesti-n_Citas\\src\\IMG\\contrasena (1).png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 76, 45));

        jLabel3.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cambiar Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 280, 50));

        jLabel4.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nueva contraseña: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 30));

        txtUsuario.setBackground(java.awt.SystemColor.control);
        txtUsuario.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txtUsuario.setBorder(null);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 140, 20));

        jLabel5.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Usuario ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        txtNuevaContra.setBackground(new java.awt.Color(0, 204, 204));
        txtNuevaContra.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtNuevaContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 140, 20));

        jLabel6.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Contraseña actual: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 150, 30));

        txtContra.setBackground(new java.awt.Color(0, 204, 204));
        txtContra.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 140, 20));

        btnNewPass.setBackground(new java.awt.Color(0, 204, 204));
        btnNewPass.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnNewPass.setText("Actualizar");
        btnNewPass.setBorder(null);
        btnNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPassActionPerformed(evt);
            }
        });
        jPanel1.add(btnNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 110, 30));

        btnCancelar.setBackground(new java.awt.Color(0, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 110, 30));

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon("C:\\Users\\SENA\\Desktop\\Gestion Cita ADSO 2\\Gesti-n_Citas\\src\\IMG\\img3.jpg")); // NOI18N
        Background.setText("jLabel2");
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 396, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPassActionPerformed

      String use=txtUsuario.getText();
      String pass=new String (txtContra.getPassword());
     cambiarpassword  (use,pass);
     

    }//GEN-LAST:event_btnNewPassActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNewPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JPasswordField txtNuevaContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
