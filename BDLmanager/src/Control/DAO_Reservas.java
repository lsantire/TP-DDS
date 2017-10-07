/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Reserva;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class DAO_Reservas {
    
    //Patrón Singleton
    private static DAO_Reservas instance=null;
    private DAO_Reservas(){};
    public static DAO_Reservas getInstance(){
        if(instance==null) instance=new DAO_Reservas();
        return instance;
    }
    
    public Collection<Reserva> find () {
        
        //A implementar
        
        return new ArrayList();
        
    }
    
    public boolean delete(Reserva rsv){
        
        //A implementar
        
        return true;
    }
    
    public boolean insert (Reserva rsv){
        
        //a implementar
        
        return true;
    }
    
    public boolean update (){
        
        // a implementar
        
        return true;
    }
    
}
