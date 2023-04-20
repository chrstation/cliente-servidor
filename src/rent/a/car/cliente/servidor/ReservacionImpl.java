package rent.a.car.cliente.servidor;

import rent.a.car.cliente.servidor.db.BaseDeDatosTemporal;
import rent.a.car.cliente.servidor.frames.MenuCliente;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;
import javax.swing.JButton;
import static rent.a.car.cliente.servidor.clase_vehiculos.arreglo;
import static rent.a.car.cliente.servidor.frames.MenuCliente.cliente;

/**
 *
 * @author Charlie
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rent.a.car.cliente.servidor.interfaces.Reservacion;

public class ReservacionImpl implements Reservacion {

    public int id;
    public int dias;
    public int seguro;
    public int precio;
    public int deposito;
    public int monto_total;
    public int numero_reserva;
    public String numero_vehiculo;

    private final BaseDeDatosTemporal db;

    public ReservacionImpl(BaseDeDatosTemporal db) {
        this.db = db;
    }

    public Reservacion crear(Reservacion reservacion) {
//        for (int x = 0; x < fecha.length; x++) {
//            int dias = Integer.parseInt(JOptionPane.showInputDialog("Escriba la cantidad de días a reservar: "));
//            int numero_reserva = 1;
//
//            MenuCliente clientFrame = new MenuCliente();
//            JTextField id = clientFrame.getId();
//            String numero_vehiculo = "";
//            int monto_total = 0;
//            int deposito = 0;
//            int seguro = 0;
//            int precio = 0;
//
//            fecha[x] = new ReservacionImpl(dias, numero_reserva, id, numero_vehiculo, monto_total, deposito, seguro, precio);
//        }
//
//        for (int i = 0; i < fecha.length; i++) {
//            JFrame frame = new JFrame("Nueva Reserva");
//            JLabel label1 = new JLabel("Cantidad de días: " + fecha[i].dias);
//            JLabel label2 = new JLabel("N° reserva: " + fecha[i].numero_reserva);
//            frame.add(label1);
//            frame.add(label2);
//            frame.pack();
//            frame.setVisible(true);
//        }
        throw new UnsupportedOperationException("Aun no esta implementado");
    }

    /**
     * @inheritdoc
     */
    @Override
    public Optional<Reservacion> consultar(int id) {
        throw new UnsupportedOperationException("Aun no esta implementado");
    }

    /**
     * @inheritdoc
     */
    @Override
    public Reservacion eliminar(int id) {
//        boolean continuar = true;
//
//        while (continuar) {
//            int reserva = Integer.parseInt(JOptionPane.showInputDialog("Escriba el número de la reserva a eliminar"));
//
//            for (int y = 0; y < fecha.length; y++) {
//                if (fecha[y].numero_reserva == reserva) {
//                    for (int i = 0; i < fecha.length; i++) {
//                        if (fecha[i].numero_reserva == reserva) {
//                            fecha[i].dias = 0;
//                        }
//                        fecha[i].id = 0;
//                        fecha[i].numero_reserva = 0;
//                        fecha[i].deposito = 0;
//                        fecha[i].monto_total = 0;
//                        fecha[i].numero_vehiculo = "";
//                        JOptionPane.showMessageDialog(null, "La reserva a sido eliminada");
//                        continuar = false;
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Su numero de reserva no existe o es incorrecto, por favor intentelo de nuevo.");
//                    continuar = true;
//                }
//            }
//        }
        throw new UnsupportedOperationException("Aun no esta implementado");
    }

    /**
     * @inheritdoc
     */
    @Override
    public Reservacion modificar(Reservacion reservacion) {
        throw new UnsupportedOperationException("Aun no esta implementado");
//        boolean continuar = true;
//
//        while (continuar) {
//            int reserva = Integer.parseInt(JOptionPane.showInputDialog("Escriba el número de la reserva a Modificar"));
//
//            for (int y = 0; y < fecha.length; y++) {
//                if (fecha[y].numero_reserva == reserva) {
//                    JFrame frame = new JFrame("Modificar Reserva");
//                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                    frame.setSize(400, 300);
//
//                    JPanel panel = new JPanel();
//                    panel.setLayout(new GridLayout(4, 2));
//
//                    JLabel label1 = new JLabel("Cambiar dias del alquiler:");
//                    JTextField text1 = new JTextField();
//                    panel.add(label1);
//                    panel.add(text1);
//
//                    JLabel label2 = new JLabel("Cambiar tipo de Vehículo:");
//                    JTextField text2 = new JTextField();
//                    panel.add(label2);
//                    panel.add(text2);
//
//                    JLabel label3 = new JLabel("Agregar o Quitar Seguro:");
//                    JTextField text3 = new JTextField();
//                    panel.add(label3);
//                    panel.add(text3);
//
//                    JButton button = new JButton("Guardar Cambios");
//                    button.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent e) {
//                            int respuesta = 0;
//                            try {
//                                respuesta = Integer.parseInt(text1.getText());
//                                for (int i = 0; i < fecha.length; i++) {
//                                    fecha[i].dias = respuesta;
//                                    JOptionPane.showMessageDialog(null, "Nueva Cantidad de días es: " + fecha[i].dias
//                                            + "\nEl monto del deposito no cambia, se hara el cambio en el total a cancelar en la devolución");
//                                }
//                            } catch (NumberFormatException ex) {
//                                // Handle exception
//                            }
//
//                            try {
//                                respuesta = Integer.parseInt(text2.getText());
//                                for (int i = 0; i < fecha.length; i++) {
//                                    for (int z = 0; z < arreglo.length; z++) {
//                                        if (fecha[i].numero_vehiculo == arreglo[z].Placa) {
//                                            arreglo[z].Reserva = "D";
//                                        }
//                                    }
//                                    fecha[i].numero_vehiculo = "";
//                                    clase_vehiculos reserva_vehiculo = new clase_vehiculos();
//                                    reserva_vehiculo.eleccion_vehiculo();
//                                }
//                            } catch (NumberFormatException ex) {
//                                // Handle exception
//                            }
//
//                            try {
//                                respuesta = Integer.parseInt(text3.getText());
//                                for (int i = 0; i < fecha.length; i++) {
//                                    if (fecha[i].seguro > 1) {
//                                        JOptionPane.showMessageDialog(null,
//                                                "El Monto del seguro a remover es de: " + fecha[i].seguro
//                                                + "\nEl monto del deposito no cambia, se hara el cambio en el total a cancelar en la devolución");
//                                    } else {
//                                        if (cliente[0].Edad > 25) {
//                                            fecha[i].seguro = 7500;
//                                            JOptionPane.showMessageDialog(null,
//                                                    "El Monto del seguro a agregar es de: " + fecha[i].seguro
//                                                    + "\nEl monto del deposito no cambia, se hara el cambio en el total a cancelar en la devolución");
//                                        } else {
//                                            fecha[i].seguro = 15000;
//                                            JOptionPane.showMessageDialog(null,
//                                                    "El Monto del seguro a agregar es de: " + fecha[i].seguro
//                                                    + "\nEl monto del tiene un descuento, se hara el cambio en el total a cancelar en la devolución");
//                                        }
//                                    }
//                                }
//                            } catch (NumberFormatException ex) {
//                                // Handle exception
//                            }
//                        }
//                    });
//                }
//            }
//        }
    }

    public void devolucion() {
         throw new UnsupportedOperationException("Aun no esta implementado");
//        boolean continuar = true;
//        JFrame frame = new JFrame("Devolución de reserva");
//
//        while (continuar) {
//            int reserva = Integer.parseInt(JOptionPane.showInputDialog(frame, "Escriba el número de la reserva a Modificar"));
//
//            for (int y = 0; y < fecha.length; y++) {
//                if (fecha[y].numero_reserva == reserva) {
//
//                    for (int x = 0; x < fecha.length; x++) {
//                        if (fecha[x].numero_reserva == reserva) {
//                            fecha[x].monto_total = ((fecha[x].dias * fecha[x].precio) + fecha[x].seguro);
//                        }
//
//                        String message = "Información de la devolución\n"
//                                + "Número de reserva: " + fecha[x].numero_reserva + "\n"
//                                + "Cantidad de días: " + fecha[x].dias + "\n"
//                                + "Identificación del cliente: " + fecha[x].id + "\n"
//                                + "Nombre del cliente: " + cliente[x].nombre + "\n"
//                                + "Número de placa del vehiculo : " + fecha[x].numero_vehiculo + "\n"
//                                + "Monto total a cancelar: " + fecha[x].monto_total + "\n"
//                                + "El monto del deposito: " + fecha[x].deposito + " le sera devuelto en el transcurso de los siguientes días";
//
//                        JOptionPane.showMessageDialog(frame, message);
//                        continuar = false;
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(frame, "Su numero de reserva no existe o es incorrecto, por favor intentelo de nuevo.");
//                    continuar = true;
//                }
//            }
//        }
    }
}
