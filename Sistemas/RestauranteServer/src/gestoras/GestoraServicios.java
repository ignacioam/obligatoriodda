package gestoras;

import entidades.Servicio;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class GestoraServicios {

    private ArrayList<Servicio> colServicios;

    private GestoraServicios() {
        colServicios = new ArrayList<>();
    }

    /**
     * Singleton
     */
    private static GestoraServicios instance;

    public static GestoraServicios getInstance() {
        if (null == instance) {
            instance = new GestoraServicios();
        }
        return instance;
    }
}
