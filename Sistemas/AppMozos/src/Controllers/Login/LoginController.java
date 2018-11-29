/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Login;

import Presentacion.FrmMozos;
import Servicio.IServer;
import dominio.entidades.Mozo;
import dominio.entidades.Usuario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Perez, Ignacio Martins
 */
public class LoginController {

    private UILogin ui;
    private IServer server;

    public LoginController(UILogin ui, IServer server) {
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
