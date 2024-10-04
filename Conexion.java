/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisinfo2;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author tody_
 */
public class Conexion {
    Connection con; 
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://b9br9u8tlhgwppflmhwt-mysql.services.clever-cloud.com:3306/b9br9u8tlhgwppflmhwt","ux6dx9kst0phlebk","nlPWo7Ll234Nbkj3sDDV");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void registrar(int idPersona, String nombre) {
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO b9br9u8tlhgwppflmhwt.Persona (idPersona,nombre) VALUES (?, ?)")) {
            pstmt.setInt(1, idPersona);
            pstmt.setString(2, nombre);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean verificarEnBD(){
       Conexion cn = new Conexion();
       boolean respuesta = false;
       Statement st;
       ResultSet rs;
       try {
            st = cn.con.createStatement();
            rs = st.executeQuery("SELECT * FROM b9br9u8tlhgwppflmhwt.Persona");
            while (rs.next()) {      
                System.out.println(rs.getInt("idPersona")+ " " + rs.getString("nombre"));
                 
            }
            cn.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return respuesta;
    
    }
    
}
