package aplicacionmozo.controllers.servicio;

import aplicacionmozo.Sistema;
import entidades.Cliente;
import entidades.Mesa;
import entidades.Producto;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.IService;

/**
 *
 * @author Ignacio, Juan
 */
public class ServicioController {

    IService server;
    UIServicio ui;
    Mesa mesa;

    public ServicioController(IService server, UIServicio ui, Mesa m) {
        this.server = server;
        this.ui = ui;
        this.mesa = m;
    }

    public void agregarLineaServicio() {
        try {
            Producto p = ui.getProducto();
            int cant = ui.getCantidad();
            String descripcion = ui.getDescripcion();
            if (server.agregarLineaServicio(p.getNombre(), cant, descripcion, mesa.getNumero())) {
                mesa = server.getMesaPorNumero(mesa.getNumero());
                ui.listarPedido(mesa);
            } else {
                ui.mostrarMensaje("No hay stock suficiente");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obtenerClientes() {
        try {
            ui.listarClientes(server.getAllClientes());
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarProductos() {
        try {
            ui.listarProdcutos(server.getAllProductos());
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarMesa() {
        try {
            if (!server.cerrarMesa(mesa.getNumero())) {
                ui.mostrarMensaje("La mesa aún tiene pedidos pendientes");
            } else {
                ui.cerrarForm();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCliente(Cliente c) {
        try {
            server.setClienteServicio(mesa.getServicio().getNumero(), c.getDocumento());
            mesa = Sistema.getService().getMesaPorNumero(mesa.getNumero());
            ui.listarPedido(mesa);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
