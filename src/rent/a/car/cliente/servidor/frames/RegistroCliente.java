package rent.a.car.cliente.servidor.frames;

/**
 *
 * @author Charlie
 */
import javax.swing.*;
import java.awt.*;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.interfaces.ServicioCliente;
import rent.a.car.cliente.servidor.modelos.Cliente;
import rent.a.car.cliente.servidor.servicios.ServicioClienteImpl;
import rent.a.car.cliente.servidor.util.StringUtil;

public class RegistroCliente extends JFrame {

    private final JFrame menuReservacion;
    private final ServicioCliente servicioCliente;

    private static final String PAIS = "País";
    private static final String EDAD = "Edad";
    private static final String NOMBRE = "Nombre";
    private static final String APELLIDOS = "Apellidos";
    private static final String IDENTIFICACION = "Identificación";
    private static final String DATO_INVALIDO = "Datos incorrectos";

    private final JTextField nombre = new JTextField(10);
    private final JTextField pais = new JTextField(10);
    private final JTextField edad = new JTextField(10);
    private final JTextField apellidos = new JTextField(20);
    private final JTextField identificacion = new JTextField(10);

    public RegistroCliente(JFrame menuReservacion) throws Exception {
        super("Nuevo Cliente");
        this.menuReservacion = menuReservacion;
        this.servicioCliente = new ServicioClienteImpl();

        configurarInterfaz();
    }

    private void configurarInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 210);
        setLocationRelativeTo(null);

        JPanel inputPanel = configurarCamposEntrada();

        JButton agregar = configurarBotonRegistrar();
        JButton cancelar = configurarBotonCancelar();
        inputPanel.add(cancelar);
        inputPanel.add(agregar);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
    }

    private JPanel configurarCamposEntrada() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("   " + IDENTIFICACION + ":"));
        inputPanel.add(identificacion);
        inputPanel.add(new JLabel("   " + NOMBRE + ":"));
        inputPanel.add(nombre);
        inputPanel.add(new JLabel("   " + APELLIDOS + ":"));
        inputPanel.add(apellidos);
        inputPanel.add(new JLabel("   " + PAIS + ":"));
        inputPanel.add(pais);
        inputPanel.add(new JLabel("   " + EDAD + ":"));
        inputPanel.add(edad);
        return inputPanel;
    }

    private JButton configurarBotonRegistrar() {
        JButton agregar = new JButton("Registrar");
        agregar.addActionListener(event -> {
            if (validarEntradas()) {
                try {
                    Cliente cliente = servicioCliente.crear(new Cliente(null, this.nombre.getText(), this.apellidos.getText(),
                            this.pais.getText(), Integer.parseInt(this.edad.getText()),
                            this.identificacion.getText()));

                    this.dispose();
                    confirmarRegistro(cliente);
                    this.setVisible(false);
                    menuReservacion.setVisible(true);
                } catch (ErrorConexionBaseDeDatos ex) {
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Error registrando nuevo cliente. Por favor intentelo de nuevo mas tarde",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return agregar;
    }

    private void confirmarRegistro(Cliente cliente) {
        JOptionPane.showMessageDialog(this, "El cliente se ha agregado exitosamente:\n\n"
                + "ID: " + cliente.getId() + "\n"
                + "Nombre: " + cliente.getNombre() + "\n"
                + "Apellidos: " + cliente.getApellidos() + "\n"
                + "Identificación: " + cliente.getIdentificacion() + "\n"
                + "Pais: " + cliente.getPais() + "\n"
                + "Edad: " + cliente.getEdad() + "\n\n", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
    }

    private JButton configurarBotonCancelar() {
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(event -> {
            this.dispose();
            this.setVisible(false);
        });

        return cancelar;
    }

    private boolean validarEntradas() {
        boolean entradasValidas = true;
        String formatoMensaje = "El campo \"%s\" es invalido";

        if (StringUtil.isEmpty(this.identificacion.getText())) {
            entradasValidas = false;
            JOptionPane.showMessageDialog(this, String.format(formatoMensaje, IDENTIFICACION), DATO_INVALIDO, JOptionPane.ERROR_MESSAGE);
        } else if (StringUtil.isEmpty(this.nombre.getText())) {
            entradasValidas = false;
            JOptionPane.showMessageDialog(this, String.format(formatoMensaje, NOMBRE), DATO_INVALIDO, JOptionPane.ERROR_MESSAGE);
        } else if (StringUtil.isEmpty(this.apellidos.getText())) {
            entradasValidas = false;
            JOptionPane.showMessageDialog(this, String.format(formatoMensaje, APELLIDOS), DATO_INVALIDO, JOptionPane.ERROR_MESSAGE);
        } else if (StringUtil.isEmpty(this.pais.getText())) {
            entradasValidas = false;
            JOptionPane.showMessageDialog(this, String.format(formatoMensaje, PAIS), DATO_INVALIDO, JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Integer.valueOf(this.edad.getText());
            } catch (NumberFormatException numberFormatException) {
                entradasValidas = false;
                JOptionPane.showMessageDialog(this, String.format(formatoMensaje, EDAD), DATO_INVALIDO, JOptionPane.ERROR_MESSAGE);
            }
        }

        return entradasValidas;
    }
}
