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
public class Administrador {
    
    @Id
    private String id;
    private String contrasenia;
    
    @OneToMany(targetEntity=ContraseniaAnteriorAdministrador.class, mappedBy="administrador", cascade=CascadeType.ALL)
    private Collection<ContraseniaAnteriorAdministrador> contraseniasAnteriores;

    public Administrador(String id, String contrasenia, Collection<ContraseniaAnteriorAdministrador> contraseniasAnteriores) {
        this.id = id;
        this.contrasenia = contrasenia;
        this.contraseniasAnteriores = contraseniasAnteriores;
    }
    
    public Administrador(){
        
    }
    
    
    
}
