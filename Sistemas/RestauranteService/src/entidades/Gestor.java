package entidades;

import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan Pérez
 */
public class Gestor extends Usuario {

    private ArrayList<LineaServicio> lineasTomadas;
    
    public Gestor(String usuario, String contrasenia, String nombre) {
        super(usuario, contrasenia, nombre);
        this.lineasTomadas = new ArrayList<>();
    }
    
    public ArrayList<LineaServicio> getLineas(){
        return lineasTomadas;
    }
    
    public void addLinea(LineaServicio ls){
        lineasTomadas.add(ls);
    }

}
