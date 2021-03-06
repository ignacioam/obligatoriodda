package aplicacionmozo.controllers.mozo;

import entidades.Mesa;
import entidades.Mozo;
import entidades.Transferencia;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Juan, Ignacio
 */
public interface UIMozo {

    void listarUsuarios(ArrayList<Mozo> colUsers);

    void listarMesas(Mesa[][] mesas);

    void listarMesasTransferencia(ArrayList<Mesa> mesas);

    Mesa getMesaTransferencia();

    Mozo getMozoTransferencia();

    boolean tranferenciaMesa(Transferencia t);

    void mostrarMensaje(String msg, Color color);
    
    void mostrarMensajePane(String msg, String titulo, int opt);
}
