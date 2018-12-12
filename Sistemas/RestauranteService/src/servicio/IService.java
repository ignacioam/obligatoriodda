package servicio;

import entidades.Cliente;
import entidades.LineaServicio;
import entidades.Mesa;
import entidades.Producto;
import entidades.Transferencia;
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

    boolean agregarLineaServicio(int producto, int cantidad, int mesa) throws RemoteException;
    
    void iniciarTransferencia(String mozoOrigen, String mozoDestino, int mesa) throws RemoteException;

    ArrayList<Transferencia> obtenerTransferenciasPendientesDeMozo(String username) throws RemoteException;

    void transferirMesa(boolean aceptada, int numTransferencia) throws RemoteException;

    ArrayList<Cliente> getAllClientes() throws RemoteException;

    ArrayList<Producto> getAllProductos() throws RemoteException;

    Mesa getMesaPorNumero(int numero)throws RemoteException;

    ArrayList<Transferencia> getTransferenciasEmitidasMozo(String username) throws RemoteException;

    public void transferenciaEmitida(int numero) throws RemoteException;

}
