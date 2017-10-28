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
        
        ArrayList<Bedel> resultado;
        
        try{
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            
            Criteria crit = ses.createCriteria(Bedel.class);
        
            Conjunction conj = Restrictions.conjunction();
        
            if(bdl.getId()!=null){
                conj.add(Restrictions.eq("id",bdl.getId()));
            }
        
            if(bdl.getNombre()!=null){
                conj.add(Restrictions.ilike("nombre", bdl.getNombre(),MatchMode.ANYWHERE));
            }
        
            if(bdl.getApellido()!=null){
                conj.add(Restrictions.ilike("apellido", bdl.getApellido(), MatchMode.ANYWHERE));
            }
        
            if(bdl.getContrasenia()!=null){
                conj.add(Restrictions.eq("contrasenia",bdl.getContrasenia()));
            }
        
            if(bdl.getTurno()!=null){
                conj.add(Restrictions.eq("turno",bdl.getTurno()));
            }
        
            conj.add(Restrictions.eq("eliminado", bdl.isEliminado()));
        
            crit.add(conj);
        
            resultado = (ArrayList<Bedel>)crit.list();
        
            ses.getTransaction().commit();
            }
        catch(org.hibernate.exception.GenericJDBCException jbdc){
            resultado=new ArrayList();
        }
        
        
        return resultado;
        
    }
    
    public boolean insert(Bedel bdl){
        try{
            Session s = Hibernator.getInstance().getSession();
            s.beginTransaction();
            s.save(bdl);
            s.getTransaction().commit();
            return true;
        }
        catch (org.hibernate.exception.GenericJDBCException jbdc){
            return false;
        }
    }
    
    public boolean update (Bedel bdl){
        
        
        try{
            Session s=Hibernator.getInstance().getSession();
            s.beginTransaction();
            s.update(bdl);
            s.getTransaction().commit();
            return true;
        }
        catch (org.hibernate.exception.GenericJDBCException jbdc){
            return false;
        }
        
    }
    
}
