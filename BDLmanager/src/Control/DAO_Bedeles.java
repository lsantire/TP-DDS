/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Bedel;
import Hibernate.Hibernator;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

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
        
        Session ses = Hibernator.getInstance().getSessionFactory().openSession();
        ses.beginTransaction();
        
        Criteria crit = ses.createCriteria(Bedel.class);
        
        Conjunction conj = Restrictions.conjunction();
        
        if(bdl.getId()!=null){
            conj.add(Restrictions.eq("id",bdl.getId()));
        }
        
        if(bdl.getNombre()!=null){
            conj.add(Restrictions.eq("nombre",bdl.getNombre()));
        }
        
        if(bdl.getApellido()!=null){
            conj.add(Restrictions.eq("apellido", bdl.getApellido()));
        }
        
        if(bdl.getContraseña()!=null){
            conj.add(Restrictions.eq("contrasenia",bdl.getContraseña()));
        }
        
        if(bdl.getTurno()!=null){
            conj.add(Restrictions.eq("turno",bdl.getTurno()));
        }
        
        crit.add(conj);
        
        ArrayList<Bedel> resultado = (ArrayList<Bedel>)crit.list();
        
        ses.getTransaction().commit();
        ses.close();
        
        return resultado;
        
    }
    
    public boolean insert(Bedel bdl){
        
        Session s = Hibernator.getInstance().getSessionFactory().openSession();
        s.beginTransaction();
        s.save(bdl);
        s.getTransaction().commit();
        s.close();
        
        return true;
        
    }
    
    public boolean update (Bedel bdl, String apellido, String contrasenia, String eliminado, String nombre, String turno){
        
        //A implementar
        return true;
        
    }
    
}
