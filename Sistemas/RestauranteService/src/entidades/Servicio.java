package entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class Servicio implements Serializable{

    private Cliente cliente;
    private ArrayList<LineaServicio> colLineas;

    public Servicio(){
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
        return this.getCliente().getTipo().descuento(this);
    }
}
