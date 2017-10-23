/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 * @author Facundo
 */

@Entity
public class Reserva {
    
    @Id
    @GeneratedValue
    private int id;
    private int cantidadAlumnos;
    private boolean esPeriodica;
    
    @OneToMany(mappedBy = "reserva", targetEntity = DiaReserva.class, cascade = CascadeType.ALL)
    private Collection<DiaReserva> diasReserva;
    
    @ManyToOne
    @JoinColumn(name="idBedelFK")
    private Bedel bedel;
    
    @ManyToOne
    @JoinColumn(name="idCursoFK")
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name="dniDocenteFK")
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
    
    public Reserva(){
        
    }
    
}
