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
public class NoCumplePoliticaException extends Exception {

    /**
     * Creates a new instance of <code>NoCumplePoliticaException</code> without
     * detail message.
     */
    public NoCumplePoliticaException() {
    }

    /**
     * Constructs an instance of <code>NoCumplePoliticaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoCumplePoliticaException(String msg) {
        super(msg);
    }
}
