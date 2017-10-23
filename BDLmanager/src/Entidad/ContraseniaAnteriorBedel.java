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
public class ContraseniaAnteriorBedel {
    
    @Id
    @GeneratedValue
    private int id;
    private String contrasenia;
    
    @ManyToOne
    @JoinColumn(name = "idBedelFK")
    private Bedel bedel;
    
    public ContraseniaAnteriorBedel(){
        
    }
    
    public ContraseniaAnteriorBedel(String contrasenia){
        this.contrasenia=contrasenia;
    }
    
}
