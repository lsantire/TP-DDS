/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javafx.util.Pair;

/**
 *
 * @author Facundo
 */
public class Gestor_Reservas {
  
    //Patrón Singleton
    private static Gestor_Reservas instance=null;
    private Gestor_Reservas(){};
    public static Gestor_Reservas getInstance(){
        if(instance==null) instance=new Gestor_Reservas();
        return instance;
    }
    
    public Pair<Date,Date> obtenerPeriodo(boolean C1, boolean C2){
        //Se obtiene el año actual en el que se esta ejecutando el programa, usando new Date() y formateando a yyyy
        DateFormat formatter = new SimpleDateFormat("yyyy");
        int cicloLectivo = Integer.parseInt(formatter.format(new Date()));
        
        //Se busca en la bdd las entradas de la tabla cuatrimestre que correspondan al ciclo lectivo actual (llamando al dao_cuatrimestre)
        ArrayList<Cuatrimestre> cuatrimestres = (ArrayList<Cuatrimestre>)(DAO_Cuatrimestre.getInstance().find(cicloLectivo));
        
        //Se obtienen 2 cuatrimestres de la lista (deberia solamente haber 2 en la tabla)
        Cuatrimestre primerCuatrimestre=null;
        Cuatrimestre segundoCuatrimestre=null;
        
        //Se establece que el primer cuatrimestre es el que mas temprano comienza
        for (int i=0;i<cuatrimestres.size();i++){
            
            if(primerCuatrimestre==null){
                primerCuatrimestre=cuatrimestres.get(i);
            }
            
            if(primerCuatrimestre.getFechaInicio().after(cuatrimestres.get(i).getFechaInicio())){
                primerCuatrimestre=cuatrimestres.get(i);
            }
        }
        
        //el segundo cuatrimestre es el que mas temprano comienza pero cuya fecha de inicio es posterior a la fecha de fin del primer cuatrimestre
        for (int i=0;i<cuatrimestres.size();i++){
            
            if(segundoCuatrimestre==null && cuatrimestres.get(i).getFechaInicio().after(primerCuatrimestre.getFechaFin())){
                segundoCuatrimestre=cuatrimestres.get(i);
            }
            
        }
        
        for (int i=0;i<cuatrimestres.size();i++){
            
            if(segundoCuatrimestre.getFechaInicio().after(cuatrimestres.get(i).getFechaInicio()) && cuatrimestres.get(i).getFechaInicio().after(primerCuatrimestre.getFechaFin())){
                segundoCuatrimestre=cuatrimestres.get(i);
            }
            
        }
        
        if(C1 && !C2){
            return new Pair(primerCuatrimestre.getFechaInicio(),primerCuatrimestre.getFechaFin());
        }else if(C2 && !C1){
            return new Pair(segundoCuatrimestre.getFechaInicio(),segundoCuatrimestre.getFechaFin());
        }else{
            return new Pair(primerCuatrimestre.getFechaInicio(),segundoCuatrimestre.getFechaFin());
        }
        
    }
    
    public Collection<Reserva> buscarReservasPorCurso(){
        //a implementar
        return new ArrayList();
    }
    
    public Collection<Reserva> buscarReservasPorDia(){
        //a implementar
        return new ArrayList();
    }
    
    public void crearReserva(){ //deberia devolver una reserva
        //a implementar
    }
    
    public Collection<Docente> obtenerDocentes (){
        return DAO_Docentes.getInstance().find();
    }
    
    public Collection<Curso> obtenerCursos(){
        return DAO_Curso.getInstance().find();
    }
    
}
