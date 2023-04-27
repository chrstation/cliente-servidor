package rent.a.car.cliente.servidor.frames;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.interfaces.ServicioCliente;
import rent.a.car.cliente.servidor.modelos.Cliente;
import rent.a.car.cliente.servidor.servicios.ServicioClienteImpl;

/**
 *
 * @author daniel.guzman
 */
public class MenuReservacionNueva extends JFrame {

    private static final String NO_HAY_CLIENTES_DEFAULT = "No hay clientes registrados";

    private JComboBox listaClientes;
    private final JFrame menuPrincipal;
    private final ServicioCliente servicioCliente;

    public MenuReservacionNueva(JFrame menuPrincipal) throws ErrorConexionBaseDeDatos {
        this.menuPrincipal = menuPrincipal;
        this.servicioCliente = new ServicioClienteImpl();
        configurarInterfaz();
    }

    private void configurarInterfaz() throws ErrorConexionBaseDeDatos {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);

        JLabel label = new JLabel("Seleccione el cliente:");
        panel.add(label);

        configurarListaClientes(panel);

        JButton nuevoCliente = new JButton("Registrar nuevo cliente");
        nuevoClienteActionListener(nuevoCliente);
        panel.add(nuevoCliente);

        JButton continuar = new JButton("Continuar");
        continuarActionListener(continuar);
        panel.add(continuar);

    }

    private void configurarListaClientes(JPanel panel) throws ErrorConexionBaseDeDatos {
        listaClientes = new JComboBox();
        listaClientes.setPrototypeDisplayValue(NO_HAY_CLIENTES_DEFAULT);
        panel.add(listaClientes);

    }

    private void nuevoClienteActionListener(JButton nuevoCliente) {
        nuevoCliente.addActionListener(event -> {
            try {
                RegistroCliente menuCliente = new RegistroCliente(this);
                menuCliente.setVisible(true);
            } catch (Exception ex) {
                System.err.println(String.format("%s abriendo pantall de registro de cliente. Mensaje: %s", ex.getClass().getName(), ex.getMessage()));
                JOptionPane.showMessageDialog(this, "Error abriendo pantall de registro de cliente. Por favor intentelo de nuevo mas tarde.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void continuarActionListener(JButton continuar) {
        continuar.addActionListener(event -> {
            try {
                this.dispose();
                RegistroReservacion registroReservacion = new RegistroReservacion(servicioCliente.consultarTodos().get(
                        listaClientes.getSelectedIndex()), menuPrincipal);
                registroReservacion.setVisible(true);
            } catch (ErrorConexionBaseDeDatos ex) {
                System.err.println("Error mostrando pantalla registro reservacion. Mensaje: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error configurando pantall de registro de reservacion, por favor intentelo mas tarde",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void configurarListaCliente() {
        try {
            List<Cliente> clientes = servicioCliente.consultarTodos();

            if (listaClientes.getItemCount() != clientes.size()) {
                listaClientes.removeAllItems();
                clientes.stream()
                        .map(cliente -> (cliente.getNombre() + " " + cliente.getApellidos())).forEach(cliente -> listaClientes.addItem(cliente));
                listaClientes.setSelectedIndex(listaClientes.getItemCount() - 1);
            } else {
                listaClientes.addItem(NO_HAY_CLIENTES_DEFAULT);
                listaClientes.setEnabled(false);
            }

        } catch (ErrorConexionBaseDeDatos ex) {
            this.dispose();
            JOptionPane.showMessageDialog(this, "Error consultando la lista de clientes, por favor intentelo mas tarde", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void setVisible(boolean b) {
        if (b) {
            configurarListaCliente();
            super.setVisible(true);
        } else {
            super.setVisible(false);
        }
    }
}
