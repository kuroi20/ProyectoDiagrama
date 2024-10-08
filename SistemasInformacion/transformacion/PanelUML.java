/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package transformacion;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelUML extends JPanel {
    private BufferedImage imagen;
    private JLabel imagenPanel; // Para mostrar la imagen
    

    public PanelUML() {
        setLayout(new BorderLayout()); // Usar BorderLayout para organizar los paneles
        
        JDesktopPane panelContenido = new JDesktopPane();
        // Crear el panel para mostrar la imagen
        imagenPanel = new JLabel();
        imagenPanel.setHorizontalAlignment(JLabel.CENTER);
        add(imagenPanel, BorderLayout.CENTER);

        // Crear el panel de selección de archivos
        JPanel selectorPanel = new JPanel();
        // Añadir el panel de selección al panel principal
        add(selectorPanel, BorderLayout.NORTH);
        
        JButton botonArchivo = new JButton("Seleccionar archivo UML");
        botonArchivo.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Archivos UML (*.uml, *.xmi, *.xml, *.mdj)", "uml", "xmi", "xml", "mdj");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                System.out.println("Archivo UML seleccionado: " + filePath);
            }
        });
        
        // Añadir el botón al panel de selección
        selectorPanel.add(botonArchivo);

        // Crear el botón para seleccionar imágenes
        JButton imagenBoton = new JButton("Seleccionar Imagen UML");
        imagenBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear el selector de archivos para imágenes
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes (JPG, PNG, JPEG)", "jpg", "png","jpeg");
                fileChooser.setFileFilter(filter);
                
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    cargarImagen(filePath); // Cargar y mostrar la imagen
                }
            }
        });

        // Añadir el botón para imágenes al panel de selección
        selectorPanel.add(imagenBoton);
        
        
        // Crear el botón para seleccionar herramientas
        JButton herramientaBoton = new JButton("Barra Herramienta");
        herramientaBoton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    BarraHerramienta barra = new BarraHerramienta(panelContenido);
                    panelContenido.add(barra);
            }
        });
        selectorPanel.add(panelContenido.add(herramientaBoton), BorderLayout.CENTER);
        // Crear Boton para guardar Imagen en la BD
        JButton GuardarBoton = new JButton("Guardar en BD");
        GuardarBoton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    Visualizacion visua = new Visualizacion(panelContenido);
                    panelContenido.add(visua);
            }
        });
        selectorPanel.add(panelContenido.add(GuardarBoton), BorderLayout.CENTER);

    }

    private void cargarImagen(String rutaImagen) {
        try {
            // Cargar la imagen desde el archivo
            imagen = ImageIO.read(new File(rutaImagen));
            imagenPanel.setIcon(new ImageIcon(imagen));
            
            // Ajustar el tamaño del JFrame al tamaño de la imagen
            int imgAncho = imagen.getWidth();
            int imgAlto = imagen.getHeight();
            // Cambiar el tamaño del frame para ajustarse al tamaño de la imagen
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.setSize(new Dimension(imgAncho + 100 , imgAlto + 100)); 
            topFrame.setLocationRelativeTo(null); 
            repaint(); // Redibujar el panel
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen UML: " + e.getMessage());
        }
    }

}

