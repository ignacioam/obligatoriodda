package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class UnidadProcesadora implements Serializable{

    private String nombre;

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
