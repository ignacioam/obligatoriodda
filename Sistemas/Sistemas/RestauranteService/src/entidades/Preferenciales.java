/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Preferenciales implements TipoCliente, Serializable {

    @Override
    public float descuento(Servicio s) {
        float dtoAgua = descuentoPorAgua(s.getLineas());
        float total = s.calcularSubTotal() - dtoAgua;
        if (total > 2000) {
            return (total * 0.05f);
        }
        return dtoAgua;
    }

    private float descuentoPorAgua(ArrayList<LineaServicio> ls) {
        float totalAgua = 0;
        for (LineaServicio lp : ls) {
            if ("Agua Mineral".equals(lp.getProducto().getNombre())) {
                totalAgua += lp.getProducto().getPrecioUnitario() * lp.getCantidad();
                break;
            }
        }
        return totalAgua;
    }

    @Override
    public String toString() {
        return "Preferencial";
    }

}
