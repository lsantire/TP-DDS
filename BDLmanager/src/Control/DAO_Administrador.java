/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Administrador;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class DAO_Administrador {
    
    //Patrón Singleton
    private static DAO_Administrador instance=null;
    private DAO_Administrador(){};
    public static DAO_Administrador getInstance(){
        if(instance==null) instance=new DAO_Administrador();
        return instance;
    }
    
    public Collection<Administrador> find (){
        return new ArrayList();
    }
    
}
