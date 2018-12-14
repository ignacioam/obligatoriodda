package gestoras;

import entidades.UnidadProcesadora;
import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class GestoraUnidadProcesadora {

    private ArrayList<UnidadProcesadora> colUnidadesProcesadoras;

    //Singleton    
    private GestoraUnidadProcesadora() {
        colUnidadesProcesadoras = new ArrayList<>();
        cargarUnidades();
    }

    private static GestoraUnidadProcesadora instance;

    public static GestoraUnidadProcesadora getInstance() {
        if (null == instance) {
            instance = new GestoraUnidadProcesadora();
        }
        return instance;
    }

    public void addUnidad(UnidadProcesadora upp) {
        colUnidadesProcesadoras.add(upp);
    }

    public UnidadProcesadora getUnidadProcesadora(String nombre) {
        for (UnidadProcesadora up : colUnidadesProcesadoras) {
            if (up.getNombre().equals(nombre)) {
                return up;
            }
        }
        return null;
    }

    public ArrayList<UnidadProcesadora> getUnidades() {
        return colUnidadesProcesadoras;
    }

    private void cargarUnidades() {
        colUnidadesProcesadoras.add(new UnidadProcesadora("Cocina"));
        colUnidadesProcesadoras.add(new UnidadProcesadora("Bar"));
    }
}
