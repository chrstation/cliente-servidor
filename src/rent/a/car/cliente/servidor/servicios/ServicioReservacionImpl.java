
package rent.a.car.cliente.servidor.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import rent.a.car.cliente.servidor.db.BaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ReservacionInexistente;
import rent.a.car.cliente.servidor.interfaces.ServicioReservacion;
import rent.a.car.cliente.servidor.modelos.Reservacion;

/**
 * Impl significa implementacion, por que implementa una interfaz
 *
 * @author Charlie.guzman
 */
public class ServicioReservacionImpl implements ServicioReservacion {

    public ServicioReservacionImpl() {
    }

    /**
     * @inheritdoc
     */
    @Override
    public Reservacion crear(Reservacion reservacion) throws IllegalArgumentException, ErrorConexionBaseDeDatos {
        if (reservacion != null) {
            try (Connection conexionDb = BaseDeDatos.getConexion()) {
                String sql = " INSERT INTO rent_a_car.reservacion (costo, dias, vehiculo_fk, cliente_fk)"
                        + " VALUES (?, ?, ?, ?)";

                PreparedStatement preparedStatement = conexionDb.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setDouble(1, reservacion.getCosto());
                preparedStatement.setInt(2, reservacion.getDias());
                preparedStatement.setInt(3, reservacion.getVehiculo_fk());
                preparedStatement.setInt(4, reservacion.getCliente_fk());

                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                rs.next();
                reservacion.setId(rs.getInt(1));
                return reservacion;
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println("Error insertando reservacion: " + ex.getMessage());
                throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
            }
        } else {
            throw new IllegalArgumentException("Reservacion invalida");
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    public Optional<Reservacion> consultar(int id) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Reservacion> consultarTodos() throws ErrorConexionBaseDeDatos {
        List<Reservacion> reservaciones = new ArrayList<>();

        try (Connection conexionDb = BaseDeDatos.getConexion()) {
            String sql = "SELECT * FROM rent_a_car.reservacion";

            PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Reservacion reservacion = new Reservacion(result.getInt("id"), result.getInt("dias"),
                        result.getDouble("costo"), result.getInt("vehiculo_fk"),
                        result.getInt("cliente_fk"));
                reservaciones.add(reservacion);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error consultando lista de reservaciones: " + ex.getMessage());
            throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
        }

        return reservaciones;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Reservacion modificar(Reservacion reservacion) throws ReservacionInexistente, IllegalArgumentException, ErrorConexionBaseDeDatos {
        if (reservacion != null) {
            try (Connection conexionDb = BaseDeDatos.getConexion()) {
                String sql = "UPDATE rent_a_car.reservacion SET costo=?, dias=? WHERE id=?";

                PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
                preparedStatement.setDouble(1, reservacion.getCosto());
                preparedStatement.setInt(2, reservacion.getDias());
                preparedStatement.setInt(3, reservacion.getId());

                int registrosActualizados = preparedStatement.executeUpdate();

                if (registrosActualizados == 0) {
                    throw new ReservacionInexistente("No existe ninguna reservacion con este ID");
                } else {
                    System.out.println(String.format("Advertencia: Se han actualizado %d registros de la base de datos", registrosActualizados));
                    return reservacion;
                }
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println("Error modificando reservacion: " + ex.getMessage());
                throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
            }
        } else {
            throw new IllegalArgumentException("ID reservacion invalido");
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    public void eliminar(int id) throws ReservacionInexistente, ErrorConexionBaseDeDatos {
        if (id > 0) {
            try (Connection conexionDb = BaseDeDatos.getConexion()) {
                String sql = "DELETE FROM rent_a_car.reservacion WHERE id = ?";

                PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                int registrosBorrados = preparedStatement.executeUpdate();

                if (registrosBorrados == 0) {
                    throw new ReservacionInexistente("No existe ninguna reservacion con este ID");
                } else {
                    System.err.println(String.format("Advertencia: Se han eliminado %d registros de la base de datos", registrosBorrados));
                }
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println("Error eliminando reservacion: " + ex.getMessage());
                throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
            }
        } else {
            throw new IllegalArgumentException("ID reservacion invalido");
        }
    }

}
