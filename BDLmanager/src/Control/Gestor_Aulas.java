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
public class Gestor_Aulas {
    
     //Patrón Singleton
    private static Gestor_Aulas instance=null;
    private Gestor_Aulas(){};
    public static Gestor_Aulas getInstance(){
        if(instance==null) instance=new Gestor_Aulas();
        return instance;
    }
    
    public Collection<Aula> buscarAula(){
        
        // a implementar
        
        return new ArrayList();
    }
    
    public boolean modificarAula(Aula aula){
        
        //a implementar
        return DAO_Aulas.getInstance().update();
    }
    
    
}
