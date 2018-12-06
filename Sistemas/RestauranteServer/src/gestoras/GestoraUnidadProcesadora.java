package gestoras;

import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class GestoraUnidadProcesadora {

    private ArrayList<Usuario> colUnidadesProcesadoras;
   
    //Singleton    
     private GestoraUnidadProcesadora() {
        colUnidadesProcesadoras = new ArrayList<>();
    }
    
    private static GestoraUnidadProcesadora instance;

    public static GestoraUnidadProcesadora getInstance() {
        if (null == instance) {
            instance = new GestoraUnidadProcesadora();
        }
        return instance;
    }
}
