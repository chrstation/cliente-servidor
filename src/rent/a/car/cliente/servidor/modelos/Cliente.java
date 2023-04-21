package rent.a.car.cliente.servidor.modelos;

/**
 * Clientes.Constructores.
 *
 * @author Charlie
 */
public class Cliente {

    private Integer id;
    private int edad;
    private String pais;
    private String nombre;
    private String apellidos;
    private String identificacion;

    public Cliente(Integer id, String nombre, String apellidos, String pais, int edad, String identificacion) {
        this.id = id;
        this.pais = pais;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
