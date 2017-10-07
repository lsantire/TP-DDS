/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class Reserva {
    private int cantidadAlumnos;
    private boolean esPeriodica;
    private int id;
    private Collection<DiaReserva> diasReserva;
    private Bedel bedel;
    private Curso curso;
    private Docente docente;

    public Reserva(int cantidadAlumnos, boolean esPeriodica, int id, Collection<DiaReserva> diasReserva, Bedel bedel, Curso curso, Docente docente) {
        this.cantidadAlumnos = cantidadAlumnos;
        this.esPeriodica = esPeriodica;
        this.id = id;
        this.diasReserva = diasReserva;
        this.bedel = bedel;
        this.curso = curso;
        this.docente = docente;
    }
    
    
}
