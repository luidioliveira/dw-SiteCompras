<%@page import="br.DAO.Produto"%>
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
        <h1>Lista de Produtos</h1>
        <h1>Excluir Produto</h1>
        <% Produto produto = (Produto) request.getAttribute("produto"); 
        %>
        <form action="Excluir_Produto" method="Post">
            
            <input type="hidden" name="id" value="<%=produto.getId()%>" >
            
            <% if(request.getAttribute("erro_idcategoria") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            ID Categoria:<br>
            <input type="text" name="idcategoria" value="<%=produto.getIdCategoria() %>" readonly="" >
            <br>
            
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=produto.getNome()%>" readonly="" >
            <br><br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaProduto">Retorna</a>
        </form> 
    </body>
</html>
