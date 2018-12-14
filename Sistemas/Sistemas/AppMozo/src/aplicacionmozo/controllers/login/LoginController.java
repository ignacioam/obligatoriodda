package aplicacionmozo.controllers.login;

import aplicacionmozo.Sistema;
import aplicacionmozo.views.FrmMozos;
import entidades.Mozo;
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
        this.ui = ui;
        this.server = server;
    }

    public void iniciarSesion() {
        String username = ui.getUsername();
        String password = ui.getPassword();
        try {
            if (server.iniciarSesion(username, password)) {
                Usuario u = server.getUserPorUserName(username);
                if (u instanceof Mozo) {
                    Sistema.setMozo((Mozo) u);
                    ui.cerrarForm();
                    new FrmMozos().setVisible(true);
                }
            } else {
                ui.mostrarMensaje("Ha ocurrido un error. Por favor, compruebe los datos.");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
