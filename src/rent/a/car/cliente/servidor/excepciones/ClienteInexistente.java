package rent.a.car.cliente.servidor.excepciones;

/**
 *
 * @author Charlie
 */
public class ClienteInexistente extends Exception {

    private String mensaje;
    private Throwable causa;

    public ClienteInexistente(String mensaje) {
        super(mensaje);
    }

    public ClienteInexistente(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
