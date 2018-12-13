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
    private Mesa mesa;

    public Servicio() {
        this.cliente = null;
        this.colLineas = new ArrayList<>();
    }

    public Mesa getMesa() {
        return mesa;
    }

<<<<<<< HEAD
    public void setM(Mesa mesa) {
        this.mesa = mesa;
    }

=======
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ArrayList<LineaServicio> getColLineas() {
        return colLineas;
    }

    public void setColLineas(ArrayList<LineaServicio> colLineas) {
        this.colLineas = colLineas;
    }
    
    

>>>>>>> ae3f7b77f91987f3889f349b08c3d595d23480af
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
        if (this.cliente != null) {
            return this.getCliente().getTipo().descuento(this);
        }
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
}
