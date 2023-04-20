/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.frames;

import java.awt.TrayIcon;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rent.a.car.cliente.servidor.Cliente;
import rent.a.car.cliente.servidor.ReservacionImpl;
import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;

/**
 *
 * @author daniel.guzman
 */
public class MenuReservacion extends JFrame {

    private static final String NO_HAY_CLIENTES_DEFAULT = "No hay clientes registrados";

    private final BaseDeDatosTemporal db;
    private final JComboBox listaClientes;

    public MenuReservacion(BaseDeDatosTemporal db) {
        this.db = db;
        listaClientes = new JComboBox(db.getClientes().stream()
                .map(cliente -> (cliente.getNombre() + " " + cliente.getApellidos())).collect(Collectors.toList()).toArray());

        configurarInterfaz();
    }

    private void configurarInterfaz() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);

        JLabel label = new JLabel("Seleccione el cliente:");
        panel.add(label);

        configurarListaClientes(panel);

        JButton nuevoCliente = new JButton("Regsitrar nuevo cliente");
        nuevoClienteActionListener(nuevoCliente);
        panel.add(nuevoCliente);
    }

    private void configurarListaClientes(JPanel panel) {
        listaClientes.setPrototypeDisplayValue(NO_HAY_CLIENTES_DEFAULT);
        panel.add(listaClientes);

        if (listaClientes.getItemCount() > 0) {
            listaClientes.setSelectedIndex(0);
        } else {
            listaClientes.addItem(NO_HAY_CLIENTES_DEFAULT);
            listaClientes.setEnabled(false);
        }
    }

    private void nuevoClienteActionListener(JButton nuevoCliente) {
        nuevoCliente.addActionListener(event -> {
//            Esto tiene que ser en un metodo aparte muy posiblementes
            MenuCliente menuCliente = new MenuCliente();
            menuCliente.setVisible(true);
        });
    }

    public void nuevaReservacion(JFrame menuPrincipal) {
        Cliente cliente = db.getClientes().get(listaClientes.getSelectedIndex());
        System.out.println("El cliente es " + cliente);

        String diasReserva = JOptionPane.showInputDialog("Cantidad de dias de alquiler: ");

        if (!diasReserva.isBlank() && !diasReserva.isEmpty()) {
            try {
                int dias = Integer.parseInt(diasReserva);

                //        esto tiene que ser autogenerado por la DB, no aqui, de forma que puedo poner la abstraccion en la clase que hace el brete
//                int numero_reserva = 1;
                //aqui este mae esta agregando el valor del field directamente de un campo estatico entonces obvio no le va a bretiar
                //para diversas iteraciones, necesita una nueva instancia.
                // aqui primero se debe consultar si es un nuevo cliente o un ya registrado para obtener los datos, sino ingresarlos
                //Por ahora primero es nuevo registro siempre, este valor que venir ya definido de antemano antes de llegar a esta linea
//                MenuCliente clientFrame = new MenuCliente();
//                JTextField id = clientFrame.getId();
//                String numero_vehiculo = "";
//                int monto_total = 0;
//                int deposito = 0;
//                int seguro = 0;
//                int precio = 0;
//
//                for (int i = 0; i < fecha.length; i++) {
//                    JFrame frame = new JFrame("Nueva Reserva");
//                    JLabel label1 = new JLabel("Cantidad de días: " + fecha[i].dias);
//                    JLabel label2 = new JLabel("N° reserva: " + fecha[i].numero_reserva);
//                    frame.add(label1);
//                    frame.add(label2);
//                    frame.pack();
//                    frame.setVisible(true);
//                }
            } catch (NumberFormatException numberFormatException) {
                //El numero de dias es invalido en este caso, se aborta la operacion para permitir al usuario ingresar de nuevo si lo desea
                System.err.println("NumberFormatException: " + numberFormatException.getMessage());
                JOptionPane.showMessageDialog(this, "Debe ingresar un numero entero", "El numero de dias ingresado es invalido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
