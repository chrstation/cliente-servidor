package rent.a.car.cliente.servidor.interfaces;

import java.util.List;
import java.util.Optional;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.modelos.Vehiculo;

public interface ServicioVehiculo {

    /**
     * Consulta un vehiculo existente
     *
     * @param id ID de el vehiculo a consultar
     * @return Optional con un valor presente si existe un cliente con el ID
     * dado
     * @throws IllegalArgumentException Si el ID dado es menor o igual a cero
     * @throws ErrorConexionBaseDeDatos Si ocurre un error al conectarse con la
     * base de datos
     */
    public Optional<Vehiculo> consultar(int id) throws IllegalArgumentException, ErrorConexionBaseDeDatos;

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
