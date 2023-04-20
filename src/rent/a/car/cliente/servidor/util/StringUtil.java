/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rent.a.car.cliente.servidor.util;

/**
 *
 * @author daniel.guzman
 */
public class StringUtil {

    /**
     * Metodo utilitario para evaluar si un String dado: es nulo, esta en blanco
     * o esta vacio
     *
     * @param string El string a evaluar
     * @return {@code true} si y solo si el string dado es nulo O esta en blanco
     * O esta vacio
     */
    public static boolean isEmpty(String string) {
        return string == null || string.isBlank() || string.isEmpty();
    }

}
