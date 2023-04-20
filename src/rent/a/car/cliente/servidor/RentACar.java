package rent.a.car.cliente.servidor;

import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;
import rent.a.car.cliente.servidor.frames.MenuPrincipal;
import static rent.a.car.cliente.servidor.clase_vehiculos.arreglo;

/**
 * Clase main: se usan arreglos predefinidos, se usaron fuera de la clases para
 * que se guarden en memoria y puedan ser modificados.
 *
 * @author Charlie
 */
public class RentACar {

    public static void main(String[] args) {
        BaseDeDatosTemporal db = new BaseDeDatosTemporal();
        MenuPrincipal menuPrincipal = new MenuPrincipal(db);
        menuPrincipal.mostrar();
    }
}
