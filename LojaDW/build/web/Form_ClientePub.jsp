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
        <form action="IncluirClientePub" method="POST">
            <% if(
                    (request.getAttribute("erro_nome") != null)
                    || (request.getAttribute("erro_nome") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" maxlength="100" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_endereco") != null)
                    || (request.getAttribute("erro_endereco") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_endereco"));%></h3>        
            <% }%>
            Endereço:<br>
            <input type="text" name="endereco" maxlength="100" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_bairro") != null)
                    || (request.getAttribute("erro_bairro") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_bairro"));%></h3>        
            <% }%>
            Bairro:<br>
            <input type="text" name="bairro" maxlength="100" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_cidade") != null)
                    || (request.getAttribute("erro_cidade") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cidade"));%></h3>        
            <% }%>
            Cidade:<br>
            <input type="text" name="cidade" maxlength="100" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_cep") != null)
                    || (request.getAttribute("erro_cep") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cep"));%></h3>        
            <% }%>
            CEP:<br>
            <input type="text" name="cep" maxlength="8" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_uf") != null)
                    || (request.getAttribute("erro_uf") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_uf"));%></h3>        
            <% }%>
            UF:<br>
            <input type="text" name="uf" maxlength="2" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_referencia") != null)
                    || (request.getAttribute("erro_referencia") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_referencia"));%></h3>        
            <% }%>
            Referência:<br>
            <input type="text" name="referencia" maxlength="200" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_cpf") != null)
                    || (request.getAttribute("erro_cpf") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cpf"));%></h3>        
            <% }%>
            CPF:<br>
            <input type="text" name="cpf" maxlength="12" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_ri") != null)
                    || (request.getAttribute("erro_ri") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_ri"));%></h3>        
            <% }%>
            RI:<br>
            <input type="text" name="ri" maxlength="15" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_telfixo") != null)
                    || (request.getAttribute("erro_telfixo") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_telfixo"));%></h3>        
            <% }%>
            Telefone Fixo:<br>
            <input type="text" name="telfixo" maxlength="8" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_celular") != null)
                    || (request.getAttribute("erro_celular") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_celular"));%></h3>        
            <% }%>
            Celular:<br>
            <input type="text" name="celular" maxlength="9" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_cartaocred") != null)
                    || (request.getAttribute("erro_cartaocred") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cartaocred"));%></h3>        
            <% }%>
            Cartão de Crédito:<br>
            <input type="text" name="cartaocred" maxlength="16" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_bandeira") != null)
                    || (request.getAttribute("erro_bandeira") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_bandeira"));%></h3>        
            <% }%>
            Bandeira do Cartão:<br>
            <input type="text" name="bandeira" maxlength="20" >
            <br><br>
            <input type="submit" value="Concluir">
			<a href="index.jsp"><input type="button" value="Cancelar"></a>
        </form> 
    </body>
</html>
