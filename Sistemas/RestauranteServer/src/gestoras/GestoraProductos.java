package gestoras;

import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class GestoraProductos {

    private ArrayList<Usuario> colProductos;

    private GestoraProductos() {
        colProductos = new ArrayList<>();
    }

    /**
     * Singleton
     */
    private static GestoraProductos instance;

    public static GestoraProductos getInstance() {
        if (null == instance) {
            instance = new GestoraProductos();
        }
        return instance;
    }
}
