package aplicacionmozo.controllers.mozo;

import aplicacionmozo.Sistema;
import entidades.EstadoLinea;
import entidades.EstadoTransferencia;
import entidades.LineaServicio;
import entidades.Mesa;
import entidades.Mozo;
import entidades.Transferencia;
import entidades.Usuario;
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
public class MozoController extends UnicastRemoteObject implements IRemoteObserver {

    IService server;
    UIMozo ui;

    public MozoController(IService server, UIMozo ui) throws RemoteException {
        this.server = server;
        this.ui = ui;
        server.agregarObserver(this);
        ArrayList<Mesa> mesasMozo = Sistema.getMozo().getMesas();
        ui.listarMesas(obtenerMatrizDeMesas(mesasMozo));
        ui.listarMesasTransferencia(mesasMozo);
        listarUsers(Sistema.getService().obtenerMozosConectados());

    }

    public boolean cerrarSesion() {
        for (Mesa m : Sistema.getMozo().getMesas()) {
            if (m.isAbierta()) {
                ui.mostrarMensajePane("Usted tiene mesas abiertas", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        try {
            server.cerrarSesion(Sistema.getMozo().getUsername());
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void abrirMesa(int m) {
        try {
            server.abrirMesa(m);
        } catch (RemoteException ex) {
            Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(IService s, Object obj) throws RemoteException {
        Sistema.setMozo((Mozo) s.getUserPorUserName(Sistema.getMozo().getUsername()));
        if (obj == Evento.USUARIO_CONECTADO || obj == Evento.USUARIO_DESCONECTADO) {
            listarUsers(s.obtenerMozosConectados());
        } else if (obj == Evento.MESA_TRANSFERIDA) {
            actualizarMesas();
            emitirTransferencias(s.getTransferenciasEmitidasMozo(Sistema.getMozo().getUsername()));
        } else if (obj == Evento.ABRIR_MESA || obj == Evento.CERRAR_MESA) {
            actualizarMesas();
        } else if (obj == Evento.INICIAR_TRANSFERENCIA) {
            mostrarTransferenciasPendientes();
        } else if (obj == Evento.PEDIDO_FINALIZADO) {
            emitirLinea(s.getLineasMozo(Sistema.getMozo().getUsername()));
        }
    }

    private void mostrarTransferenciasPendientes() throws RemoteException {
        for (Transferencia t : server.obtenerTransferenciasPendientesDeMozo(Sistema.getMozo().getUsername())) {
            boolean opt = ui.tranferenciaMesa(t);
            server.transferirMesa(opt, t.getNumero());
        }
        actualizarMesas();
    }

    private void listarUsers(ArrayList<Mozo> col) {
        for (Usuario usuario : col) {
            if (usuario.getUsername().equals(Sistema.getMozo().getUsername())) {
                col.remove(usuario);
                break;
            }
        }
        ui.listarUsuarios(col);
    }

    private void actualizarMesas() {
        ui.listarMesas(obtenerMatrizDeMesas(Sistema.getMozo().getMesas()));
        ui.listarMesasTransferencia(Sistema.getMozo().getMesas());
    }

    private void emitirTransferencias(ArrayList<Transferencia> col) {
        for (Transferencia t : col) {
            if (t.getEstado() != EstadoTransferencia.PENDIENTE && !t.isEmitida()) {
                try {
                    if (t.getEstado() == EstadoTransferencia.ACEPTADA) {
                        ui.mostrarMensaje("Transferencia aceptada - Mesa: " + t.getMesa().getNumero(), new java.awt.Color(98, 160, 240));
                    } else {
                        ui.mostrarMensaje("Transferencia rechazada - Mesa: " + t.getMesa().getNumero(), new java.awt.Color(255, 102, 102));
                    }
                    server.transferenciaEmitida(t.getNumero());
                } catch (RemoteException ex) {
                    Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void emitirLinea(ArrayList<LineaServicio> col) {
        for (LineaServicio ls : col) {
            if (ls.getEstado() == EstadoLinea.FINALIZADA && !ls.isEmitida()) {
                try {
                    String datos = "Pedido finalizado"
                            + "\nArtículo: " + ls.getProducto().getNombre()
                            + "\nCantidad: " + ls.getCantidad()
                            + "\nMesa: " + ls.getServicio().getMesa().getNumero();
                    ui.mostrarMensajePane(datos, "Atención", JOptionPane.INFORMATION_MESSAGE);
                    server.lineaEmitida(ls.getServicio().getNumero(), ls.getProducto().getNombre());
                } catch (RemoteException ex) {
                    Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private Mesa[][] obtenerMatrizDeMesas(ArrayList<Mesa> mesasMozo) {
        int cant = (int) Math.ceil(mesasMozo.size() / 3f);
        Mesa[][] matriz = new Mesa[cant][3];
        int x = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (x == mesasMozo.size()) {
                    break;
                }
                matriz[i][j] = mesasMozo.get(x++);
            }
        }
        return matriz;
    }

    public void iniciarTransferencia() {
        try {
            Mesa mesa = ui.getMesaTransferencia();
            Mozo mozo = ui.getMozoTransferencia();
            server.iniciarTransferencia(Sistema.getMozo().getUsername(), mozo.getUsername(), mesa.getNumero());
        } catch (RemoteException ex) {
            Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
