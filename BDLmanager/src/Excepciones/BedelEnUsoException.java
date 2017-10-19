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
public class BedelEnUsoException extends Exception {

    /**
     * Creates a new instance of <code>BedelEnUsoException</code> without detail
     * message.
     */
    public BedelEnUsoException() {
    }

    /**
     * Constructs an instance of <code>BedelEnUsoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BedelEnUsoException(String msg) {
        super(msg);
    }
}
