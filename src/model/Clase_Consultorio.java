
package model;

import model.conexion;
import view.FrmRegConsultorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Clase_Consultorio {
         
    private String idCon;
    private String NumCon;
    private String DespCon;
    
    conexion con = new conexion();

    public Clase_Consultorio(String idCon, String NumCon, String DespCon) {
        this.idCon = idCon;
        this.NumCon = NumCon;
        this.DespCon = DespCon;
    }
    public Clase_Consultorio() {
        
    }

    public String getIdCon() {
        return idCon;
    }

    public void setIdCon(String idCon) {
        this.idCon = idCon;
    }

    public String getNumCon() {
        return NumCon;
    }

    public void setNumCon(String NumCon) {
        this.NumCon = NumCon;
    }

    public String getDespCon() {
        return DespCon;
    }

    public void setDespCon(String DespCon) {
        this.DespCon = DespCon;
    }
    
        public void LlenarComboConsultorio(JComboBox<Clase_Consultorio>ComboConsultorio){
        
        conexion con= new conexion();
        Connection cn= con.conexion();
        String sql="SELECT * FROM consultorio ORDER BY NumConsul";
        ComboConsultorio.removeAllItems();
        
    
        try{
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sql);
           
           while(rs.next()){
                ComboConsultorio.addItem(new Clase_Consultorio(
                rs.getString("idConsultorio"),
               rs.getString("NumConsul"),
                rs.getString("ConNombre")
                ));
               
           }
        }catch(SQLException e){
            Logger.getLogger(Clase_Medico.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    @Override
    public String toString(){
        return NumCon+" "+ DespCon;
    }
    
    
}
