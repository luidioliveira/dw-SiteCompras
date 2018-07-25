<%@page import="br.DAO.Administrador"%>
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
        <h1>Lista de Administradores</h1>
        <h1>Dados do Administrador</h1>
        <% Administrador administrador = (Administrador) request.getAttribute("administrador"); 
        %>
        <form action="ListaAdministrador" method="GET">
            
            <input type="hidden" name="id" value="<%=administrador.getId()%>" >
            
            <% if(request.getAttribute("erro_login") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_login"));%></h3>        
            <% }%>
            Login:<br>
            <input type="text" name="login" value="<%=administrador.getLogin() %>" readonly="true" >
            <br>
            <% if(request.getAttribute("erro_senha") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_aenha"));%></h3>        
            <% }%>
            Senha:<br>
            <input type="text" name="senha" value="<%=administrador.getSenha()%>" readonly="true" >
            <br><br>
            <a href="ListaAdministrador">Retorna</a>
        </form> 
    </body>
</html>
