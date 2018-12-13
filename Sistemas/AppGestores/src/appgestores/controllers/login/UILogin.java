package appgestores.controllers.login;

import entidades.UnidadProcesadora;
import java.util.ArrayList;

/**
 *
 * @author Juan, Ignacio
 */
public interface UILogin {

    String getUsername();

    String getPassword();

    void mostrarMensaje(String msg);

    void cerrarForm();

    void listarUnidades(ArrayList<UnidadProcesadora> col);
    
    UnidadProcesadora getUnidad();
}
