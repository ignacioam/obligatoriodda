package dominio.gestoras;

import dominio.entidades.Mozo;
import dominio.entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Juan, Ignacio
 */
public class GestoraUsuarios {

    private ArrayList<Usuario> colUsuarios;

    private GestoraUsuarios() {
        colUsuarios = new ArrayList<>();
        cargarUsuarios();
    }

    /**
     * Precarga los usuarios
     */
    public void cargarUsuarios() {
        Usuario m2 = new Mozo("jperez", "juanchi", "Juan Pérez");
        Usuario m1 = new Mozo("imartins", "nacho", "Ignacio Martins");
        colUsuarios.add(m1);
        colUsuarios.add(m2);
    }

    //Singleton     
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
        if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
            return false;
        }
        Usuario u = getUserPorUserName(username);
        if (u != null && u.getContrasenia().equals(password) && !u.isLogueado()) {
            u.setLogueado(true);
            return true;
        }
        return false;
    }

    public void cerrarSesion(Usuario user) {
        for (Usuario u : colUsuarios) {
            if (u.getNombre().equals(user.getNombre())) {
                u.setLogueado(false);
            }
        }
    }
}
