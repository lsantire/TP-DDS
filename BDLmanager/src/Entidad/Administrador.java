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
public class Administrador {
    private String id;
    private String contrasenia;
    private Collection<ContraseniaAnterior> contraseniasAnteriores;

    public Administrador(String id, String contrasenia, Collection<ContraseniaAnterior> contraseniasAnteriores) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.contraseniasAnteriores = contraseniasAnteriores;
    }
    
    
    
}
