/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Reserva;
import java.util.ArrayList;
import java.util.Collection;

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
    
}
