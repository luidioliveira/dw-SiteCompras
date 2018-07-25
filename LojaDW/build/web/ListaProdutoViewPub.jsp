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
            <a id="logout" href="login_arearestrita.jsp">Área Restrita</a>
        </p>
		<a href="Carrinho"><img id="carrinho-de-compras" src="images/carrinho-de-compras.png"></a>
			<h3>
				<a href="ListaEletrodomesticos" name="nome" value="Eletrodomésticos">Eletrodomésticos</a>
				<a href="ListaInformatica" name="nome" value="Informática">Informática</a>
				<a href="ListaEletroportateis" name="nome" value="Eletroportáteis">Eletroportáteis</a>
				<a href="ListaSmartphones" name="nome" value="Smartphones">Smartphones</a>
			</h3>
		<form action="BuscarProduto" method="GET">
			<input type="text" name="pesquisar"/>
			<input type="submit" value="Pesquisar" />
		</form>
		<br><br>
        <table>
        <%
            ArrayList<Produto> resultado = (ArrayList) request.getAttribute("meusProdutos");
            for (int i = 0; i < resultado.size(); i++) {
                Produto aux = (Produto)resultado.get(i);
        %>
        <tr>
       	<td><%=aux.getNome()%></td>
        <td><%=aux.getDescricao()%></td>
        <td>- R$ <%=aux.getValor()%></td>
        <td><a href="IncluirCompraPub?idproduto=<%=aux.getId()%>">Comprar</a></td>
        </tr>
        <%
			}
        %>

    </table>

</body>
</html>

