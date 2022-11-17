
package model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Validacion {
    
        public void ValidarSoloLetras(JTextField Campo){
        
        Campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(Character.isDigit(c)){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Recuerda que solo debes Digitar Letras");
                }
            }
    });
           
    }


     public void ValidarSoloNumeros(JTextField Campo){
        
        Campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Recuerda que solo debes Digitar Numeros");
                }
            }
    });
           
    } 
    
    
}
    

