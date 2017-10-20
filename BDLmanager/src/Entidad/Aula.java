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
public abstract class Aula {
    protected int capacidad;
    protected boolean habilitado;
    protected int id;
    protected String nombreAula;
    protected int piso;
    protected String tipoPizarron; //Deberia ser una ENUM, x lo menos en la implementacion
}
