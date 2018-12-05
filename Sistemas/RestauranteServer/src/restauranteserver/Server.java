package restauranteserver;

import entidades.Usuario;
import gestoras.GestoraProductos;
import gestoras.GestoraServicios;
import gestoras.GestoraUnidadProcesadora;
import gestoras.GestoraUsuarios;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import servicio.IRemoteObserver;
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
    private ArrayList<IRemoteObserver> colObservers = new ArrayList<>();
    
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

    @Override
    public void agregarObserver(IRemoteObserver io) throws RemoteException {
        colObservers.add(io);
    }

    public void notificarObserver(Object obj){
        Iterator<IRemoteObserver> it = colObservers.iterator();
        while (it.hasNext()) {
            try {
                it.next().update(this, obj);
            } catch (RemoteException e) {
                it.remove();
            }
        }
    }
}
