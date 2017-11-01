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
public class Docente implements Comparable<Docente>{
    
    @Id
    private int dni;
    private String nombreYApellido;
    private String mail;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente", targetEntity = Reserva.class)
    private Collection<Reserva> reservas;

    public Docente(int dni, String nombreYApellido) {
        this.dni = dni;
        this.nombreYApellido = nombreYApellido;
    }
    
    public Docente (){
        
    }

    public String getMail() {
        return mail;
    }

    @Override
    public int compareTo(Docente o) {
        return this.nombreYApellido.compareTo(o.toString());
    }
    
    @Override
    public String toString(){
        return this.nombreYApellido;
    }

}
