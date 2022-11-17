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
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Validacion;



public class FrmRegEmpleado extends javax.swing.JInternalFrame {
    
            FileInputStream fis;
            int longitudbytes;
            
    DefaultTableModel modelo;
  
    void mostrarEmpleado(){
  
            String [] titulos ={"Codigo", "Identificación", "Nombres", "Apellidos", "Usuario", "Contraseña","Tipo"};
        
            String [] registros= new String [7];
        
            String  sql ="SELECT * FROM empleado";
        
        modelo = new DefaultTableModel(null, titulos);
        
            conexion  con = new conexion();
            Connection cn=con.conexion();
            
            try{
                
              Statement st=cn.createStatement();
              ResultSet rs=st.executeQuery(sql);
                
            while(rs.next()){
                
            registros [0] = rs.getString("IdEmpleado");
            registros [1] = rs.getString("EmpIdentificacion"); 
            registros [2] = rs.getString("EmpNombre");
            registros [3] = rs.getString("EmpApellido");
            registros [4] = rs.getString("EmpUsuario");
            registros [5] = rs.getString("EmpContra");
            registros [6]=  rs.getString("EmpTipo");
           
            modelo.addRow(registros);
            }
            
            jTEmpleado.setModel(modelo);
            
            }catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null, "hubo un error" + ex);
            }
        
  
  }
    void ajustarColumnas(){
    TableColumnModel  columnModel  = jTEmpleado.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(170);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(170);
        columnModel.getColumn(4).setPreferredWidth(170);
        columnModel.getColumn(5).setPreferredWidth(170);
        columnModel.getColumn(5).setPreferredWidth(170);
   
    
    }
    void mostrarImagen(){
    
       ImageIcon foto;
        InputStream is;
        
        try{
            String sql="SELECT EmpFoto FROM empleado where IdEmpleado=" + txtIdEmp.getText();
            
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
    
    Validacion V =new Validacion();
    
    public FrmRegEmpleado() {
        
        
        initComponents();
        mostrarEmpleado();
        ajustarColumnas();
        btnActualizarEmp.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtIdEmp.setVisible(true);
        
        V.ValidarSoloLetras(txtNombreEmpleado);
        V.ValidarSoloLetras(txtApellidosEmpleado);
        V.ValidarSoloLetras(txtUsuarioEmpleado);
        V.ValidarSoloNumeros(txtIdenEmpleado);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        txtIdenEmpleado = new javax.swing.JTextField();
        txtUsuarioEmpleado = new javax.swing.JTextField();
        txtApellidosEmpleado = new javax.swing.JTextField();
        PsEmpleado = new javax.swing.JPasswordField();
        txtIdEmp = new javax.swing.JLabel();
        LblFoto = new javax.swing.JLabel();
        btnCargarImagen = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbTiposUsuarios = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarEmpleado = new javax.swing.JButton();
        btnNuevoEmpleado = new javax.swing.JButton();
        btnActualizarEmp = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEmpleado = new javax.swing.JTable();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Identificación: ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos: ");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario: ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña");

        txtIdEmp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIdEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCargarImagen.setText("Cargar Imagen");
        btnCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo de usuario:");

        cmbTiposUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ", "Administrador", "Moderador" }));
        cmbTiposUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTiposUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PsEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtIdenEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtApellidosEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtUsuarioEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(cmbTiposUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(txtIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(LblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnCargarImagen)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargarImagen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtApellidosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtUsuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(PsEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtIdenEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbTiposUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        btnRegistrarEmpleado.setText("Registrar");
        btnRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmpleadoActionPerformed(evt);
            }
        });

        btnNuevoEmpleado.setText("Nuevo");
        btnNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpleadoActionPerformed(evt);
            }
        });

        btnActualizarEmp.setText("Actualizar");
        btnActualizarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEmpActionPerformed(evt);
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegistrarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarEmp))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNuevoEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarEmpleado)
                    .addComponent(btnActualizarEmp))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoEmpleado)
                    .addComponent(btnEliminar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registro de Empleado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTEmpleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jTEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEmpleado);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoActionPerformed

         
         conexion con= new conexion();
        Connection cn= con.conexion();
        
        try{
            
            PreparedStatement pps=cn.prepareStatement("insert into empleado (EmpIdentificacion,EmpNombre,EmpApellido,EmpUsuario,EmpContra,EmpFoto,EmpTipo)" + "values(?,?,?,?,?,?,?)");
            
            pps.setString(1,txtIdenEmpleado.getText());
            pps.setString(2,txtNombreEmpleado.getText());
            pps.setString(3,txtApellidosEmpleado.getText());
            pps.setString(4,txtUsuarioEmpleado.getText() );
            pps.setString(5, PsEmpleado.getText());
            pps.setBinaryStream(6,fis,longitudbytes);
            pps.setString(7,cmbTiposUsuarios.getSelectedItem().toString());
            
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro guardado");
            mostrarEmpleado();
            ajustarColumnas();
        }catch (SQLException ex){
           Logger.getLogger(FrmRegEmpleado.class.getName()).log(Level.SEVERE,null,ex);
           JOptionPane.showMessageDialog(null, "Ha habido un error de guardado");
        }
        
        
    }//GEN-LAST:event_btnRegistrarEmpleadoActionPerformed

    private void btnNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpleadoActionPerformed
        txtIdEmp.setText("");
        btnEliminar.setEnabled(false);
        btnRegistrarEmpleado.setEnabled(true);
        btnActualizarEmp.setEnabled(false);
        txtIdenEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtApellidosEmpleado.setText("");
        txtUsuarioEmpleado.setText("");
        PsEmpleado.setText("");
        txtIdenEmpleado.requestFocus();
        LblFoto.setIcon(null);
        
    }//GEN-LAST:event_btnNuevoEmpleadoActionPerformed

    private void jTEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmpleadoMouseClicked
      
         int fila=jTEmpleado.getSelectedRow();
        
        if (fila>=0) {
        txtIdEmp.setText(jTEmpleado.getValueAt(fila,0).toString());    
        txtIdenEmpleado.setText(jTEmpleado.getValueAt(fila,1).toString());
        txtNombreEmpleado.setText(jTEmpleado.getValueAt(fila,2).toString());
        txtApellidosEmpleado.setText(jTEmpleado.getValueAt(fila,3).toString());
        txtUsuarioEmpleado.setText(jTEmpleado.getValueAt(fila,4).toString());
        PsEmpleado.setText(jTEmpleado.getValueAt(fila,5).toString());

        btnRegistrarEmpleado.setEnabled(false);
        btnActualizarEmp.setEnabled(true);
        btnEliminar.setEnabled(true);
        mostrarImagen();
        }else{
        
            JOptionPane.showMessageDialog(null, "No se ha selecionado ningun Registro");
        
        }
    }//GEN-LAST:event_jTEmpleadoMouseClicked

    private void btnActualizarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEmpActionPerformed
       
        
         
       conexion con = new conexion();
       Connection cn= con.conexion();

       try{
           PreparedStatement pps=cn.prepareStatement("UPDATE empleado SET "
            +"EmpIdentificacion='"+ txtIdenEmpleado.getText() + "'," 
            +"EmpNombre='"+ txtNombreEmpleado.getText() + "'," +
             "EmpApellido='"+ txtApellidosEmpleado.getText() + "'," +
             "EmpUsuario='" + txtUsuarioEmpleado.getText() +"', " +
             "EmpContra='"+ PsEmpleado.getText()+ "', "+
             "EmpTipo='" + cmbTiposUsuarios.getSelectedItem() +"', "+
             "EmpFoto='" + LblFoto.getIcon()+"' "+ "WHERE IdEmpleado = '" + txtIdEmp.getText() +"'");
           
           pps.executeUpdate();
           mostrarEmpleado();
           JOptionPane.showMessageDialog(null, "Actualización con éxito " , "Actualización", HEIGHT);
       }catch(SQLException ex){
            
         Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "Ha habido un error al actualizar " +  ex, "ERROR", HEIGHT, frameIcon);
       }
       
        
        
        
    }//GEN-LAST:event_btnActualizarEmpActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
          conexion con = new conexion();
       Connection cn= con.conexion();
       
       
       int fila= jTEmpleado.getSelectedRow();
       String valor= jTEmpleado.getValueAt(fila,0).toString();
       
        if (fila>=0) {
            
            try{
                
           PreparedStatement pps=cn.prepareStatement("DELETE FROM empleado WHERE IdEmpleado= '"+valor+"'");
           pps.executeUpdate();
           JOptionPane.showMessageDialog(null, "EL dato se ha eliminado con exito " , "Eliminar", HEIGHT);
           mostrarEmpleado();
                txtIdenEmpleado.setText("");
                txtNombreEmpleado.setText("");
                txtApellidosEmpleado.setText("");
                txtUsuarioEmpleado.setText("");
                PsEmpleado.setText("");
                txtIdenEmpleado.requestFocus();
                LblFoto.setIcon(null);
           
             }catch(SQLException ex){
            
         Logger.getLogger(FrmRegistro_Paciente.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "Ha habido un error al Eliminar " +  ex, "ERROR", HEIGHT, frameIcon);
       }
            
        }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
        cargarImagen();
    }//GEN-LAST:event_btnCargarImagenActionPerformed

    private void cmbTiposUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTiposUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTiposUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblFoto;
    private javax.swing.JPasswordField PsEmpleado;
    private javax.swing.JButton btnActualizarEmp;
    private javax.swing.JButton btnCargarImagen;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevoEmpleado;
    private javax.swing.JButton btnRegistrarEmpleado;
    private javax.swing.JComboBox<String> cmbTiposUsuarios;
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
    private javax.swing.JTable jTEmpleado;
    private javax.swing.JTextField txtApellidosEmpleado;
    private javax.swing.JLabel txtIdEmp;
    private javax.swing.JTextField txtIdenEmpleado;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtUsuarioEmpleado;
    // End of variables declaration//GEN-END:variables
    

}
