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
import org.hibernate.Session;

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
        
        ArrayList<PoliticaSeguridad> retorno;
        try{
        Session ses=Hibernator.getInstance().getSession();
        retorno=(ArrayList<PoliticaSeguridad>)ses.createCriteria(PoliticaSeguridad.class).list();
        }
        catch (org.hibernate.exception.GenericJDBCException jbdc){
            retorno=new ArrayList();
        }
        return retorno;
        
    }
    
}
