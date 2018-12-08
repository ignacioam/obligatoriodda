package aplicacionmozo.controllers.servicio;

import entidades.Cliente;
import entidades.LineaServicio;
import entidades.Mesa;
import entidades.Producto;
import servicio.IService;

/**
 *
 * @author Ignacio, Juan
 */
public class ServicioController{
    IService server;
    UIServicio ui;
    Mesa mesa;
    
    public ServicioController(IService server, UIServicio ui, Mesa m){
        this.server = server;
        this.ui = ui;
        this.mesa = m;
    }
    
    public void agregarLineaServicio(){
        Producto p = ui.getProducto();
        int cantidad = ui.getCantidad();
                
        server.agregarLineaServicio(new LineaServicio(p, cantidad), mesa);
    }
    
}
