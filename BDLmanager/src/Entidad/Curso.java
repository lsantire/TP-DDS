/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author Facundo
 */

@Entity
public class Curso implements Comparable<Curso> {
    
    @Id
    private int id;
    private String nombreCurso;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", targetEntity = Reserva.class)
    private Collection<Reserva> reservas;

    public Curso(int id, String nombreCurso) {
        this.id = id;
        this.nombreCurso = nombreCurso;
    }
    
    public Curso (){
        
    }

    @Override
    public int compareTo(Curso o) {
        return this.nombreCurso.compareTo(o.toString());
    }
 
    @Override
    public String toString(){
        return this.nombreCurso;
    }
    
}
