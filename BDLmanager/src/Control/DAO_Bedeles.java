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
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

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
        
        Disjunction disj = Restrictions.disjunction();
        
        if(bdl.getId()!=null){
            disj.add(Restrictions.eq("id",bdl.getId()));
        }
        
        if(bdl.getNombre()!=null){
            disj.add(Restrictions.eq("nombre",bdl.getNombre()));
        }
        
        if(bdl.getApellido()!=null){
            disj.add(Restrictions.eq("apellido", bdl.getApellido()));
        }
        
        if(bdl.getContraseña()!=null){
            disj.add(Restrictions.eq("contraseña",bdl.getContraseña()));
        }
        
        if(bdl.getTurno()!=null){
            disj.add(Restrictions.eq("turno",bdl.getTurno()));
        }
        
        crit.add(disj);
        
        ArrayList<Bedel> resultado = (ArrayList<Bedel>)crit.list();
        
        ses.getTransaction().commit();
        ses.close();
        
        return resultado;
        
    }
    
    public boolean insert(Bedel bdl){
        
        Session s = Hibernator.getInstance().getSessionFactory().openSession();
        s.beginTransaction();
        s.save(s);
        s.getTransaction().commit();
        s.close();
        
        return true;
        
    }
    
    public boolean update (Bedel bdl, String apellido, String contraseña, String eliminado, String nombre, String turno){
        
        //A implementar
        return true;
        
    }
    
}
