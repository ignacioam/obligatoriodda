package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class DeLaCasa implements TipoCliente, Serializable {

    @Override
    public float descuento(Servicio s) {
        float precio = s.calcularSubTotal();
        return (((precio - 500) < 0) ? precio : 500);
    }

    @Override
    public String toString() {
        return "De la casa";
    }
}
