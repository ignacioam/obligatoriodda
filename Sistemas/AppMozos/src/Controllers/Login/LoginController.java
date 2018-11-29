package controllers.Login;

import views.FrmMozos;
import entidades.Mozo;
import entidades.Usuario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.IService;

/**
 *
 * @author Juan Perez, Ignacio Martins
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
            Usuario u = server.getUserPorUserName(username);
            if (server.iniciarSesion(username, password) && u instanceof Mozo) {
                ui.cerrarForm();
                new FrmMozos((Mozo) u).setVisible(true);
            } else {
                ui.mostrarMensaje("Ha ocurrido un error. Por favor, compruebe los datos.");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
