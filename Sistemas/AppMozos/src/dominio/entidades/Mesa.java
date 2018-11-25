package dominio.entidades;

/**
 *
 * @author Ignacio, Juan
 */
public class Mesa {

    private int numero;
    private Mozo mozo;
    private boolean abierto;

    public Mesa(int numero, Mozo mozo, boolean abierto) {
        this.numero = numero;
        this.mozo = mozo;
        this.abierto = abierto;
    }

    public int getNumero() {
        return this.numero;
    }

    public Mozo getMozo() {
        return this.mozo;
    }

    public boolean getAbierto() {
        return this.abierto;
    }

}
