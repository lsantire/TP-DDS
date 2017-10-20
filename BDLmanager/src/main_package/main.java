/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package;

import Control.DAO_PoliticaSeguridad;
import Entidad.PoliticaSeguridad;
import Interfaz.CU17_Login;
import Interfaz.PopUp;
import Interfaz.TipoPopUp;
import java.util.ArrayList;

/**
 *
 * @author Mateo Chamorro
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        new CU17_Login().setVisible(true);
        
        /*ArrayList<PoliticaSeguridad> ps = (ArrayList<PoliticaSeguridad>)DAO_PoliticaSeguridad.getInstance().find();
        
        for(int i=0;i<ps.size();i++){
            
            System.out.println("ID="+ps.get(i).getId()+" debeEspecial="+ps.get(i).isDebeEspecial()+" debeMayus="+ps.get(i).isDebeUnaMayus()+" debeEspecial="+ps.get(i).isDebeEspecial()+" debeNumero="+ps.get(i).isDebeUnNumero()+" LongMin="+ps.get(i).getLongitudMinima()+"\n");
            
        }*/
        
    }
    
}
