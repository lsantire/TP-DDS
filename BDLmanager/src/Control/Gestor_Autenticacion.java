/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Facundo
 */
public class Gestor_Autenticacion {
    
    private static String usuarioActual;
    
    //Patrón Singleton
    private static Gestor_Autenticacion instance=null;
    private Gestor_Autenticacion(){};
    public static Gestor_Autenticacion getInstance(){
        if(instance==null) instance=new Gestor_Autenticacion();
        return instance;
    }
    
    public boolean autenticarUsuario(String id, String contrasenia){
        
        //a implementar
        
        return true;
        
    }
    
}
