/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rent.a.car.cliente.servidor.db.BaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.interfaces.ServicioUsuario;
import rent.a.car.cliente.servidor.modelos.Usuario;

/**
 *
 * @author daniel.guzman
 */
public class ServicioUsuarioImpl implements ServicioUsuario {

    @Override
    public boolean autenticar(Usuario usuario) throws IllegalArgumentException, ErrorConexionBaseDeDatos {
        if (usuario != null) {
            try (Connection conexionDb = BaseDeDatos.getConexion()) {
                boolean autenticado = false;
                String sql = " SELECT * FROM rent_a_car.usuario WHERE nombre = ?";

                PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getNombre());

                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    String pwd = rs.getString("contrasennia");
                    autenticado = usuario.getContrasennia().equals(pwd);
                }

                return autenticado;
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println("Error insertando cliente: " + ex.getMessage());
                throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
            }
        } else {
            throw new IllegalArgumentException("Usuario invalido");
        }
    }

}
