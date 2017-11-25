/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Facundo
 */
public class ErrorNuevaReservaException extends Exception {

    /**
     * Creates a new instance of <code>ErrorNuevaReservaException</code> without
     * detail message.
     */
    public ErrorNuevaReservaException() {
    }

    /**
     * Constructs an instance of <code>ErrorNuevaReservaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ErrorNuevaReservaException(String msg) {
        super(msg);
    }
}
