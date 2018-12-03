package appmozo.controllers.login;

/**
 *
 * @author Juan Perez, Ignacio Martins
 */
public interface UILogin {

    String getUsername();

    String getPassword();
    
    void mostrarMensaje(String msg);
    
    void cerrarForm();
}