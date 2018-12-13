package entidades;

/**
 *
 * @author Juan, Ignacio
 */
public class Pedido {

    private LineaServicio ls;

    public Pedido(LineaServicio ls) {
        this.ls = ls;
    }

    public LineaServicio getLinea() {
        return ls;
    }

    @Override
    public String toString() {
        Pedido pe = this;
        return "Artículo: " + ls.getProducto().getNombre() + " - Cantidad:" + ls.getCantidad() + " Descripción: " + ls.getDescripcion()
                + " Mesa: " + ls.getServicio().getMesa().getNumero() + " Mozo: " + ls.getServicio().getMesa().getMozo().getNombre();
    }

}
