package restauranteserver;

import entidades.Cliente;
import entidades.EstadoTransferencia;
import entidades.Gestor;
import entidades.LineaServicio;
import entidades.Mesa;
import entidades.Mozo;
import entidades.Producto;
import entidades.Servicio;
import entidades.Transferencia;
import entidades.UnidadProcesadora;
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

    private static Server instance;

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    private Server() {
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
    public ArrayList<Mozo> obtenerMozosConectados() throws RemoteException {
        return gsu.obtenerMozosConectados();
    }

    @Override
    public void abrirMesa(int m) throws RemoteException {
        if (gsm.abrirMesa(m)) {
            notificarObserver(Evento.ABRIR_MESA);
        }
    }

    @Override
    public ArrayList<Transferencia> obtenerTransferenciasPendientesDeMozo(String username) throws RemoteException {
        return gst.obtenerTransferenciasPendientesDeMozo(username);
    }

    @Override
    public void transferirMesa(boolean aceptada, int numTransferencia) throws RemoteException {
        if (gst.getTransferenciaPorNumero(numTransferencia).getEstado() == EstadoTransferencia.PENDIENTE) {
            gst.transferirMesa(aceptada, numTransferencia);
            notificarObserver(Evento.MESA_TRANSFERIDA);
        }
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
    public boolean agregarLineaServicio(String producto, int cantidad, String descricion, int mesa) throws RemoteException {
        Producto p = gsp.getProductoPorNombre(producto);
        Mesa m = gsm.obtenerMesaPorNumero(mesa);
        if (gss.addLineaAServicio(new LineaServicio(p, cantidad, descricion), mesa)) {
            notificarObserver(Evento.LINEA_AGREGADA);
            return true;
        }
        return false;
    }

    @Override
    public Mesa getMesaPorNumero(int numero) throws RemoteException {
        return gsm.obtenerMesaPorNumero(numero);
    }

    @Override
    public void iniciarTransferencia(String mozoOrigen, String mozoDestino, int mesa) throws RemoteException {
        Mesa m = gsm.obtenerMesaPorNumero(mesa);
        Mozo mozoD = (Mozo) gsu.getUserPorUserName(mozoDestino);
        Mozo mozoO = (Mozo) gsu.getUserPorUserName(mozoOrigen);
        Transferencia t = new Transferencia(m, mozoD, mozoO);
        gst.addTransferencia(t);
        ThreadSimple ts = new ThreadSimple(t.getNumero());
        ts.iniciar();
    }

    @Override
    public ArrayList<Transferencia> getTransferenciasEmitidasMozo(String username) throws RemoteException {
        return gst.getTransferenciasEmitidasMozo(username);
    }

    @Override
    public void transferenciaEmitida(int numero) throws RemoteException {
        gst.transferenciaEmitida(numero);
    }

    @Override
    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras() throws RemoteException {
        return gsup.getUnidades();
    }

    @Override
    public UnidadProcesadora getUnidadPorNombre(String nombre) throws RemoteException {
        return gsup.getUnidadProcesadora(nombre);
    }

    @Override
    public void tomarLinea(int numServicio, String producto, String gestor) throws RemoteException {
        Servicio s = gss.getServicioPorNumero(numServicio);
        Producto p = gsp.getProductoPorNombre(producto);
        Gestor g = (Gestor) gsu.getUserPorUserName(gestor);
        if (gss.tomarLinea(s, p, g)) {
            notificarObserver(Evento.PEDIDO_TOMADO);
        }
    }

    @Override
    public void finalizarLinea(int numServicio, String nomProd) throws RemoteException {
        Servicio s = gss.getServicioPorNumero(numServicio);
        Producto p = gsp.getProductoPorNombre(nomProd);
        if (gss.finalizarLinea(s, p)) {
            notificarObserver(Evento.PEDIDO_FINALIZADO);
        }
    }

    @Override
    public void lineaEmitida(int numServicio, String nomProd) throws RemoteException {
        gss.lineaEmitida(numServicio, nomProd);
    }

    @Override
    public ArrayList<LineaServicio> getLineasMozo(String username) throws RemoteException {
        return gss.getLineasDeMozo(username);
    }

    @Override
    public boolean cerrarMesa(int numero) throws RemoteException {
        if (gsm.cerrarMesa(numero)) {
            notificarObserver(Evento.CERRAR_MESA);
            return true;
        }
        return false;
    }
}
