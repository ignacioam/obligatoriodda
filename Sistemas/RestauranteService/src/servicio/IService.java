package servicio;

import entidades.Mesa;
import entidades.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Juan, Ignacio
 */
public interface IService extends Remote {

    boolean iniciarSesion(String username, String password) throws RemoteException;

    Usuario getUserPorUserName(String username) throws RemoteException;

    void cerrarSesion(String username) throws RemoteException;
    
    void agregarObserver(IRemoteObserver io) throws RemoteException;
    
    ArrayList<Usuario> obtenerUsuariosConectados() throws RemoteException;
    
    ArrayList<Mesa> obtenerMesasDeMozo(String username) throws RemoteException;
}
