/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Cuatrimestre;
import Utilidades.Hibernator;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Facundo
 */
public class DAO_Cuatrimestre {
    
    //Patrón Singleton
    private static DAO_Cuatrimestre instance=null;
    private DAO_Cuatrimestre(){};
    public static DAO_Cuatrimestre getInstance(){
        if(instance==null) instance=new DAO_Cuatrimestre();
        return instance;
    }
    
    public Collection<Cuatrimestre> find (int cicloLectivo) {
        
        ArrayList<Cuatrimestre> resultado=new ArrayList(),inter;
        
        try{
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            Criteria cr = ses.createCriteria(Cuatrimestre.class);
            inter=(ArrayList<Cuatrimestre>)cr.list();
            ses.getTransaction().commit();
            for(int i=0;i<inter.size();i++){
                if(inter.get(i).getCicloLectivo()==cicloLectivo){
                    resultado.add(inter.get(i));
                }
            }
        }
        catch(org.hibernate.exception.GenericJDBCException jbdc){
            resultado=new ArrayList();
        }
        
        
        return resultado;
        
    }
    
}
