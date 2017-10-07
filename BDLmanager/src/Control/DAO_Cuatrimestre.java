/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Cuatrimestre;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class DAO_Cuatrimestre {
    
    //Patrón Singleton
    private static DAO_Cuatrimestre instance=null;
    private DAO_Cuatrimestre(){};
    public static DAO_Cuatrimestre getInstance(){
        if(instance==null) instance=new DAO_Cuatrimestre();
        return instance;
    }
    
    public Collection<Cuatrimestre> find () {
        
        //a implementar
        
        return new ArrayList();
        
    }
    
}
