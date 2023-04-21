/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rent.a.car.cliente.servidor.interfaces;

import java.util.Optional;
import rent.a.car.cliente.servidor.excepciones.ClienteInexistente;
import rent.a.car.cliente.servidor.modelos.Cliente;

/**
 *
 * @author daniel.guzman
 */
public interface ServicioCliente {
    
     /**
     * Crea una nuevo Cliente
     *
     * @param cliente El cliente a crear
     * @return El cliente creada
     * @throws IllegalArgumentException Si el cliente dada es invalida
     */
    public Cliente crear(Cliente cliente) throws IllegalArgumentException;

    /**
     * Consulta una cliente existente
     *
     * @param id ID de el cliente a consultar
     * @return Optional con un valor presente si existe una cliente con el
     * ID dado
     * @throws IllegalArgumentException Si el ID dado es menor o igual a cero
     */
    public Optional<Cliente> consultar(int id) throws IllegalArgumentException;

    /**
     * Actualiza el cliente dada con nuevos datos
     *
     * @param cliente Los datos de el cliente a actualizar
     * @return El cliente actualizada
     * @throws IllegalArgumentException Si el cliente dada no es valida
     * @throws ClienteInexistente Si el cliente dada no existe en la
     * base de datos
     */
    public Cliente modificar(Cliente cliente) throws ClienteInexistente, IllegalArgumentException;

    /**
     * Elimina una cliente existente
     *
     * @param id ID de el cliente a eliminar
     * @return El cliente eliminada
     * @throws ClienteInexistente Si el ID dado no existe en la base de
     * datos.
     */
    public Cliente eliminar(int id) throws ClienteInexistente;

    
}
