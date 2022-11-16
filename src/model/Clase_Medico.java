
package model;

import model.conexion;
import view.FrmRegMedico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Clase_Medico {

    private String idMedico;
    private String MedNombre;
    private String MedApellido;
    
    conexion con = new conexion();

    public Clase_Medico(String idMedico, String MedNombre, String MedApellido) {
        this.idMedico = idMedico;
        this.MedNombre = MedNombre;
        this.MedApellido = MedApellido;
    }
    public Clase_Medico(){
    
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getMedNombre() {
        return MedNombre;
    }

    public void setMedNombre(String MedNombre) {
        this.MedNombre = MedNombre;
    }

    public String getMedApellido() {
        return MedApellido;
    }

    public void setMedApellido(String MedApellido) {
        this.MedApellido = MedApellido;
    }
    
        public void LlenarComboMedico(JComboBox<Clase_Medico>ComboMedico){
        
        conexion con= new conexion();
        Connection cn= con.conexion();
        String sql="SELECT * FROM medico ORDER BY MedApellido";
        ComboMedico.removeAllItems();
        
    
        try{
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sql);
           
           while(rs.next()){
                ComboMedico.addItem(new Clase_Medico(
                rs.getString("idMedico"),
               rs.getString("MedNombre"),
                rs.getString("MedApellido")
                ));
               
           }
        }catch(SQLException e){
            Logger.getLogger(Clase_Medico.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    @Override
    public String toString(){
        return MedNombre+" "+MedApellido;
    }
    
}
