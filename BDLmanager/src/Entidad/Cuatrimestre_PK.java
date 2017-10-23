/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Facundo
 */

@Embeddable
public class Cuatrimestre_PK implements Serializable{
    
    private int cicloLectivo;
    private Date fechaInicio;

    public Cuatrimestre_PK() {
    }

    public Cuatrimestre_PK(int cicloLectivo, Date fechaInicio) {
        this.cicloLectivo = cicloLectivo;
        this.fechaInicio = fechaInicio;
    }

    public int getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(int cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    
    
}
