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
        <h1>Dados do Produto</h1>
        <% Produto produto = (Produto) request.getAttribute("produto"); 
        %>
        <form action="ListaProduto" method="GET">
            
            <input type="hidden" name="id" value="<%=produto.getId()%>" >
            
            <% if(request.getAttribute("erro_idcategoria") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idcategoria"));%></h3>        
            <% }%>
            ID Categoria:<br>
            <input type="text" name="idcategoria" value="<%=produto.getIdCategoria() %>" readonly="true" >
            <br>
            
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>    
            <input type="text" name="descricao" value="<%=produto.getDescricao()%>" readonly="true" >
            <br> 
            
            
            <% if(request.getAttribute("erro_descricao") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=produto.getDescricao()%>" readonly="true" >
            <br> 
            
            
            <% if(request.getAttribute("erro_") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_valor"));%></h3>        
            <% }%>
            Valor:<br>
            <input type="text" name="valor" value="<%=produto.getValor()%>" readonly="true" >
            <br><br>
            <a href="ListaProduto">Retorna</a>
        </form> 
    </body>
</html>
