<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Loja DW</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <h1>Lista de Categorias</h1>
        <a href="Form_Categoria.jsp">Incluir Categoria</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Categoria</th>
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Categoria> resultado = (ArrayList) request.getAttribute("minhasCategorias");
            for (int i = 0; i < resultado.size(); i++) {
                Categoria aux = (Categoria)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getIdCategoria()%></td>
        <td><%=aux.getCategoria()%></td> 
        <td><a href="VisualizarCategoria?id=<%=aux.getIdCategoria()%>">Visualizar</a> | <a href="EditarCategoria?id=<%=aux.getIdCategoria()%>">Editar</a> | <a href="ExcluirCategoria?id=<%=aux.getIdCategoria()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>

