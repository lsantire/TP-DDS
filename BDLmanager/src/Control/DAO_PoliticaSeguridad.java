/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.PoliticaSeguridad;
import Hibernate.Hibernator;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class DAO_PoliticaSeguridad {
    
    //Patrón Singleton
    private static DAO_PoliticaSeguridad instance=null;
    private DAO_PoliticaSeguridad(){};
    public static DAO_PoliticaSeguridad getInstance(){
        if(instance==null) instance=new DAO_PoliticaSeguridad();
        return instance;
    }
    
    public Collection<PoliticaSeguridad> find(){
        
        ArrayList<PoliticaSeguridad> retorno = (ArrayList<PoliticaSeguridad>) Hibernator.getInstance().getSessionFactory().openSession().createCriteria(PoliticaSeguridad.class).list();
        
        
        return retorno;
        
    }
    
}
