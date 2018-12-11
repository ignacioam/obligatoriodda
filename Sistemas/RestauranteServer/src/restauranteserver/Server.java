package restauranteserver;

import entidades.Cliente;
import entidades.Estado;
import entidades.LineaServicio;
import entidades.Mesa;
import entidades.Mozo;
import entidades.Producto;
import entidades.Transferencia;
import entidades.Usuario;
import gestoras.GestoraClientes;
import gestoras.GestoraMesas;
import gestoras.GestoraProductos;
import gestoras.GestoraServicios;
import gestoras.GestoraTransferencias;
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
    private GestoraClientes gsc;
    private GestoraTransferencias gst;
    private ArrayList<IRemoteObserver> colObservers;

    public Server() {
        gsp = GestoraProductos.getInstance();
        gss = GestoraServicios.getInstance();
        gsup = GestoraUnidadProcesadora.getInstance();
        gsu = GestoraUsuarios.getInstance();
        gsm = GestoraMesas.getInstance();
        gsc = GestoraClientes.getInstance();
        gst = GestoraTransferencias.getInstance();
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
    public void abrirMesa(int m) throws RemoteException {
        if (gsm.abrirMesa(m)) {
            notificarObserver(Evento.ABRIR_MESA);
        }
    }

    @Override
    public boolean transferirMesa(String mozoDestino, int mesa, String mozoOrigen) throws RemoteException {
        Mesa m = gsm.obtenerMesaPorNumero(mesa);
        Mozo mozoD = (Mozo) gsu.getUserPorUserName(mozoDestino);
        Mozo mozoO = (Mozo) gsu.getUserPorUserName(mozoOrigen);
        Transferencia t = new Transferencia(m, mozoD, mozoO);
        gst.addTransferencia(t);
        notificarObserver(Evento.INICIAR_TRANSFERENCIA);
        if (t.getEstado() == Estado.PENDIENTE || t.getEstado() == Estado.RECHAZADA) {
            t.setEstado(Estado.RECHAZADA);
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Transferencia> obtenerTransferenciasPendientesDeMozo(String username) throws RemoteException {
        return gst.obtenerTransferenciasPendientesDeMozo(username);
    }

    @Override
    public void transferirMesa(boolean aceptada, int numTransferencia) throws RemoteException {
        gst.transferirMesa(aceptada, numTransferencia);
        notificarObserver(Evento.MESA_TRANSFERIDA);
    }

    @Override
    public ArrayList<Cliente> getAllClientes() throws RemoteException {
        return gsc.getAllClientes();
    }

    @Override
    public ArrayList<Producto> getAllProductos() throws RemoteException {
        return gsp.getAllProductosConStock();
    }

    @Override
    public boolean agregarLineaServicio(int producto, int cantidad, int mesa) throws RemoteException {
        Producto p = gsp.obtenerProductoPorNumero(producto);
        Mesa m = gsm.obtenerMesaPorNumero(mesa);
        return gss.addLineaAServicio(new LineaServicio(p, cantidad), mesa);
    }

    @Override
    public Mesa getMesaPorNumero(int numero) throws RemoteException {
        return gsm.obtenerMesaPorNumero(numero);
    }
}
