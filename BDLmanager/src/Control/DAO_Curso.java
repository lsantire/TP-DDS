/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Curso;
import Utilidades.Hibernator;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Facundo
 */
public class DAO_Curso {
    
    //Patrón Singleton
    private static DAO_Curso instance=null;
    private DAO_Curso (){};
    public static DAO_Curso getInstance(){
        if(instance==null) instance=new DAO_Curso();
        return instance;
    }
    
    public Collection<Curso> find (){
        
        Session ses=Hibernator.getInstance().getSession();
        ses.beginTransaction();
        Criteria crit = ses.createCriteria(Curso.class);
        ArrayList<Curso> resultado = new ArrayList(); 
        if(!crit.list().isEmpty()){resultado=(ArrayList<Curso>)crit.list();}
        ses.getTransaction().commit();
        
        return resultado;
        
    }
    
    
}
