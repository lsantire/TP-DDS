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
public class AulaMultimedios extends Aula{
    
    private boolean aireAcondicionado;
    private boolean canion;
    private boolean computadora;
    private boolean dvd;
    private boolean televisor;

    public AulaMultimedios(int capacidad, boolean habilitado, int id, String nombreAula, String tipoPizarron, int piso, boolean aireAcondicionado, boolean canion, boolean computadora, boolean dvd, boolean televisor) {
        
        this.capacidad=capacidad;
        this.habilitado=habilitado;
        this.id=id;
        this.nombreAula=nombreAula;
        this.tipoPizarron=tipoPizarron;
        this.piso=piso;
        
        this.aireAcondicionado = aireAcondicionado;
        this.canion = canion;
        this.computadora = computadora;
        this.dvd = dvd;
        this.televisor = televisor;
    }
    
    
    
}
