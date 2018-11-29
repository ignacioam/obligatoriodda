package Servicio;

import dominio.entidades.Mozo;
import dominio.entidades.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Juan, Ignacio
 */
public interface IServer extends Remote {

    boolean iniciarSesion(String username, String password) throws RemoteException;

    Usuario getUserPorUserName(String username) throws RemoteException;

    void cerrarSesion(Mozo m) throws RemoteException;
}
