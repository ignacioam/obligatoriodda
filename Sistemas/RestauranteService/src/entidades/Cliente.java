package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio , Juan
 */
public class Cliente implements Serializable{

    private String documento;
    private String nombre;
    private String correo;
    private TipoCliente tipo;

    public Cliente(String documento, String nombre, String correo, TipoCliente tipo) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    @Override
    public String toString() {
        return nombre + " - (" + tipo.toString() + ")";
    }
    
    

}
