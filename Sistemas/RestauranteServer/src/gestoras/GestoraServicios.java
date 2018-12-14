package gestoras;

import entidades.Cliente;
import entidades.EstadoLinea;
import entidades.Gestor;
import entidades.LineaServicio;
import entidades.Mesa;
import entidades.Producto;

import entidades.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import restauranteserver.conexiondb;

/**
 *
 * @author Ignacio, Juan
 */
public class GestoraServicios {

    private ArrayList<Servicio> colServicios;

    private GestoraServicios() {
        colServicios = new ArrayList<>();
    }

    /**
     * Singleton
     */
    private static GestoraServicios instance;

    public static GestoraServicios getInstance() {
        if (null == instance) {
            instance = new GestoraServicios();
        }
        return instance;
    }

    public void addServicio(Servicio s) {
        s.setNumero(1 + colServicios.size());
        s.setMesa(s.getMesa());
        this.colServicios.add(s);
    }
    
    public void addServicioBd(Servicio s){
        conexiondb db = new conexiondb();
        Connection conn = null;
        
        PreparedStatement ps = null;
        PreparedStatement pslineas = null;
        
        String cliente = ((s.getCliente() == null) ? "Sin cliente" :  s.getCliente().getDocumento());
        
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            
            String query = "INSERT INTO servicios (id, cliente, mesa) VALUES(?,?,?)";
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, s.getNumero());
            ps.setString(2, cliente);
            ps.setInt(3, s.getMesa().getNumero());
            
            int rs = ps.executeUpdate();
            
            if(rs > 0){
                String queryLineas = "INSERT INTO lineas_servicios (servicio, producto, cantidad, descripcion) VALUES(?, ?, ?, ?)";
                pslineas = conn.prepareStatement(queryLineas);
                
                for(LineaServicio ls : s.getColLineas()){
                    pslineas.setInt(1, s.getNumero());
                    pslineas.setString(2, ls.getProducto().getNombre());
                    pslineas.setInt(3, ls.getCantidad());
                    pslineas.setString(4, ls.getDescripcion());
                    
                    pslineas.executeUpdate();
                }
                conn.commit();
            }else{
                conn.rollback();
            }
        } catch (SQLException ex) {
            // roll back the transaction
            try{
                if(conn != null)
                    conn.rollback();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(GestoraServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Servicio> obtenerServicios(){
        ArrayList<Servicio> col = new ArrayList<>();
        
        conexiondb  db = new conexiondb();
        Connection conn = null;
        
        PreparedStatement ps = null;
        PreparedStatement pslienas = null;
        
        try {
            conn = db.getConnection();
            String query = "SELECT * FROM servicios";
            
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Cliente c = GestoraClientes.getInstance().getClientePorDoc(rs.getString("cliente"));
                Mesa m = GestoraMesas.getInstance().obtenerMesaPorNumero(rs.getInt("mesa"));
                Servicio s = new Servicio();
                s.setCliente(c);
                s.setNumero(rs.getInt("id"));
                s.setMesa(m);
                
                
                
                String queryLineas = "SELECT * FROM lineas_servicios WHERE servicio = " + rs.getInt("id");
                pslienas = conn.prepareStatement(queryLineas);
                ResultSet rslineas = pslienas.executeQuery();
                
                while(rslineas.next()){
                    Producto p = GestoraProductos.getInstance().getProductoPorNombre(rslineas.getString("producto"));
                    LineaServicio linea = new LineaServicio(p, rslineas.getInt("cantidad"), rslineas.getString("descripcion"));
                    s.addLinea(linea);
                }
               
                col.add(s);
            }
            
            return col;
            
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException sq) {
            }
            
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sq) {
            }
        }
        return col;
    
    }
   
    public boolean addLineaAServicio(LineaServicio linea, int mesa) {
        
        Servicio s = GestoraMesas.getInstance().obtenerMesaPorNumero(mesa).getServicio();
        LineaServicio ls = s.getLineaProducto(linea.getProducto().getNombre());
        if (ls != null) {
            int diff = ls.getCantidad() - linea.getCantidad();
            if (diff < 0 && linea.getProducto().getStock() < Math.abs(diff)) {
                return false;
            }
            linea.getProducto().cambiarStock(diff);
            ls.setCantidad(linea.getCantidad());
            return true;
        }
        linea.getProducto().cambiarStock(-linea.getCantidad());
        s.addLinea(linea);
        linea.getProducto().getUpp().addPedido(linea);
        return true;
    }

    public Servicio getServicioPorNumero(int num) {
        for (Servicio s : colServicios) {
            if (s.getNumero() == num) {
                return s;
            }
        }
        return null;
    }

    public boolean tomarLinea(Servicio s, Producto p, Gestor g) {
        LineaServicio ls = s.getLineaProducto(p.getNombre());
        if (ls != null && ls.getEstado() == EstadoLinea.PENDIENTE) {
            ls.setGestor(g);
            ls.setEstado(EstadoLinea.EN_PROCESO);
            g.addLinea(ls);
            return true;
        }
        return false;
    }

    public boolean finalizarLinea(Servicio s, Producto p) {
        LineaServicio ls = s.getLineaProducto(p.getNombre());
        if (ls != null && ls.getEstado() == EstadoLinea.EN_PROCESO) {
            ls.setEstado(EstadoLinea.FINALIZADA);
            return true;
        }
        return false;
    }

    public void lineaEmitida(int numServicio, String nomProd) {
        Servicio s = getServicioPorNumero(numServicio);
        if (s != null) {
            LineaServicio ls = s.getLineaProducto(nomProd);
            if (ls != null) {
                ls.setEmitida(true);
            }
        }
    }

    public ArrayList<LineaServicio> getLineasDeMozo(String username) {
        ArrayList<LineaServicio> lineas = new ArrayList<>();
        for (Servicio s : colServicios) {
            for (LineaServicio linea : s.getLineas()) {
                if (linea.getServicio().getMesa().getMozo().getUsername().equals(username)) {
                    lineas.add(linea);
                }
            }
        }
        return lineas;
    }
}
