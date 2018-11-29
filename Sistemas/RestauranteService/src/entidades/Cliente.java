package entidades;

/**
 *
 * @author Ignacio , Juan
 */
public class Cliente {

    private int id;
    private String nombre;
    private String correo;
    private TipoCliente tipo;

    public Cliente(int id, String nombre, String correo, TipoCliente tipo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

}
