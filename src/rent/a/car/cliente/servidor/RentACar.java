package rent.a.car.cliente.servidor;

import java.sql.Connection;
import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;
import rent.a.car.cliente.servidor.db.Conexion;
import rent.a.car.cliente.servidor.frames.MenuPrincipal;

/**
 * Clase main: se usan arreglos predefinidos, se usaron fuera de la clases para
 * que se guarden en memoria y puedan ser modificados.
 *
 * @author Charlie
 */
public class RentACar {

    public static void main(String[] args) throws Exception {
        Connection conn = Conexion.getConexion();

        BaseDeDatosTemporal db = new BaseDeDatosTemporal();
        MenuPrincipal menuPrincipal = new MenuPrincipal(db);
        menuPrincipal.mostrar();
    }
}
