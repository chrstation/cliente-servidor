package rent.a.car.cliente.servidor;

import rent.a.car.cliente.servidor.modelos.Vehiculo;
//import static rent.a.car.cliente.servidor.ReservacionImpl.fecha;

/**
 * Clase vehiculos: se usan if, else, while y arreglo de 10.
 *
 * @author Charlie
 */
public class clase_vehiculos {

    int Precio1 = 10000;
    int Precio2 = 15000;
    int opcion;

    public static Vehiculo arreglo[] = new Vehiculo[10];

    public void eleccion_vehiculo() {
        throw new UnsupportedOperationException("Aun no esta implementado");
//        boolean seguir = true;
//        while (seguir) {
//            opcion = Integer.parseInt(JOptionPane.showInputDialog("A continuacion se le presentaran los vehiculos, marcas y modelos, tome en cuenta que si se presenta una D al lado es porque esta disponible" + "\n"
//                    + "1. " + arreglo[0].Marca + " " + arreglo[0].Modelo + " " + arreglo[0].Año + ", placa: " + arreglo[0].Placa + ", " + Precio1 + " colones por dia, " + arreglo[0].Reserva + "\n"
//                    + "2. " + arreglo[1].Marca + " " + arreglo[1].Modelo + " " + arreglo[1].Año + ", placa: " + arreglo[1].Placa + ", " + Precio2 + " colones por dia, " + arreglo[1].Reserva + "\n"
//                    + "3. " + arreglo[2].Marca + " " + arreglo[2].Modelo + " " + arreglo[2].Año + ", placa: " + arreglo[2].Placa + ", " + Precio1 + " colones por dia, " + arreglo[2].Reserva + "\n"
//                    + "4. " + arreglo[3].Marca + " " + arreglo[3].Modelo + " " + arreglo[3].Año + ", placa: " + arreglo[3].Placa + ", " + Precio2 + " colones por dia, " + arreglo[3].Reserva + "\n"
//                    + "5. " + arreglo[4].Marca + " " + arreglo[4].Modelo + " " + arreglo[4].Año + ", placa: " + arreglo[4].Placa + ", " + Precio1 + " colones por dia, " + arreglo[4].Reserva + "\n"
//                    + "6. " + arreglo[5].Marca + " " + arreglo[5].Modelo + " " + arreglo[5].Año + ", placa: " + arreglo[5].Placa + ", " + Precio2 + " colones por dia, " + arreglo[5].Reserva + "\n"
//                    + "7. " + arreglo[6].Marca + " " + arreglo[6].Modelo + " " + arreglo[6].Año + ", placa: " + arreglo[6].Placa + ", " + Precio1 + " colones por dia, " + arreglo[6].Reserva + "\n"
//                    + "8. " + arreglo[7].Marca + " " + arreglo[7].Modelo + " " + arreglo[7].Año + ", placa: " + arreglo[7].Placa + ", " + Precio2 + " colones por dia, " + arreglo[7].Reserva + "\n"
//                    + "9. " + arreglo[8].Marca + " " + arreglo[8].Modelo + " " + arreglo[8].Año + ", placa: " + arreglo[8].Placa + ", " + Precio1 + " colones por dia, " + arreglo[8].Reserva + "\n"
//                    + "10. " + arreglo[9].Marca + " " + arreglo[9].Modelo + " " + arreglo[9].Año + ", placa: " + arreglo[9].Placa + ", " + Precio2 + " colones por dia, " + arreglo[9].Reserva));
//            if (arreglo[opcion - 1].Reserva == "D") {
//                arreglo[opcion - 1].Reserva = "R";
//                fecha[0].numero_vehiculo = arreglo[opcion - 1].Placa;
//                JOptionPane.showMessageDialog(null, "Vehiculo Reservado");
//
//                int seguro = JOptionPane.showConfirmDialog(null, "Desea incluir el seguro?\n"
//                        + "Existe descuento del 25% en el seguro para mayores de 25 años");
//
//                if (seguro == 0) {
//                    if (opcion == 1 || opcion == 3 || opcion == 5 || opcion == 7 || opcion == 9) {
//                        if (cliente[0].Edad > 25) {
//                            int monto_seguro = 7500;
//                            fecha[0].seguro = monto_seguro;
//                            int deposito = ((Precio1 * fecha[0].dias) + monto_seguro);
//                            fecha[0].precio = Precio1;
//                            JOptionPane.showMessageDialog(null, "A continuacion se le mostrara la factura de su deposito con seguro incluido." + "\n"
//                                    + "Vehiculo Marca: " + arreglo[opcion - 1].Marca + "\n"
//                                    + "Modelo: " + arreglo[opcion - 1].Modelo + "\n"
//                                    + "Año: " + arreglo[opcion - 1].Año + "\n"
//                                    + "Placa: " + arreglo[opcion - 1].Placa + "\n"
//                                    + "Dias a rentar: " + fecha[0].dias + "\n"
//                                    + "Seguro: " + monto_seguro + "\n"
//                                    + "--------------------------------------" + "\n"
//                                    + "Monto del deposito: " + deposito);
//                            fecha[0].deposito = deposito;
//                            seguir = false;
//                        } else {
//                            int monto_seguro = 10000;
//                            fecha[0].seguro = monto_seguro;
//                            int deposito = ((Precio1 * fecha[0].dias) + monto_seguro);
//                            fecha[0].precio = Precio1;
//                            JOptionPane.showMessageDialog(null, "A continuacion se le mostrara la factura de su deposito con seguro incluido." + "\n"
//                                    + "Vehiculo Marca: " + arreglo[opcion - 1].Marca + "\n"
//                                    + "Modelo: " + arreglo[opcion - 1].Modelo + "\n"
//                                    + "Año: " + arreglo[opcion - 1].Año + "\n"
//                                    + "Placa: " + arreglo[opcion - 1].Placa + "\n"
//                                    + "Dias de alquiler: " + fecha[0].dias + "\n"
//                                    + "Seguro: " + monto_seguro + "\n"
//                                    + "--------------------------------------" + "\n"
//                                    + "Monto del deposito: " + deposito);
//                            fecha[0].deposito = deposito;
//                            seguir = false;
//                        }
//                    } else {
//                        if (cliente[0].Edad > 25) {
//                            int monto_seguro = 7500;
//                            fecha[0].seguro = monto_seguro;
//                            int deposito = ((Precio2 * fecha[0].dias) + monto_seguro);
//                            fecha[0].precio = Precio2;
//                            JOptionPane.showMessageDialog(null, "A continuacion se le mostrara la factura de su deposito con seguro incluido." + "\n"
//                                    + "Vehiculo Marca: " + arreglo[opcion - 1].Marca + "\n"
//                                    + "Modelo: " + arreglo[opcion - 1].Modelo + "\n"
//                                    + "Año: " + arreglo[opcion - 1].Año + "\n"
//                                    + "Placa: " + arreglo[opcion - 1].Placa + "\n"
//                                    + "Dias de alquiler: " + fecha[0].dias + "\n"
//                                    + "Seguro: " + monto_seguro + "\n"
//                                    + "--------------------------------------" + "\n"
//                                    + "Monto del deposito: " + deposito);
//                            fecha[0].deposito = deposito;
//                            seguir = false;
//                        } else {
//                            int monto_seguro = 10000;
//                            fecha[0].seguro = monto_seguro;
//                            int deposito = ((Precio2 * fecha[0].dias) + monto_seguro);
//                            fecha[0].precio = Precio2;
//                            JOptionPane.showMessageDialog(null, "A continuacion se le mostrara la factura de su deposito con seguro incluido." + "\n"
//                                    + "Vehiculo Marca: " + arreglo[opcion - 1].Marca + "\n"
//                                    + "Modelo: " + arreglo[opcion - 1].Modelo + "\n"
//                                    + "Año: " + arreglo[opcion - 1].Año + "\n"
//                                    + "Placa: " + arreglo[opcion - 1].Placa + "\n"
//                                    + "Dias de alquiler: " + fecha[0].dias + "\n"
//                                    + "Seguro: " + monto_seguro + "\n"
//                                    + "--------------------------------------" + "\n"
//                                    + "Monto del deposito: " + deposito);
//                            fecha[0].deposito = deposito;
//                            seguir = false;
//                        }
//                    }
//                } else {
//                    if (opcion == 1 || opcion == 3 || opcion == 5 || opcion == 7 || opcion == 9) {
//                        int deposito = (Precio1 * fecha[0].dias);
//                        fecha[0].precio = Precio1;
//                        JOptionPane.showMessageDialog(null, "A continuacion se le mostrara la factura de su deposito sin seguro incluido." + "\n"
//                                + "Vehiculo Marca: " + arreglo[opcion - 1].Marca + "\n"
//                                + "Modelo: " + arreglo[opcion - 1].Modelo + "\n"
//                                + "Año: " + arreglo[opcion - 1].Año + "\n"
//                                + "Placa: " + arreglo[opcion - 1].Placa + "\n"
//                                + "Dias de alquiler: " + fecha[0].dias + "\n"
//                                + "--------------------------------------" + "\n"
//                                + "Monto del deposito: " + deposito);
//                        fecha[0].deposito = deposito;
//                        seguir = false;
//                    } else {
//                        int deposito = (Precio2 * fecha[0].dias);
//                        fecha[0].precio = Precio2;
//                        JOptionPane.showMessageDialog(null, "A continuacion se le mostrara la factura de su deposito sin seguro incluido." + "\n"
//                                + "Vehiculo Marca: " + arreglo[opcion - 1].Marca + "\n"
//                                + "Modelo: " + arreglo[opcion - 1].Modelo + "\n"
//                                + "Año: " + arreglo[opcion - 1].Año + "\n"
//                                + "Placa: " + arreglo[opcion - 1].Placa + "\n"
//                                + "Dias de alquiler: " + fecha[0].dias + "\n"
//                                + "--------------------------------------" + "\n"
//                                + "Monto del deposito: " + deposito);
//                        fecha[0].deposito = deposito;
//                        seguir = false;
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Lo sentimos, ese vehiculo no se encuentra disponible. Por favor lea el mensaje anterior con detenimiento para ver cuales vehiculos se encuentran disponibles.");
//            }
//        }
    }
}
