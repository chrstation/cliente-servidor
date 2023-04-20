
package rent.a.car.cliente.servidor;

import javax.swing.JOptionPane;

/** Menu principal: se usan switch, while y submenus con dialogos
 *
 * @author Charlie
 */
import javax.swing.*;

public class menuprincipal extends JFrame {

    public void menuprincipal() {
        setTitle("Rent a Car");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        add(panel);

        JLabel label = new JLabel("Elija de las opciones a continuacion:");
        panel.add(label);

        JButton nuevoAlquilerButton = new JButton("Nuevo Alquiler");
        panel.add(nuevoAlquilerButton);

        JButton reservaExistenteButton = new JButton("Reservación existente");
        panel.add(reservaExistenteButton);

        JButton salirButton = new JButton("Salir");
        panel.add(salirButton);

        nuevoAlquilerButton.addActionListener(e -> {
            ClienteFrame frame = new ClienteFrame();
            frame.setVisible(true);

            clase_reservaciones Nueva_Reserva = new clase_reservaciones();
            Nueva_Reserva.Nueva_reserva();

            clase_vehiculos reserva_vehiculo = new clase_vehiculos();
            reserva_vehiculo.eleccion_vehiculo();

            int input = JOptionPane.showConfirmDialog(null, "Desea realizar otra reservación");

            if (input == 1) {
                JOptionPane.showMessageDialog(null, "Muchas Gracias!");
                dispose();
            }
        });

        reservaExistenteButton.addActionListener(e -> {
            boolean submenu2 = true;
            while (submenu2) {
                int submenu = Integer.parseInt(JOptionPane.showInputDialog("Por favor elija de las opciones a continuacion:\n"
                        + "1. Devolucion de vehículo\n"
                        + "2. Eliminar Reservación\n"
                        + "3. Modificar Reservación\n"
                        + "4. Salir al menú principal\n"));
                switch (submenu) {
                    case 1:
                        {
                            clase_reservaciones miclase = new clase_reservaciones();
                            miclase.devolucion_reserva();
                        }
                        break;
                    case 2:
                        {
                            clase_reservaciones miclase = new clase_reservaciones();
                            miclase.Eliminar_reserva();
                        }
                        break;
                    case 3:
                        {
                            clase_reservaciones miclase = new clase_reservaciones();
                            miclase.Modificar_reserva();
                        }
                        break;
                    case 4:
                        {
                            JOptionPane.showMessageDialog(null, "Volviendo al menú principal.");
                            dispose();
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                        break;
                }
            }
        });

        salirButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Gracias, vuelva pronto!");
            dispose();
        });

        setVisible(true);
    }
}



