
package model;

import java.sql.*;
import javax.swing.*;

public class conexion {
    Connection conect = null;
        public Connection conexion(){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/gestion_de_citas","root","");

            }
            catch(ClassNotFoundException | SQLException e){
            }
            return conect;
        }

   
}
