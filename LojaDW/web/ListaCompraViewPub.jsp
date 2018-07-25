<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Loja DW</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
        <p>
            LOJA DW
        </p>
		<p>
		<b>Minhas Compras</b>
		</p>
        <table>
        <%
            ArrayList<Produto> resultado = (ArrayList) request.getAttribute("meusProdutos");
			double totalValor = 0;
            for (int i = 0; i < resultado.size(); i++) {
                Produto aux = (Produto)resultado.get(i);
				totalValor=totalValor+aux.getValor();
            
        %>
        <tr>
        <td><%=aux.getNome()%></td>
        <td><%=aux.getDescricao()%></td>
        <td>- R$ <%=aux.getValor()%></td>
        <td><a href="ExcluirCompraPub?idproduto=<%=aux.getId()%>">Remover</a></td>
        </tr>
		<%
            }
        %>
		<td>Total da Compra: <b>R$ <%=totalValor%></b></td>
    </table>
	<br>
	<a href="Form_ClientePub.jsp">FINALIZAR A COMPRA</a>
	<br><br><br>	
	<a href="index.jsp">RETORNAR AS COMPRAS</a>

</body>
</html>

