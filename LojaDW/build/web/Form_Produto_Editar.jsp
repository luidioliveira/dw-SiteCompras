<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja DW</title>
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        <h1>Alterar Dados do Produto</h1>
        <% Produto produto = (Produto) request.getAttribute("produto"); 
        %>
        <form action="Editar_Produto" method="POST">
            
            <input type="text" hidden name="id" value="<%=produto.getId()%>" >
            
            <% if(request.getAttribute("erro_idcategoria") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idcategoria"));%></h3>        
            <% }%>
            ID Categoria:<br>
            <input type="text" name="idcategoria" value="<%=produto.getIdCategoria()%>" >
            <br>
            
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=produto.getNome()%>" >
            <br>
            
            
            <% if(request.getAttribute("erro_descricao") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=produto.getDescricao()%>" >
            <br>
            
            
            <% if(request.getAttribute("erro_valor") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_valor"));%></h3>        
            <% }%>
            Valor:<br>
            <input type="text" name="valor" value="<%=produto.getValor()%>" >
            <br><br>
            
            
            <input type="submit" value="Alterar">
            <a href="ListaProduto">Retorna</a>
        </form> 
    </body>
</html>
