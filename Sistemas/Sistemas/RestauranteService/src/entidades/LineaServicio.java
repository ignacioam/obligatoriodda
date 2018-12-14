package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class LineaServicio implements Serializable {

    private Producto producto;
    private int cantidad;
    private String descripcion;
    private Servicio servicio;
    private EstadoLinea estado;
    private Gestor gestor;
    private boolean emitida;

    public LineaServicio(Producto producto, int cantidad, String descripcion) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.estado = EstadoLinea.PENDIENTE;
        this.gestor = null;
        this.emitida = false;
    }

    public EstadoLinea getEstado() {
        return estado;
    }

    public void setEstado(EstadoLinea estado) {
        this.estado = estado;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public float getPrecio() {
        return producto.getPrecioUnitario() * cantidad;
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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "PRODUCTO: " + producto.getNombre() + "\t|\t CANTIDAD: " + cantidad + "\t|\t PRECIO U: $" + getProducto().getPrecioUnitario() + "\t|\t SUB TOTAL: $" + getSubTotal();
    }

    public float getSubTotal() {
        return producto.getPrecioUnitario() * cantidad;
    }

    public boolean isEmitida() {
        return emitida;
    }

    public void setEmitida(boolean emitida) {
        this.emitida = emitida;
    }

}
