
package rent.a.car.cliente.servidor;

import static rent.a.car.cliente.servidor.clase_vehiculos.arreglo;

/** Clase main: se usan arreglos predefinidos, se usaron fuera de la clases para que se guarden en memoria y puedan ser 
 * modificados.
 *
 * @author Charlie
 */
public class RentACar {

    public static void main(String[] args) {
        
        arreglo[0]=new Vehiculos("Honda", "Accord", 2017, "HHK-909", "D");
        arreglo[1]=new Vehiculos("Honda", "Civic", 2021, "KMM-788", "D");
        arreglo[2]=new Vehiculos("Hyundai", "Elantra", 2018, "VDH-888", "D");
        arreglo[3]=new Vehiculos("Hyundai", "Santa Fe", 2021, "CHH-911", "D");
        arreglo[4]=new Vehiculos("Nissan", "Sentra", 2018, "MNM-546", "D");
        arreglo[5]=new Vehiculos("Lexus", "Rx350", 2021, "JVV-109", "D");
        arreglo[6]=new Vehiculos("Toyota", "Corona", 2019, "LLG-777", "D");
        arreglo[7]=new Vehiculos("Toyota", "4Runner", 2021, "WWW-434", "D");
        arreglo[8]=new Vehiculos("Mazda", "Cx5", 2017, "SFR-911", "D");
        arreglo[9]=new Vehiculos("Mazda", "Cx9", 2021, "CHR-888", "D");
        
        menuprincipal menu = new menuprincipal();
        menu.menuprincipal();
        }
    }
    
