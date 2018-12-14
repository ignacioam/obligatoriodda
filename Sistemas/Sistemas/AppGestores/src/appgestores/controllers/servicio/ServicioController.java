package appgestores.controllers.servicio;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.IService;

/**
 *
 * @author Ignacio, Juan
 */
public class ServicioController {
    private UIServicio ui;
    private IService server;
    
    public ServicioController(IService service, UIServicio ui) {
            this.ui = ui;
            this.server = service;
    }
    
    public void listarServicios() {
        try {
            ui.listarServicios(server.obtenerServicios());
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}