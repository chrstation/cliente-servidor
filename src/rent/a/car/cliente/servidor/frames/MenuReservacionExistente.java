package rent.a.car.cliente.servidor.frames;

import java.awt.GridLayout;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.excepciones.ReservacionInexistente;
import rent.a.car.cliente.servidor.interfaces.ServicioCliente;
import rent.a.car.cliente.servidor.interfaces.ServicioReservacion;
import rent.a.car.cliente.servidor.interfaces.ServicioVehiculo;
import rent.a.car.cliente.servidor.modelos.Cliente;
import rent.a.car.cliente.servidor.modelos.Reservacion;
import rent.a.car.cliente.servidor.modelos.Vehiculo;
import rent.a.car.cliente.servidor.servicios.ServicioClienteImpl;
import rent.a.car.cliente.servidor.servicios.ServicioReservacionImpl;
import rent.a.car.cliente.servidor.servicios.ServicioVehiculoImpl;
import rent.a.car.cliente.servidor.util.StringUtil;

/**
 *
 * @author daniel.guzman
 */
public class MenuReservacionExistente extends JFrame {

    private int tipoEvento = 0;

    private List<Reservacion> listaReservaciones;
    private Reservacion reservacionSeleccionada;
    Optional<Cliente> clienteInfo = Optional.empty();
    Optional<Vehiculo> vehiculoInfo = Optional.empty();

    private final JFrame menuPrincipal;
    private final ServicioReservacion servicioReservacion;
    private final ServicioCliente servicioCliente;
    private final ServicioVehiculo servicioVehiculo;

    private final JTextField codigoReservacion = new JTextField(20);
    private final JTextField cliente = new JTextField(20);
    private final JTextField vehiculo = new JTextField(20);
    private final JTextField dias = new JTextField(20);
    private final JTextField costo = new JTextField(20);

    public MenuReservacionExistente(JFrame menuPrincipal) throws ErrorConexionBaseDeDatos {
        this.menuPrincipal = menuPrincipal;
        this.servicioReservacion = new ServicioReservacionImpl();
        this.servicioCliente = new ServicioClienteImpl();
        this.servicioVehiculo = new ServicioVehiculoImpl();
        configurarInterfaz();
    }

