package restauranteserver;

import entidades.Mozo;
import entidades.Usuario;
import gestoras.GestoraProductos;
import gestoras.GestoraServicios;
import gestoras.GestoraUnidadProcesadora;
import gestoras.GestoraUsuarios;
import java.rmi.RemoteException;
import servicio.IService;

/**
 *
 * @author Juan, Ignacio
 */
public class Server implements IService {

    private GestoraProductos gsp = GestoraProductos.getInstance();
    private GestoraServicios gss = GestoraServicios.getInstance();
    private GestoraUnidadProcesadora gsup = GestoraUnidadProcesadora.getInstance();
    private GestoraUsuarios gsu = GestoraUsuarios.getInstance();

    @Override
    public boolean iniciarSesion(String username, String password) throws RemoteException {
        return gsu.iniciarSesion(username, password);
    }

    @Override
    public Usuario getUserPorUserName(String username) throws RemoteException {
        return gsu.getUserPorUserName(username);
    }

    @Override
    public void cerrarSesion(Usuario u) {
        gsu.cerrarSesion(u);
    }

}
