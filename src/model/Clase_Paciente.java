/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import model.conexion;
import view.FrmRegistro_Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


public class Clase_Paciente {

    private String Idpac;
    private String PacNomb;
    private String PacApe;

    conexion con = new conexion();

    public Clase_Paciente(String Idpac, String PacNomb, String PacApe) {
        this.Idpac = Idpac;
        this.PacNomb = PacNomb;
        this.PacApe = PacApe;
        
    }
    
     public Clase_Paciente(){
    
    }

    public String getIdpac() {
        return Idpac;
    }

    public void setIdpac(String Idpac) {
        this.Idpac = Idpac;
    }

    public String getPacNomb() {
        return PacNomb;
    }

    public void setPacNomb(String PacNomb) {
        this.PacNomb = PacNomb;
    }

    public String getPacApe() {
        return PacApe;
    }

    public void setPacApe(String PacApe) {
        this.PacApe = PacApe;
    }
    
    public void LlenarComboPaciente(JComboBox<Clase_Paciente>ComboPaciente){
        
        conexion con= new conexion();
        Connection cn= con.conexion();
        String sql="SELECT * FROM paciente ORDER BY PacApellidos";
        ComboPaciente.removeAllItems();
        
    
        try{
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sql);
           
           while(rs.next()){
                ComboPaciente.addItem(new Clase_Paciente(
                rs.getString("IdPaciente"),
               rs.getString("PacNombre"),
                rs.getString("PacApellidos")
                ));
               
           }
        }catch(SQLException e){
            Logger.getLogger(Clase_Paciente.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    @Override
    public String toString(){
        return PacNomb+" "+PacApe;
    }
   
    
    
}
