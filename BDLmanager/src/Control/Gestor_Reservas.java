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
    
    public void crearReserva (int cantAlumnos, boolean C1, boolean C2, Docente docente, Curso curso, Bedel bedel, ArrayList<Pair<Triple<Date,Time,Time>,Aula>> listaDiasAulas){
        
        Reserva r = new Reserva();
        r.setBedel(bedel);
        r.setCantidadAlumnos(cantAlumnos);
        if(C1 || C2){r.setEsPeriodica(true);}else{r.setEsPeriodica(false);}
        r.setCurso(curso);
        r.setDocente(docente);
        Collection<DiaReserva> drs = new ArrayList();
        
        for (int i=0;i<listaDiasAulas.size();i++){
            
            DiaReserva dr=new DiaReserva();
            dr.setAula(listaDiasAulas.get(i).getValue());
            dr.setFecha(listaDiasAulas.get(i).getKey().first);
            dr.setHoraInicio(listaDiasAulas.get(i).getKey().second);
            dr.setHoraFin(listaDiasAulas.get(i).getKey().third);
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
    
    public ArrayList<Triple<Integer,DiaReserva,Aula>> obtenerAulasDisponibles(boolean C1, boolean C2, int cantAlumnos, String tipoAula, ArrayList<Date> dias, Time horainicio, Time horafin){
        
        
        ArrayList<Aula> aulasCompatibles = (ArrayList)Gestor_Aulas.getInstance().obtenerAulas(cantAlumnos, tipoAula);
        DiaReserva dr=new DiaReserva();
        ArrayList<Triple<Integer,DiaReserva,Aula>> aulasYSolapamientos=new ArrayList();
        
        //primero se buscan aulas compatibles con 100% de disponibilidad
        for (int i=0;i<aulasCompatibles.size();i++)
        {
            dr.setAula(aulasCompatibles.get(i));
            boolean libre=true;
            for(int j=0;j<dias.size();j++)
            {
                dr.setFecha(dias.get(j));
                dr.setHoraInicio(horainicio);
                dr.setHoraFin(horafin);
                
                if(!DAO_Reservas.getInstance().verificarDisponibilidad(dr).isEmpty()) libre=false;
                
            }
            
            if(libre){
                aulasYSolapamientos.add(new Triple(0,null,aulasCompatibles.get(i)));
            }
            
        }
        
        //En el caso de que no se encuentren, se buscan aulas compatibles con solapamiento.
        if(aulasYSolapamientos.isEmpty()){
            
            for (int i=0;i<aulasCompatibles.size();i++)
                {
                    dr.setAula(aulasCompatibles.get(i));
                    ArrayList<Pair<Integer,DiaReserva>> listaSolapamientos=new ArrayList();
                    for(int j=0;j<dias.size();j++)
                    {
                        dr.setFecha(dias.get(j));
                        dr.setHoraInicio(horainicio);
                        dr.setHoraFin(horafin);
                
                        ArrayList<DiaReserva> drsQueSolapan=(ArrayList<DiaReserva>) DAO_Reservas.getInstance().verificarDisponibilidad(dr);
                        Pair<Integer,DiaReserva> solapamiento=this.calcularSolapamientos(dr, drsQueSolapan);
                        listaSolapamientos.add(solapamiento);
                        
                    }
                    
                    
                    //no es dr
                    Pair<Integer,DiaReserva> maxSolap=new Pair(0,null);
                    for(int k=0;k<listaSolapamientos.size();k++){
                        if(listaSolapamientos.get(k).getKey()>maxSolap.getKey()){maxSolap=listaSolapamientos.get(k);}
                    }
                    aulasYSolapamientos.add(new Triple(maxSolap.getKey(),maxSolap.getValue(),maxSolap.getValue().getAula()));
                    
                }
            
                //Reordenar segun solapamiento decreciente
                /*for(int i=0;i<aulasYSolapamientos.size();i++){
                    
                    for(int j=0;j<aulasYSolapamientos.size()-i;j++){
                        
                        if(aulasYSolapamientos.get(j).first>aulasYSolapamientos.get(j+1).first){
                            Triple taux=aulasYSolapamientos.get(j);
                            aulasYSolapamientos.set(j, aulasYSolapamientos.get(j+1));
                            aulasYSolapamientos.set(j+1, taux);
                        }
                        
                    }
                    
                }*/
            
            
            }
        

        
        return aulasYSolapamientos;
     
        
    }
    
    private Pair<Integer,DiaReserva> calcularSolapamientos(DiaReserva dr, ArrayList<DiaReserva> drs){
        
        //Este metodo debe, dado un dia reserva y una coleccion de dias reserva, evaluar cual dia reserva de "drs" es el que genera
        //el maximo grado de solapamiento, ponderarlo (en el integer) y devolverlo, junto con ese mismo dia reserva que genero el solapamiento.
        
        Pair<Integer,DiaReserva> retorno=null;
        long solapamientoEnMS=0;
        long solapamientoEnMS_aux=0;
        DiaReserva causanteSolapamiento=null;
        
        Time hf=dr.getHoraFin();
        Time hi=dr.getHoraInicio();
        Time _hf;
        Time _hi;
        
        for(int i=0;i<drs.size();i++){
            
            _hf=drs.get(i).getHoraFin();
            _hi=drs.get(i).getHoraInicio();
            
            
            //Se plantean los 9 posibles casos de overlapping
            
            //1. Start inside: _hi < hi && hi< _hf && _hf<hf
            if(_hi.before(hi) && hi.before(_hf) && _hf.before(hf)){
                solapamientoEnMS_aux=_hf.getTime()-hi.getTime();
            }
            
            //2. Inside start touching _hi==hi && hf<_hf
            if(_hi.equals(hi) && hf.before(_hf)){
                solapamientoEnMS_aux=hf.getTime()-hi.getTime();
            }
            
            //3. Enclosign start touching _hi==hi && _hf<hf
            if(_hi.equals(hi) && _hf.before(hf)){
                solapamientoEnMS_aux=_hf.getTime()-hi.getTime();
            }
            
            //4. Enclosing hi<_hi && _hf<hf
            if(hi.before(_hi) && _hf.before(hf)){
                solapamientoEnMS_aux=_hf.getTime()-_hi.getTime();
            }
            
            //5. Enclosing end touching hi<_hi && hf==_hf
            if(hi.before(_hi) && _hf.equals(hf)){
                solapamientoEnMS_aux=hf.getTime()-_hi.getTime();
            }
            
            //6. Exact Match hi==_hi && hf==_hf
            if(hi.equals(_hi) && hf.equals(_hf)){
                solapamientoEnMS_aux=hf.getTime()-hi.getTime();
            }
            
            //7. Inside _hi<hi && hf<_hf
            if(_hi.before(hi) && hf.before(_hf)){
                solapamientoEnMS_aux=hf.getTime()-hi.getTime();
            }
            
            //8. Inside end touching _hi<hf && hf==_hf
            if(_hi.before(hi) && hf.equals(_hf)){
                solapamientoEnMS_aux=hf.getTime()-hi.getTime();
            }
            
            //9. End inside _hi<hf && hi<_hi && hf<_hf
            if(_hi.before(hf) && hi.before(_hi) && hf.before(_hf)){
                solapamientoEnMS_aux=hf.getTime()-_hi.getTime();
            }
            
            if(solapamientoEnMS_aux>solapamientoEnMS){
                causanteSolapamiento=drs.get(i);
                solapamientoEnMS=solapamientoEnMS_aux;
                solapamientoEnMS_aux=0;
            }
            
        }
        
        retorno=new Pair((Integer)(int)(solapamientoEnMS/60000),causanteSolapamiento);        
        
        return retorno;
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
