/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.excepciones;

/**
 *
 * @author daniel.guzman
 */
public class ErrorConexionBaseDeDatos extends Exception {

    private String mensaje;
    private Throwable causa;

    public ErrorConexionBaseDeDatos(String mensaje) {
        super(mensaje);
    }

    public ErrorConexionBaseDeDatos(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
