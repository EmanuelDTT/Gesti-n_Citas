
package model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Validacion {
    
    public void ValidarSoloLetras(JTextField Campo){
    
    Campo.addKeyListener(new KeyAdapter(){
        public void  KeyTyped(KeyEvent e){
            
            char c=e.getKeyChar();
            if (Character.isDigit(c)) {
                e.consume();
                 JOptionPane.showMessageDialog(null, "Recueda que solo debes digitar letras");
            }else{
            JOptionPane.showMessageDialog(null, "SADASDAS");
            }
        }
    
    });
    
    }
    
}
