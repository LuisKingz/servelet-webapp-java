package utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion {
    private static String direccion;
    private static String nombreBD;
    private static String usuario;
    private static String contrasena;
    private static String puerto;
    private static ResourceBundle propiedadesConexion;
    
    public static Connection obtenerConexion() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Librería no encontrada" + e.getMessage());
        }
        
        if(propiedadesConexion == null){
            propiedadesConexion = ResourceBundle.getBundle("propiedades");
            direccion = propiedadesConexion.getString("direccion");
            nombreBD = propiedadesConexion.getString("nombre_bd");
            usuario = propiedadesConexion.getString("usuario");
            contrasena = propiedadesConexion.getString("contrasena");
            puerto = propiedadesConexion.getString("puerto");
        }
        
        //String url = "jdbc:sqlserver://"+direccion+":"+puerto+";databaseName="+nombreBD + ";integratedSecurity=false";
        String url = "jdbc:mysql://" + direccion + ":" + puerto + "/" + nombreBD;
        return DriverManager.getConnection(url, usuario, contrasena);
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Connection con = obtenerConexion();
        System.out.println("Conexión exitosa: " + con);
        con.close();
    }
    
}
