<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Compra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Loja Dw</title>
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
        <h1>Lista de Compras</h1>
        <a href="Form_Compra.jsp">Incluir Compra</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Id Cliente</th>
            <th>Id Produto</th>
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Compra> resultado = (ArrayList) request.getAttribute("minhasCompras");
            for (int i = 0; i < resultado.size(); i++) {
                Compra aux = (Compra)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getIdCliente()%></td> 
        <td><%=aux.getIdProduto()%></td>
        <td><a href="VisualizarCompra?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarCompra?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirCompra?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>

