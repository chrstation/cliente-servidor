package rent.a.car.cliente.servidor.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rent.a.car.cliente.servidor.db.BaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.interfaces.ServicioVehiculo;
import rent.a.car.cliente.servidor.modelos.Vehiculo;

/**
 *
 * @author daniel.guzman
 */
public class ServicioVehiculoImpl implements ServicioVehiculo {

    /**
     * @inheritDoc
     *
     * @return
     * @throws ErrorConexionBaseDeDatos
     */
    @Override
    public List<Vehiculo> consultarTodos() throws ErrorConexionBaseDeDatos {
        List<Vehiculo> vehiculos = new ArrayList<>();

        try (Connection conexionDb = BaseDeDatos.getConexion()) {
            String sql = "SELECT * FROM rent_a_car.vehiculo";

            PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Vehiculo vehiculo = new Vehiculo(result.getInt("id"), result.getString("marca"),
                        result.getString("modelo"), result.getInt("annio"), result.getString("placa"), result.getDouble("precio"));
                vehiculos.add(vehiculo);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error consultando lista vehiculos: " + ex.getMessage());
            throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
        }

        return vehiculos;
    }

    @Override
    public List<Vehiculo> consultarVehiculosDisponibles() throws ErrorConexionBaseDeDatos {
        List<Vehiculo> vehiculos = new ArrayList<>();

        try (Connection conexionDb = BaseDeDatos.getConexion()) {
            String sql = "SELECT * FROM rent_a_car.vehiculo WHERE id NOT IN (SELECT vehiculo_fk FROM reservacion r);";

            PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Vehiculo vehiculo = new Vehiculo(result.getInt("id"), result.getString("marca"),
                        result.getString("modelo"), result.getInt("annio"), result.getString("placa"), result.getDouble("precio"));
                vehiculos.add(vehiculo);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error consultando lista vehiculos: " + ex.getMessage());
            throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
        }

        return vehiculos;
    }

}
