
package rent.a.car.cliente.servidor;

import javax.swing.JTextField;

/**Reservaciones: constructores
 *
 * @author Charlie
 */
class Reservaciones {
        public int Dias;
        public int Numero_reserva;
        public int Id;
        public String Numero_vehiculo;
        public int Monto_total;
        public int Deposito;
        public int Seguro;
        public int Precio;
      
        
        
    public Reservaciones(int dias, int numero_reserva, JTextField id1, String numero_vehiculo, int precio, int monto_total, int deposito, int seguro)
    {
        this.Dias = dias;
        this.Numero_reserva = numero_reserva;
        this.Id = precio;
        this.Numero_vehiculo = numero_vehiculo;
        this.Monto_total = monto_total;
        this.Deposito = deposito;
        this.Seguro = seguro;
        this.Precio = precio;
    }
}
