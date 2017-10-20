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
public class Curso {
    private int id;
    private String nombreCurso;

    public Curso(int id, String nombreCurso) {
        this.id = id;
        this.nombreCurso = nombreCurso;
    }
    
    public Curso (){
        
    }
    
}
