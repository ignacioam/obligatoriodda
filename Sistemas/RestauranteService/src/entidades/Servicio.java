package entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class Servicio implements Serializable {

    private int numero;
    private Cliente cliente;
    private ArrayList<LineaServicio> colLineas;

    public Servicio() {
        this.cliente = null;
        this.colLineas = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaServicio> getLineas() {
        return colLineas;
    }

    public void addLinea(LineaServicio linea) {
        this.colLineas.add(linea);
    }

    public float calcularTotal() {
        if (this.cliente != null) {
            return this.getCliente().getTipo().descuento(this);
        }
        float precio = 0;
        for (LineaServicio ls : colLineas) {
            precio += ls.getPrecio();
        }
        return precio;
    }

    public LineaServicio getLineaProducto(int producto) {
        for (LineaServicio ls : colLineas) {
            if (ls.getProducto().getCodigo() == producto) {
                return ls;
            }
        }
        return null;
    }

    public void setNumero(int i) {
        this.numero = i;
    }

    public int getNumero() {
        return this.numero;
    }
}
