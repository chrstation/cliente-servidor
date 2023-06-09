package rent.a.car.cliente.servidor.interfaces;

import java.util.List;
import java.util.Optional;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ReservacionInexistente;
import rent.a.car.cliente.servidor.modelos.Reservacion;

/**
 *
 * @author daniel.guzman
 */
public interface ServicioReservacion {

    /**
     * Crea una nueva Reservacion
     *
     * @param reservacion La reservacion a crear
     * @return La reservacion creada
     * @throws IllegalArgumentException Si la reservacion dada es invalida
     * @throws ErrorConexionBaseDeDatos Si ocurre un error al conectarse con la
     * base de datos
     */
    public Reservacion crear(Reservacion reservacion) throws IllegalArgumentException, ErrorConexionBaseDeDatos;

    /**
     * Consulta una reservacion existente
     *
     * @param id ID de la reservacion a consultar
     * @return Optional con un valor presente si existe una reservacion con el
     * ID dado
     * @throws IllegalArgumentException Si el ID dado es menor o igual a cero
     * @throws ErrorConexionBaseDeDatos Si ocurre un error al conectarse con la
     * base de datos
     */
    public Optional<Reservacion> consultar(int id) throws IllegalArgumentException, ErrorConexionBaseDeDatos;

    /**
     * Consulta la lista de reservaciones registradas en la base de datos
     *
     * @return Lista de reservaciones registradas en la base de datos
     * @throws ErrorConexionBaseDeDatos Si ocurre un error al conectarse con la
     * base de datos
     */
    public List<Reservacion> consultarTodos() throws ErrorConexionBaseDeDatos;

    /**
     * Actualiza la reservacion dada con nuevos datos
     *
     * @param reservacion Los datos de la reservacion a actualizar
     * @return La reservacion actualizada
     * @throws IllegalArgumentException Si la reservacion dada no es valida
     * @throws ReservacionInexistente Si la reservacion dada no existe en la
     * base de datos
     * @throws ErrorConexionBaseDeDatos Si ocurre un error al conectarse con la
     * base de datos
     */
    public Reservacion modificar(Reservacion reservacion) throws ReservacionInexistente, IllegalArgumentException, ErrorConexionBaseDeDatos;

    /**
     * Elimina una reservacion existente
     *
     * @param id ID de la reservacion a eliminar
     * @return {@code true} si la reservacion fue eliminada
     * @throws ReservacionInexistente Si el ID dado no existe en la base de
     * datos.
     * @throws ErrorConexionBaseDeDatos Si ocurre un error al conectarse con la
     * base de datos
     */
    public void eliminar(int id) throws ReservacionInexistente, ErrorConexionBaseDeDatos;

}
