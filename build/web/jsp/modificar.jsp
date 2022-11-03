<%@page import="java.util.List"%>
<%@page import="modelo.bean.Categoria"%>
<%@page import="modelo.bean.Producto"%>
<% String context = request.getContextPath(); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=context%>/css/bootstrap.min.css" />
        <title>Modificar un producto</title>
    </head>
    <body>
        <br>
        <div class="container">
            <div class="row">
                <%Producto p = (Producto)request.getAttribute("producto");%>
                <%List<Categoria> lista = (List<Categoria>) request.getAttribute("categorias"); %>
                <div class="col-lg-6 offset-3">
                    <legend>Modificar producto</legend>
                    <form action="<%=context%>/ServletModificarProducto" method="POST">
                        <input type="hidden" name="id" value="<%=p.getId()%>"/>
                        <div class="form-group">
                            <label>Nombre: </label>
                            <input type="text" class="form-control" required="" name="nombre" value="<%=p.getNombre() %>"/>
                        </div>
                        <div class="form-group">
                            <label>Descripción: </label>
                            <textarea required="" class="form-control" name="descripcion"><%=p.getDescripcion() %></textarea>
                        </div>
                        <div class="form-group">
                            <label>Cantidad: </label>
                            <input type="number" class="form-control" required="" name="cantidad" value="<%=p.getCantidad() %>"/>
                        </div>
                        <div class="form-group">
                            <label>Precio </label>
                            <input type="number" class="form-control" required="" name="precio" value="<%=p.getPrecio() %>"/>
                        </div>
                        <div class="form-group">
                            <label>Categoria: </label>
                            <select required="" class="form-control" name="categoria">
                                <option value="">Seleccione una opción</option>
                                <%for(Categoria cate : lista){%>
                                    <%if(p.getCategoria().getId() == cate.getId()){%>
                                    <option selected="selected" value="<%=cate.getId() %>"><%=cate.getDescripcion() %></option>
                                    <%}else{%>
                                        <option value="<%=cate.getId() %>"><%=cate.getDescripcion() %></option>
                                    <%}%>
                                <%}%>
                            </select>
                        </div>
                        <a class="btn btn-light" href="<%=context%>/index.jsp">Cancelar</a>
                        <button type="submit" class="btn btn-info">Modificar</button>
                    </form>
                </div>
            </div>
        </div>
        
        
        <script src="<%=context%>/js/jquery-3.3.1.min.js"></script>
        <script src="<%=context%>/js/popper.min.js"></script>
        <script src="<%=context%>/js/bootstrap.min.js"></script>
    </body>
</html>