    private void configurarInterfaz() throws ErrorConexionBaseDeDatos {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2));
        JLabel reservacionesLabel = new JLabel("   Reservaciones");
        panel.add(reservacionesLabel);

        JComboBox reservaciones = new JComboBox();
        configurarListaReservaciones(reservaciones);
        configurarReservacionesActionListener(reservaciones);
        panel.add(reservaciones);

        configurarCamposDeTexto(panel);

        JButton actualizar = new JButton("Actualizar");
        configurarActualizarActionListener(actualizar);
        panel.add(actualizar);

        JButton eliminar = new JButton("Borrar");
        configurarEliminarActionListener(reservaciones, eliminar);
        panel.add(eliminar);

        JButton volver = new JButton("Volver");
        configurarVolverActionListener(volver);
        panel.add(volver);

        add(panel);
    }

    private void configurarListaReservaciones(JComboBox reservaciones) throws ErrorConexionBaseDeDatos {
        listaReservaciones = servicioReservacion.consultarTodos();
        reservaciones.removeAllItems();
        listaReservaciones.stream()
                .map(reservacion -> reservacion.getId()).forEach(reservacion -> reservaciones.addItem(reservacion));

        if (reservaciones.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay reservaciones registradas",
                    "No hay datos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            reservaciones.setSelectedIndex(0);
            obtenerDatosReservacion(0);
        }
    }

    private void configurarCamposDeTexto(JPanel panel) {
        JLabel codigoReservacionLabel = new JLabel("   Codigo de reservacion:");
        codigoReservacion.setEditable(false);
        codigoReservacion.setEnabled(false);
        panel.add(codigoReservacionLabel);
        panel.add(codigoReservacion);

        JLabel clienteLabel = new JLabel("   Cliente:");
        cliente.setEditable(false);
        cliente.setEnabled(false);
        panel.add(clienteLabel);
        panel.add(cliente);

        JLabel vehiculoLabel = new JLabel("   Vehiculo:");

        vehiculo.setEditable(false);
        vehiculo.setEnabled(false);
        panel.add(vehiculoLabel);
        panel.add(vehiculo);

        JLabel diasLabel = new JLabel("   Dias:");
        dias.setEditable(true);
        dias.setEnabled(true);
        panel.add(diasLabel);
        panel.add(dias);

        JLabel costoLabel = new JLabel("   Costo:");
        costo.setEditable(false);
        costo.setEnabled(false);
        panel.add(costoLabel);
        panel.add(costo);
    }

    private void limpiarCamposDeTexto() {
        codigoReservacion.setText("");
        cliente.setText("");
        vehiculo.setText("");
        dias.setText("");
        costo.setText("");
    }

    private void configurarReservacionesActionListener(JComboBox reservaciones) {
        reservaciones.addActionListener(event -> {
            try {
                if (tipoEvento == 0) {
                    obtenerDatosReservacion(reservaciones.getSelectedIndex());
                }
            } catch (IllegalArgumentException | ErrorConexionBaseDeDatos ex) {
                System.err.println("Error consultando datos de la reservacion. Mensaje: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error consultando datos de la reservacion, por favor intentelo mas tarde",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void configurarEliminarActionListener(JComboBox reservaciones, JButton eliminar) {
        eliminar.addActionListener(event -> {
            try {
                if (reservacionSeleccionada != null) {
                    int respuesta = JOptionPane.showConfirmDialog(this, "Esta seguro que desea borrar la reservacion " + reservacionSeleccionada.getId(),
                            "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        servicioReservacion.eliminar(reservacionSeleccionada.getId());
                        JOptionPane.showMessageDialog(this, "Reservacion eliminada existosamente",
                                "Reservacion eliminada", JOptionPane.INFORMATION_MESSAGE);
                        tipoEvento = 1;
                        configurarListaReservaciones(reservaciones);
                        limpiarCamposDeTexto();
                    } else {
                        JOptionPane.showMessageDialog(this, "Operacion cancelada", "Operacion cancelada", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay ninguna reservacion seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IllegalArgumentException | ErrorConexionBaseDeDatos | ReservacionInexistente ex) {
                System.err.println("Error eliminado reservacion. Mensaje: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error eliminando reservacion, por favor intentelo mas tarde",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void configurarVolverActionListener(JButton volver) {
        volver.addActionListener(event -> {
            this.dispose();
            this.setVisible(false);
            menuPrincipal.setVisible(true);
        });
    }

    private void obtenerDatosReservacion(int indice) throws IllegalArgumentException, ErrorConexionBaseDeDatos {
        reservacionSeleccionada = listaReservaciones.get(indice);
        clienteInfo = servicioCliente.consultar(reservacionSeleccionada.getCliente_fk());
        vehiculoInfo = servicioVehiculo.consultar(reservacionSeleccionada.getVehiculo_fk());

        if (!clienteInfo.isEmpty() && !vehiculoInfo.isEmpty()) {
            codigoReservacion.setText(String.valueOf(reservacionSeleccionada.getId()));
            cliente.setText(clienteInfo.get().getNombre() + " " + clienteInfo.get().getApellidos());
            vehiculo.setText(vehiculoInfo.get().getPlaca() + " - " + vehiculoInfo.get().getMarca() + " " + vehiculoInfo.get().getModelo() + " " + vehiculoInfo.get().getAnnio());
            vehiculo.setToolTipText(vehiculoInfo.get().getPlaca() + " - " + vehiculoInfo.get().getMarca() + " " + vehiculoInfo.get().getModelo() + " " + vehiculoInfo.get().getAnnio());
            dias.setText(String.valueOf(reservacionSeleccionada.getDias()));
            costo.setText(String.valueOf("$" + reservacionSeleccionada.getCosto()));
        } else {
            JOptionPane.showMessageDialog(this, "No se pudieron encontrar los datos asociados a esta reservacion",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        tipoEvento = 0;
    }

    private void configurarActualizarActionListener(JButton actualizar) {
        actualizar.addActionListener(event -> {
            if (validarCamposDeEntrada()) {
                int diasInt = Integer.parseInt(dias.getText());

                if (diasInt != reservacionSeleccionada.getDias()) {

                    // Aqui se esta asumiendo que el seguro siempre va incluido, esto se debe mejorar para validar si el seguro esta realmente inclido o no
                    // Se puede lograr agregando otra columna a la tabla reservacion con el campo boolean y el costo del seguro
                    double nuevoCosto = RegistroReservacion.MONTO_SEGURO + (diasInt * vehiculoInfo.get().getPrecio());
                    int respuesta = JOptionPane.showConfirmDialog(this, "Desea atualizar la reservacion:\n\n Nuevo costo: $" + nuevoCosto,
                            "Nuevo costo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            reservacionSeleccionada.setDias(diasInt);
                            reservacionSeleccionada.setCosto(nuevoCosto);
                            servicioReservacion.modificar(reservacionSeleccionada);
                            JOptionPane.showMessageDialog(this, "Reservacion actualizada", "Reservacion actualizada", JOptionPane.INFORMATION_MESSAGE);
                        } catch (IllegalArgumentException | ReservacionInexistente | ErrorConexionBaseDeDatos ex) {
                            System.err.println("Error actualizando reservacion. Mensaje: " + ex.getMessage());
                            JOptionPane.showMessageDialog(this, "Error actualizando reservacion", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Operacion cancelada", "Operacion cancelada", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    private boolean validarCamposDeEntrada() {
        boolean valido = true;

        if (!StringUtil.isEmpty(dias.getText())) {
            try {
                int diasInt = Integer.parseInt(dias.getText());

                if (diasInt <= 0) {
                    mostrarMensajeCampoInvalido(dias, "dias", String.valueOf(reservacionSeleccionada.getDias()));
                }
            } catch (NumberFormatException numberFormatException) {
                mostrarMensajeCampoInvalido(dias, "dias", String.valueOf(reservacionSeleccionada.getDias()));
            }

        } else {
            mostrarMensajeCampoInvalido(dias, "dias", String.valueOf(reservacionSeleccionada.getDias()));
        }

        return valido;
    }

    private void mostrarMensajeCampoInvalido(JTextField campo, String nombre, String valor) {
        campo.setText(valor);
        JOptionPane.showMessageDialog(this, String.format("El campo \"%s\" es invalido", nombre),
                "Valor invalido", JOptionPane.ERROR_MESSAGE);
    }

}
