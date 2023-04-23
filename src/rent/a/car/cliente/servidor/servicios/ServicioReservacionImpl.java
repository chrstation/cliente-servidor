/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.servicios;

import java.util.Optional;
import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;
import rent.a.car.cliente.servidor.excepciones.ReservacionInexistente;
import rent.a.car.cliente.servidor.interfaces.ServicioReservacion;
import rent.a.car.cliente.servidor.modelos.Reservacion;

/**
 * Impl significa implementacion, por que implementa una interfaz
 *
 * @author Charlie.guzman
 */
public class ServicioReservacionImpl implements ServicioReservacion {

    private final BaseDeDatosTemporal db;

    public ServicioReservacionImpl(BaseDeDatosTemporal db) {
        this.db = db;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Reservacion crear(Reservacion reservacion) throws IllegalArgumentException {
        if (reservacion != null) {
            return this.db.guardarReservacion(reservacion);
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
