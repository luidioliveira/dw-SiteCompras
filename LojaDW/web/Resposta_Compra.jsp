<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja DW</title>
    </head>
    <body>
        <h1>Lista de Compras</h1>
        <h1><% out.println(request.getAttribute("mensagem"));    %></h1>
        <p></p>
        <div><a href="<% out.println(request.getAttribute("retorna"));%>">Retornar Para a Lista de Compras</a></div>
    </body>
</html>
