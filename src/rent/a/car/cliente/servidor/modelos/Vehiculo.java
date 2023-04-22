package rent.a.car.cliente.servidor.modelos;

/**
 * Constructores de los vehiculos.
 *
 * @author Charlie
 */
public class Vehiculo {

    public Integer id;
    public int annio;
    public double precio;
    public String marca;
    public String modelo;
    public String placa;

    public Vehiculo(Integer id, String marca, String modelo, int annio, String placa, double precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.annio = annio;
        this.placa = placa;
        this.precio = precio;
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int annio) {
        this.annio = annio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
