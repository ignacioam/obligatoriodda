package gestoras;

import entidades.Producto;
import entidades.UnidadProcesadora;
import java.util.ArrayList;

/**
 *
 * @author Ignacio, Juan
 */
public class GestoraProductos {

    private ArrayList<Producto> colProductos;

    private GestoraProductos() {
        colProductos = new ArrayList<>();
        preCargarProductos();
    }

    /**
     * Singleton
     */
    private static GestoraProductos instance;

    public static GestoraProductos getInstance() {
        if (null == instance) {
            instance = new GestoraProductos();
        }
        return instance;
    }
    
    public ArrayList<Producto> getAllProductosConStock(){
        ArrayList<Producto> col = new ArrayList<>();
        
        for(Producto p : colProductos){
            if(p.getStock() > 0){
                col.add(p);
            }
        }
        return col;
    }
    
    public void preCargarProductos(){
        UnidadProcesadora bar = new UnidadProcesadora("Bar");
        UnidadProcesadora cocina = new UnidadProcesadora("Cocina");
        
        colProductos.add(new Producto(1, "Hamburguesa comun", 110, 10, cocina));
        colProductos.add(new Producto(2, "Hamburguesa completa", 150, 4, cocina));
        colProductos.add(new Producto(3, "Hamburguesa doble carne", 180, 0, cocina));
        colProductos.add(new Producto(4, "Hamburguesa con fritas", 220, 8, cocina));
        
        colProductos.add(new Producto(5, "Pizza comun", 150, 8, cocina));
        colProductos.add(new Producto(6, "Pizza con panceta", 190, 11, cocina));
        colProductos.add(new Producto(7, "Pizza con anana", 180, 100, cocina));
        colProductos.add(new Producto(8, "Pizza con mortadela", 220, 2, cocina));
        
        colProductos.add(new Producto(9, "Ensalada de tomate a la vinagreta", 90, 20, cocina));
        colProductos.add(new Producto(10, "Ensalada de trigos", 110, 6, cocina));
        
        colProductos.add(new Producto(11, "Pepsi 1L", 100, 20, bar));
        colProductos.add(new Producto(12, "Coca Cola 1L", 99, 20, bar));
        colProductos.add(new Producto(11, "Pilsen", 120, 30, bar));
        colProductos.add(new Producto(12, "Patricia", 130, 30, bar));
        colProductos.add(new Producto(11, "Miller", 120, 20, bar));
        colProductos.add(new Producto(12, "Pomelo", 80, 0, bar));
    }

    public Producto obtenerProductoPorNumero(int producto) {
        for (Producto p : colProductos) {
            if(p.getCodigo() == producto){
                return p;
            }
        }
        return null;
    }
}
