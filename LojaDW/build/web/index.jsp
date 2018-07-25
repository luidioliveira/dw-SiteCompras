<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
    </body>
</html>
