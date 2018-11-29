package app;

import views.FrmLogin;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.IService;

/**
 *
 * @author Juan Pérez, Ignacio Martins
 */
public class AppMozos {

    private final String DIRECCION  = "rmi://192.168.2.127/Servidor";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        (new AppMozos()).conectarServidor();
    }
    
    /**
     * Se conecta al servidor
     */
    private void conectarServidor(){
        try {
            Sistema.setService((IService) Naming.lookup(DIRECCION));
            new FrmLogin().setVisible(true);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AppMozos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
