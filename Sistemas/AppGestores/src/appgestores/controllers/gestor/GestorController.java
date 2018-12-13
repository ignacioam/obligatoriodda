package appgestores.controllers.gestor;

import appgestores.Sistema;
import entidades.EstadoLinea;
import entidades.Gestor;
import entidades.LineaServicio;
import entidades.Pedido;
import entidades.UnidadProcesadora;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import servicio.Evento;
import servicio.IRemoteObserver;
import servicio.IService;

/**
 *
 * @author Juan, Ignacio
 */
public class GestorController extends UnicastRemoteObject implements IRemoteObserver {

    private UnidadProcesadora up;
    private IService server;
    private UIGestor ui;

    public GestorController(IService server, UIGestor ui, UnidadProcesadora up) throws RemoteException {
        this.server = server;
        this.ui = ui;
        this.up = up;
        server.agregarObserver(this);
        listarPedidos(Sistema.getUnidadProcesadora().getPedidos());
        listarMisPedidos(Sistema.getGestor().getLineas());
    }

    public void cerrarSesion() {
        boolean ok = true;
        if (ok) {
            try {
                server.cerrarSesion(Sistema.getGestor().getUsername());
            } catch (RemoteException ex) {
                Logger.getLogger(GestorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ui.mostrarMensaje("Usted tiene mesas abiertas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(IService s, Object obj) throws RemoteException {
        Sistema.setUnidadProcesadora(s.getUnidadPorNombre(Sistema.getUnidadProcesadora().getNombre()));
        Sistema.setGestor((Gestor) s.getUserPorUserName(Sistema.getGestor().getUsername()));
        if (obj == Evento.LINEA_AGREGADA) {
            listarPedidos(Sistema.getUnidadProcesadora().getPedidos());
        } else if (obj == Evento.PEDIDO_TOMADO || obj == Evento.MESA_TRANSFERIDA || obj == Evento.PEDIDO_FINALIZADO) {
            listarPedidos(Sistema.getUnidadProcesadora().getPedidos());
            listarMisPedidos(Sistema.getGestor().getLineas());
        }
    }

    private void listarMisPedidos(ArrayList<LineaServicio> col) {
        ArrayList<Pedido> lista = new ArrayList<>();
        for (LineaServicio ls : col) {
            if (ls.getEstado() == EstadoLinea.EN_PROCESO) {
                lista.add(new Pedido(ls));
            }
        }
        ui.listarMisPedidos(lista);
    }

    private void listarPedidos(ArrayList<LineaServicio> col) {
        ArrayList<Pedido> lista = new ArrayList<>();
        for (LineaServicio ls : col) {
            if (ls.getEstado() == EstadoLinea.PENDIENTE) {
                lista.add(new Pedido(ls));
            }
        }
        ui.listarPedidos(lista);
    }

    public void tomarPedido() {
        Pedido p = ui.getPedidoTomar();
        if (p == null) {
            ui.mostrarMensaje("Seleccione un pedido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String user = Sistema.getGestor().getUsername();
                int numServicio = p.getLinea().getServicio().getNumero();
                String nomProd = p.getLinea().getProducto().getNombre();
                server.tomarLinea(numServicio, nomProd, user);
            } catch (RemoteException ex) {
                Logger.getLogger(GestorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void finalizarPedido() {
        Pedido p = ui.getPedidoFinalizar();
        if (p == null) {
            ui.mostrarMensaje("Seleccione un pedido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String user = Sistema.getGestor().getUsername();
                int numServicio = p.getLinea().getServicio().getNumero();
                String nomProd = p.getLinea().getProducto().getNombre();
                server.finalizarLinea(numServicio, nomProd);
            } catch (RemoteException ex) {
                Logger.getLogger(GestorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
