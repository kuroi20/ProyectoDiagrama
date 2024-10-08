/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacion;

import javax.swing.JFrame;

/**
 *
 * @author tody_
 */
public class Main {
    public static void main(String[] args) {
        JFrame panelUsuario = new JFrame("Transform UML");
        panelUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelUML combinedPanel = new PanelUML();
        panelUsuario.add(combinedPanel);
        panelUsuario.setSize(1250, 800); 
        panelUsuario.setLocationRelativeTo(null); 
        panelUsuario.setVisible(true);
    }
}
