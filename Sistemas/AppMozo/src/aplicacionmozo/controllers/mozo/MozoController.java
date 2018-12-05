/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionmozo.controllers.mozo;

import aplicacionmozo.Sistema;
import entidades.Usuario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.IService;

/**
 *
 * @author Juanchi Perez
 */
public class MozoController {

    IService server;
    UIMozo ui;

    public MozoController(IService server, UIMozo ui) throws RemoteException {
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
