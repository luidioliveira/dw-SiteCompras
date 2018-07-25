<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Cliente"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
        <h1>Lista de Clientes</h1>
        <a href="Form_Cliente.jsp">Incluir Cliente</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Nome</th>
            <th>Endereço</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>CEP</th>
            <th>Estado</th>
            <th>Referência</th>
            <th>CPF</th>
            <th>RI</th>
            <th>Telefone Fixo</th>
            <th>Celular</th>
            <th>Cartão de Crédito</th>
            <th>Bandeira do Cartão</th>
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Cliente> resultado = (ArrayList) request.getAttribute("meusClientes");
            for (int i = 0; i < resultado.size(); i++) {
                Cliente aux = (Cliente)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getNome()%></td> 
        <td><%=aux.getEndereco()%></td>
        <td><%=aux.getBairro()%></td>
        <td><%=aux.getCidade()%></td> 
        <td><%=aux.getCep()%></td> 
        <td><%=aux.getEstado()%></td>
        <td><%=aux.getReferencia()%></td>
        <td><%=aux.getCpf()%></td> 
        <td><%=aux.getRi()%></td>
        <td><%=aux.getTelfixo()%></td>
        <td><%=aux.getCelular()%></td> 
        <td><%=aux.getCartaocred()%></td>
        <td><%=aux.getBandeira()%></td>
        <td><a href="VisualizarCliente?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarCliente?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirCliente?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>

