package controllers.Login;

import entidades.Mozo;
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

    public void cerrarSesion(Mozo m) {
        try {        
            server.cerrarSesion(m);
        } catch (RemoteException ex) {
            Logger.getLogger(MozoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
