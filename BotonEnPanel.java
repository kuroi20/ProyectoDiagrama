/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacion;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;

public class BotonEnPanel {

    public static void main(String[] args) {
        // Crear el marco (window)
        JFrame frame = new JFrame("Selector de Imagen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);  // Aumentar el tamaño de la ventana para mostrar la imagen
        
         // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Crear el panel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        
        // Crear el botón
        JButton button = new JButton("Seleccionar Imagen");
        button.setBounds(200, 20, 200, 25);  // Posición y tamaño del botón
        panel.add(button);
        
        // Crear un JLabel donde se mostrará la imagen
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(50, 70, 500, 500);  // Posición y tamaño del área para la imagen
        panel.add(imageLabel);
        
        // Agregar la funcionalidad del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear el selector de archivos
                JFileChooser fileChooser = new JFileChooser();
                
                // Crear un filtro para permitir solo imágenes (jpg, png)
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes (JPG, PNG)", "jpg", "png");
                fileChooser.setFileFilter(filter);
                
                // Permitir seleccionar solo archivos
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
                // Mostrar el diálogo de selección
                int result = fileChooser.showOpenDialog(null);
                
                // Si el usuario selecciona un archivo
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    
                    // Cargar la imagen seleccionada
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    
                    // Redimensionar la imagen si es más grande que el área disponible
                    Image image = imageIcon.getImage();
                    Image resizedImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(resizedImage);
                    
                    // Mostrar la imagen en el JLabel
                    imageLabel.setIcon(imageIcon);
                }
            }
        });
    }
}

