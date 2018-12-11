package gestoras;

import java.util.ArrayList;
import entidades.Mesa;

/**
 *
 * @author Juan, Ignacio
 */
public class GestoraMesas {

    private ArrayList<Mesa> colMesas;

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

    public void addMesa(Mesa mesa) {
        mesa.getMozo().addMesa(mesa);
        colMesas.add(mesa);
    }

    public Mesa obtenerMesaPorNumero(int mesa) {
        for (Mesa m : colMesas) {
            if (m.getNumero() == mesa) {
                return m;
            }
        }
        return null;
    }

    public boolean abrirMesa(int mesa) {
        Mesa m = obtenerMesaPorNumero(mesa);
        if (m != null && m.abrir()) {
            GestoraServicios.getInstance().addServicio(m.getServicio());
            return true;
        }
        return false;
    }
}
