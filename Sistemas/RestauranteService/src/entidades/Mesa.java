package entidades;

/**
 *
 * @author Ignacio, Juan
 */
public class Mesa {

    private int numero;
    private Mozo mozo;
    private boolean abierta;

    public Mesa(int numero, Mozo mozo) {
        this.numero = numero;
        this.mozo = mozo;
        this.abierta = false;
    }
    
    public Mesa(int numero, boolean abierto) {
        this.numero = numero;
        this.abierta = abierto;
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

}
