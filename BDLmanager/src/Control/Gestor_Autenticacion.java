/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.*;
import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class Gestor_Autenticacion {
    
    private static Bedel bedelActual;
    private static Administrador adminActual;
    
    //Patrón Singleton
    private static Gestor_Autenticacion instance=null;
    private Gestor_Autenticacion(){};
    public static Gestor_Autenticacion getInstance(){
        if(instance==null) instance=new Gestor_Autenticacion();
        return instance;
    }
    
    public boolean autenticarBedel(String id, String contrasenia){
        
        Bedel bdl=new Bedel();
        bdl.setContrasenia(contrasenia);
        bdl.setId(id);
        ArrayList<Bedel> retorno = (ArrayList<Bedel>)DAO_Bedeles.getInstance().find(bdl);
        
        if(retorno.size()!=1){
            return false;
        }else{
            bedelActual=retorno.get(0);
            adminActual=null;
        }
        
        return true;
        
    }
    
    public boolean autenticarAdministrador(String id, String contrasenia){
        
        ArrayList<Administrador> retorno =(ArrayList<Administrador>)DAO_Administrador.getInstance().find(id,contrasenia);
        
        if(retorno.size()!=1){
            return false;
        }else{
            adminActual=retorno.get(0);
            bedelActual=null;
            return true;
        }
        
    }

    public static Bedel getBedelActual() {
        return bedelActual;
    }

    public static void setBedelActual(Bedel bedelActual) {
        Gestor_Autenticacion.bedelActual = bedelActual;
    }

    public static Administrador getAdminActual() {
        return adminActual;
    }

    public static void setAdminActual(Administrador adminActual) {
        Gestor_Autenticacion.adminActual = adminActual;
    }
    
    
    
}
