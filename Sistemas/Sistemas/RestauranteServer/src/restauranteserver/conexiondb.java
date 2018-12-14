package restauranteserver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ignacio
 */
public class conexiondb {
    static String ipBD;
    static String portBD;
    static String serviceBD;
    static String userBD;
    static String passwd;
    static String url;
    static boolean logConect=true;

    Connection conn=null;

    public conexiondb(){
        try {            
            ipBD = "localhost";
            serviceBD = "restaurantdb";
            userBD = "root";
            passwd = "";
            portBD = "3308";
            
            String hostname = java.net.InetAddress.getLocalHost().getHostName().trim();
            this.printSystem("hostname:"+hostname);

            url = "jdbc:mysql://"+ipBD+":"+portBD+"/"+serviceBD;
            this.printSystem("url = " + url);
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection (url, userBD, passwd);
           
            if (conn != null) {
                conn.setAutoCommit(false);
                this.printSystem("---> CONECTADO AL SERVIDOR: "+ipBD+ " BASE:"+serviceBD);
            } else {
                this.printSystem("---> NO! CONECTADO AL SERVIDOR: "+ipBD);
            }
            logConect=false;
        } catch(Exception e) {
            System.out.println("Error: "+e);
        }
    }

    public Connection getConnection() throws Exception{
        try {
            if(this.conn == null){
                Class.forName ("com.mysql.jdbc.Driver").newInstance ();
                conn = DriverManager.getConnection (url, userBD, passwd);

                if (conn != null) {
                    conn.setAutoCommit(false);
                }else{
                    throw (new Exception("null") );
                }
            }
        }
        catch (Exception e) {
            if(conn!=null){
                conn.rollback();
                conn.close();
            }
            throw(new Exception("Sin Conexion Base de Datos. ["+e.getMessage()+"]"));
        }
        return conn;
    }
    public void printSystem(String msj){
        if(logConect) System.out.println(msj);
    }
}
