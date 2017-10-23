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
public class AulaInformatica extends Aula{
    
    private boolean aireAcondicionado;
    private boolean canion;
    private int cantidadPcs;

    public AulaInformatica(int capacidad, boolean habilitado, int id, String nombreAula, String tipoPizarron, int piso, boolean aireAcondicionado, boolean canion, int cantidadPcs) {
        
        this.capacidad=capacidad;
        this.habilitado=habilitado;
        this.id=id;
        this.nombreAula=nombreAula;
        this.tipoPizarron=tipoPizarron;
        this.piso=piso;
        
        this.aireAcondicionado = aireAcondicionado;
        this.canion = canion;
        this.cantidadPcs = cantidadPcs;
    }
    
    public AulaInformatica (){
        
    }
    
}
