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
public class AulaSinRecursos extends Aula{
    
    private String tipoClimatizacion; //Deberia ser ENUM

    public AulaSinRecursos(int capacidad, boolean habilitado, int id, String nombreAula, String tipoPizarron, int piso, String tipoClimatizacion) {
        this.capacidad=capacidad;
        this.habilitado=habilitado;
        this.id=id;
        this.nombreAula=nombreAula;
        this.tipoPizarron=tipoPizarron;
        this.piso=piso;
        
        this.tipoClimatizacion = tipoClimatizacion;
    }

    
    public AulaSinRecursos(){
        
    }
    
    
}
