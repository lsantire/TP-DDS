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
public class Bedel {
    
    private String nombre;
    private String apellido;
    private String id;
    private String contraseña;
    private String turno; //deberia ser una enumeracion, por lo menos en la implementacion (facilita que si se agrega un elemento a la enum va a andar igual)
    private boolean eliminado;
    private Collection<ContraseniaAnterior> contraseniasAnteriores;
    private Collection<Reserva> reservas;

    public Bedel(String nombre, String apellido, String id, String contraseña, String turno, boolean eliminado, Collection<ContraseniaAnterior> contraseniasAnteriores, Collection<Reserva> reservas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.contraseña = contraseña;
        this.turno = turno;
        this.eliminado = eliminado;
        this.contraseniasAnteriores = contraseniasAnteriores;
        this.reservas = reservas;
    }
    
    
    
}
