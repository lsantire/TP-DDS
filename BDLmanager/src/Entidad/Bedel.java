/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author Facundo
 */

@Entity
public class Bedel {
    
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String turno; //deberia ser una enumeracion, por lo menos en la implementacion (facilita que si se agrega un elemento a la enum va a andar igual)
    private boolean eliminado;
    
    @OneToMany(targetEntity = ContraseniaAnteriorBedel.class, mappedBy = "bedel", cascade = CascadeType.ALL)
    private Collection<ContraseniaAnteriorBedel> contraseniasAnteriores;
    
    @OneToMany(targetEntity = Reserva.class, mappedBy="bedel", cascade = CascadeType.PERSIST)
    private Collection<Reserva> reservas;

    public Bedel (){
        
    }
    
    public Bedel(String nombre, String apellido, String id, String contrasenia, String turno, boolean eliminado, Collection<ContraseniaAnteriorBedel> contraseniasAnteriores, Collection<Reserva> reservas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.contrasenia = contrasenia;
        this.turno = turno;
        this.eliminado = eliminado;
        this.contraseniasAnteriores = contraseniasAnteriores;
        this.reservas = reservas;
    }
    
    public Bedel(String nombre, String apellido, String id, String contrasenia, String turno){
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.contrasenia = contrasenia;
        this.turno = turno;
        this.eliminado=false;
        this.contraseniasAnteriores=new ArrayList();
        this.reservas=new ArrayList();
    }
    
    public Bedel(String id){
        nombre=null;
        apellido=null;
        this.id=id;
        contrasenia=null;
        turno=null;
        eliminado=false;
        contraseniasAnteriores=null;
        reservas=null;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contrasenia;
    }

    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Collection<ContraseniaAnteriorBedel> getContraseniasAnteriores() {
        return contraseniasAnteriores;
    }

    public void setContraseniasAnteriores(Collection<ContraseniaAnteriorBedel> contraseniasAnteriores) {
        this.contraseniasAnteriores = contraseniasAnteriores;
    }

    public Collection<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Collection<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    
    
    
}
