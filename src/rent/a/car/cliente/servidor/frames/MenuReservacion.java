/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.frames;

import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import rent.a.car.cliente.servidor.modelos.Cliente;
import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;

/**
 *
 * @author daniel.guzman
 */
public class MenuReservacion extends JFrame {

    private static final String NO_HAY_CLIENTES_DEFAULT = "No hay clientes registrados";

    private JFrame menuPrincipal;
    private JComboBox listaClientes;
    private final BaseDeDatosTemporal db;

    public MenuReservacion(BaseDeDatosTemporal db, JFrame menuPrincipal) {
        this.db = db;
        this.menuPrincipal = menuPrincipal;
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

        JButton continuar = new JButton("Continuar");
        continuarActionListener(continuar);
        panel.add(continuar);

    }

    private void configurarListaClientes(JPanel panel) {
        listaClientes = new JComboBox(db.getClientes().stream()
                .map(cliente -> (cliente.getNombre() + " " + cliente.getApellidos())).collect(Collectors.toList()).toArray());
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
            RegistroCliente menuCliente = new RegistroCliente(db, this);
            menuCliente.setVisible(true);
        });
    }

    private void continuarActionListener(JButton continuar) {
        continuar.addActionListener(event -> {
            this.dispose();
            RegistroReservacion registroReservacion = new RegistroReservacion(db, db.getClientes()
                    .get(listaClientes.getSelectedIndex()), menuPrincipal);
            registroReservacion.setVisible(true);
        });
    }

    @Override
    public void setVisible(boolean b) {
        listaClientes.removeAllItems();
        db.getClientes().stream()
                .map(cliente -> (cliente.getNombre() + " " + cliente.getApellidos())).forEach(cliente -> listaClientes.addItem(cliente));
        listaClientes.setSelectedIndex(listaClientes.getItemCount() - 1);

        super.setVisible(b);
    }
}
