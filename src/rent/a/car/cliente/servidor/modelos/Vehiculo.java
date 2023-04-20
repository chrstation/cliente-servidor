package rent.a.car.cliente.servidor.modelos;

/**
 * Constructores de los vehiculos.
 *
 * @author Charlie
 */
public class Vehiculo {

    public int Año;
    public String Marca;
    public String Modelo;
    public String Placa;
    public String Reserva;

    public Vehiculo(String marca, String modelo, int año, String placa, String reserva) {
        this.Marca = marca;
        this.Modelo = modelo;
        this.Año = año;
        this.Placa = placa;
        this.Reserva = reserva;
    }
}
