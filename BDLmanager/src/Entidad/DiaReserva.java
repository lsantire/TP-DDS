/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

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
}
