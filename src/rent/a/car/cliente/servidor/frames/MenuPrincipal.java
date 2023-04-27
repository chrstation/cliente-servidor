package rent.a.car.cliente.servidor.frames;

import javax.swing.JOptionPane;

/**
 * Menu principal
 *
 * @author Charlie
 */
import javax.swing.*;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
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
            try {
                MenuReservacionNueva menuReservacion = new MenuReservacionNueva(this);
                menuReservacion.setVisible(true);
                this.setVisible(false);
            } catch (ErrorConexionBaseDeDatos ex) {
                System.err.println("Error configurando menu reservacion. Mensaje: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error configurando menu de reservacion, por favor intentelo de nuevo mas tarde",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void reservaExistenteActionListener(JButton reservaExistente) {
        reservaExistente.addActionListener(e -> {
            try {
                this.setVisible(false);
                MenuReservacionExistente menuReservacionExistente = new MenuReservacionExistente(this);
                menuReservacionExistente.setVisible(true);
            } catch (ErrorConexionBaseDeDatos ex) {
                System.err.println("Error configurando pantalla menu reservacion. Mensaje: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error configurando menu de reservacion existente, por favor intentelo mas tarde",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void salirActionListener(JButton salir) {
        salir.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Gracias, vuelva pronto!", "Hasta luego", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            System.exit(0);
        });
    }
}
