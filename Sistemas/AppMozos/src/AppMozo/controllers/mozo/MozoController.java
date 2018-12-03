package appmozo.controllers.mozo;

import appmozo.Sistema;
import entidades.Usuario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.IService;
/**
 *
 * @author Juan, Ignacio
 */
public class MozoController {

    IService server;
    UIMozo ui;

    public MozoController(IService server, UIMozo ui) {
        this.server = server;
        this.ui = ui;
    }

    public void cerrarSesion() {
        try {        
            server.cerrarSesion((Usuario) Sistema.getMozo());
        } catch (RemoteException ex) {
            Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
