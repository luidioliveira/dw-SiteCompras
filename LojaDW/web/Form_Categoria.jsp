<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja DW</title>
    </head>
    <body>
        <h1>Incluir Categoria</h1>
        <form action="IncluirCategoria" method="POST">
            <% if(
                    (request.getAttribute("erro_nmcategoria") != null)
                    || (request.getAttribute("erro_nmcategoria") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nmcategoria"));%></h3>        
            <% }%>
            Categoria:<br>
            <input type="text" name="nmcategoria" >
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>
