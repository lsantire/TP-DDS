/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JOptionPane;

/**
 *
 * @author Facundo
 */
public class PopUp extends JOptionPane {
    
    
    public PopUp(TipoPopUp tipo,String mensaje){
        
        switch (tipo){
            case ERROR:
            case ADVERTENCIA:
            case INFORMACION:
            case CONFIRMACION:
        }
        
    }
    
    
}
