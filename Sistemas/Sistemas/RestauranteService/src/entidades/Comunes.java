package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class Comunes implements TipoCliente, Serializable {

    @Override
    public float descuento(Servicio s) {
        float totalCafe = 0;
        for (LineaServicio lp : s.getLineas()) {
            if ("Café".equals(lp.getProducto().getNombre())) {
                totalCafe += lp.getProducto().getPrecioUnitario() * lp.getCantidad();
                break;
            }
        }
        return totalCafe;
    }

    @Override
    public String toString() {
        return "Común";
    }
}
