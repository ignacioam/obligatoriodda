package appgestores;

import entidades.Gestor;
import servicio.IService;

/**
 *
 * @author Juan, Ignacio
 */
public class Sistema {

    private static IService stub;
    private static Gestor gestor;

    private Sistema() {

    }

    public static Gestor getGestor() {
        return gestor;
    }

    public static void setGestor(Gestor gestor) {
        Sistema.gestor = gestor;
    }

    public static IService getService() {
        return stub;
    }

    public static void setService(IService stub) {
        Sistema.stub = stub;
    }
}
