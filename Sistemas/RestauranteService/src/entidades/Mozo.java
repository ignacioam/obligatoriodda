package entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class Mozo extends Usuario implements Serializable {

    private ArrayList<Mesa> colMesas;

    public Mozo(String usuario, String contrasenia, String nombre) {
        super(usuario, contrasenia, nombre);
        this.colMesas = new ArrayList<>();
    }

    public void addMesa(Mesa m) {
        colMesas.add(m);
    }

    public ArrayList<Mesa> getMesas() {
        return new ArrayList<>(colMesas);
    }

    public void removeMesa(int numero) {
        for (Mesa m : colMesas) {
            if (m.getNumero() == numero) {
                colMesas.remove(m);
                return;
            }
        }
    }
}
