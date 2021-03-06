/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.DiaReserva;
import Entidad.Reserva;
import Utilidades.Hibernator;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

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
    
    public Collection<DiaReserva> verificarDisponibilidad (DiaReserva dr) {
        
        ArrayList<DiaReserva> resultado=new ArrayList();
        
        try{
            
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            
            Criteria cr=ses.createCriteria(DiaReserva.class);
            Conjunction conj = Restrictions.conjunction();
            Disjunction disj = Restrictions.disjunction();
            
            if(dr.getFecha()!=null){
                conj.add(Restrictions.eq("fecha",dr.getFecha()));
            }
            
            Time hi=dr.getHoraInicio();
            Time hf=dr.getHoraFin();
            String _hi="horaInicio";
            String _hf="horaFin";
            
            
            if(dr.getAula()!=null){
                conj.add(Restrictions.eq("aula", dr.getAula()));
                
            }
            conj.add(Restrictions.and(
                    Restrictions.lt(_hi, hf),
                    Restrictions.gt(_hf, hi)
                    )
            );
            
            cr.add(conj);
            
            resultado=(ArrayList<DiaReserva>) cr.list();
                    
            ses.getTransaction().commit();
        }
        catch(org.hibernate.exception.GenericJDBCException jbdc){
            resultado=new ArrayList();
        }
        
        System.out.println(resultado.size());
        return resultado;
        
    }
    
    public boolean delete(Reserva rsv){
        
        //A implementar
        
        return true;
    }
    
    public boolean insert (Reserva rsv){
        
            try{
            Session s = Hibernator.getInstance().getSession();
            s.beginTransaction();
            s.save(rsv);
            s.getTransaction().commit();
            return true;
        }
        catch (org.hibernate.exception.GenericJDBCException jbdc){
            return false;
        }
        
    }
    
    public boolean update (){
        
        // a implementar
        
        return true;
    }
    
}
