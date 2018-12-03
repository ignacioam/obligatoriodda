package restauranteserver;

import servicio.IService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan, Ignacio
 */
public class MainServidor {

    /**
     * Propiedades del servidor
     */
    private final int PUERTO = 8888;

    /**
     * Main servidor
     *
     * @param args
     */
    public static void main(String[] args) {
        new MainServidor().iniciarServidor();
    }

    /**
     * Inicia el servidor
     */
    public void iniciarServidor() {
        try {
            Server servidor = new Server();
            IService remote = (IService) UnicastRemoteObject.exportObject(servidor, PUERTO);

            Registry registro = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            registro.rebind("Servidor", remote);

            // Información
            String direccionIp = (InetAddress.getLocalHost()).toString();
            System.out.println("*************| INFO SERVER |*************");
            System.out.println("* Estado: ON\t\t\t\t*");
            System.out.println("* IP: " + direccionIp + "\t\t*");
            System.out.println("* PORT: " + PUERTO + "\t\t\t\t*");
            System.out.println("*****************************************");

        } catch (RemoteException ex) {
            Logger.getLogger(MainServidor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("[ERROR SERVER]: Excepcion: " + ex.getMessage());
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
