package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class Comunes implements TipoCliente, Serializable {

    @Override
    public float descuento(Servicio s) {
        float totalAgua = 0;
        for(LineaServicio lp : s.getLineas()){
           if(lp.getProducto().getNombre() == "Café"){
               totalAgua+= lp.getProducto().getPrecioUnitario();
           }
        }
        return s.calcularTotal()-totalAgua;
    }
    
    @Override
    public String toString() {
        return "Común";
    }
}
