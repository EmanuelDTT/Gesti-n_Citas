
package model;


import model.conexion;
import view.FrmRegEmpleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


public class Clase_Empleado {
    
    private String IdEmp;
    private String Usuario;

     conexion con = new conexion();

    public Clase_Empleado(String IdEmp, String Usuario) {
        this.IdEmp = IdEmp;
        this.Usuario = Usuario;
    }
    public Clase_Empleado(){
    
    
       }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
        public void LlenarComboEmp(JComboBox<Clase_Empleado>ComboEmp){
        
        conexion con= new conexion();
        Connection cn= con.conexion();
        String sql="SELECT * FROM empleado ORDER BY EmpUsuario";
        ComboEmp.removeAllItems();
        
    
        try{
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sql);
           
           while(rs.next()){
                ComboEmp.addItem(new Clase_Empleado(
                rs.getString("IdEmpleado"),
                rs.getString("EmpUsuario")
                ));
               
           }
        }catch(SQLException e){
            Logger.getLogger(Clase_Empleado.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    @Override
    public String toString(){
        return Usuario+" ";
    }
    
    
    
}
