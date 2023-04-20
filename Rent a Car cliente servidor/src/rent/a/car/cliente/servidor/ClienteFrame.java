package rent.a.car.cliente.servidor;

/**
 *
 * @author Charlie
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClienteFrame extends JFrame implements ActionListener {

    static JTextField idField;
    private JTextField nombreField;
    private JTextField paisField;
    private JTextField edadField;
    private JButton agregarButton;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private JTextArea outputArea;
    private JScrollPane scrollPane;

    public static clientes[] cliente;

    public ClienteFrame() {
        super("Nuevo Cliente");

        cliente = new clientes[1];

        idField = new JTextField(10);
        nombreField = new JTextField(10);
        paisField = new JTextField(10);
        edadField = new JTextField(10);

        agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(this);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(nombreField);
        inputPanel.add(new JLabel("Pais:"));
        inputPanel.add(paisField);
        inputPanel.add(new JLabel("Edad:"));
        inputPanel.add(edadField);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        scrollPane = new JScrollPane(outputArea);

        outputPanel = new JPanel();
        outputPanel.add(scrollPane);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(agregarButton, BorderLayout.CENTER);
        contentPane.add(outputPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarButton) {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            String pais = paisField.getText();
            int edad = Integer.parseInt(edadField.getText());

            for (int i = 0; i < cliente.length; i++) {
                if (cliente[i] == null) {
                    cliente[i] = new clientes(nombre, pais, edad, id);
                    outputArea.append("El cliente se ha agregado exitosamente\n"
                            + "Nombre: " + cliente[i].Nombre + "\n"
                            + "Identificación: " + cliente[i].Id + "\n"
                            + "Pais: " + cliente[i].Pais + "\n"
                            + "Edad: " + cliente[i].Edad + "\n\n");
                    break;
                }
            }
            idField.setText("");
            nombreField.setText("");
            paisField.setText("");
            edadField.setText("");
        }
    }

    public static void main(String[] args) {
        ClienteFrame frame = new ClienteFrame();
        frame.setVisible(true);
    }
}
