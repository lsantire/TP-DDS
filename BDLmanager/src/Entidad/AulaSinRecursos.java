/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Collection;
import javax.persistence.*;
/**
 *
 * @author Facundo
 */

@Entity
public class AulaSinRecursos extends Aula{
    
    private String tipoClimatizacion; //Deberia ser ENUM

    public AulaSinRecursos(int capacidad, boolean habilitado, int id, String nombreAula, String tipoPizarron, int piso, String tipoClimatizacion) {
        this.capacidad=capacidad;
        this.habilitado=habilitado;
        this.id=id;
        this.nombreAula=nombreAula;
        this.tipoPizarron=tipoPizarron;
        this.piso=piso;
        
        this.tipoClimatizacion = tipoClimatizacion; //Aire acondicionado, Ventiladores, N/A
    }

    
    public AulaSinRecursos(){
        
    }

    public String getTipoClimatizacion() {
        return tipoClimatizacion;
    }

    public void setTipoClimatizacion(String tipoClimatizacion) {
        this.tipoClimatizacion = tipoClimatizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTipoPizarron() {
        return tipoPizarron;
    }

    public void setTipoPizarron(String tipoPizarron) {
        this.tipoPizarron = tipoPizarron;
    }

    public Collection<DiaReserva> getDiasReserva() {
        return diasReserva;
    }

    public void setDiasReserva(Collection<DiaReserva> diasReserva) {
        this.diasReserva = diasReserva;
    }
    
    
        @Override
    public String getResumenCaracteristicas(){
        
        String retorno="";
        
        retorno+=tipoPizarron;
        retorno+=", "+tipoClimatizacion;
        
        
        return retorno;
    }
    
    

    
}
