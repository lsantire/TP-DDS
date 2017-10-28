/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Administrador;
import Hibernate.Hibernator;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Facundo
 */
public class DAO_Administrador {
    
    //Patrón Singleton
    private static DAO_Administrador instance=null;
    private DAO_Administrador(){};
    public static DAO_Administrador getInstance(){
        if(instance==null) instance=new DAO_Administrador();
        return instance;
    }
    
    public Collection<Administrador> find (String id, String pass){
        
        ArrayList<Administrador> resultado;
        
        try{
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            Criteria cr = ses.createCriteria(Administrador.class);
            cr.add(Restrictions.conjunction().add(Restrictions.eq("id",id)).add(Restrictions.eq("contrasenia",pass)));
            resultado= (ArrayList<Administrador>)cr.list();
            ses.getTransaction().commit();
        }
        catch(org.hibernate.exception.GenericJDBCException jbdc){
            resultado=new ArrayList();
        }
        
        
        return resultado;
        
    }
    
}
