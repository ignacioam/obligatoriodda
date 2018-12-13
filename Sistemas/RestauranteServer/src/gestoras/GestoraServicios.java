package gestoras;

import entidades.EstadoLinea;
import entidades.Gestor;
import entidades.LineaServicio;
<<<<<<< HEAD
import entidades.Mesa;
import entidades.Producto;
=======
>>>>>>> ae3f7b77f91987f3889f349b08c3d595d23480af
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
        LineaServicio ls = s.getLineaProducto(linea.getProducto().getNombre());
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
        linea.getProducto().getUpp().addPedido(linea);
        return true;
    }

    public Servicio getServicioPorNumero(int num) {
        for (Servicio s : colServicios) {
            if (s.getNumero() == num) {
                return s;
            }
        }
        return null;
    }

    public boolean tomarLinea(Servicio s, Producto p, Gestor g) {
        LineaServicio ls = s.getLineaProducto(p.getNombre());
        if (ls != null && ls.getEstado() == EstadoLinea.PENDIENTE) {
            ls.setGestor(g);
            ls.setEstado(EstadoLinea.EN_PROCESO);
            g.addLinea(ls);
            return true;
        }
        return false;
    }

    public boolean finalizarLinea(Servicio s, Producto p) {
        LineaServicio ls = s.getLineaProducto(p.getNombre());
        if (ls != null && ls.getEstado() == EstadoLinea.EN_PROCESO) {
            ls.setEstado(EstadoLinea.FINALIZADA);
            return true;
        }
        return false;
    }

    public void lineaEmitida(int numServicio, String nomProd) {
        Servicio s = getServicioPorNumero(numServicio);
        if (s != null) {
            LineaServicio ls = s.getLineaProducto(nomProd);
            if (ls != null) {
                ls.setEmitida(true);
            }
        }
    }

    public ArrayList<LineaServicio> getLineasDeMozo(String username) {
        ArrayList<LineaServicio> lineas = new ArrayList<>();
        for (Servicio s : colServicios) {
            for (LineaServicio linea : s.getLineas()) {
                if (linea.getServicio().getMesa().getMozo().getUsername().equals(username)) {
                    lineas.add(linea);
                }
            }
        }
        return lineas;
    }
}
