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

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isCanion() {
        return canion;
    }

    public void setCanion(boolean canion) {
        this.canion = canion;
    }

    public int getCantidadPcs() {
        return cantidadPcs;
    }

    public void setCantidadPcs(int cantidadPcs) {
        this.cantidadPcs = cantidadPcs;
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
        retorno+=", "+cantidadPcs+" PCs";
        
        if(aireAcondicionado){
            retorno+=", Aire Acondicionado";
        }
        if(canion){
            retorno+=", Cañon";
        }
        
        
        return retorno;
    }
    
    
}
