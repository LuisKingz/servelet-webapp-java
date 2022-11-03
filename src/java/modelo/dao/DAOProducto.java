package modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.bean.Categoria;
import modelo.bean.Producto;
import utilerias.Conexion;

public class DAOProducto {
    Connection c;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    
    public List<Producto> consultarProductos(){
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto "
                + "JOIN categoria ON producto.categoria_id = categoria.id;";
        
        try {
            c = Conexion.obtenerConexion();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt("producto.id"));
                p.setNombre(rs.getString("producto.nombre"));
                p.setDescripcion(rs.getString("producto.descripcion"));
                p.setCantidad(rs.getInt("producto.cantidad"));
                p.setPrecio(rs.getDouble("producto.precio"));
                
                Categoria cate = new Categoria();
                cate.setId(rs.getInt("categoria.id"));
                cate.setDescripcion(rs.getString("categoria.descripcion"));
                
                p.setCategoria(cate);
                
                lista.add(p);
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

    public boolean agregarProducto(Producto producto) {
        boolean respuesta = false;
        String sql = "INSERT INTO producto(nombre, descripcion, cantidad, precio, categoria_id) "
                + "VALUES (?,?,?,?,?)";
        try {
            c = Conexion.obtenerConexion();
            ps = c.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getCantidad());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getCategoria().getId());
            
            respuesta = ps.executeUpdate() == 1;
            
            ps.close();
            c.close();
            
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        
        return respuesta;
    }

    public void obtenerInformacionProducto(Producto p) {
        String sql = "SELECT * FROM producto WHERE id = ?;";
        
        try {
            c = Conexion.obtenerConexion();
            ps = c.prepareStatement(sql);
            ps.setInt(1, p.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCategoria(new Categoria(rs.getInt("categoria_id")));
            }
            
        } catch (SQLException e) {            
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String modificarProducto(Producto p) {
        String respuesta = "";
        String sql = "CALL actualizarProducto(?,?,?,?,?,?,?);";
        try{
            c = Conexion.obtenerConexion();
            cs = c.prepareCall(sql);
            cs.setString(1, p.getNombre());
            cs.setString(2, p.getDescripcion());
            cs.setInt(3, p.getCantidad());
            cs.setDouble(4, p.getPrecio());
            cs.setInt(5, p.getCategoria().getId());
            cs.setInt(6, p.getId());
            
            cs.registerOutParameter(7, Types.VARCHAR);
            
            cs.execute();
            
            respuesta = cs.getString(7);
            
            cs.close();
            c.close();
            
        }catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        
        return respuesta;
    }


}
