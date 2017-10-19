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
public class PopUp {
    private int val=0;
    
    
    public PopUp(TipoPopUp tipo,String mensaje){
        
        switch (tipo){
            case ERROR: JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE); break;
            case ADVERTENCIA: JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE); break;
            case INFORMACION: JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE); break;
            case CONFIRMACION: int x=JOptionPane.showConfirmDialog(null, mensaje, "Confirmacion", JOptionPane.YES_NO_OPTION);
                               if(x==JOptionPane.YES_OPTION)val=1;break;
        }
        
    }
    
    public int getVal(){
        return val;
    }
    
    
}
