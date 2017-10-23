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
public abstract class Aula {
    
    @Id
    @GeneratedValue
    protected int id;
    protected int capacidad;
    protected boolean habilitado;
    protected String nombreAula;
    protected int piso;
    protected String tipoPizarron; 
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aula", targetEntity = DiaReserva.class)
    protected Collection<DiaReserva> diasReserva;
}
