package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class DeLaCasa implements TipoCliente, Serializable{

    @Override
    public float descuento(Servicio s) {
        return s.calcularTotal()-500 < 0 ? 0 : s.calcularTotal() -500;
    }
    
    @Override
    public String toString() {
        return "De la casa";
    }
}
