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
public class ErrorInsercionException extends Exception {

    /**
     * Creates a new instance of <code>ErrorInsercionException</code> without
     * detail message.
     */
    public ErrorInsercionException() {
    }

    /**
     * Constructs an instance of <code>ErrorInsercionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ErrorInsercionException(String msg) {
        super(msg);
    }
}
