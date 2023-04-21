package rent.a.car.cliente.servidor.servicios;

import java.util.Optional;
import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;
import rent.a.car.cliente.servidor.excepciones.ClienteInexistente;
import rent.a.car.cliente.servidor.interfaces.ServicioCliente;
import rent.a.car.cliente.servidor.modelos.Cliente;

/**
 *
 * @author daniel.guzman
 */
public class ServicioClienteImpl implements ServicioCliente {

    private final BaseDeDatosTemporal db;

    public ServicioClienteImpl(BaseDeDatosTemporal db) {
        this.db = db;
    }

    @Override
    public Cliente crear(Cliente cliente) throws IllegalArgumentException {
        if (cliente != null) {
            return db.guardarCliente(cliente);
        } else {
            throw new IllegalArgumentException("Cliente invalido");
        }
    }

    @Override
    public Optional<Cliente> consultar(int id) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
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
