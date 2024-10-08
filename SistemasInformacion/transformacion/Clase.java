/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacion;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class Clase extends JInternalFrame{
      private JPanel contentPane;
    public Clase(){
        super("Clase", true, true, true, true);
        this.setSize(300, 300);
        this.setLocation(50,50);
        this.setVisible(true);
        
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
    }
}

