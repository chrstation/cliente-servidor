/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.interfaces.ServicioUsuario;
import rent.a.car.cliente.servidor.modelos.Usuario;
import rent.a.car.cliente.servidor.servicios.ServicioUsuarioImpl;
import rent.a.car.cliente.servidor.util.StringUtil;

/**
 *
 * @author daniel.guzman
 */
public class InicioSesion extends JFrame {

    private final ServicioUsuario servicioUsuario;

    public InicioSesion() {
        configurarInterfaz();
        this.servicioUsuario = new ServicioUsuarioImpl();
    }

    private void configurarInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 125);
        setLocationRelativeTo(null);

        JTextField usuario = new JTextField(20);
        JPasswordField contrasennia = new JPasswordField(50);
        JPanel inputPanel = configurarCamposEntrada(usuario, contrasennia);
        JPanel botones = configurarBotones(usuario, contrasennia);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(botones, BorderLayout.CENTER);
    }

    private JPanel configurarCamposEntrada(JTextField usuario, JTextField contrasennia) {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("   Nombre de usuario:"));
        inputPanel.add(usuario);
        inputPanel.add(new JLabel("   Contraseña:"));
        inputPanel.add(contrasennia);
        return inputPanel;
    }

    private JPanel configurarBotones(JTextField usuario, JTextField contrasennia) {
        JPanel botones = new JPanel();
        JButton inicio = new JButton("Iniciar sesion");
        botones.add(inicio);

        inicio.addActionListener(event -> {
            try {
                String nombre = usuario.getText();
                String pwd = contrasennia.getText();

                if (validarEntrada(nombre, pwd) && servicioUsuario.autenticar(new Usuario(null, nombre, pwd))) {
                    this.dispose();
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.mostrar();
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña invalido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IllegalArgumentException | ErrorConexionBaseDeDatos ex) {
                System.err.println("Erro autenticando usuario. Mensaje: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error autenticando usuario, por favor intentlo de nuevo mas tarde",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        JButton salir = new JButton("Salir");
        botones.add(salir);

        salir.addActionListener(event -> {
            this.dispose();
            System.exit(0);
        });
        return botones;
    }

    private boolean validarEntrada(String usuario, String contrasennia) {
        return !StringUtil.isEmpty(usuario) && !StringUtil.isEmpty(contrasennia);
    }

}
