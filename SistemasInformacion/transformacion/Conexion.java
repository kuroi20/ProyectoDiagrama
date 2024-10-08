/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Conexion{
     private String url = "jdbc:mysql://b9br9u8tlhgwppflmhwt-mysql.services.clever-cloud.com:3306/b9br9u8tlhgwppflmhwt";
     private String usuario = "ux6dx9kst0phlebk";
        private String contrasena = "nlPWo7Ll234Nbkj3sDDV";

    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, usuario, contrasena);
    }
    
    public void guardarImagenEnBD(File file) throws SQLException, IOException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        FileInputStream fis = null;

        try{
            conn = conectar();

            String sql = "INSERT INTO Imagen (nombreIm, contenido) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, file.getName());
            fis = new FileInputStream(file);
            pstmt.setBinaryStream(2, fis, (int) file.length());

            pstmt.executeUpdate();
        }finally{
            // Cerrar recursos
            if (fis != null) fis.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }
    
    
}

