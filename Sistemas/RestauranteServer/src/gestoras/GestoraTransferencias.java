package gestoras;

import entidades.Estado;
import entidades.Mesa;
import entidades.Transferencia;
import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class GestoraTransferencias {

    private ArrayList<Transferencia> colTransferencias;

    //Singleton
    private GestoraTransferencias() {
        this.colTransferencias = new ArrayList<>();
    }

    private static GestoraTransferencias instance;

    public static GestoraTransferencias getInstance() {
        if (null == instance) {
            instance = new GestoraTransferencias();
        }
        return instance;
    }

    public void addTransferencia(Transferencia t) {
        t.setNumero(colTransferencias.size() + 1);
        colTransferencias.add(t);
    }

    public ArrayList<Transferencia> obtenerTransferenciasPendientesDeMozo(String username) {
        ArrayList<Transferencia> aux = new ArrayList<>();
        for (Transferencia t : colTransferencias) {
            if (t.getEstado() == Estado.PENDIENTE && t.getMozoDestino().getUsername().equals(username)) {
                aux.add(t);
            }
        }
        return aux;
    }

    public void transferirMesa(boolean aceptada, int numTransferencia) {
        Transferencia t = getTransferenciaPorNumero(numTransferencia);
        if (t != null) {
            if (aceptada) {
                t.aceptar();
                Mesa m = GestoraMesas.getInstance().obtenerMesaPorNumero(t.getMesa().getNumero());
                t.getMozoDestino().addMesa(m);
                m.setMozo(t.getMozoDestino());
                t.getMozoOrigen().removeMesa(m.getNumero());
            } else {
                t.rechazar();
            }
        }
    }

    public Transferencia getTransferenciaPorNumero(int numTransferencia) {
        for (Transferencia t : colTransferencias) {
            if (t.getNumero() == numTransferencia) {
                return t;
            }
        }
        return null;
    }
}
