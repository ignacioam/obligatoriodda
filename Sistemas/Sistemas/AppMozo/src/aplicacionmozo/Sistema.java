package aplicacionmozo;

import entidades.Mozo;
import servicio.IService;

/**
 *
 * @author Juan, Ignacio
 */
public class Sistema {

    private static IService stub;
    private static Mozo mozo;

    private Sistema() {

    }

    public static Mozo getMozo() {
        return mozo;
    }

    public static void setMozo(Mozo mozo) {
        Sistema.mozo = mozo;
    }

    public static IService getService() {
        return stub;
    }

    public static void setService(IService stub) {
        Sistema.stub = stub;
    }
}
