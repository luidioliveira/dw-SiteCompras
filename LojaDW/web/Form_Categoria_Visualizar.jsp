<%@page import="br.DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja DW</title>
        <style>
        input:-moz-read-only { /* For Firefox */
            background-color: #DCDCDC;
        }

        input:read-only {
            background-color: #DCDCDC;
        }
        </style>
    </head>
    <body>
        <h1>Lista de Categoria</h1>
        <h1>Dados da Categoria</h1>
        <% Categoria categoria = (Categoria) request.getAttribute("categoria"); 
        %>
        <form action="ListaCategoria" method="GET">
            
            <input type="hidden" name="id" value="<%=categoria.getIdCategoria()%>" >
            
            <% if(request.getAttribute("erro_nmcategoria") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nmcategoria"));%></h3>        
            <% }%>
            Categoria:<br>
            <input type="text" name="nmcategoria" value="<%=categoria.getCategoria()%>" readonly="true" >
            <br><br>
            <a href="ListaCategoria">Retorna</a>
        </form> 
    </body>
</html>
