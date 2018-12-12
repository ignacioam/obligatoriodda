package restauranteserver;

import entidades.Estado;
import gestoras.GestoraTransferencias;
import servicio.Evento;

/**
 *
 * @author Juan, Ignacio
 */
public class ThreadSimple implements Runnable {

    private Thread miThread = null;
    public int numTransferencia;

    public ThreadSimple(int numTransferencia) {
        this.numTransferencia = numTransferencia;
    }

    public void iniciar() {
        miThread = new Thread(this);
        miThread.start();
    }

    @Override
    public void run() {
        try {
            Server.getInstance().notificarObserver(Evento.INICIAR_TRANSFERENCIA);
            miThread.sleep(31000);
        } catch (InterruptedException exc) {
        };

        if (GestoraTransferencias.getInstance().getTransferenciaPorNumero(numTransferencia).getEstado() == Estado.PENDIENTE) {
            GestoraTransferencias.getInstance().transferirMesa(false, numTransferencia);
            Server.getInstance().notificarObserver(Evento.MESA_TRANSFERIDA);
        }
    }
}
