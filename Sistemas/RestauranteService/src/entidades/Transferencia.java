package entidades;

import java.io.Serializable;

/**
 *
 * @author juanc
 */
public class Transferencia implements Serializable {

    private int numero;
    private Estado estado;
    private boolean emitida;
    private Mesa mesa;
    private Mozo mozoDestino;
    private Mozo mozoOrigen;

    public Transferencia(Mesa mesa, Mozo mozoDestino, Mozo mozoOrigen) {
        this.estado = Estado.PENDIENTE;
        this.mesa = mesa;
        this.mozoDestino = mozoDestino;
        this.mozoOrigen = mozoOrigen;
        this.emitida = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Mozo getMozoDestino() {
        return mozoDestino;
    }

    public Mozo getMozoOrigen() {
        return mozoOrigen;
    }

    public void aceptar() {
        this.estado = Estado.ACEPTADA;
    }

    public void rechazar() {
        this.estado = Estado.RECHAZADA;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isEmitida() {
        return emitida;
    }

    public void setEmitida(boolean emitida) {
        this.emitida = emitida;
    }
    
    
}
