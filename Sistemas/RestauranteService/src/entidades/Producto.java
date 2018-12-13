package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class Producto implements Serializable {

    private String nombre;
    private float precioUnitario;
    private int stock;
    private UnidadProcesadora upp;

    public Producto(String nombre, float precioUnitario, int stock, UnidadProcesadora upp) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.upp = upp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public UnidadProcesadora getUpp() {
        return upp;
    }

    public void setUpp(UnidadProcesadora upp) {
        this.upp = upp;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precioUnitario + " - Stock:" + stock;
    }

    public void cambiarStock(int i) {
        this.stock += i;
    }

}
