/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionmozo.controllers.servicio;

import entidades.Cliente;
import entidades.Producto;

/**
 *
 * @author Ignacio
 */
public interface UIServicio {
    int getCantidad();
    Producto getProducto();
    Cliente getCliente();
}
