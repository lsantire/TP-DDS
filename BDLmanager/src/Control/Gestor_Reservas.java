/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.*;
import Utilidades.Triple;
import java.sql.Time;
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
    
    public void crearReserva (int cantAlumnos, boolean C1, boolean C2, Docente docente, Curso curso, Bedel bedel, ArrayList<Pair<Triple<Date,Time,Time>,Aula>> lista){
        
        Reserva r = new Reserva();
        r.setBedel(bedel);
        r.setCantidadAlumnos(cantAlumnos);
        if(C1 || C2){r.setEsPeriodica(true);}else{r.setEsPeriodica(false);}
        r.setCurso(curso);
        r.setDocente(docente);
        Collection<DiaReserva> drs = new ArrayList();
        
        for (int i=0;i<lista.size();i++){
            
            DiaReserva dr=new DiaReserva();
            dr.setAula(lista.get(i).getValue());
            dr.setFecha(lista.get(i).getKey().first);
            dr.setHoraInicio(lista.get(i).getKey().second);
            dr.setHoraFin(lista.get(i).getKey().third);
            dr.setReserva(r);
            drs.add(dr);
            
        }
        
        r.setDiasReserva(drs);
        
        DAO_Reservas.getInstance().insert(r);
        
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
    
    public Collection<Pair<Integer,Aula>> obtenerAulasDisponibles(boolean C1, boolean C2, int cantAlumnos, String tipoAula, ArrayList<Date> dias, Time horainicio, Time horafin){
        
        
        ArrayList<Aula> aulasCompatibles = (ArrayList)Gestor_Aulas.getInstance().obtenerAulas(cantAlumnos, tipoAula);
        DiaReserva dr=new DiaReserva();
        ArrayList<Pair<Integer,Aula>> aulasYSolapamientos=new ArrayList();
        
        for (int i=0;i<aulasCompatibles.size();i++)
        {
            dr.setAula(aulasCompatibles.get(i));
            boolean libre=true;
            for(int j=0;j<dias.size();j++)
            {
                dr.setFecha(dias.get(j));
                dr.setHoraInicio(horainicio);
                dr.setHoraFin(horafin);
                
                if(!DAO_Reservas.getInstance().find(dr).isEmpty()) libre=false;
                
            }
            
            if(libre){
                aulasYSolapamientos.add(new Pair(0,aulasCompatibles.get(i)));
            }
            
        }
        
        if(aulasYSolapamientos.isEmpty()){
            
            //AQUI CORRESPONDE EL CODIGO AL METODO QUE MANEJA LOS SOLAPAMIENTOS
            
        }
        
        return aulasYSolapamientos;
        
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
