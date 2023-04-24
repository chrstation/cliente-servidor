/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.modelos;

/**
 *
 * @author daniel.guzman
 */
public class Usuario {
    private final Integer id;
    private final String nombre;
    private final String contrasennia;

    public Usuario(Integer id, String nombre, String contrasennia) {
        this.id = id;
        this.nombre = nombre;
        this.contrasennia = contrasennia;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasennia() {
        return contrasennia;
    }
}
