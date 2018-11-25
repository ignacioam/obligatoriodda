/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauranteserver;

import dominio.entidades.Usuario;
import dominio.gestoras.GestoraProductos;
import dominio.gestoras.GestoraServicios;
import dominio.gestoras.GestoraUnidadProcesadora;
import dominio.gestoras.GestoraUsuarios;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Juanchi Perez
 */
public class Server implements IServer {

    private GestoraProductos gsp = GestoraProductos.getInstance();
    private GestoraServicios gss = GestoraServicios.getInstance();
    private GestoraUnidadProcesadora gsup = GestoraUnidadProcesadora.getInstance();
    private GestoraUsuarios gsu = GestoraUsuarios.getInstance();

    @Override
    public boolean iniciarSesion(String username, String password) throws RemoteException {
        return gsu.iniciarSesion(username, password);
    }

    @Override
    public Usuario getUserPorUserName(String username) throws RemoteException {
        return gsu.getUserPorUserName(username);
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            IServer stub = (IServer) UnicastRemoteObject.exportObject(obj, 1099);

            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.setProperty("java.rmi.server.hostname","192.168.1.1");
            registry.rebind("Server", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
