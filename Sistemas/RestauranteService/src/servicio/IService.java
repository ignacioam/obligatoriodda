package servicio;

import entidades.Mozo;
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

    void cerrarSesion(Mozo m) throws RemoteException;
}