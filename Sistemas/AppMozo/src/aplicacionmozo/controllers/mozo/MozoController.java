package aplicacionmozo.controllers.mozo;

import aplicacionmozo.Sistema;
import entidades.Mesa;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        ArrayList<Mesa> mesasMozo = server.obtenerMesasDeMozo(Sistema.getMozo().getUsername());
        ui.listarMesas(obtenerMatrizDeMesas(mesasMozo));
    }

    public void cerrarSesion() {
        try {
            server.cerrarSesion(Sistema.getMozo().getUsername());
        } catch (RemoteException ex) {
            Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(IService s, Object obj) throws RemoteException {
        if ((Evento) obj == Evento.USUARIO_CONECTADO || (Evento) obj == Evento.USUARIO_DESCONECTADO) {
            ui.listarUsuarios(s.obtenerUsuariosConectados());
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
}
