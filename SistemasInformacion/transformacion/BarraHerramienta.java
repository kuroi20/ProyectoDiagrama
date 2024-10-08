/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacion;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BarraHerramienta extends JFrame{
    
        private JPanel contentPane;
        private JLabel etiqueta;
    
    public BarraHerramienta(JDesktopPane ventana){
        //super("Barra de Herramientas", true, true, true, true);
        this.setSize(600, 400);
        this.setLocation(50,50);
        this.setVisible(true);
        
        
        contentPane = new JPanel();
        contentPane.setLayout(null);
        this.setContentPane(contentPane);
        
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JButton botonClase = new JButton(loadIcon("Imagenes/Clase.png", 120, 50));
        botonClase.setToolTipText("Define Atributos y metodos");

        JButton botonAsociacion = new JButton(loadIcon("Imagenes/Asociacion.png", 120, 50));
        botonAsociacion.setToolTipText("Conecta dos clases donde una usa o tiene referencia a la otra.");
        
        JButton botonComposicion = new JButton(loadIcon("Imagenes/Composicion.png", 120, 50));
        botonComposicion.setToolTipText("Relacion donde una clase depende de la otra para existir");
        
        JButton botonAgregacion = new JButton(loadIcon("Imagenes/Agregacion.png", 120, 50));
        botonAgregacion.setToolTipText("Relacion donde una clase puede existir sin importar del otro");
        
        JButton botonGeneralizacion = new JButton(loadIcon("Imagenes/Generalizacion.png", 120, 50));
        botonGeneralizacion.setToolTipText("Jerarquia de clases");

        botonClase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Clase panelC = new Clase();
                ventana.add(panelC);
                
            }
        });
        
        
        Dimension buttonSize = new Dimension(120, 50);
        botonClase.setPreferredSize(buttonSize);
        botonAsociacion.setPreferredSize(buttonSize);
        botonComposicion.setPreferredSize(buttonSize);
        botonAgregacion.setPreferredSize(buttonSize);
        botonGeneralizacion.setPreferredSize(buttonSize);

        botonClase.setMaximumSize(buttonSize);
        botonAsociacion.setMaximumSize(buttonSize);
        botonComposicion.setMaximumSize(buttonSize);
        botonAgregacion.setMaximumSize(buttonSize);
        botonGeneralizacion.setMaximumSize(buttonSize);
        // joel
        
        contentPane.add(botonClase);
        contentPane.add(botonAsociacion);
        contentPane.add(botonComposicion);
        contentPane.add(botonAgregacion);
        contentPane.add(botonGeneralizacion);
        
         contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        
        
        
    }
    
    private static ImageIcon loadIcon(String path, int width, int height){
        ImageIcon originalIcon = new ImageIcon(BarraHerramienta.class.getResource("/" + path));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    
}

