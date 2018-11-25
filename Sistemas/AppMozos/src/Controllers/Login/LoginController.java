/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Login;

import dominio.entidades.Mozo;
import dominio.entidades.Usuario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import restauranteserver.IServer;

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
        try {
            if (server.iniciarSesion(ui.getUsername(), ui.getPassword())) {
                Usuario u = server.getUserPorUserName(ui.getUsername());
                if(u instanceof Mozo){
                    ui.mostrarMensaje("Niceeeeeee");
                } else {
                    ui.mostrarMensaje("Niceeeeeee");
                }
            } else {
                ui.mostrarMensaje("NOOOOOOOOOOOO");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
