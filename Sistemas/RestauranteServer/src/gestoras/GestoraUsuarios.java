package gestoras;

import entidades.Mesa;
import entidades.Mozo;
import entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Juan, Ignacio
 */
public class GestoraUsuarios implements Serializable {

    private ArrayList<Usuario> colUsuarios;
    private ArrayList<Usuario> colUsuarioConectados;

    private GestoraUsuarios() {
        colUsuarios = new ArrayList<>();
        colUsuarioConectados = new ArrayList<>();
        cargarUsuarios();
    }

    /**
     * Precarga los usuarios
     */
    public void cargarUsuarios() {
        Mozo m1 = new Mozo("jperez", "juanchi", "Juan Pérez");
        Mozo m2 = new Mozo("imartins", "nacho", "Ignacio Martins");
        Mozo m3 = new Mozo("tvandelli", "tomas", "Tomas Vandelli");
        Mozo m4 = new Mozo("fspasiuk", "fernando", "Fernando Spasiuk");
        Mozo m5 = new Mozo("sconde", "sebac", "Sebastian Conde");

        ArrayList<Mesa> col = new ArrayList<Mesa>() {
            {
                add(new Mesa(m5));
                add(new Mesa(m3));
                add(new Mesa(m5));
                add(new Mesa(m2));
                add(new Mesa(m1));
                add(new Mesa(m4));
                add(new Mesa(m1));
                add(new Mesa(m5));
                add(new Mesa(m2));
                add(new Mesa(m5));
                add(new Mesa(m2));
                add(new Mesa(m1));
                add(new Mesa(m3));
                add(new Mesa(m4));
                add(new Mesa(m4));
                add(new Mesa(m5));
                add(new Mesa(m4));
                add(new Mesa(m3));
                add(new Mesa(m4));
                add(new Mesa(m5));
                add(new Mesa(m3));
                add(new Mesa(m4));
                add(new Mesa(m1));
                add(new Mesa(m2));
                add(new Mesa(m4));
                add(new Mesa(m5));
                add(new Mesa(m1));
            }
        };

        colUsuarios.add(m1);
        colUsuarios.add(m2);
        colUsuarios.add(m3);
        colUsuarios.add(m4);
        colUsuarios.add(m5);
        GestoraMesas.getInstance().setColMesas(col);
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
            addUsuarioConectado(u);
            return true;
        }
        return false;
    }

    public boolean cerrarSesion(String nick) {
        for (Usuario usu : colUsuarios) {
            if (usu.getUsername().equals(nick)) {
                usu.setLogueado(false);
                colUsuarioConectados.remove(usu);
                return true;
            }
        }
        return false;
    }

    public void addUsuarioConectado(Usuario u) {
        colUsuarioConectados.add(u);
    }

    public ArrayList<Usuario> obtenerUsuariosConectados() {
        return new ArrayList<>(colUsuarioConectados);
    }
}
