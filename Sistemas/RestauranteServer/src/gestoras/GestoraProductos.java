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

    public ArrayList<Producto> getAllProductosConStock() {
        ArrayList<Producto> col = new ArrayList<>();

        for (Producto p : colProductos) {
            if (p.getStock() > 0) {
                col.add(p);
            }
        }
        return col;
    }

    public void preCargarProductos() {
        UnidadProcesadora bar = GestoraUnidadProcesadora.getInstance().getUnidadProcesadora("Bar");
        UnidadProcesadora cocina = GestoraUnidadProcesadora.getInstance().getUnidadProcesadora("Cocina");

        colProductos.add(new Producto("Hamburguesa comun", 110, 10, cocina));
        colProductos.add(new Producto("Hamburguesa completa", 150, 4, cocina));
        colProductos.add(new Producto("Hamburguesa doble carne", 180, 0, cocina));
        colProductos.add(new Producto("Hamburguesa con fritas", 220, 8, cocina));

        colProductos.add(new Producto("Pizza comun", 150, 8, cocina));
        colProductos.add(new Producto("Pizza con panceta", 190, 11, cocina));
        colProductos.add(new Producto("Pizza con anana", 180, 100, cocina));
        colProductos.add(new Producto("Pizza con mortadela", 220, 2, cocina));

        colProductos.add(new Producto("Ensalada de tomate a la vinagreta", 90, 20, cocina));
        colProductos.add(new Producto("Ensalada de trigos", 110, 6, cocina));

        colProductos.add(new Producto("Pepsi 1L", 100, 20, bar));
        colProductos.add(new Producto("Coca Cola 1L", 99, 20, bar));
        colProductos.add(new Producto("Pilsen", 120, 30, bar));
        colProductos.add(new Producto("Patricia", 130, 30, bar));
        colProductos.add(new Producto("Miller", 120, 20, bar));
        colProductos.add(new Producto("Pomelo", 80, 0, bar));
    }

    public Producto getProductoPorNombre(String producto) {
        for (Producto p : colProductos) {
            if (p.getNombre().equals(producto)) {
                return p;
            }
        }
        return null;
    }
}
