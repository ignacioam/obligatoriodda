package appgestores.controllers.login;

import appgestores.Sistema;
import appgestores.views.FrmGestores;
import entidades.Gestor;
import entidades.Usuario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.IService;

/**
 *
 * @author Juan, Ignacio
 */
public class LoginController {
    
    private UILogin ui;
    private IService server;
    
    public LoginController(UILogin ui, IService server) {
        try {
            this.ui = ui;
            this.server = server;
            ui.listarUnidades(server.getUnidadesProcesadoras());
        } catch (RemoteException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniciarSesion() {
        String username = ui.getUsername();
        String password = ui.getPassword();
        try {
            if (server.iniciarSesion(username, password)) {
                Usuario u = server.getUserPorUserName(username);
                if (u instanceof Gestor && ui.getUnidad() != null) {
                    Sistema.setGestor((Gestor) u);
                    Sistema.setUnidadProcesadora(Sistema.getService().getUnidadPorNombre(ui.getUnidad().getNombre()));
                    new FrmGestores().setVisible(true);
                    ui.cerrarForm();
                } else {
                    ui.mostrarMensaje("Ha ocurrido un error. Por favor, compruebe los datos.");
                }
            } else {
                ui.mostrarMensaje("Ha ocurrido un error. Por favor, compruebe los datos.");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
