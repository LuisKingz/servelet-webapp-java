<% String context = request.getContextPath(); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=context%>/css/bootstrap.min.css" />
        <title>CRUD</title>
    </head>
    <body>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-3">
                    <a href="<%=context%>/ServletProductoNuevo" class="btn btn-lg btn-success btn-block">Agregar un nuevo producto</a>
                    <a href="<%=context%>/ServletConsultar" class="btn btn-lg btn-success btn-block">Consultar productos</a>
                </div>
            </div>
        </div>
        
        
        <script src="<%=context%>/js/jquery-3.3.1.min.js"></script>
        <script src="<%=context%>/js/popper.min.js"></script>
        <script src="<%=context%>/js/bootstrap.min.js"></script>
    </body>
</html>
