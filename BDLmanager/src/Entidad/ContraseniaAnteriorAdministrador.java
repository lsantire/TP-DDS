/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import javax.persistence.*;

/**
 *
 * @author Facundo
 */

@Entity
public class ContraseniaAnteriorAdministrador {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    @JoinColumn(name="idAdministradorFK")
    private Administrador administrador;
    private String contraseña;

    public ContraseniaAnteriorAdministrador(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public ContraseniaAnteriorAdministrador(){
        
    }
    
    
}
