/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Aula;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class DAO_Aulas {
    
    //Patrón Singleton
    private static DAO_Aulas instance=null;
    private DAO_Aulas(){};
    public static DAO_Aulas getInstance(){
        if(instance==null) instance=new DAO_Aulas();
        return instance;
    }
    
    public Collection<Aula> find (){
        
        //A implementar
        
        return new ArrayList();
        
    }
    
    public boolean update(){
        
        //A implementar
        
        return true;
        
    }
    
}
