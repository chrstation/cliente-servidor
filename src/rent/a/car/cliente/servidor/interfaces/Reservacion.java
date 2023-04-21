/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rent.a.car.cliente.servidor.interfaces;

import java.util.Optional;
import rent.a.car.cliente.servidor.excepciones.ReservacionInexistente;

/**
 *
 * @author daniel.guzman
 */
public interface Reservacion {

    /**
     * Crea una nueva {@link Reservacion}
     *
     * @param reservacion {@link Reservacion} con los datos a registrar
     *
     * @return Nueva {@link Reservacion}
     * @throws IllegalArgumentException Si la {@code reservacion} dada no es
     * valida
     */
    public Reservacion crear(Reservacion reservacion) throws IllegalArgumentException;

    /**
     * Consulta una {@link Reservacion} existente
     *
     * @param id ID de la reservacion a obtener
     *
     * @return {@link Optional} con un valor presente si la reservacion dada
     * existe.
     * @throws ReservacionInexistente Si el ID no existe
     */
    public Optional<Reservacion> consultar(int id) throws ReservacionInexistente;

    /**
     * Modifica la {@link Reservacion} dada con la informacion provista por el
     * argumento {@code reservacion}
     *
     * @param reservacion {@link Reservacion} con la informacion a actualizar.
     * Debe tener un ID existente obligatoriamente.
     *
     * @return {@link Reservacion} actualizada
     * @throws ReservacionInexistente Si la la {@code reservacion} no existe.
     * @throws IllegalArgumentException Si la {@code reservacion} dada es
     * invalida
     */
    public Reservacion modificar(Reservacion reservacion) throws ReservacionInexistente, IllegalArgumentException;

    /**
     * Elimina la {@link Reservacion} asociada al {@code id} dado
     *
     * @param id ID de la reservacion. El ID debe existir obligatoriamente.
     * @return La {@link Reservacion} eliminada
     * @throws ReservacionInexistente Si el ID no existe
     */
    public Reservacion eliminar(int id) throws ReservacionInexistente;
}
