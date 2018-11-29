/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmozos;

import Servicio.IServer;
import dominio.entidades.Mozo;

/**
 *
 * @author Juanchi Perez
 */
public class Sistema {

    private static IServer stub;
    private static Mozo mozo;

    private Sistema() {

    }

    public static Mozo getMozo() {
        return mozo;
    }

    public static void setMozo(Mozo mozo) {
        Sistema.mozo = mozo;
    }   
    
    public static IServer getService() {
        return stub;
    }

    public static void setService(IServer stub1) {
        stub = stub1;
    }
}
