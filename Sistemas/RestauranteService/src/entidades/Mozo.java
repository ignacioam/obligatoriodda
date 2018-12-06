package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class Mozo extends Usuario implements Serializable {

    public Mozo(String usuario, String contrasenia, String nombre) {
        super(usuario, contrasenia, nombre);
    }
}
