/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rent.a.car.cliente.servidor.interfaces;

import rent.a.car.cliente.servidor.excepciones.ErrorConexionBaseDeDatos;
import rent.a.car.cliente.servidor.modelos.Usuario;

/**
 *
 * @author daniel.guzman
 */
public interface ServicioUsuario {

    /**
     * Autentica el usuario dado contra los registros de la base de datos
     *
     * @param usuario El usuario a autenticar
     * @return {@code true} Si y solo si el usuario dado es valido.
     * @throws IllegalArgumentException Si el usuario dado no es valido
     * @throws ErrorConexionBaseDeDatos Si sucede un error al conectar a la base
     * de datos
     */
    public boolean autenticar(Usuario usuario) throws IllegalArgumentException, ErrorConexionBaseDeDatos;

}
