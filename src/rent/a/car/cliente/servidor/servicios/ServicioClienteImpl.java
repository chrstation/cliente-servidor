package rent.a.car.cliente.servidor.servicios;

import java.util.Optional;
import rent.a.car.cliente.servidor.db.BaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ClienteInexistente;
import rent.a.car.cliente.servidor.interfaces.ServicioCliente;
import rent.a.car.cliente.servidor.modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;

public class ServicioClienteImpl implements ServicioCliente {

    public ServicioClienteImpl() {
    }

    @Override
    public Cliente crear(Cliente cliente) throws IllegalArgumentException, ErrorConexionBaseDeDatos {
        if (cliente != null) {
            try (Connection conexionDb = BaseDeDatos.getConexion()) {

                String sql = " INSERT INTO rent_a_car.cliente (nombre, apellido, pais, edad, identificacion)"
                        + " VALUES (?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = conexionDb.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, cliente.getNombre());
                preparedStatement.setString(2, cliente.getApellidos());
                preparedStatement.setString(3, cliente.getPais());
                preparedStatement.setInt(4, cliente.getEdad());
                preparedStatement.setString(5, cliente.getIdentificacion());

                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                rs.next();
                cliente.setId(rs.getInt(1));
                return cliente;
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println("Error insertando cliente: " + ex.getMessage());
                throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
            }
        } else {
            throw new IllegalArgumentException("Cliente invalido");
        }
    }

    @Override
    public Optional<Cliente> consultar(int id) throws IllegalArgumentException, ErrorConexionBaseDeDatos {
        if (id > 0) {
            try (Connection conexionDb = BaseDeDatos.getConexion()) {
                Optional<Cliente> cliente = Optional.empty();
                String sql = " SELECT * FROM rent_a_car.cliente WHERE id = ?";

                PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    cliente = Optional.of(new Cliente(rs.getInt("id"), rs.getString("nombre"),
                            rs.getString("apellido"), rs.getString("pais"),
                            rs.getInt("edad"), rs.getString("identificacion")));
                }

                return cliente;
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println("Error consultando cliente: " + ex.getMessage());
                throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
            }
        } else {
            throw new IllegalArgumentException("ID Cliente invalido");
        }
    }

    @Override
    public List<Cliente> consultarTodos() throws ErrorConexionBaseDeDatos {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conexionDb = BaseDeDatos.getConexion()) {
            String sql = "SELECT * FROM rent_a_car.cliente";

            PreparedStatement preparedStatement = conexionDb.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Cliente cliente = new Cliente(result.getInt("id"), result.getString("nombre"),
                        result.getString("apellido"), result.getString("pais"),
                        result.getInt("edad"), result.getString("identificacion"));
                clientes.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error consultando lista cliente: " + ex.getMessage());
            throw new ErrorConexionBaseDeDatos(ex.getMessage(), ex);
        }

        return clientes;
    }

    @Override
    public Cliente modificar(Cliente cliente) throws ClienteInexistente, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente eliminar(int id) throws ClienteInexistente {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
