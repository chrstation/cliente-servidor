package rent.a.car.cliente.servidor;

import rent.a.car.cliente.servidor.frames.MenuPrincipal;

/**
 * Clase main: se usan arreglos predefinidos, se usaron fuera de la clases para
 * que se guarden en memoria y puedan ser modificados.
 *
 * @author Charlie
 */
public class RentACar {

    public static void main(String[] args) throws Exception {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrar();
    }
}
