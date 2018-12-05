package aplicacionmozo;

import aplicacionmozo.views.FrmLogin;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.IService;

/**
 *
 * @author Juanchi Perez
 */
public class AplicacionMozo {

    private static String DIRECCION;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DIRECCION = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Servidor";
            new AplicacionMozo().conectarServidor();
        } catch (UnknownHostException ex) {
            Logger.getLogger(AplicacionMozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Se conecta al servidor
     */
    private void conectarServidor() {
        try {
            Sistema.setService((IService) Naming.lookup(DIRECCION));
            new FrmLogin().setVisible(true);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AplicacionMozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
