/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.db;

import java.util.ArrayList;
import java.util.List;
import rent.a.car.cliente.servidor.Cliente;
import rent.a.car.cliente.servidor.ReservacionImpl;
import rent.a.car.cliente.servidor.Vehiculo;
import rent.a.car.cliente.servidor.interfaces.Reservacion;

/**
 *
 * @author daniel.guzman
 */
public class BaseDeDatosTemporal {

    /**
     * Abastracion de una Base de datos en memoria para gestionar la informacion
     * de la aplicacion. Esto debe ser sustituido por una base de datos real
     */
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Vehiculo> vehiculos = new ArrayList<>();
    private final List<Reservacion> reservaciones = new ArrayList<>();

    public BaseDeDatosTemporal() {
        clientes.add(new Cliente("Carlos", "Charlie", "Costa Rica", 20, 1, "1-234-56-789"));
        clientes.add(new Cliente("Daniel", "Guzman", "Costa Rica", 20, 2, "1-234-56-789"));

        vehiculos.add(new Vehiculo("Honda", "Accord", 2017, "HHK-909", "D"));
        vehiculos.add(new Vehiculo("Honda", "Civic", 2021, "KMM-788", "D"));
        vehiculos.add(new Vehiculo("Hyundai", "Elantra", 2018, "VDH-888", "D"));
        vehiculos.add(new Vehiculo("Hyundai", "Santa Fe", 2021, "CHH-911", "D"));
        vehiculos.add(new Vehiculo("Nissan", "Sentra", 2018, "MNM-546", "D"));
        vehiculos.add(new Vehiculo("Lexus", "Rx350", 2021, "JVV-109", "D"));
        vehiculos.add(new Vehiculo("Toyota", "Corona", 2019, "LLG-777", "D"));
        vehiculos.add(new Vehiculo("Toyota", "4Runner", 2021, "WWW-434", "D"));
        vehiculos.add(new Vehiculo("Mazda", "Cx5", 2017, "SFR-911", "D"));
    }

    public void guardarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void guardarReservacion(ReservacionImpl reservacion) {
        reservaciones.add(reservacion);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<Reservacion> getReservaciones() {
        return reservaciones;
    }

}
