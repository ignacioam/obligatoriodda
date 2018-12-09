package gestoras;

import entidades.Cliente;
import entidades.Comunes;
import entidades.DeLaCasa;
import entidades.Preferenciales;
import java.util.ArrayList;

/**
 *
 * @author Juan, Ignacio
 */
public class GestoraClientes {
    private ArrayList<Cliente> colClientes;
    
    private GestoraClientes() {
        this.colClientes = new ArrayList<>();
        preCargarClientes();
    }
    //Singleton
    private static GestoraClientes instance;
    public static GestoraClientes getInstance() {
        if (null == instance) {
            instance = new GestoraClientes();
        }
        return instance;
    }
    
    public void preCargarClientes(){
        colClientes.add(new Cliente(1, "Jorge Baldassini", "jbalda@gmail.com", new DeLaCasa()));
        colClientes.add(new Cliente(2, "Federico Anton", "fede@gmail.com", new DeLaCasa()));
        colClientes.add(new Cliente(3, "Sirley Olivera", "sirley@gmail.com", new Preferenciales()));
        colClientes.add(new Cliente(4, "Juan Martins", "jmartins@gmail.com", new Preferenciales()));
        colClientes.add(new Cliente(5, "Ruben Espino", "rubencito@gmail.com", new Comunes()));
        colClientes.add(new Cliente(6, "Rodrigo Silveria", "rodri@gmail.com", new Comunes()));
        colClientes.add(new Cliente(7, "Abril Carballal", "abi@gmail.com", new Comunes()));
        colClientes.add(new Cliente(8, "Rodolgo Lenovo", "lrodolfo@gmail.com", new Comunes()));
        colClientes.add(new Cliente(9, "Bill Gates", "billi@gmail.com", new Preferenciales()));
        colClientes.add(new Cliente(10, "Diego Hernandez", "herna@gmail.com", new Comunes()));
        colClientes.add(new Cliente(11, "Maria Perez", "mperez@gmail.com", new Comunes()));
        colClientes.add(new Cliente(12, "Ayelen Rodriguez", "aye@gmail.com", new Comunes()));
        colClientes.add(new Cliente(13, "Florencia Marquez", "fmarquez@gmail.com", new Comunes()));
        colClientes.add(new Cliente(14, "Noemi de los santos", "noemi@gmail.com", new Comunes()));
        colClientes.add(new Cliente(15, "Pepe Nuñez", "nuñez@gmail.com", new Comunes()));
        colClientes.add(new Cliente(16, "Martina Daltina", "martinadaltina@gmail.com", new Comunes()));
        colClientes.add(new Cliente(17, "Mauricio Macri", "macri@gmail.com", new Preferenciales()));
        colClientes.add(new Cliente(18, "Steve Job", "sjob@gmail.com", new Preferenciales()));
    }
    
    public ArrayList<Cliente> getAllClientes(){
        return (ArrayList<Cliente>) colClientes.clone();
    }
}
