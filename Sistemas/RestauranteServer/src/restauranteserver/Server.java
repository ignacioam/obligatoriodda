package restauranteserver;

import entidades.Mesa;
import entidades.Usuario;
import gestoras.GestoraMesas;
import gestoras.GestoraProductos;
import gestoras.GestoraServicios;
import gestoras.GestoraUnidadProcesadora;
import gestoras.GestoraUsuarios;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import servicio.Evento;
import servicio.IRemoteObserver;
import servicio.IService;

/**
 *
 * @author Juan, Ignacio
 */
public class Server implements IService {

    private GestoraProductos gsp;
    private GestoraServicios gss;
    private GestoraUnidadProcesadora gsup;
    private GestoraUsuarios gsu;
    private GestoraMesas gsm;
    private ArrayList<IRemoteObserver> colObservers;

    public Server() {
        gsp = GestoraProductos.getInstance();
        gss = GestoraServicios.getInstance();
        gsup = GestoraUnidadProcesadora.getInstance();
        gsu = GestoraUsuarios.getInstance();
        gsm = GestoraMesas.getInstance();
        colObservers = new ArrayList<>();
    }

    @Override
    public boolean iniciarSesion(String username, String password) throws RemoteException {
        if (gsu.iniciarSesion(username, password)) {
            notificarObserver(Evento.USUARIO_CONECTADO);
            return true;
        }
        return false;
    }

    @Override
    public Usuario getUserPorUserName(String username) throws RemoteException {
        return gsu.getUserPorUserName(username);
    }

    @Override
    public void cerrarSesion(String username) {
        if (gsu.cerrarSesion(username)) {
            notificarObserver(Evento.USUARIO_DESCONECTADO);
        }
    }

    @Override
    public void agregarObserver(IRemoteObserver io) throws RemoteException {
        colObservers.add(io);
    }

    public void notificarObserver(Object obj) {
        Iterator<IRemoteObserver> it = colObservers.iterator();
        while (it.hasNext()) {
            try {
                it.next().update(this, obj);
            } catch (RemoteException e) {
                it.remove();
            }
        }
    }

    @Override
    public ArrayList<Usuario> obtenerUsuariosConectados() throws RemoteException {
        return gsu.obtenerUsuariosConectados();
    }

    @Override
    public ArrayList<Mesa> obtenerMesasDeMozo(String username) throws RemoteException {
        return gsm.getMesasDeMozo(username);
    }
}
