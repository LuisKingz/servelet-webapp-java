<%@page import="java.util.List"%>
<%@page import="modelo.bean.Categoria"%>
<% String context = request.getContextPath(); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=context%>/css/bootstrap.min.css" />
        <title>Agregar un producto</title>
    </head>
    <body>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-3">
                    <legend>Agregar un producto</legend>
                    <form action="<%=context%>/ServletAgregarProducto" method="POST">
                        <div class="form-group">
                            <label>Nombre: </label>
                            <input type="text" class="form-control" required="" name="nombre" />
                        </div>
                        <div class="form-group">
                            <label>Descripción: </label>
                            <textarea required="" class="form-control" name="descripcion"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Cantidad: </label>
                            <input type="number" class="form-control" required="" name="cantidad"/>
                        </div>
                        <div class="form-group">
                            <label>Precio </label>
                            <input type="number" class="form-control" required="" name="precio"/>
                        </div>
                        <div class="form-group">
                            <label>Categoria: </label>
                            <select required="" class="form-control" name="categoria">
                                <option value="">Seleccione una opción</option>
                                <%List<Categoria> lista = (List<Categoria>) request.getAttribute("lista"); %>
                                <%for(Categoria cate : lista){%>
                                <option value="<%=cate.getId() %>"><%=cate.getDescripcion() %></option>
                                <%}%>
                            </select>
                        </div>
                        <a class="btn btn-light" href="<%=context%>/index.jsp">Cancelar</a>
                        <button type="submit" class="btn btn-info">Agregar</button>
                    </form>
                        <br><br>
                </div>
            </div>
        </div>
        
        
        <script src="<%=context%>/js/jquery-3.3.1.min.js"></script>
        <script src="<%=context%>/js/popper.min.js"></script>
        <script src="<%=context%>/js/bootstrap.min.js"></script>
    </body>
</html>
