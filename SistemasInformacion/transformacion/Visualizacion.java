/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Visualizacion extends JFrame{
     private static File selectedFile = null;
    public Visualizacion(JDesktopPane ventana){
        JFrame frame = new JFrame("Visualizar Herramientas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem cargarImagenMenuItem = new JMenuItem("Añadir Imagen");
        JMenuItem guardarImagenMenuItem = new JMenuItem("Guardar Imagen en BD");

        menuArchivo.add(cargarImagenMenuItem);
        menuArchivo.add(guardarImagenMenuItem);
        menuBar.add(menuArchivo);
        frame.setJMenuBar(menuBar);


        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel();
        imagePanel.add(imageLabel);
        frame.getContentPane().add(imagePanel, BorderLayout.CENTER);

        cargarImagenMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);

                if(result == JFileChooser.APPROVE_OPTION){
                    selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());

                    Image scaledImage = imageIcon.getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(scaledImage));
                    frame.revalidate();
                }
            }
        });

        guardarImagenMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(selectedFile != null){
                    Conexion conexion = new Conexion();
                    try{
                        conexion.guardarImagenEnBD(selectedFile);
                        JOptionPane.showMessageDialog(frame, "Imagen guardada en la base de datos correctamente.");
                    }catch(SQLException | IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error al guardar la imagen: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "No se ha cargado ninguna imagen.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        
        frame.setVisible(true);
    }
    
}
