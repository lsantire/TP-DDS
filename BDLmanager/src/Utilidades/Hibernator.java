/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;
import Entidad.*;
import org.hibernate.*;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.exception.*;


/**
 *
 * @author Facundo
 */
public class Hibernator {
    
    private static AnnotationConfiguration config;
    private static SessionFactory sesFactory;
    private static Session sesion;
    private static Hibernator instance=null;
    
    private Hibernator(){
        config=new AnnotationConfiguration();
        
        config.addAnnotatedClass(Administrador.class);
        config.addAnnotatedClass(Aula.class);
        config.addAnnotatedClass(AulaInformatica.class);
        config.addAnnotatedClass(AulaMultimedios.class);
        config.addAnnotatedClass(AulaSinRecursos.class);
        config.addAnnotatedClass(Bedel.class);
        config.addAnnotatedClass(ContraseniaAnteriorAdministrador.class);
        config.addAnnotatedClass(ContraseniaAnteriorBedel.class);
        config.addAnnotatedClass(Cuatrimestre.class);
        config.addAnnotatedClass(Curso.class);
        config.addAnnotatedClass(DiaReserva.class);
        config.addAnnotatedClass(Docente.class);
        config.addAnnotatedClass(PoliticaSeguridad.class);
        config.addAnnotatedClass(Reserva.class);
        config.configure("Utilidades/hibernate.cfg.xml");
        
        
        sesFactory=config.buildSessionFactory();
        sesion=sesFactory.openSession(); 
        //new SchemaExport(config).create(true, true);// -> Exporta en el schema nuevas tablas en base a las anotaciones en las clases
        
    };
    
    public static Hibernator getInstance() throws org.hibernate.exception.GenericJDBCException{
        if(instance==null) {
            
            try{
                instance=new Hibernator();
            }
            catch (org.hibernate.exception.GenericJDBCException gjdbce){
                throw new GenericJDBCException(gjdbce.getMessage(),gjdbce.getSQLException());
            }
            
        }
        return instance;
    }
    
    
    public Session getSession(){
        return sesion;
    }
    
}
