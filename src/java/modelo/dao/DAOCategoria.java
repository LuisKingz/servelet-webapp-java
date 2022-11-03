package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.bean.Categoria;
import utilerias.Conexion;

public class DAOCategoria {
    Connection c;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Categoria> consultarCategorias(){
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria;";
        try {
            c = Conexion.obtenerConexion();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDescripcion(rs.getString("descripcion"));                
                lista.add(categoria);
            }
            
            rs.close();
            ps.close();
            c.close();
            
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        
        return lista;
    }
}
