/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestores.controllers.gestor;

import entidades.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Juanchi Pérez
 */
public interface UIGestor {
    void mostrarMensaje(String msg, String titulo, int opt);
    
    void listarPedidos(ArrayList<Pedido> col);
    
    Pedido getPedidoTomar();
    
    Pedido getPedidoFinalizar();

    public void listarMisPedidos(ArrayList<Pedido> lista);
}
