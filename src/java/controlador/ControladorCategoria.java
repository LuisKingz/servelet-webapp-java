package controlador;

import java.util.List;
import modelo.bean.Categoria;
import modelo.dao.DAOCategoria;

public class ControladorCategoria {
    DAOCategoria dao = new DAOCategoria();
    
    public List<Categoria> consultarCategoria(){
        return dao.consultarCategorias();
    }
}
