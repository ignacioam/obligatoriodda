package gestoras;

import entidades.LineaServicio;
import entidades.Servicio;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class GestoraServicios {

    private ArrayList<Servicio> colServicios;

    private GestoraServicios() {
        colServicios = new ArrayList<>();
    }

    /**
     * Singleton
     */
    private static GestoraServicios instance;

    public static GestoraServicios getInstance() {
        if (null == instance) {
            instance = new GestoraServicios();
        }
        return instance;
    }

    public void addServicio(Servicio s) {
        s.setNumero(1 + colServicios.size());
        s.setMesa(s.getMesa());
        this.colServicios.add(s);
    }

    public boolean addLineaAServicio(LineaServicio linea, int mesa) {
        Servicio s = GestoraMesas.getInstance().obtenerMesaPorNumero(mesa).getServicio();
        LineaServicio ls = s.getLineaProducto(linea.getProducto().getCodigo());
        if (ls != null) {
            int diff = ls.getCantidad() - linea.getCantidad();
            if (diff < 0 && linea.getProducto().getStock() < Math.abs(diff)) {
                return false;
            }
            linea.getProducto().cambiarStock(diff);
            ls.setCantidad(linea.getCantidad());
            return true;
        }
        linea.getProducto().cambiarStock(-linea.getCantidad());
        s.addLinea(linea);
        return true;
    }
}
