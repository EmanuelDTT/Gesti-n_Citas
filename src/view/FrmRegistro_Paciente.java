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

import model.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Validacion;








public class FrmRegistro_Paciente extends javax.swing.JInternalFrame {
    
    FileInputStream fis;
    int longitudbytes;
    
    DefaultTableModel modelo;
    
    void mostrarPacientes(){
        String [] titulos ={"Codigo", "Identificación", "Nombres", "Apellidos", "Fecha Nac", "Sexo"};
        
        String [] registros= new String [6];
        
        String  sql ="SELECT * FROM paciente";
        
        modelo = new DefaultTableModel(null, titulos);
        
            conexion  con = new conexion();
            Connection cn=con.conexion();
            
            try{
                
              Statement st=cn.createStatement();
              ResultSet rs=st.executeQuery(sql);
                
            while(rs.next()){
                
            registros [0] = rs.getString("IdPaciente");
            registros [1] = rs.getString("PacIdentifiacion"); 
            registros [2] = rs.getString("PacNombre");
            registros [3] = rs.getString("PacApellidos");
            registros [4] = rs.getString("PacFechaNac");
            registros [5] = rs.getString("PacSexo");
            modelo.addRow(registros);
            }
            
            jTPacientes.setModel(modelo);
            
            }catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "hubo un error" + ex);
            }
        
        
        
        
    }
    void ajustarColumnas()  {
        
        TableColumnModel  columnModel  = jTPacientes.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(110);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(170);
        columnModel.getColumn(4).setPreferredWidth(90);
        columnModel.getColumn(5).setPreferredWidth(80);
        
    
    }
    void mostrarImagen(){
        
        ImageIcon foto;
        InputStream is;
        
        try{
            String sql="SELECT PacFoto FROM paciente where IdPaciente=" + txtIdPaciente.getText();
            
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
    void agregarimagen(){
        
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
    
    
    
    Validacion V =new Validacion();
    
    
    public FrmRegistro_Paciente() {
        initComponents();
      
       
        btnModificar.setEnabled(false);
        mostrarPacientes();
        ajustarColumnas();
        txtIdPaciente.setVisible(true);
        btnEliminar.setEnabled(false);
        V.ValidarSoloLetras(txtNombrePaciente);
        V.ValidarSoloLetras(txtApellidosPaciente);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SEXO = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdenPaciente = new javax.swing.JTextField();
        txtNombrePaciente = new javax.swing.JTextField();
        txtApellidosPaciente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rdPacienteM = new javax.swing.JRadioButton();
        rdPacienteF = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        FechaNac = new com.toedter.calendar.JDateChooser();
        txtIdPaciente = new javax.swing.JLabel();
        LblFoto = new javax.swing.JLabel();
        btnImgPac = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPacientes = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Identificación: ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre: ");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos: ");

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        SEXO.add(rdPacienteM);
        rdPacienteM.setForeground(new java.awt.Color(255, 255, 255));
        rdPacienteM.setText("Masculino");
        rdPacienteM.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));
        rdPacienteM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdPacienteMActionPerformed(evt);
            }
        });

        SEXO.add(rdPacienteF);
        rdPacienteF.setForeground(new java.awt.Color(255, 255, 255));
        rdPacienteF.setText("Femenino");
        rdPacienteF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdPacienteFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdPacienteM, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdPacienteF)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdPacienteM)
                    .addComponent(rdPacienteF))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de Nacimiento: ");

        FechaNac.setDateFormatString("YYYY/MM/dd");

        txtIdPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIdPaciente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIdPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdPacienteMouseClicked(evt);
            }
        });

        LblFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnImgPac.setText("Cargar imagen");
        btnImgPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgPacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(FechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(46, 46, 46))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(41, 41, 41)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombrePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                .addComponent(txtApellidosPaciente)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtIdenPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImgPac))
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdenPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(FechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(LblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImgPac)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        jTPacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPacientes);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Candara", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registro del paciente");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(270, 270, 270))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(400, 200, 943, 799);
    }// </editor-fold>//GEN-END:initComponents

    private void rdPacienteMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdPacienteMActionPerformed
        sexo="Masculino";
        
    }//GEN-LAST:event_rdPacienteMActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        conexion con= new conexion();
        Connection cn= con.conexion();
        
        try{
            
            PreparedStatement pps=cn.prepareStatement("insert into paciente (PacIdentifiacion,PacNombre,PacApellidos,PacFechaNac,PacSexo,PacFoto)" + "values(?,?,?,?,?,?)");
            
            pps.setString(1,txtIdenPaciente.getText());
            pps.setString(2,txtNombrePaciente.getText());
            pps.setString(3,txtApellidosPaciente.getText());
            pps.setString(4,((JTextField) FechaNac.getDateEditor().getUiComponent()).getText());
            pps.setString(5, sexo);
            pps.setBinaryStream(6,fis,longitudbytes);
            pps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro guardado");
            
            mostrarPacientes();
            ajustarColumnas();
        }catch (SQLException ex){
           Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
           JOptionPane.showMessageDialog(null, "Ha habido un error de guardado");
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void rdPacienteFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdPacienteFActionPerformed
        sexo="Femenino";
    }//GEN-LAST:event_rdPacienteFActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtIdPaciente.setText("");      
        txtIdenPaciente.setText("");
        txtNombrePaciente.setText("");
        txtApellidosPaciente.setText("");
        LblFoto.setIcon(null);
        FechaNac.setCalendar(null);
        SEXO.clearSelection();
        txtIdenPaciente.requestFocus();
        txtIdenPaciente.setEditable(true);
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jTPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPacientesMouseClicked
       
         int fila=jTPacientes.getSelectedRow();

        if (fila>=0) {
        
        txtIdPaciente.setText(jTPacientes.getValueAt(fila,0).toString());
        txtIdenPaciente.setText(jTPacientes.getValueAt(fila,1).toString());
        txtNombrePaciente.setText(jTPacientes.getValueAt(fila,2).toString());
        txtApellidosPaciente.setText(jTPacientes.getValueAt(fila,3).toString());
        FechaNac.setDate(Date.valueOf(jTPacientes.getValueAt(fila, 4).toString()));
       
            if (jTPacientes.getValueAt(fila,5).toString().equals("Masculino")){
                rdPacienteM.setSelected(true);
                sexo= "Masculino";
        }else{
                rdPacienteF.setSelected(true);
                sexo="Femenino";
        }
            btnModificar.setEnabled(true);
            btnRegistrar.setEnabled(false);
             btnEliminar.setEnabled(true);
             mostrarImagen();
        }else{
        
            JOptionPane.showMessageDialog(null, "No se ha selecionado ningun Registro");
        
        }
        
    }//GEN-LAST:event_jTPacientesMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       
       conexion con = new conexion();
       Connection cn= con.conexion();

       try{
           PreparedStatement pps=cn.prepareStatement("UPDATE paciente SET "
            +"PacIdentifiacion='"+ txtIdenPaciente.getText() + "'," 
            +"PacNombre='"+ txtNombrePaciente.getText() + "'," +
             "PacApellidos='"+ txtApellidosPaciente.getText() + "'," +
             "PacFechaNac='" + ((JTextField) FechaNac.getDateEditor().getUiComponent()).getText()   +"', " +
             "PacSexo= '" + sexo + "', " +
             "PacFoto= '" + LblFoto.getIcon() + "' "+"WHERE IdPaciente = '" + txtIdPaciente.getText() +"'");
           
           pps.executeUpdate();
           mostrarPacientes();
           JOptionPane.showMessageDialog(null, "Actualización con éxito " , "Actualización", HEIGHT);
       }catch(SQLException ex){
            
         Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar " +  ex, "ERROR", HEIGHT, frameIcon);
       }
   
   
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtIdPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdPacienteMouseClicked
      
        
        
    }//GEN-LAST:event_txtIdPacienteMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        conexion con = new conexion();
       Connection cn= con.conexion();
       
       
       int fila= jTPacientes.getSelectedRow();
       String valor= jTPacientes.getValueAt(fila,0).toString();
       
        if (fila>=0) {
            
            try{
                
           PreparedStatement pps=cn.prepareStatement("DELETE FROM paciente WHERE idPaciente='"+valor+"'");
           pps.executeUpdate();
           JOptionPane.showMessageDialog(null, "EL dato se ha eliminado con exito " , "Eliminar", HEIGHT);
           mostrarPacientes();
           
            txtIdenPaciente.setText("");
            txtNombrePaciente.setText("");
            txtApellidosPaciente.setText("");
            FechaNac.setCalendar(null);
            SEXO.clearSelection();
            txtIdenPaciente.requestFocus();
            LblFoto.setIcon(null);
            
             }catch(SQLException ex){
            
         Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "Ha habido un error al Eliminar " +  ex, "ERROR", HEIGHT, frameIcon);
       }
            
        }

        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnImgPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgPacActionPerformed
        agregarimagen();
    }//GEN-LAST:event_btnImgPacActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaNac;
    private javax.swing.JLabel LblFoto;
    private javax.swing.ButtonGroup SEXO;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImgPac;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPacientes;
    private javax.swing.JRadioButton rdPacienteF;
    private javax.swing.JRadioButton rdPacienteM;
    private javax.swing.JTextField txtApellidosPaciente;
    private javax.swing.JLabel txtIdPaciente;
    private javax.swing.JTextField txtIdenPaciente;
    private javax.swing.JTextField txtNombrePaciente;
    // End of variables declaration//GEN-END:variables
    private String sexo; 
}
