package servicio;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ignacio
 */
public interface IRemoteObserver extends Remote{
    void update(IService s, Object obj) throws RemoteException;
}
