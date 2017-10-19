/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Bedel;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class DAO_Bedeles {
    
    //Patrón Singleton
    private static DAO_Bedeles instance=null;
    private DAO_Bedeles(){};
    public static DAO_Bedeles getInstance(){
        if(instance==null) instance=new DAO_Bedeles();
        return instance;
    }
    
    public boolean delete(Bedel bdl){
        
        //A implementar
        
        return true;
    }
    
    public Collection<Bedel> find(Bedel bdl){
        
        //A implementar
        
        return new ArrayList();
        
    }
    
    public boolean insert(Bedel bdl){
        //A implementar
        return true;
        
    }
    
    public boolean update (Bedel bdl, String apellido, String contraseña, String eliminado, String nombre, String turno){
        
        //A implementar
        return true;
        
    }
    
}
