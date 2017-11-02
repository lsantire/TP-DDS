/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Docente;
import Utilidades.Hibernator;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Facundo
 */
public class DAO_Docentes {
    
    //Patrón Singleton
    private static DAO_Docentes instance=null;
    private DAO_Docentes(){};
    public static DAO_Docentes getInstance(){
        if(instance==null) instance=new DAO_Docentes();
        return instance;
    }
    
    public Collection<Docente> find (){
        
        Session ses=Hibernator.getInstance().getSession();
        ses.beginTransaction();
        Criteria crit = ses.createCriteria(Docente.class);
        ArrayList<Docente> resultado = new ArrayList(); 
        if(!crit.list().isEmpty()){resultado=(ArrayList<Docente>)crit.list();}
        ses.getTransaction().commit();
        
        return resultado;
    }
    
}
