package entidades;

/**
 *
 * @author Ignacio, Juan
 */
public class DeLaCasa implements TipoCliente {

    @Override
    public float descuento(Servicio s) {
        return s.calcularTotal()-500 < 0 ? 0 : s.calcularTotal() -500;
    }
}
