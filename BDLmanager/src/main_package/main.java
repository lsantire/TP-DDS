/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package;

import Hibernate.Hibernator;
import Interfaz.CU17_Login;
import java.awt.Font;
import java.util.logging.*;
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
        
        setUIFont (new javax.swing.plaf.FontUIResource("Segoe UI",Font.PLAIN,11));
        setLogLevel(Level.SEVERE);
        
        new CU17_Login().setVisible(true);
        
        Hibernator.getInstance();
        
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
    
    public static void setLogLevel(Level l){
        
       LogManager.getLogManager().getLogger("").setLevel(l);
        
    }
    
}
