/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmozos;

import restauranteserver.IServer;

/**
 *
 * @author Juanchi Perez
 */
public class Sistema {

    private static IServer stub;

    private Sistema() {

    }

    public static IServer getService() {
        return stub;
    }

    public static void setService(IServer stub1) {
        stub = stub1;
    }
}
