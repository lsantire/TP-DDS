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
public class PoliticaSeguridad {
    
    @Id
    private int id;
    private boolean debeEspecial;
    private boolean debeUnNumero;
    private boolean debeUnaMayus;
    private boolean puedeRepetirse;
    private boolean vigente;
    private int longitudMinima;
    
    public PoliticaSeguridad (boolean debeEspecial, boolean debeUnNumero, boolean debeUnaMayus, boolean puedeRepetirse, boolean vigente, int id, int longitudMinima){
        
        this.debeEspecial=debeEspecial;
        this.debeUnNumero=debeUnNumero;
        this.debeUnaMayus=debeUnaMayus;
        this.puedeRepetirse=puedeRepetirse;
        this.vigente=vigente;
        this.id=id;
        this.longitudMinima=longitudMinima;
        
    }
    
    public PoliticaSeguridad(){
        
    }

    public boolean isVigente() {
        return vigente;
    }
    
        
    
    public boolean isDebeEspecial() {
        return debeEspecial;
    }

    public boolean isDebeUnNumero() {
        return debeUnNumero;
    }

    public boolean isDebeUnaMayus() {
        return debeUnaMayus;
    }

    public boolean isPuedeRepetirse() {
        return puedeRepetirse;
    }

    public int getId() {
        return id;
    }

    public int getLongitudMinima() {
        return longitudMinima;
    }
    
    
    
}
