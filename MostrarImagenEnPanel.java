/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package transformacion;



import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MostrarImagenEnPanel extends JPanel {
    private BufferedImage imagen;

    public MostrarImagenEnPanel(String rutaImagen) {
        try {
            // Cargar la imagen desde el archivo
            imagen = ImageIO.read(new File(rutaImagen));
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagen != null) {
            // Obtener dimensiones originales de la imagen
            int width = imagen.getWidth();
            int height = imagen.getHeight();

            // Obtener dimensiones del panel
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calcular el factor de escala para mantener la proporción
            double scaleX = (double) panelWidth / width;
            double scaleY = (double) panelHeight / height;
            double scale = Math.min(scaleX, scaleY); // Mantiene la imagen dentro del panel y conserva proporción

            // Calcular nuevas dimensiones de la imagen redimensionada
            int newWidth = (int) (width * scale);
            int newHeight = (int) (height * scale);

            // Dibujar la imagen centrada en el panel
            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;
            g.drawImage(imagen, x, y, newWidth, newHeight, this);
        }
    }

    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Imagen Proporcional en el Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel y cargar la imagen
        MostrarImagenEnPanel panelConImagen = new MostrarImagenEnPanel("E:\\OneDrive\\Desktop\\Main.jpg");

        // Añadir el panel al frame
        frame.add(panelConImagen);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
