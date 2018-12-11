package aplicacionmozo.controllers.mozo;

import aplicacionmozo.Sistema;
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
        listarUsers(Sistema.getService().obtenerUsuariosConectados());
    }

    public void cerrarSesion() {
        try {
            server.cerrarSesion(Sistema.getMozo().getUsername());
        } catch (RemoteException ex) {
            Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
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
        if (obj == Evento.USUARIO_CONECTADO || obj == Evento.USUARIO_DESCONECTADO) {
            listarUsers(s.obtenerUsuariosConectados());
        } else if (obj == Evento.MESA_TRANSFERIDA) {

        } else if (obj == Evento.ABRIR_MESA) {
            Sistema.setMozo((Mozo) s.getUserPorUserName(Sistema.getMozo().getUsername()));
            ui.listarMesas(obtenerMatrizDeMesas(Sistema.getMozo().getMesas()));
            ui.listarMesasTransferencia(Sistema.getMozo().getMesas());
        } else if (obj == Evento.INICIAR_TRANSFERENCIA) {
            Sistema.setMozo((Mozo) s.getUserPorUserName(Sistema.getMozo().getUsername()));
            for (Transferencia t : server.obtenerTransferenciasPendientesDeMozo(Sistema.getMozo().getUsername())) {
                boolean opt = ui.tranferenciaMesa(t);
                server.transferirMesa(opt, t.getNumero());
            }
            ArrayList<Mesa> col = Sistema.getMozo().getMesas();
            ui.listarMesas(obtenerMatrizDeMesas(col));
            ui.listarMesasTransferencia(col);
        }
    }

    private void listarUsers(ArrayList<Usuario> col) {
        for (Usuario usuario : col) {
            if (usuario.getUsername().equals(Sistema.getMozo().getUsername())) {
                col.remove(usuario);
                break;
            }
        }
        ui.listarUsuarios(col);
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
            if (server.transferirMesa(mozo.getUsername(), mesa.getNumero(), Sistema.getMozo().getUsername())) {
                ui.mostrarMensaje("Mesa aceptada", "Informacón", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ui.mostrarMensaje("Mesa rechazada", "Informacón", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
