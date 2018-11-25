package dominio.gestoras;

import dominio.entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan Pérez
 */
public class GestoraUsuarios {
    private ArrayList<Usuario> colUsuarios;
    
    private GestoraUsuarios(){
        colUsuarios = new ArrayList<>();
    }
    
    /**
     * Singleton
     */
    private static GestoraUsuarios instance;
    public static GestoraUsuarios getInstance(){
        if(null == instance)
            instance = new GestoraUsuarios();
        return instance;
    }
}
