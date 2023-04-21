package rent.a.car.cliente.servidor.frames;

import javax.swing.JOptionPane;

/**
 * Menu principal
 *
 * @author Charlie
 */
import javax.swing.*;
import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;
import rent.a.car.cliente.servidor.ReservacionImpl;

public class MenuPrincipal extends JFrame {

    private final ReservacionImpl reservacion;
    private final BaseDeDatosTemporal db;

    public MenuPrincipal(BaseDeDatosTemporal db) {
        this.db = db;
        this.reservacion = new ReservacionImpl(db);
        configuraInterfaz();
    }

    public void mostrar() {
        setVisible(true);
    }

    private void configuraInterfaz() {
        setTitle("Rent a Car");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 100);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);

        JLabel label = new JLabel("Elija de las opciones a continuacion:");
        panel.add(label);

        JPanel panelBotones = new JPanel();
        panel.add(panelBotones);
        agregarBotones(panelBotones);
    }

    private void agregarBotones(JPanel panel) {
        JButton nuevoAlquiler = new JButton("Nuevo Alquiler");
        panel.add(nuevoAlquiler);
        nuevoAlquilerActionListener(nuevoAlquiler);

        JButton reservaExistente = new JButton("Reservación existente");
        panel.add(reservaExistente);
        reservaExistenteActionListener(reservaExistente);

        JButton salir = new JButton("Salir");
        panel.add(salir);
        salirActionListener(salir);
    }

    private void nuevoAlquilerActionListener(JButton nuevoAlquiler) {
        nuevoAlquiler.addActionListener(e -> {
//            MenuCliente frame = new MenuCliente();
//            frame.setVisible(true);

            MenuReservacion menuReservacion = new MenuReservacion(db);
            menuReservacion.setVisible(true);

//            clase_vehiculos reserva_vehiculo = new clase_vehiculos();
//            reserva_vehiculo.eleccion_vehiculo();
//            
//            int input = JOptionPane.showConfirmDialog(null, "Desea realizar otra reservación");
//            
//            if (input == 1) {
//                JOptionPane.showMessageDialog(null, "Muchas Gracias!");
//                dispose();
//            }
        });
    }

    private void reservaExistenteActionListener(JButton reservaExistente) {

        reservaExistente.addActionListener(e -> {
            int respuesta = Integer.parseInt(JOptionPane.showInputDialog("Por favor elija de las opciones a continuacion:\n\n"
                    + "1. Devolucion de vehículo\n"
                    + "2. Eliminar Reservación\n"
                    + "3. Modificar Reservación\n"
                    + "4. Salir al menú principal\n"));

            switch (respuesta) {
                case 1:
                    reservacion.devolucion();
                    break;

                case 2:
                    reservacion.eliminar(0);
                    break;

                case 3:
                    reservacion.modificar(null);
                    break;

                case 4:
                    dispose();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }

        });
    }

    private void salirActionListener(JButton salir) {
        salir.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Gracias, vuelva pronto!");
            dispose();
            System.exit(0);
        });
    }
}
