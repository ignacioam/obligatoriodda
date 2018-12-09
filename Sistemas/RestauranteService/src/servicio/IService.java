package servicio;

import entidades.Cliente;
import entidades.LineaServicio;
import entidades.Mesa;
import entidades.Producto;
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
    
    void abrirMesa(int mesa) throws RemoteException;
    
    void agregarLineaServicio(LineaServicio ls, Mesa m) throws RemoteException;
    
    ArrayList<Cliente> getAllClientes() throws RemoteException;
    
    ArrayList<Producto> getAllProductos() throws RemoteException;
}
