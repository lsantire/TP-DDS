/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.*;
import java.util.*;

/**
 *
 * @author Facundo
 */
public class Gestor_Aulas {
    
     //Patrón Singleton
    private static Gestor_Aulas instance=null;
    private Gestor_Aulas(){};
    public static Gestor_Aulas getInstance(){
        if(instance==null) instance=new Gestor_Aulas();
        return instance;
    }

    
    public Collection<Aula> obtenerAulas(int cantAlumnos, String tipoAula){
        
        Aula buscador;
        
        switch (tipoAula){
            case "Sin Recursos Adicionales": buscador=new AulaSinRecursos(); ((Aula)buscador).setCapacidad(cantAlumnos); break;
            case "Multimedios": buscador=new AulaMultimedios(); ((Aula)buscador).setCapacidad(cantAlumnos); break;
            case "Informática": buscador=new AulaInformatica(); ((Aula)buscador).setCapacidad(cantAlumnos); break;
            default: buscador=new Aula(); buscador.setCapacidad(cantAlumnos);
        }
        
        Collection<Aula> aulasCompatibles = DAO_Aulas.getInstance().find(buscador);
        
        return aulasCompatibles;
        
    }
    
    public boolean modificarAula(Aula aula){
        
        //a implementar
        return DAO_Aulas.getInstance().update();
    }
    
    
}
