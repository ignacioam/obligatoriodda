package aplicacionmozo.controllers.servicio;

import entidades.Cliente;
import entidades.Mesa;
import entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public interface UIServicio {

    int getCantidad();

    Producto getProducto();

    Cliente getCliente();

    String getDescripcion();

    void listarClientes(ArrayList<Cliente> c);

    void listarProdcutos(ArrayList<Producto> p);

    void mostrarMensaje(String msg);

    void listarPedido(Mesa mesa);

    void cerrarForm();
}
