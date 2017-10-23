/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package;

import Control.DAO_PoliticaSeguridad;
import Entidad.PoliticaSeguridad;
import Hibernate.Hibernator;
import Interfaz.CU17_Login;
import Interfaz.PopUp;
import Interfaz.TipoPopUp;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 *
 * @author Mateo Chamorro
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        setUIFont (new javax.swing.plaf.FontUIResource("Segoe UI",Font.PLAIN,12));
        
        new CU17_Login().setVisible(true);
        
        Hibernator.getInstance();
        
        /*ArrayList<PoliticaSeguridad> ps = (ArrayList<PoliticaSeguridad>)DAO_PoliticaSeguridad.getInstance().find();
        
        for(int i=0;i<ps.size();i++){
            
            System.out.println("ID="+ps.get(i).getId()+" debeEspecial="+ps.get(i).isDebeEspecial()+" debeMayus="+ps.get(i).isDebeUnaMayus()+" debeEspecial="+ps.get(i).isDebeEspecial()+" debeNumero="+ps.get(i).isDebeUnNumero()+" LongMin="+ps.get(i).getLongitudMinima()+"\n");
            
        }*/
        
    }
    
    public static void setUIFont (javax.swing.plaf.FontUIResource f){
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get (key);
      if (value instanceof javax.swing.plaf.FontUIResource)
        UIManager.put (key, f);
      }
    } 
    
}
