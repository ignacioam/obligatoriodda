package servicio;

import entidades.Cliente;
import entidades.LineaServicio;
import entidades.Mesa;
import entidades.Mozo;
import entidades.Producto;
import entidades.Servicio;
import entidades.Transferencia;
import entidades.UnidadProcesadora;
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

    ArrayList<Mozo> obtenerMozosConectados() throws RemoteException;

    void abrirMesa(int mesa) throws RemoteException;

    boolean agregarLineaServicio(String producto, int cantidad, String descripcion, int mesa) throws RemoteException;
    
    void iniciarTransferencia(String mozoOrigen, String mozoDestino, int mesa) throws RemoteException;

    ArrayList<Transferencia> obtenerTransferenciasPendientesDeMozo(String username) throws RemoteException;

    void transferirMesa(boolean aceptada, int numTransferencia) throws RemoteException;

    ArrayList<Cliente> getAllClientes() throws RemoteException;

    ArrayList<Producto> getAllProductos() throws RemoteException;

    Mesa getMesaPorNumero(int numero)throws RemoteException;

    ArrayList<Transferencia> getTransferenciasEmitidasMozo(String username) throws RemoteException;

    void transferenciaEmitida(int numero) throws RemoteException;

    ArrayList<UnidadProcesadora> getUnidadesProcesadoras() throws RemoteException;

    UnidadProcesadora getUnidadPorNombre(String nombre) throws RemoteException;
 
    void tomarLinea(int numServicio, String producto, String gestor) throws RemoteException;

    void finalizarLinea(int numServicio, String nomProd) throws RemoteException;

    void lineaEmitida(int numServicio, String nomProd) throws RemoteException;

    ArrayList<LineaServicio> getLineasMozo(String username) throws RemoteException;

    public boolean cerrarMesa(int numero) throws RemoteException;
    
    public ArrayList<Servicio> obtenerServicios() throws RemoteException;
}
