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
public class ErrorUpdateException extends Exception {

    /**
     * Creates a new instance of <code>ErrorUpdateException</code> without
     * detail message.
     */
    public ErrorUpdateException() {
    }

    /**
     * Constructs an instance of <code>ErrorUpdateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ErrorUpdateException(String msg) {
        super(msg);
    }
}
