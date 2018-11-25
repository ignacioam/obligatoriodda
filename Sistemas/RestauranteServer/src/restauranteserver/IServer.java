package restauranteserver;

import dominio.entidades.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Juan Perez, Ignacio Martins
 */
public interface IServer extends Remote {

    boolean iniciarSesion(String username, String password) throws RemoteException;

    Usuario getUserPorUserName(String username) throws RemoteException;
}
