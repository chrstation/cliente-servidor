package rent.a.car.cliente.servidor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static rent.a.car.cliente.servidor.clase_vehiculos.arreglo;
import static rent.a.car.cliente.servidor.ClienteFrame.cliente;

/**
 *
 * @author Charlie
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class clase_reservaciones {

    public static Reservaciones fecha[] = new Reservaciones[1];

    public void Nueva_reserva() {
        for (int x = 0; x < fecha.length; x++) {
            int dias = Integer.parseInt(JOptionPane.showInputDialog("Escriba la cantidad de días a reservar: "));
            int numero_reserva = 1;
            JTextField id = ClienteFrame.idField;
            String numero_vehiculo = "";
            int monto_total = 0;
            int deposito = 0;
            int seguro = 0;
            int precio = 0;
            fecha[x] = new Reservaciones(dias, numero_reserva, id, numero_vehiculo, monto_total, deposito, seguro, precio);
        }

        for (int i = 0; i < fecha.length; i++) {
            JFrame frame = new JFrame("Nueva Reserva");
            JLabel label1 = new JLabel("Cantidad de días: " + fecha[i].Dias);
            JLabel label2 = new JLabel("N° reserva: " + fecha[i].Numero_reserva);
            frame.add(label1);
            frame.add(label2);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public void Eliminar_reserva() {
        boolean continuar = true;

        while (continuar) {
            int reserva = Integer.parseInt(JOptionPane.showInputDialog("Escriba el número de la reserva a eliminar"));

            for (int y = 0; y < fecha.length; y++) {
                if (fecha[y].Numero_reserva == reserva) {
                    for (int i = 0; i < fecha.length; i++) {
                        if (fecha[i].Numero_reserva == reserva) {
                            fecha[i].Dias = 0;
                        }
                        fecha[i].Id = 0;
                        fecha[i].Numero_reserva = 0;
                        fecha[i].Deposito = 0;
                        fecha[i].Monto_total = 0;
                        fecha[i].Numero_vehiculo = "";
                        JOptionPane.showMessageDialog(null, "La reserva a sido eliminada");
                        continuar = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Su numero de reserva no existe o es incorrecto, por favor intentelo de nuevo.");
                    continuar = true;
                }
            }
        }
    }

    public void Modificar_reserva() {
        boolean continuar = true;

        while (continuar) {
            int reserva = Integer.parseInt(JOptionPane.showInputDialog("Escriba el número de la reserva a Modificar"));

            for (int y = 0; y < fecha.length; y++) {
                if (fecha[y].Numero_reserva == reserva) {
                    JFrame frame = new JFrame("Modificar Reserva");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(400, 300);

                    JPanel panel = new JPanel();
                    panel.setLayout(new GridLayout(4, 2));

                    JLabel label1 = new JLabel("Cambiar dias del alquiler:");
                    JTextField text1 = new JTextField();
                    panel.add(label1);
                    panel.add(text1);

                    JLabel label2 = new JLabel("Cambiar tipo de Vehículo:");
                    JTextField text2 = new JTextField();
                    panel.add(label2);
                    panel.add(text2);

                    JLabel label3 = new JLabel("Agregar o Quitar Seguro:");
                    JTextField text3 = new JTextField();
                    panel.add(label3);
                    panel.add(text3);

                    JButton button = new JButton("Guardar Cambios");
                    button.addActionListener(new ActionListener(){                 
                        public void actionPerformed(ActionEvent e) {
                            int respuesta = 0;
                            try {
                                respuesta = Integer.parseInt(text1.getText());
                                for (int i = 0; i < fecha.length; i++) {
                                    fecha[i].Dias = respuesta;
                                    JOptionPane.showMessageDialog(null, "Nueva Cantidad de días es: " + fecha[i].Dias
                                            + "\nEl monto del deposito no cambia, se hara el cambio en el total a cancelar en la devolución");
                                }
                            } catch (NumberFormatException ex) {
                                // Handle exception
                            }

                            try {
                                respuesta = Integer.parseInt(text2.getText());
                                for (int i = 0; i < fecha.length; i++) {
                                    for (int z = 0; z < arreglo.length; z++) {
                                        if (fecha[i].Numero_vehiculo == arreglo[z].Placa) {
                                            arreglo[z].Reserva = "D";
                                        }
                                    }
                                    fecha[i].Numero_vehiculo = "";
                                    clase_vehiculos reserva_vehiculo = new clase_vehiculos();
                                    reserva_vehiculo.eleccion_vehiculo();
                                }
                            } catch (NumberFormatException ex) {
                                // Handle exception
                            }

                            try {
                                respuesta = Integer.parseInt(text3.getText());
                                for (int i = 0; i < fecha.length; i++) {
                                    if (fecha[i].Seguro > 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "El Monto del seguro a remover es de: " + fecha[i].Seguro
                                                + "\nEl monto del deposito no cambia, se hara el cambio en el total a cancelar en la devolución");
                                    } else {
                                        if (cliente[0].Edad > 25) {
                                            fecha[i].Seguro = 7500;
                                            JOptionPane.showMessageDialog(null,
                                                    "El Monto del seguro a agregar es de: " + fecha[i].Seguro
                                                    + "\nEl monto del deposito no cambia, se hara el cambio en el total a cancelar en la devolución");
                                        } else {
                                            fecha[i].Seguro = 15000;
                                            JOptionPane.showMessageDialog(null,
                                                    "El Monto del seguro a agregar es de: " + fecha[i].Seguro
                                                    + "\nEl monto del tiene un descuento, se hara el cambio en el total a cancelar en la devolución");
                                        }
                                    }
                                }
                            } catch (NumberFormatException ex) {
                                // Handle exception
                            }
                        }
                    });
                }
            }
        }
    }



public void devolucion_reserva() {
    boolean continuar = true;
    JFrame frame = new JFrame("Devolución de reserva");

    while (continuar) {
        int reserva = Integer.parseInt(JOptionPane.showInputDialog(frame, "Escriba el número de la reserva a Modificar"));

        for (int y = 0; y < fecha.length; y++) {
            if (fecha[y].Numero_reserva == reserva) {

                for (int x = 0; x < fecha.length; x++) {
                    if (fecha[x].Numero_reserva == reserva) {
                        fecha[x].Monto_total = ((fecha[x].Dias * fecha[x].Precio) + fecha[x].Seguro);
                    }

                    String message = "Información de la devolución\n"
                            + "Número de reserva: " + fecha[x].Numero_reserva + "\n"
                            + "Cantidad de días: " + fecha[x].Dias + "\n"
                            + "Identificación del cliente: " + fecha[x].Id + "\n"
                            + "Nombre del cliente: " + cliente[x].Nombre + "\n"
                            + "Número de placa del vehiculo : " + fecha[x].Numero_vehiculo + "\n"
                            + "Monto total a cancelar: " + fecha[x].Monto_total + "\n"
                            + "El monto del deposito: " + fecha[x].Deposito + " le sera devuelto en el transcurso de los siguientes días";

                    JOptionPane.showMessageDialog(frame, message);
                    continuar = false;
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Su numero de reserva no existe o es incorrecto, por favor intentelo de nuevo.");
                continuar = true;
            }
        }
    }
}
}




