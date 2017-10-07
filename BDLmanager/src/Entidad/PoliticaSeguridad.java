/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Facundo
 */
public class PoliticaSeguridad {
    
    private boolean debeEspecial;
    private boolean debeUnNumero;
    private boolean debeUnaMayus;
    private boolean puedeRepetirse;
    private boolean vigente;
    private int id;
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
    
}
