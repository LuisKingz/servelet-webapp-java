package controlador;

import java.sql.SQLException;
import java.util.List;
import modelo.bean.Producto;
import modelo.dao.DAOProducto;

public class ControladorProducto {
    DAOProducto dao = new DAOProducto();
    
    public List<Producto> consultarProductos(){
        return dao.consultarProductos();
    }

    public boolean agregarProducto(Producto producto) {
        return dao.agregarProducto(producto);
    }

    public void obtenerInformacionProducto(Producto p) {
        dao.obtenerInformacionProducto(p);
    }

    public String modificarProducto(Producto p) {
        return dao.modificarProducto(p);
    }
}
