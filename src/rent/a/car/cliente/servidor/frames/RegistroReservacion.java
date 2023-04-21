package rent.a.car.cliente.servidor.frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;
import rent.a.car.cliente.servidor.interfaces.ServicioReservacion;
import rent.a.car.cliente.servidor.modelos.Cliente;
import rent.a.car.cliente.servidor.modelos.Reservacion;
import rent.a.car.cliente.servidor.modelos.Vehiculo;
import rent.a.car.cliente.servidor.servicios.ServicioReservacionImpl;
import rent.a.car.cliente.servidor.util.StringUtil;

/**
 *
 * @author daniel.guzman
 */
public class RegistroReservacion extends JFrame {

    private static final int MONTO_SEGURO = 10000;
    private static final String NO_HAY_VEHICULOS_DEFAULT = "No hay vehiculos disponibles";

    private final Cliente cliente;
    private final JFrame menuPrincipal;
    private final BaseDeDatosTemporal db;
    private final ServicioReservacion servicioReservacion;

    public RegistroReservacion(BaseDeDatosTemporal db, Cliente cliente, JFrame menuPrincipal) {
        this.db = db;
        this.cliente = cliente;
        this.menuPrincipal = menuPrincipal;
        this.servicioReservacion = new ServicioReservacionImpl(db);
        configurarInterfaz();
    }

    private void configurarInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel etiquetas = configurarEtiquetas();

        JTextField dias = new JTextField(3);
        JCheckBox agregarSeguro = new JCheckBox("Incluir seguro", true);
        JComboBox listaVehiculos = new JComboBox(db.getVehiculos().stream()
                .map(vehiculo -> concatenarDescVehiculo(vehiculo)).collect(Collectors.toList()).toArray());
        listaVehiculos.setPrototypeDisplayValue(NO_HAY_VEHICULOS_DEFAULT);
        JPanel comboPanel = configurarComboPanel(listaVehiculos, agregarSeguro, dias);

        JButton reservar = configurarBotonReservar(listaVehiculos, agregarSeguro, dias);
        JButton cancelar = configurarBotonCancelar();
        configurarListaVehiculos(listaVehiculos, reservar);

        JPanel botones = new JPanel();
        botones.add(cancelar);
        botones.add(reservar);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(etiquetas, BorderLayout.NORTH);
        contentPane.add(comboPanel, BorderLayout.CENTER);
        contentPane.add(botones, BorderLayout.SOUTH);

        pack();
    }

    private String concatenarDescVehiculo(Vehiculo vehiculo) {
        return "$" + vehiculo.getPrecio() + " - " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getPlaca();
    }

    private JPanel configurarEtiquetas() {
        JPanel etiquetas = new JPanel();
        etiquetas.setLayout(new GridLayout(3, 1));
        etiquetas.add(new JLabel("   \bCliente: " + this.cliente.getNombre() + " " + cliente.getApellidos()
                + " : " + cliente.getIdentificacion()));
        etiquetas.add(new JLabel("\n\n"));
        etiquetas.add(new JLabel("   Vehiculos disponibles:"));
        return etiquetas;
    }

    private JPanel configurarComboPanel(JComboBox listaVehiculos, JCheckBox agregarSeguro, JTextField dias) {
        //        Aqui se debe consultar la DB por vehiculos disponibles solamente
        JPanel comboPanel = new JPanel();
        comboPanel.setLayout(new GridLayout(3, 2));
        comboPanel.add(listaVehiculos);
        comboPanel.add(agregarSeguro);
        comboPanel.add(new JLabel("   "));
        comboPanel.add(new JLabel("   "));
        comboPanel.add(new JLabel("   Cantidad de dias:"));
        comboPanel.add(dias);
        return comboPanel;
    }

    private JButton configurarBotonReservar(JComboBox listaVehiculos, JCheckBox agregarSeguro, JTextField dias) {
        JButton reservar = new JButton("Reservar");
        reservar.addActionListener(event -> {
            if (validarDatosEntrada(dias)) {
                Vehiculo vehiculo = db.getVehiculos().get(listaVehiculos.getSelectedIndex());
                int seguro = agregarSeguro.isSelected() ? MONTO_SEGURO : 0;
                int diasInt = Integer.parseInt(dias.getText());
                int costo = ((diasInt * vehiculo.precio) + seguro);

                String mensajeConfirmacion = "Datos de la reservación:\n\n"
                        + "- Precio vehiculo: $" + vehiculo.getPrecio() + "\n"
                        + "- Costo seguro: $" + seguro + "\n"
                        + "- Cantidad de dias: " + dias.getText() + "\n"
                        + "-------------------------\n"
                        + "Costo total: $" + costo;
                int respuesta = JOptionPane.showConfirmDialog(this, mensajeConfirmacion,
                        "Confirmar reservacion", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    servicioReservacion.crear(new Reservacion(null, diasInt, costo, vehiculo.getId(), cliente.getId()));
                    JOptionPane.showMessageDialog(this, "Reservacion registrada exsitosamente",
                            "Reservacion registrada", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    menuPrincipal.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Reservacion cancelada",
                            "Reservacion cancelada", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return reservar;
    }

    private boolean validarDatosEntrada(JTextField dias) {
        boolean valido = true;

        if (!StringUtil.isEmpty(dias.getText())) {
            try {
                Integer.parseInt(dias.getText());
            } catch (NumberFormatException numberFormatException) {
                valido = false;
                JOptionPane.showMessageDialog(this, "El campo \"dias\" no es valido", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            valido = false;
        }

        return valido;
    }

    private JButton configurarBotonCancelar() {
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(event -> {
            this.dispose();
            menuPrincipal.setVisible(true);
        });
        return cancelar;
    }

    private void configurarListaVehiculos(JComboBox listaVehiculos, JButton reservar) {
        if (listaVehiculos.getItemCount() > 0) {
            listaVehiculos.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, NO_HAY_VEHICULOS_DEFAULT, NO_HAY_VEHICULOS_DEFAULT,
                    JOptionPane.ERROR_MESSAGE);
            listaVehiculos.addItem(NO_HAY_VEHICULOS_DEFAULT);
            listaVehiculos.setEnabled(false);

//            Deshabilita el boton reservar por que no hay vehiculos.
            reservar.setEnabled(false);
        }
    }

}
