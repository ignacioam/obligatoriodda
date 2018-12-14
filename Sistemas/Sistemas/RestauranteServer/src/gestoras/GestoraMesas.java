package gestoras;

import java.util.ArrayList;
import entidades.Mesa;
import entidades.Servicio;

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
            m.getServicio().setMesa(m);
            return true;
        }
        return false;
    }

    public boolean cerrarMesa(int numero) {
        Mesa m = obtenerMesaPorNumero(numero);
        if (m != null) {
            Servicio s = GestoraServicios.getInstance().getServicioPorNumero(m.getServicio().getNumero());
            if(!s.tieneLineasPendientes()){
                GestoraServicios.getInstance().addServicioBd(s);
                m.cerrar();
                return true;
            } else{
                return false;
            }
        }
        return false;
    }
}
