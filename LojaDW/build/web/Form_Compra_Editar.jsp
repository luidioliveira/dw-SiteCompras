<%@page import="br.DAO.Compra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja DW</title>
    </head>
    <body>
        <h1>Lista de Compras</h1>
        <h1>Alterar Dados da Compra</h1>
        <% Compra compra = (Compra) request.getAttribute("compra"); 
        %>
        <form action="EditarCompra" method="POST">
            
            <input type="hidden" name="id" value="<%=compra.getId()%>" >
            
            <% if(request.getAttribute("erro_idcliente") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idcliente"));%></h3>        
            <% }%>
            ID Cliente:<br>
            <input type="text" name="idcliente" value="<%=compra.getIdCliente() %>" >
            <br>
            <% if(request.getAttribute("erro_idproduto") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idproduto"));%></h3>        
            <% }%>
            ID Produto:<br>
            <input type="text" name="idproduto" value="<%=compra.getIdProduto()%>" >
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaCompra">Retorna</a>
        </form> 
    </body>
</html>
