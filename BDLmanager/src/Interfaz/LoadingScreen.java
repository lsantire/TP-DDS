/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Facundo
 */
public class LoadingScreen {
    
    JFrame frame=null;
    
    public LoadingScreen(){
        frame = new JFrame();
        frame.getContentPane().add(new ImagePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(0, 53, 118, 0));
        frame.setVisible(true);
        FrameController.push(frame);
    }
    
    public void dispose(){
        this.frame.dispose();
    }

    private static class ImagePanel extends JPanel {

        Image img;

        public ImagePanel() {
            setOpaque(false);
            setLayout(new GridBagLayout());
            img = new ImageIcon(getClass().getResource("/Interfaz/loading.gif")).getImage();
            

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(64, 64);
        }
        
    }
    
}
