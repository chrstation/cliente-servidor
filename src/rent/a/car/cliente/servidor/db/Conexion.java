/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.db;

/**
 *
 * @author charlie
 */
import java.sql.*;

public class Conexion {

    private static Connection conn;

    public static Connection getConexion() throws Exception {
        try {
            if (conn == null) {
                String url = "jdbc:mysql://localhost:3306/rent_a_car";
                String user = "rentacar"; // Reemplaza con el nombre de usuario de MySQL
                String password = "rentacar"; // Reemplaza con la contraseña de MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
            }
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            throw e;
        }
    }
}
