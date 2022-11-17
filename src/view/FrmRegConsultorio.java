/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import model.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Validacion;

public class FrmRegConsultorio extends javax.swing.JInternalFrame {
     DefaultTableModel modelo;
    void mostrarConsultorio(){
        
            String [] titulos ={"Codigo", "Numero Consultorio", "Descripción"};
        
            String [] registros= new String [3];
        
            String  sql ="SELECT * FROM consultorio";
        
        modelo = new DefaultTableModel(null, titulos);
        
            conexion  con = new conexion();
            Connection cn=con.conexion();
            
            try{
                
              Statement st=cn.createStatement();
              ResultSet rs=st.executeQuery(sql);
                
            while(rs.next()){
                
            registros [0] = rs.getString("IdConsultorio");
            registros [1] = rs.getString("NumConsul"); 
            registros [2] = rs.getString("ConNombre");
           
           
            modelo.addRow(registros);
            }
            
            jTConsultorio.setModel(modelo);
            
            }catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "hubo un error" + ex);
            }


    }
    void ajustarColumnas(){
      
        TableColumnModel  columnModel  = jTConsultorio.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(110);
        columnModel.getColumn(2).setPreferredWidth(170);
        
    
    }
    Validacion V =new Validacion();
    
    public FrmRegConsultorio() {
        initComponents();
        
        mostrarConsultorio();
        ajustarColumnas();
        txtIdConsul.setVisible(true);
        btnActualizarConsultorio.setEnabled(false);
        btnEliminar.setEnabled(false);
        V.ValidarSoloNumeros(txtNumeroConsultorio);
        V.ValidarSoloLetras(txtDescripcionConsultorio);
    }
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroConsultorio = new javax.swing.JTextField();
        txtDescripcionConsultorio = new javax.swing.JTextField();
        txtIdConsul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarConsultorio = new javax.swing.JButton();
        btnNuevoConsultorio = new javax.swing.JButton();
        btnActualizarConsultorio = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTConsultorio = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Consultorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("N° del Consultorio: ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción: ");

        txtIdConsul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIdConsul.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescripcionConsultorio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdConsul, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtIdConsul, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcionConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnRegistrarConsultorio.setText("Registrar");
        btnRegistrarConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarConsultorioActionPerformed(evt);
            }
        });

        btnNuevoConsultorio.setText("Nuevo");
        btnNuevoConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoConsultorioActionPerformed(evt);
            }
        });

        btnActualizarConsultorio.setText("Actualizar");
        btnActualizarConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarConsultorioActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarConsultorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarConsultorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevoConsultorio, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarConsultorio)
                    .addComponent(btnNuevoConsultorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarConsultorio)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        jTConsultorio.setModel(new javax.swing.table.DefaultTableModel(
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
        jTConsultorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConsultorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTConsultorio);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registro de Consultorio");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(187, 187, 187))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarConsultorioActionPerformed
      
         
         conexion con= new conexion();
        Connection cn= con.conexion();
        
        try{
            
            PreparedStatement pps=cn.prepareStatement("insert into consultorio (NumConsul,ConNombre)" + "values(?,?)");
            
            pps.setString(1,txtNumeroConsultorio.getText());
            pps.setString(2,txtDescripcionConsultorio.getText());
            
         
            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro guardado");
                    mostrarConsultorio();
                    ajustarColumnas();
            
        }catch (SQLException ex){
           Logger.getLogger(FrmRegConsultorio.class.getName()).log(Level.SEVERE,null,ex);
           JOptionPane.showMessageDialog(null, "Ha habido un error de guardado");
        }
    }//GEN-LAST:event_btnRegistrarConsultorioActionPerformed

    private void btnNuevoConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoConsultorioActionPerformed
        txtIdConsul.setText("");
        txtNumeroConsultorio.setText("");
        txtDescripcionConsultorio.setText("");
        txtNumeroConsultorio.requestFocus();
         btnRegistrarConsultorio.setEnabled(true);
        btnActualizarConsultorio.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnNuevoConsultorioActionPerformed

    private void jTConsultorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConsultorioMouseClicked
        int fila=jTConsultorio.getSelectedRow();
        
          
        if (fila>=0) {
        txtIdConsul.setText(jTConsultorio.getValueAt(fila, 0).toString());    
        txtNumeroConsultorio.setText(jTConsultorio.getValueAt(fila,1).toString());
        txtDescripcionConsultorio.setText(jTConsultorio.getValueAt(fila,2).toString());
       
        btnRegistrarConsultorio.setEnabled(false);
        btnActualizarConsultorio.setEnabled(true);
        btnEliminar.setEnabled(true);
        }else{
        
            JOptionPane.showMessageDialog(null, "No se ha selecionado ningun Registro");
        
        }
    }//GEN-LAST:event_jTConsultorioMouseClicked

    private void btnActualizarConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarConsultorioActionPerformed
      conexion con = new conexion();
       Connection cn= con.conexion();

       try{
           PreparedStatement pps=cn.prepareStatement("UPDATE consultorio SET " +
             "NumConsul='" + txtNumeroConsultorio.getText() +"', " +
             "ConNombre='"+ txtDescripcionConsultorio.getText()+ "' "  + "WHERE IdConsultorio = '" + txtIdConsul.getText() +"'");
           
           pps.executeUpdate();
           mostrarConsultorio();
           JOptionPane.showMessageDialog(null, "Actualización con éxito " , "Actualización", HEIGHT);
       }catch(SQLException ex){
            
         Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar " +  ex, "ERROR", HEIGHT, frameIcon);
       }
       
        
        
        
        
    }//GEN-LAST:event_btnActualizarConsultorioActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        
          conexion con = new conexion();
       Connection cn= con.conexion();
       
       
       int fila= jTConsultorio.getSelectedRow();
       String valor= jTConsultorio.getValueAt(fila,0).toString();
       
        if (fila>=0) {
            
            try{
                
           PreparedStatement pps=cn.prepareStatement("DELETE FROM consultorio WHERE IdConsultorio='"+valor+"'");
           pps.executeUpdate();
           JOptionPane.showMessageDialog(null, "EL dato se ha eliminado con exito " , "Eliminar", HEIGHT);
           mostrarConsultorio();
           
           txtNumeroConsultorio.setText("");
           txtDescripcionConsultorio.setText("");
           
             }catch(SQLException ex){
            
         Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "Ha habido un error al Eliminar " +  ex, "ERROR", HEIGHT, frameIcon);
       }
            
        }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarConsultorio;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevoConsultorio;
    private javax.swing.JButton btnRegistrarConsultorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTConsultorio;
    private javax.swing.JTextField txtDescripcionConsultorio;
    private javax.swing.JLabel txtIdConsul;
    private javax.swing.JTextField txtNumeroConsultorio;
    // End of variables declaration//GEN-END:variables
}
