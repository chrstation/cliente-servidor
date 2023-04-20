/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.excepciones;

/**
 *
 * @author daniel.guzman
 */
public class ReservacionInexistente extends Exception {

    private String mensaje;
    private Throwable causa;

    public ReservacionInexistente(String mensaje) {
        super(mensaje);
    }

    public ReservacionInexistente(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
