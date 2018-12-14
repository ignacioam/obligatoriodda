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
    private Mesa mesa;
    private ArrayList<LineaServicio> colLineas;

    public Servicio() {
        this.cliente = null;
        this.colLineas = new ArrayList<>();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ArrayList<LineaServicio> getColLineas() {
        return colLineas;
    }

    public void setColLineas(ArrayList<LineaServicio> colLineas) {
        this.colLineas = colLineas;
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
        linea.setServicio(this);
        this.colLineas.add(linea);
    }

    public float calcularTotal() {
        float precio = calcularSubTotal();
        if (this.cliente != null) {
            float dto = this.cliente.getTipo().descuento(this);
            return precio - dto;
        }
        return precio;
    }

    public float calcularSubTotal() {
        float precio = 0;
        for (LineaServicio ls : colLineas) {
            precio += ls.getPrecio();
        }
        return precio;
    }

    public LineaServicio getLineaProducto(String producto) {
        for (LineaServicio ls : colLineas) {
            if (ls.getProducto().getNombre().equals(producto)) {
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

    public boolean tieneLineasPendientes() {
        for (LineaServicio ls : colLineas) {
            if (ls.getEstado() != EstadoLinea.FINALIZADA) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "N SERVICIO: " + numero + " CLIENTE: " + ((cliente == null) ? "Sin cliente" : cliente.getDocumento() + " - " + cliente.getNombre()) + " N MESA: " + mesa.getNumero() + " TOTAL: " + this.calcularTotal();
    }

}
