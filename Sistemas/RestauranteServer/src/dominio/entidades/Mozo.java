package dominio.entidades;

import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class Mozo extends Usuario{
    private ArrayList<Mesa> colMesas;

    public Mozo(String usuario, String contrasenia, String nombre, boolean logueado) {
        super(usuario, contrasenia, nombre, logueado);
        this.colMesas = new ArrayList<>();
    }
}
