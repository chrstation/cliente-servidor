package rent.a.car.cliente.servidor.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import rent.a.car.cliente.servidor.db.BaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ReservacionInexistente;
import rent.a.car.cliente.servidor.interfaces.ServicioReservacion;
import rent.a.car.cliente.servidor.modelos.Reservacion;

/**
 * Impl significa implementacion, por que implementa una interfaz
 *
 * @author daniel.guzman
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

    /**
     * @inheritdoc
     */
    @Override
    public Reservacion modificar(Reservacion reservacion) throws ReservacionInexistente, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @inheritdoc
     */
    @Override
    public Reservacion eliminar(int id) throws ReservacionInexistente {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
