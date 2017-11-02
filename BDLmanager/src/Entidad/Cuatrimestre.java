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

@Entity
public class Cuatrimestre {
    
    @Id
    private Cuatrimestre_PK cuatrimestrePK;
    private Date fechaFin;

    public Cuatrimestre(int cicloLectivo, Date fechaInicio, Date fechaFin) {
        this.cuatrimestrePK=new Cuatrimestre_PK();
        cuatrimestrePK.setCicloLectivo(cicloLectivo);
        cuatrimestrePK.setFechaInicio(fechaInicio);
        this.fechaFin = fechaFin;
    }
    
    public Cuatrimestre (){
        
    }

    public Date getFechaInicio(){
        return this.cuatrimestrePK.getFechaInicio();
    }
    
    public Date getFechaFin() {
        return fechaFin;
    }
    
    public int getCicloLectivo(){
        return this.cuatrimestrePK.getCicloLectivo();
    }
    
}
