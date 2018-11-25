package dominio.entidades;

/**
 *
 * @author Ignacio, Juan
 */
public class Producto {
    private int codigo;
    private String nombre;
    private String precioUnitario;
    private int stock;
    private UnidadProcesadora upp;

    public Producto(int codigo, String nombre, String precioUnitario, int stock, UnidadProcesadora upp) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.upp = upp;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
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
}
