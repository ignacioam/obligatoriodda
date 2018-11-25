package dominio.gestoras;

import dominio.entidades.Mozo;
import dominio.entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan Pérez
 */
public class GestoraUsuarios {

    private ArrayList<Usuario> colUsuarios;

    private GestoraUsuarios() {
        colUsuarios = new ArrayList<>();
        Usuario m = new Mozo("juanchip", "1234", "Juan Andrés Pérez");
        colUsuarios.add(m);
    }

    /**
     * Singleton
     */
    private static GestoraUsuarios instance;

    public static GestoraUsuarios getInstance() {
        if (null == instance) {
            instance = new GestoraUsuarios();
        }
        return instance;
    }

    public Usuario getUserPorUserName(String username) {

        Usuario u = null;
        for (Usuario user : colUsuarios) {
            if (user.getUsername().equals(username)) {
                u = user;
                break;
            }
        }
        return u;
    }

    public boolean iniciarSesion(String username, String password) {
        System.err.println(username);
        if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
            return false;
        }
        Usuario u = getUserPorUserName(username);
        return u != null && u.getContrasenia().equals(password);
    }
}
