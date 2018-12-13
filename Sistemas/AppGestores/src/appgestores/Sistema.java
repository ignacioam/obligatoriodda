package appgestores;

import entidades.Gestor;
import entidades.UnidadProcesadora;
import servicio.IService;

/**
 *
 * @author Juan, Ignacio
 */
public class Sistema {

    private static IService stub;
    private static Gestor gestor;
    private static UnidadProcesadora up;

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

    public static UnidadProcesadora getUnidadProcesadora() {
        return up;
    }

    public static void setUnidadProcesadora(UnidadProcesadora up) {
        Sistema.up = up;
    }
    
    
}
