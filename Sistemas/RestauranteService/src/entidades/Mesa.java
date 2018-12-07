package entidades;

import java.io.Serializable;

/**
 *
 * @author Ignacio, Juan
 */
public class Mesa implements Serializable {

    private static int numMesa = 0;
    private int numero;
    private Mozo mozo;
    private boolean abierta;
    private Servicio servicio;

    public Mesa(Mozo mozo) {
        this.numero = ++numMesa;
        this.mozo = mozo;
        this.abierta = false;
    }

    public int getNumero() {
        return this.numero;
    }

    public Mozo getMozo() {
        return this.mozo;
    }

    public boolean isAbierta() {
        return this.abierta;
    }

    @Override
    public String toString() {
        return "N° Mesa: " + numero + ", Mozo:" + mozo.getNombre() + ", Abierta: " + (abierta ? "Si" : "No");
    }

    public boolean abrir() {
        if (!this.abierta) {
            this.abierta = true;
            this.servicio = new Servicio();
            return true;
        }
        return false;
    }

    public boolean cerrar() {
        if (this.abierta) {
            this.abierta = false;
            this.servicio = null;
            return true;
        }
        return false;
    }
}
