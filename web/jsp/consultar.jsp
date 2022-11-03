<%@page import="java.util.List"%>
<%@page import="modelo.bean.Producto"%>
<% String context = request.getContextPath(); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=context%>/css/bootstrap.min.css" />
        <title>Consultar productos</title>
    </head>
    <body>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <legend>Listado de productos</legend>
                <%if(request.getAttribute("respuesta") != null){%>
                    <%if(request.getAttribute("respuesta").toString().equals("true")){%>
                    <div class="alert alert-success">Producto agregado correctamente</div>
                    <%}else{%>
                    <div class="alert alert-error">Error al agregar producto</div>
                    <%}%>
                <%}%>
                
                <%if(request.getAttribute("mensaje") != null){%>
                <%if(request.getAttribute("mensaje").toString().equals("Se modificó correctamente el producto")){%>
                    <div class="alert alert-success"><%=request.getAttribute("mensaje").toString()%></div>
                    <%}else{%>
                    <div class="alert alert-error"><%=request.getAttribute("mensaje").toString()%></div>
                    <%}%>
                <%}%>
                <br/>
                <table class="table table-hover table-striped">
                    <thead class="thead-dark">
                        <th>No.</th>
                        <th>Nombre</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>Categoría</th>
                        <th>Acciones</th>
                    </thead>
                    <tbody>
                        <% List<Producto> lista = (List<Producto>)request.getAttribute("lista");%>
                        <%int i = 1;%>
                        <%for(Producto p : lista){%>
                            <tr>
                                <td><%=i++%></td>
                                <td><%=p.getNombre() %></td>
                                <td><%=p.getCantidad()%></td>
                                <td>$ <%=p.getPrecio()%></td>
                                <td><%=p.getCategoria().getDescripcion() %></td>
                                <td>
                                    <a href="<%=context%>/ServletObtenerInformacion?id=<%=p.getId()%>" class="btn btn-info">Modificar</a>
                                </td>
                            </tr>
                        <%}%>
                        
                    </tbody>
                </table>
                        
                <a href="<%=context%>/index.jsp" class="btn btn-info">Regresar</a>
                </div>
            </div>
             <br><br>
        </div>
        
        
        <script src="<%=context%>/js/jquery-3.3.1.min.js"></script>
        <script src="<%=context%>/js/popper.min.js"></script>
        <script src="<%=context%>/js/bootstrap.min.js"></script>
    </body>
</html>
