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
import servicio.IRemoteObserver;
import servicio.IService;

/**
 *
 * @author Juanchi Perez
 */
public class MozoController implements IRemoteObserver{

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

    @Override
    public void update(IService s, Object obj) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
