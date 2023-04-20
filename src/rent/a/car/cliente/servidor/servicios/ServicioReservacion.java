/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.servicios;

import java.util.Optional;
import rent.a.car.cliente.servidor.excepciones.ReservacionInexistente;
import rent.a.car.cliente.servidor.interfaces.Reservacion;

/**
 *
 * @author daniel.guzman
 */
public class ServicioReservacion implements Reservacion {

    /**
     * @inheritdoc
     */
    @Override
    public Reservacion crear(Reservacion reservacion) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * @inheritdoc
     */
    @Override
    public Optional<Reservacion> consultar(int id) throws ReservacionInexistente {
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
