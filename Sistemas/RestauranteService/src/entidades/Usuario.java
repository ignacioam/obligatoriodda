package entidades;

import java.io.Serializable;

/**
 *
 * @author juanc, Ignacio
 */
public abstract class Usuario implements Serializable {

    private String username;
    private String contrasenia;
    private String nombre;
    private boolean logueado;

    public Usuario(String usuario, String contrasenia, String nombre) {
        this.username = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.logueado = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usuario) {
        this.username = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }    
}
