package servicio;

import entidades.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Juan, Ignacio
 */
public interface IService extends Remote {

    boolean iniciarSesion(String username, String password) throws RemoteException;

    Usuario getUserPorUserName(String username) throws RemoteException;

    void cerrarSesion(Usuario u) throws RemoteException;
    
    void agregarObserver(IRemoteObserver io) throws RemoteException;
}
