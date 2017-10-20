/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Facundo
 */
public class DiaReserva {
    
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;
    private int id;
    private Reserva reserva;
    private Aula aula;

    public DiaReserva(Date fecha, Time horaInicio, Time horaFin, int id, Reserva reserva, Aula aula) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.id = id;
        this.reserva = reserva;
        this.aula = aula;
    }
    
    public DiaReserva(){
        
    }
    
}
