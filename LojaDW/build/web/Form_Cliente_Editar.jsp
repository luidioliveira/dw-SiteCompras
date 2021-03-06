<%@page import="br.DAO.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja DW</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        <h1>Alterar Dados do Cliente</h1>
        <% Cliente cliente = (Cliente) request.getAttribute("cliente"); 
        %>
        <form action="EditarCliente" method="POST">
            
            <input type="hidden" name="id" value="<%=cliente.getId()%>" >
            
            <% if(
                    (request.getAttribute("erro_nome") != null)
                    || (request.getAttribute("erro_nome") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=cliente.getNome() %>" >            
            <br><br>
            <% if(
                    (request.getAttribute("erro_endereco") != null)
                    || (request.getAttribute("erro_endereco") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_endereco"));%></h3>        
            <% }%>
            Endereço:<br>
            <input type="text" name="endereco" value="<%=cliente.getEndereco() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_bairro") != null)
                    || (request.getAttribute("erro_bairro") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_bairro"));%></h3>        
            <% }%>
            Bairro:<br>
            <input type="text" name="bairro" value="<%=cliente.getBairro() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_cidade") != null)
                    || (request.getAttribute("erro_cidade") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cidade"));%></h3>        
            <% }%>
            Cidade:<br>
            <input type="text" name="cidade" value="<%=cliente.getCidade() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_cep") != null)
                    || (request.getAttribute("erro_cep") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cep"));%></h3>        
            <% }%>
            CEP:<br>
            <input type="text" name="cep" value="<%=cliente.getCep() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_uf") != null)
                    || (request.getAttribute("erro_uf") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_uf"));%></h3>        
            <% }%>
            UF:<br>
            <input type="text" name="uf" value="<%=cliente.getEstado() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_referencia") != null)
                    || (request.getAttribute("erro_referencia") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_referencia"));%></h3>        
            <% }%>
            Referência:<br>
            <input type="text" name="referencia" value="<%=cliente.getReferencia() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_cpf") != null)
                    || (request.getAttribute("erro_cpf") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cpf"));%></h3>        
            <% }%>
            CPF:<br>
            <input type="text" name="cpf" value="<%=cliente.getCpf() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_ri") != null)
                    || (request.getAttribute("erro_ri") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_ri"));%></h3>        
            <% }%>
            RI:<br>
            <input type="text" name="ri" value="<%=cliente.getRi() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_telfixo") != null)
                    || (request.getAttribute("erro_telfixo") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_telfixo"));%></h3>        
            <% }%>
            Telefone Fixo:<br>
            <input type="text" name="telfixo" value="<%=cliente.getTelfixo() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_celular") != null)
                    || (request.getAttribute("erro_celular") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_celular"));%></h3>        
            <% }%>
            Celular:<br>
            <input type="text" name="celular" value="<%=cliente.getCelular() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_cartaocred") != null)
                    || (request.getAttribute("erro_cartaocred") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cartaocred"));%></h3>        
            <% }%>
            Cartão de Crédito:<br>
            <input type="text" name="cartaocred" value="<%=cliente.getCartaocred() %>" >
            <br><br>
            <% if(
                    (request.getAttribute("erro_bandeira") != null)
                    || (request.getAttribute("erro_bandeira") == "")
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_bandeira"));%></h3>        
            <% }%>
            Bandeira do Cartão:<br>
            <input type="text" name="bandeira" value="<%=cliente.getBandeira() %>" >
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaCliente">Retorna</a>
        </form> 
    </body>
</html>
