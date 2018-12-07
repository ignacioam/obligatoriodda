package entidades;

/**
 *
 * @author Ignacio, Juan
 */
public class Comunes implements TipoCliente {

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
}
