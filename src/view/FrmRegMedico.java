/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;





import static java.awt.image.ImageObserver.HEIGHT;
import model.conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Validacion;

public class FrmRegMedico extends javax.swing.JInternalFrame {
    
            FileInputStream fis;
            int longitudbytes;
            
     DefaultTableModel modelo;
    
     void MostrarMedico(){
     
            String [] titulos ={"Codigo", "Identificación", "Nombres", "Apellidos", "Especialización", "Telefono", "Correo"};
        
        String [] registros= new String [7];
        
        String  sql ="SELECT * FROM medico";
        
        modelo = new DefaultTableModel(null, titulos);
        
            conexion  con = new conexion();
            Connection cn=con.conexion();
            
            try{
                
              Statement st=cn.createStatement();
              ResultSet rs=st.executeQuery(sql);
                
            while(rs.next()){
                
            registros [0] = rs.getString("IdMedico");
            registros [1] = rs.getString("MediIndentificacion"); 
            registros [2] = rs.getString("MedNombre");
            registros [3] = rs.getString("MedApellido");
            registros [4] = rs.getString("MedEspecialidad");
            registros [5] = rs.getString("MedTelefono");
            registros [6] = rs.getString("MedCorreo");
            modelo.addRow(registros);
            }
            
            jTMedico.setModel(modelo);
            
            }catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "hubo un error" + ex);
            }
        
        
         
     
     }
     void ajustarColumnas(){
     
       TableColumnModel  columnModel  = jTMedico.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(110);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(170);
        columnModel.getColumn(4).setPreferredWidth(170);
        columnModel.getColumn(5).setPreferredWidth(170);
        columnModel.getColumn(6).setPreferredWidth(170);
     
     }
     void mostrarImagen(){
        
        ImageIcon foto;
        InputStream is;
        
        try{
            String sql="SELECT MedFoto FROM medico where IdMedico=" + txtIdMedico.getText();
            
            conexion  con = new conexion();
            Connection cn=con.conexion();
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                is=rs.getBinaryStream(1);
                
                BufferedImage bi=ImageIO.read(is);
                foto=new  ImageIcon(bi);
                
                Image img=foto.getImage();
                Image newimg=img.getScaledInstance(140,170, java.awt.Image.SCALE_SMOOTH);
                
                ImageIcon newicon=new ImageIcon(newimg);
                LblFoto.setIcon(newicon);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, closable  + "ERROR " + ex);
    
        }
     
     
     }
     void cargarImagen(){
         
        LblFoto.setIcon(null);
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado=j.showOpenDialog(null);
        if (estado==JFileChooser.APPROVE_OPTION) {
            
            try{
                fis=new FileInputStream(j.getSelectedFile());
                
                this.longitudbytes=(int)j.getSelectedFile().length();
                try{
                    Image  icono=ImageIO.read(j.getSelectedFile()).getScaledInstance(LblFoto.getWidth(),LblFoto.getHeight(),Image.SCALE_DEFAULT);
                            LblFoto.setIcon(new ImageIcon(icono));
                            LblFoto.updateUI();
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(null,"Imagen: " + ex);
                }
                
            }catch(FileNotFoundException Ex){
                
                Ex.printStackTrace();
                
            }
            
        }
     
     }
     
     Validacion V = new Validacion();
     
     
    public FrmRegMedico() {
        initComponents();
         txtIdMedico.setVisible(true);
         btnActualizarMed.setEnabled(false);
         btnEliminar.setEnabled(false);
        MostrarMedico();
        ajustarColumnas();
        
        V.ValidarSoloNumeros(txtIdenMedico);
        V.ValidarSoloLetras(txtNombreMedico);
        V.ValidarSoloLetras(txtApellidosMedico);
        V.ValidarSoloNumeros(txtTelefonoMedico);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdenMedico = new javax.swing.JTextField();
        txtNombreMedico = new javax.swing.JTextField();
        txtApellidosMedico = new javax.swing.JTextField();
        ComboEspecialidad = new javax.swing.JComboBox<>();
        txtTelefonoMedico = new javax.swing.JTextField();
        txtCorreoMedico = new javax.swing.JTextField();
        txtIdMedico = new javax.swing.JLabel();
        LblFoto = new javax.swing.JLabel();
        btnCargarImgMed = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarMedico = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnActualizarMed = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMedico = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Medico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Identificación: ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos: ");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Especialidad");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo: ");

        ComboEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Especialidad", "Alergología", "Anestesiología y reanimación", "Cardiología", "Gastroenterología", "Endocrinología", "Geriatría", "Hematología y hemoterapia", "Infectología", "Nefrología", "Neumología", "Neurología", "Nutriología", "Oftalmología", "Oncología médica", "Oncología radioterápica", "Pediatría", "Psiquiatría", "Rehabilitación", "Reumatología", "Toxicología", "Urología" }));
        ComboEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEspecialidadActionPerformed(evt);
            }
        });

        txtIdMedico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIdMedico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCargarImgMed.setText("Cargar Imagen");
        btnCargarImgMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImgMedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdenMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidosMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoMedico))
                .addGap(18, 18, 18)
                .addComponent(txtIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnCargarImgMed)))
                .addGap(0, 86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(txtIdenMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidosMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ComboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTelefonoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCorreoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCargarImgMed)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnRegistrarMedico.setText("Registrar");
        btnRegistrarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMedicoActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnActualizarMed.setText("Actualizar");
        btnActualizarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMedActionPerformed(evt);
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegistrarMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnActualizarMed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarMedico)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarMed)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        jTMedico.setBackground(new java.awt.Color(0, 204, 204));
        jTMedico.setModel(new javax.swing.table.DefaultTableModel(
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
        jTMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTMedico);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Sitka Banner", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registro de datos del médico");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEspecialidadActionPerformed
        
    }//GEN-LAST:event_ComboEspecialidadActionPerformed

    private void btnRegistrarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMedicoActionPerformed
      
         conexion con = new conexion();
        Connection cn = con.conexion();
        
        try{
            
            PreparedStatement pps=cn.prepareStatement("insert into medico (MediIndentificacion,MedNombre,MedApellido,MedEspecialidad,MedTelefono,MedCorreo,MedFoto)" + "values(?,?,?,?,?,?,?)");
            
            pps.setString(1,txtIdenMedico.getText());
            pps.setString(2,txtNombreMedico.getText());
            pps.setString(3,txtApellidosMedico.getText());
            pps.setString(4, (String) ComboEspecialidad.getSelectedItem());
            pps.setString(5, txtTelefonoMedico.getText());
            pps.setString(6, txtCorreoMedico.getText());
            pps.setBinaryStream(7,fis,longitudbytes);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro guardado");
            MostrarMedico();
            ajustarColumnas();
        }catch (SQLException ex){
           Logger.getLogger(FrmRegMedico.class.getName()).log(Level.SEVERE,null,ex);
           JOptionPane.showMessageDialog(null, "Ha habido un error de guardado");
        }
        
        
    }//GEN-LAST:event_btnRegistrarMedicoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        LblFoto.setIcon(null);
        txtIdMedico.setText("");
        txtIdenMedico.setText("");
        txtNombreMedico.setText("");
        txtApellidosMedico.setText("");
        ComboEspecialidad.setSelectedIndex(0);
        txtTelefonoMedico.setText("");
        txtCorreoMedico.setText("");
        txtIdenMedico.requestFocus();
        btnActualizarMed.setEnabled(false);
        btnRegistrarMedico.setEnabled(true);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jTMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMedicoMouseClicked
      
              int fila=jTMedico.getSelectedRow();
             
        if (fila>=0) {
        txtIdMedico.setText(jTMedico.getValueAt(fila,0).toString());    
        txtIdenMedico.setText(jTMedico.getValueAt(fila,1).toString());
        txtNombreMedico.setText(jTMedico.getValueAt(fila,2).toString());
        txtApellidosMedico.setText(jTMedico.getValueAt(fila,3).toString());
        ComboEspecialidad.setSelectedItem(jTMedico.getValueAt(fila,4).toString());
        txtTelefonoMedico.setText(jTMedico.getValueAt(fila,5).toString());
        txtCorreoMedico.setText(jTMedico.getValueAt(fila,6).toString());
        btnRegistrarMedico.setEnabled(false);
        btnActualizarMed.setEnabled(true);
        btnEliminar.setEnabled(true);
        mostrarImagen();
        }else{
        
            JOptionPane.showMessageDialog(null, "No se ha selecionado ningun Registro");
        
        }
       
        
        
    }//GEN-LAST:event_jTMedicoMouseClicked

    private void btnActualizarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMedActionPerformed

        
       conexion con = new conexion();
       Connection cn= con.conexion();

       try{
           PreparedStatement pps=cn.prepareStatement("UPDATE medico SET "
            +"MediIndentificacion='"+ txtIdenMedico.getText() + "'," 
            +"MedNombre='"+ txtNombreMedico.getText() + "'," +
             "MedApellido='"+ txtApellidosMedico.getText() + "'," +
             "MedEspecialidad='" + ComboEspecialidad.getSelectedItem() +"', " +
             "MedTelefono= '" + txtTelefonoMedico.getText() + "', " +         
             "MedCorreo='"+ txtCorreoMedico.getText()+ "', " +
              "MedFoto= '" + LblFoto.getIcon() + "'"  + "WHERE IdMedico = '" + txtIdMedico.getText() +"'");
           
           pps.executeUpdate();
           MostrarMedico();
           JOptionPane.showMessageDialog(null, "Actualización con éxito " , "Actualización", HEIGHT);
       }catch(SQLException ex){
            
         Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar " +  ex, "ERROR", HEIGHT, frameIcon);
       }
       
        
    }//GEN-LAST:event_btnActualizarMedActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
       conexion con = new conexion();
       Connection cn= con.conexion();
       
       
       int fila= jTMedico.getSelectedRow();
       String valor= jTMedico.getValueAt(fila,0).toString();
       
        if (fila>=0) {
            
            try{
                
           PreparedStatement pps=cn.prepareStatement("DELETE FROM medico WHERE idMedico='"+valor+"'");
           pps.executeUpdate();
           JOptionPane.showMessageDialog(null, "EL dato se ha eliminado con exito " , "Eliminar", HEIGHT);
           MostrarMedico();
             txtIdenMedico.setText("");
             txtNombreMedico.setText("");
             txtApellidosMedico.setText("");
             ComboEspecialidad.setSelectedIndex(0);
             txtTelefonoMedico.setText("");
             txtCorreoMedico.setText("");
             txtIdenMedico.requestFocus();
             LblFoto.setIcon(null);
           
             }catch(SQLException ex){
            
         Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "Ha habido un error al Eliminar " +  ex, "ERROR", HEIGHT, frameIcon);
       }
            
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarImgMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImgMedActionPerformed
            cargarImagen();       
    }//GEN-LAST:event_btnCargarImgMedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEspecialidad;
    private javax.swing.JLabel LblFoto;
    private javax.swing.JButton btnActualizarMed;
    private javax.swing.JButton btnCargarImgMed;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrarMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMedico;
    private javax.swing.JTextField txtApellidosMedico;
    private javax.swing.JTextField txtCorreoMedico;
    private javax.swing.JLabel txtIdMedico;
    private javax.swing.JTextField txtIdenMedico;
    private javax.swing.JTextField txtNombreMedico;
    private javax.swing.JTextField txtTelefonoMedico;
    // End of variables declaration//GEN-END:variables
}
