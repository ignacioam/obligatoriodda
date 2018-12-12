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
    private int max = 31;
    private int segundos;

    public ThreadSimple(int numTransferencia) {
        this.numTransferencia = numTransferencia;
        segundos = 0;
    }

    public void iniciar() {
        miThread = new Thread(this);
        miThread.start();
    }

    @Override
    public void run() {
        while (segundos < max) {
            segundos++;
            try {
                miThread.sleep(1000);
            } catch (InterruptedException exc) {
            };
        }
        if (GestoraTransferencias.getInstance().getTransferenciaPorNumero(numTransferencia).getEstado() == Estado.PENDIENTE) {
            GestoraTransferencias.getInstance().transferirMesa(false, numTransferencia);
            Server.getInstance().notificarObserver(Evento.MESA_TRANSFERIDA);
        }
    }
}
