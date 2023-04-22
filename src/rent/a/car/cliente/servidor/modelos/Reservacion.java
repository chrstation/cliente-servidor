/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.modelos;

/**
 *
 * @author daniel.guzman
 */
public class Reservacion {

    private Integer id;
    private int dias;
    private double costo;
    private int vehiculo_fk;
    private int cliente_fk;

    public Reservacion(Integer id, int dias, double costo, int vehiculo_fk, int cliente_fk) {
        this.id = id;
        this.dias = dias;
        this.costo = costo;
        this.vehiculo_fk = vehiculo_fk;
        this.cliente_fk = cliente_fk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getVehiculo_fk() {
        return vehiculo_fk;
    }

    public void setVehiculo_fk(int vehiculo_fk) {
        this.vehiculo_fk = vehiculo_fk;
    }

    public int getCliente_fk() {
        return cliente_fk;
    }

    public void setCliente_fk(int cliente_fk) {
        this.cliente_fk = cliente_fk;
    }

    
}
