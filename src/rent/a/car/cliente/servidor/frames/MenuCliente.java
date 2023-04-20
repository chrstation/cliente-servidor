package rent.a.car.cliente.servidor.frames;

/**
 *
 * @author Charlie
 */
import javax.swing.*;
import java.awt.*;
import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;
import rent.a.car.cliente.servidor.modelos.Cliente;
import rent.a.car.cliente.servidor.util.StringUtil;

public class MenuCliente extends JFrame {

    private final JFrame menuReservacion;
    private final BaseDeDatosTemporal db;

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

    public MenuCliente(BaseDeDatosTemporal db, JFrame menuReservacion) {
        super("Nuevo Cliente");

        this.db = db;
        this.menuReservacion = menuReservacion;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 210);
        setLocationRelativeTo(null);
        configurarInterfaz();
    }

    private void configurarInterfaz() {
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
                Cliente cliente = new Cliente(null, this.nombre.getText(), this.apellidos.getText(),
                        this.pais.getText(), Integer.parseInt(this.edad.getText()),
                        this.identificacion.getText());
                db.guardarCliente(cliente);
                this.dispose();
                confirmarRegistro(cliente);
                menuReservacion.setVisible(true);
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
            System.out.println("Evento");
            this.dispose();
            this.setVisible(false);
            System.out.println("Completadod");
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
