package rent.a.car.cliente.servidor.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import rent.a.car.cliente.servidor.db.BaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.interfaces.ServicioVehiculo;
import rent.a.car.cliente.servidor.modelos.Cliente;
import rent.a.car.cliente.servidor.modelos.Vehiculo;

/**
 *
 * @author daniel.guzman
 */
public class ServicioVehiculoImpl implements ServicioVehiculo {

    @Override
    public Optional<Vehiculo> consultar(int id) throws IllegalArgumentException, ErrorConexionBaseDeDatos {
        if (id > 0) {
            try (Connection conexionDb = BaseDeDatos.getConexion()) {
                Optional<Vehiculo> vehiculo = Optional.empty();
                String sql = " SELECT * FROM rent_a_car.vehiculo WHERE id = ?";

                PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    vehiculo = Optional.of(new Vehiculo(rs.getInt("id"), rs.getString("marca"),
                            rs.getString("modelo"), rs.getInt("annio"),
                            rs.getString("placa"), rs.getDouble("precio")));
                }

                return vehiculo;
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println("Error consultando vehiculo: " + ex.getMessage());
                throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
            }
        } else {
            throw new IllegalArgumentException("ID Vehiculo invalido");
        }
    }

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
