package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class LineaServicio implements Serializable{

    private Producto producto;
    private int cantidad;

    public LineaServicio(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return 1;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "PRODUCTO: " + producto.getNombre() + "\t|\t CANTIDAD: " + cantidad + "\t|\t PRECIO U: $" + getProducto().getPrecioUnitario() +"\t|\t SUB TOTAL: $" + getSubTotal();
    }
    
    public float getSubTotal(){
        return producto.getPrecioUnitario() * cantidad;
    }
    
    
}
