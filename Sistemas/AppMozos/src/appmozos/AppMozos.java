/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmozos;

import Presentacion.FrmLogin;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import restauranteserver.IServer;

/**
 *
 * @author Juan Pérez, Ignacio Martins
 */
public class AppMozos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        try {
            Sistema.setService((IServer) Naming.lookup("rmi://192.168.1.31/Server"));
            new FrmLogin().setVisible(true);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AppMozos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
