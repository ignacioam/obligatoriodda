/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Preferenciales implements TipoCliente {

    @Override
    public float descuento(Servicio s) {
        float total = s.calcularTotal() - descuentoPorAgua(s.getLineas());
        if(total > 2000){
            return total-(total*0.05f);
        }
        return total;
    }
    
    private float descuentoPorAgua(ArrayList<LineaServicio> ls){
        float totalAgua = 0;
        for(LineaServicio lp : ls){
           if(lp.getProducto().getNombre() == "Agua Mineral"){
               totalAgua+= lp.getProducto().getPrecioUnitario();
           }
        }
        return totalAgua;       
    }

}
