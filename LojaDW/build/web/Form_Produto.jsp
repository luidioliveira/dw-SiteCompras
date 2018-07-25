<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.DAO.Categoria_DAO" %>

<% 
    ArrayList<Categoria> categorias =null;
    Categoria_DAO cDao = new Categoria_DAO();
    categorias = cDao.Listar();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja DW</title>
    </head>
    <body>
        <h1>Incluir Produto</h1>
        <form action="IncluirProduto" method="POST">
            <% if(
                    (request.getAttribute("erro_idcategoria") != null)
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idcategoria"));%></h3>        
            <% }%>
            ID Categoria:<br>
            <input type="text" name="idcategoria" >
            <%--
            <select>
                <c:forEach var="item" items="${item.categorias}">
                    <option value="${item.id}">${item.nmcategoria}</option>
                </c:forEach>
            </select>
            --%>
            <br>
            
            
            <% if(
                    (request.getAttribute("erro_nome") != null)
                    || (request.getAttribute("erro_nome") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" >
            <br>
            
            
            <% if(
                    (request.getAttribute("erro_descricao") != null)
                    || (request.getAttribute("erro_descricao") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_descricao"));%></h3>        
            <% }%>
            Descrição:<br>
            <input type="text" name="descricao" >
            <br>
            
            
            <% if(
                    (request.getAttribute("erro_valor") != null)
                ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_valor"));%></h3>        
            <% }%>
            Valor:<br>
            <input type="text" name="valor" >
            
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>
