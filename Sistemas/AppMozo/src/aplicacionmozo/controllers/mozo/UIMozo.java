package aplicacionmozo.controllers.mozo;

import entidades.Mesa;
import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Juan, Ignacio
 */
public interface UIMozo {

    void listarUsuarios(ArrayList<Usuario> colUsers);

    public void listarMesas(Mesa[][] mesas);
}
