package appgestores.controllers.login;

/**
 *
 * @author Juan, Ignacio
 */
public interface UILogin {

    String getUsername();

    String getPassword();
    
    void mostrarMensaje(String msg);
    
    void cerrarForm();
}
