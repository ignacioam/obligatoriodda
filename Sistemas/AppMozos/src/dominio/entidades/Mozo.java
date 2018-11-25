package dominio.entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class Mozo extends Usuario implements Serializable {

    private ArrayList<Mesa> colMesas;

    public Mozo(String usuario, String contrasenia, String nombre) {
        super(usuario, contrasenia, nombre);
        this.colMesas = new ArrayList<>();
    }
}
