package gestoras;

import entidades.Mozo;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Juan, Ignacio
 */
public class GestoraUsuarios {

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
            addUsuarioConectado(u);
            return true;
        }
        return false;
    }

   public boolean cerrarSesion(Usuario user) {
       Iterator<Usuario> colUsers = colUsuarioConectados.iterator();
       while (colUsers.hasNext()) {
           colUsers.next().setLogueado(false);
           colUsers.remove();
           return true;
       }
       return false;
   }
    
    public void addUsuarioConectado(Usuario u){
        colUsuarioConectados.add(u);
    }
    
    public ArrayList<Usuario> obtenerUsuariosConectados(){
        return new ArrayList<>(colUsuarioConectados);
    }
}
