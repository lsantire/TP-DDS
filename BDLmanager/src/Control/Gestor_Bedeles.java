/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Bedel;
import Entidad.PoliticaSeguridad;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class Gestor_Bedeles {
    
    //Patrón Singleton
    private static Gestor_Bedeles instance=null;
    private Gestor_Bedeles(){};
    public static Gestor_Bedeles getInstance(){
        if(instance==null) instance=new Gestor_Bedeles();
        return instance;
    }
    
    public Collection<Bedel> buscarBedel(){
        
        //a implementar
        
        return new ArrayList();
        
    }
    
    public void crearBedel(Bedel bdl){
        
        //a implementar
        
    }
    
    public boolean eliminarBedel (Bedel bdl){
        
        //a implementar
        
        return true;
    }
    
    public Bedel modificarBedel(Bedel bdl){
        
        //A implementar
        
        return (Bedel)(((ArrayList)DAO_Bedeles.getInstance().find("Gimenez", "mañana")).get(0));
         
    }
    
}
