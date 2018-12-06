package gestoras;

import java.util.ArrayList;
import entidades.Mesa;

/**
 *
 * @author Juan, Ignacio
 */
public class GestoraMesas {

    private ArrayList<Mesa> colMesas;

    public ArrayList<Mesa> getMesasDeMozo(String username) {
        ArrayList<Mesa> aux = new ArrayList<>();
        for (Mesa mesa : colMesas) {
            if (mesa.getMozo().getUsername().equals(username)) {
                aux.add(mesa);
            }
        }
        return aux;
    }

    //Singleton
    private GestoraMesas() {
        this.colMesas = new ArrayList<>();
    }

    private static GestoraMesas instance;

    public static GestoraMesas getInstance() {
        if (null == instance) {
            instance = new GestoraMesas();
        }
        return instance;
    }

    public void setColMesas(ArrayList<Mesa> col) {
        this.colMesas = col;
    }
}
