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
public class Aula {
    
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

    public Aula() {
        capacidad=0;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTipoPizarron() {
        return tipoPizarron;
    }

    public void setTipoPizarron(String tipoPizarron) {
        this.tipoPizarron = tipoPizarron;
    }

    public Collection<DiaReserva> getDiasReserva() {
        return diasReserva;
    }

    public void setDiasReserva(Collection<DiaReserva> diasReserva) {
        this.diasReserva = diasReserva;
    }
    
    
    
}
