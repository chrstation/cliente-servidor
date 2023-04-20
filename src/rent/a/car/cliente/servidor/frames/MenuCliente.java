package rent.a.car.cliente.servidor.frames;

/**
 *
 * @author Charlie
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import rent.a.car.cliente.servidor.Cliente;

public class MenuCliente extends JFrame implements ActionListener {

    private final JTextField id;
    private final JTextField nombre;
    private final JTextField pais;
    private final JTextField edad;
    private final JButton agregar;
    private final JPanel inputPanel;
    private final JPanel outputPanel;
    private final JTextArea outputArea;
    private final JScrollPane scrollPane;

    public static Cliente[] cliente;

    public JTextField getId() {
        return this.id;
    }

    public MenuCliente() {
        super("Nuevo Cliente");

        cliente = new Cliente[1];

        id = new JTextField(10);
        nombre = new JTextField(10);
        pais = new JTextField(10);
        edad = new JTextField(10);

        agregar = new JButton("Agregar");
        agregar.addActionListener(this);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(id);
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(nombre);
        inputPanel.add(new JLabel("Pais:"));
        inputPanel.add(pais);
        inputPanel.add(new JLabel("Edad:"));
        inputPanel.add(edad);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        scrollPane = new JScrollPane(outputArea);

        outputPanel = new JPanel();
        outputPanel.add(scrollPane);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(agregar, BorderLayout.CENTER);
        contentPane.add(outputPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == agregar) {
//            int id = Integer.parseInt(this.id.getText());
//            String nombre = this.nombre.getText();
//            String pais = this.pais.getText();
//            int edad = Integer.parseInt(this.edad.getText());
//
//            for (int i = 0; i < cliente.length; i++) {
//                if (cliente[i] == null) {
//                    cliente[i] = new Cliente(nombre, pais, edad, id);
//                    outputArea.append("El cliente se ha agregado exitosamente\n"
//                            + "Nombre: " + cliente[i].nombre + "\n"
//                            + "Identificación: " + cliente[i].Id + "\n"
//                            + "Pais: " + cliente[i].Pais + "\n"
//                            + "Edad: " + cliente[i].Edad + "\n\n");
//                    break;
//                }
//            }
//            this.id.setText("");
//            this.nombre.setText("");
//            this.pais.setText("");
//            this.edad.setText("");
//        }
        throw new UnsupportedOperationException("Aun no esta implementado");
    }

    public static void main(String[] args) {
        MenuCliente frame = new MenuCliente();
        frame.setVisible(true);
    }
}
