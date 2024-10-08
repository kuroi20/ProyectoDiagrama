/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacion;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame{
    
    public Ventana(){
        this.setTitle("LIENZO");
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        JDesktopPane panelContenido = new JDesktopPane();
        this.add(panelContenido, BorderLayout.CENTER);
        
        
        JButton botonHerra = new JButton("BarraHer");
        botonHerra.setBounds( 100, 90,250 , 23);
        panelContenido.add(botonHerra);
        
        botonHerra.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                BarraHerramienta barra = new BarraHerramienta(panelContenido);
                panelContenido.add(barra);
            }
        });
        
    }
}

