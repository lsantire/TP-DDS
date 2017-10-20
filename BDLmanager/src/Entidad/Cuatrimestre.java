/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Facundo
 */
public class Cuatrimestre {
    private int cicloLectivo;
    private Date fechaInicio;
    private Date fechaFin;

    public Cuatrimestre(int cicloLectivo, Date fechaInicio, Date fechaFin) {
        this.cicloLectivo = cicloLectivo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public Cuatrimestre (){
        
    }
    
}
