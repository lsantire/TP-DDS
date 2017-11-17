/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Aula;
import Entidad.AulaInformatica;
import Entidad.AulaMultimedios;
import Entidad.AulaSinRecursos;
import Utilidades.Hibernator;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

/**
 *
 * @author Facundo
 */
public class DAO_Aulas {
    
    //Patrón Singleton
    private static DAO_Aulas instance=null;
    private DAO_Aulas(){};
    public static DAO_Aulas getInstance(){
        if(instance==null) instance=new DAO_Aulas();
        return instance;
    }
    
    public Collection<Aula> find (Aula a){
        
        ArrayList<Aula> resultado;
        
        try{
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            
            Criteria crit=null;
            
            if(a.getClass()==AulaInformatica.class){
                crit = ses.createCriteria(AulaInformatica.class);
            }
            else  if(a.getClass()==AulaMultimedios.class){
                crit = ses.createCriteria(AulaMultimedios.class);
            }else if(a.getClass()==AulaSinRecursos.class){
                crit = ses.createCriteria(AulaSinRecursos.class);
            }else{
                crit = ses.createCriteria(Aula.class);
            }
        
            Conjunction conj = Restrictions.conjunction();
        
            if(a.getCapacidad()!=0){
                conj.add(Restrictions.ge("capacidad", a.getCapacidad()));
            }
            
            conj.add(Restrictions.eq("habilitado", true));
            
            crit.add(conj);
        
            resultado = (ArrayList<Aula>)crit.list();
        
            ses.getTransaction().commit();
            }
        
        catch(org.hibernate.exception.GenericJDBCException jbdc){
            resultado=new ArrayList();
        }
        
        return resultado;
        
    }
    
    public boolean update(){
        
        //A implementar
        
        return true;
        
    }
    
}
