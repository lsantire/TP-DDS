/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Facundo
 */
public class FrameController {
    
    private static Stack<JFrame> pila=new Stack();
    
    public static void push(JFrame frame){
        frame.setIconImage(new ImageIcon(FrameController.class.getResource("/Interfaz/iconoround.png")).getImage());
        frame.setResizable(false);
        if(!pila.isEmpty()){
            pila.peek().setEnabled(false);
            pila.peek().setVisible(false);}
        pila.push(frame);
        frame.setEnabled(true);
        frame.setVisible(true);
        frame.toFront();
    }
    
    public static JFrame pop(){
        pila.peek().dispose();
        pila.pop();
        if(!pila.isEmpty()){
            pila.peek().setEnabled(true);
            pila.peek().setVisible(true);
        }
        if(pila.isEmpty()) return new JFrame();
        return pila.peek();
    }
    
}
