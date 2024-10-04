/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisinfo2;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Panel extends JFrame {
    Conexion conexion = new Conexion();
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JButton jButton2;

    public Panel() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel("nombre");
        jLabel2 = new JLabel("IdPersona");
        jTextField1 = new JTextField(10);
        jTextField2 = new JTextField(10);
        jButton1 = new JButton("Registrar");
        jButton2 = new JButton("Mostrar");

        jButton1.addActionListener(evt -> jButton1ActionPerformed());
        jButton2.addActionListener(evt -> jButton1ActionPerformed2());

        setLayout(new java.awt.FlowLayout());

        add(jLabel1);
        add(jTextField1);
        add(jLabel2);
        add(jTextField2);
        add(jButton1);
        add(jButton2);
        

        setLocation(850, 450);
        setTitle("Registrar Personas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private void jButton1ActionPerformed() {
        conexion.registrar(Integer.parseInt(jTextField2.getText()),jTextField1.getText());
        
    }
    private void jButton1ActionPerformed2() {
        conexion.verificarEnBD();
        
    }

    public static void main(String[] args) {
        Panel p = new Panel();
        p.setVisible(true);
    }
}

