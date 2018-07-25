<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja DWt</title>
    </head>
    <body>
        <h1>Incluir Compra</h1>
        <form action="IncluirCompra" method="POST">
            <% if(
                    (request.getAttribute("erro_idcliente") != null)
                    || (request.getAttribute("erro_idcliente") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idcliente"));%></h3>        
            <% }%>
            ID Cliente<br>
            <input type="text" name="idcliente" >
            <br>
            <% if(request.getAttribute("erro_idproduto") != null) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idproduto"));%></h3>        
            <% }%>
            ID Produto:<br>
            <input type="text" name="idproduto" >
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>
