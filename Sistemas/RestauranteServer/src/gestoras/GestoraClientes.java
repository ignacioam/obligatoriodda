package gestoras;

import entidades.Cliente;
import entidades.Comunes;
import entidades.DeLaCasa;
import entidades.Preferenciales;
import java.util.ArrayList;
import restauranteserver.conexiondb;

/**
 *
 * @author Juan, Ignacio
 */
public class GestoraClientes {
    private ArrayList<Cliente> colClientes;
    
    private GestoraClientes() {
        this.colClientes = new ArrayList<>();
        preCargarClientes();
        conexiondb conn = new conexiondb();
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
        colClientes.add(new Cliente("43932982", "Jorge Baldassini", "jbalda@gmail.com", new DeLaCasa()));
        colClientes.add(new Cliente("29483028", "Federico Anton", "fede@gmail.com", new DeLaCasa()));
        colClientes.add(new Cliente("32843382", "Sirley Olivera", "sirley@gmail.com", new Preferenciales()));
        colClientes.add(new Cliente("52394329", "Juan Martins", "jmartins@gmail.com", new Preferenciales()));
        colClientes.add(new Cliente("13943294", "Ruben Espino", "rubencito@gmail.com", new Comunes()));
        colClientes.add(new Cliente("39385592", "Rodrigo Silveria", "rodri@gmail.com", new Comunes()));
        colClientes.add(new Cliente("93209732", "Abril Carballal", "abi@gmail.com", new Comunes()));
        colClientes.add(new Cliente("42142187", "Rodolgo Lenovo", "lrodolfo@gmail.com", new Comunes()));
        colClientes.add(new Cliente("39485921", "Bill Gates", "billi@gmail.com", new Preferenciales()));
        colClientes.add(new Cliente("24959282", "Diego Hernandez", "herna@gmail.com", new Comunes()));
        colClientes.add(new Cliente("24322103", "Maria Perez", "mperez@gmail.com", new Comunes()));
        colClientes.add(new Cliente("15534212", "Ayelen Rodriguez", "aye@gmail.com", new Comunes()));
        colClientes.add(new Cliente("42341132", "Florencia Marquez", "fmarquez@gmail.com", new Comunes()));
        colClientes.add(new Cliente("43242115", "Noemi de los santos", "noemi@gmail.com", new Comunes()));
        colClientes.add(new Cliente("49272931", "Pepe Nuñez", "nuñez@gmail.com", new Comunes()));
        colClientes.add(new Cliente("25483821", "Martina Daltina", "martinadaltina@gmail.com", new Comunes()));
        colClientes.add(new Cliente("98573622", "Mauricio Macri", "macri@gmail.com", new Preferenciales()));
        colClientes.add(new Cliente("54507822", "Steve Job", "sjob@gmail.com", new Preferenciales()));
    }
    
    public ArrayList<Cliente> getAllClientes(){
        return (ArrayList<Cliente>) colClientes.clone();
    }

}
