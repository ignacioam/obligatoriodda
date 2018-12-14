package entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class UnidadProcesadora implements Serializable {

    private ArrayList<LineaServicio> colPedidos;
    private String nombre;

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
        this.colPedidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public void addPedido(LineaServicio l){
        colPedidos.add(l);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<LineaServicio> getPedidos() {
        return colPedidos;
    }

}
