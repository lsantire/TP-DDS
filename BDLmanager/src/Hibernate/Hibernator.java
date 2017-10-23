/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;
import Entidad.*;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Facundo
 */
public class Hibernator {
    
    private static AnnotationConfiguration config;
    private static SessionFactory sesFactory;
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
        config.configure("Hibernate/hibernate.cfg.xml");
        
        sesFactory=config.buildSessionFactory();
        
        //new SchemaExport(config).create(true, true);// -> Exporta en el schema nuevas tablas en base a las anotaciones en las clases
        
    };
    
    public static Hibernator getInstance(){
        if(instance==null) instance=new Hibernator();
        return instance;
    }
    
    public SessionFactory getSessionFactory(){
        return sesFactory;
    }
    
}
