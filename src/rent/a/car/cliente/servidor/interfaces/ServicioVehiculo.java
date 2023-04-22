package rent.a.car.cliente.servidor.interfaces;

import java.util.List;
import java.util.Optional;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ReservacionInexistente;
import rent.a.car.cliente.servidor.modelos.Cliente;
import rent.a.car.cliente.servidor.modelos.Reservacion;
import rent.a.car.cliente.servidor.modelos.Vehiculo;

/**
 *
 * @author daniel.guzman
 */
public interface ServicioVehiculo {

    /**
     * Consulta la lista de vehiculos registrados en la base de datos
     *
     * @return Lista de vehiculos registrados en la base de datos
     * @throws ErrorConexionBaseDeDatos Si ocurre un error al conectarse con la
     * base de datos
     */
    public List<Vehiculo> consultarTodos() throws ErrorConexionBaseDeDatos;

    /**
     * Consulta la lista de vehiculos registrados en la base de datos que NO
     * tengan una reservacion asociada
     *
     * @return Lista de vehiculos disponibles para reservar.
     * @throws ErrorConexionBaseDeDatos Si ocurre un error al conectarse con la
     * base de datos
     */
    public List<Vehiculo> consultarVehiculosDisponibles() throws ErrorConexionBaseDeDatos;

}
