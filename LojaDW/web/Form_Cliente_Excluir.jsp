<%@page import="br.DAO.Cliente"%>
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
        <h1>Lista de Clientes</h1>
        <h1>Excluir Cliente</h1>
        <% Cliente cliente = (Cliente) request.getAttribute("cliente"); 
        %>
        <form action="ExcluirCliente" method="Post">
            
            <input type="hidden" name="id" value="<%=cliente.getId()%>" >
                   
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="nome" value="<%=cliente.getNome() %>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_endereco") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_endereco"));%></h3>        
            <% }%>
            Endereço:<br>
            <input type="text" name="endereco" value="<%=cliente.getEndereco()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_bairro") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_bairro"));%></h3>        
            <% }%>
            Bairro:<br>
            <input type="text" name="bairro" value="<%=cliente.getBairro()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_cidade") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cidade"));%></h3>        
            <% }%>
            Cidade:<br>
            <input type="text" name="cidade" value="<%=cliente.getCidade()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_cep") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cep"));%></h3>        
            <% }%>
            CEP:<br>
            <input type="text" name="cep" value="<%=cliente.getCep()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_uf") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_uf"));%></h3>        
            <% }%>
            UF:<br>
            <input type="text" name="uf" value="<%=cliente.getEstado()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_referencia") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_referencia"));%></h3>        
            <% }%>
            Referência:<br>
            <input type="text" name="referencia" value="<%=cliente.getReferencia()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_cpf") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cpf"));%></h3>        
            <% }%>
            CPF:<br>
            <input type="text" name="cpf" value="<%=cliente.getCpf()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_ri") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_ri"));%></h3>        
            <% }%>
            RI:<br>
            <input type="text" name="ri" value="<%=cliente.getRi()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_telfixo") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_telfixo"));%></h3>        
            <% }%>
            Telefone Fixo:<br>
            <input type="text" name="telfixo" value="<%=cliente.getTelfixo()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_celular") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_celular"));%></h3>        
            <% }%>
            Celular:<br>
            <input type="text" name="celular" value="<%=cliente.getCelular()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_cartaocred") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_cartaocred"));%></h3>        
            <% }%>
            Cartão de Crédito:<br>
            <input type="text" name="cartaocred" value="<%=cliente.getCartaocred()%>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_bandeira") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_bandeira"));%></h3>        
            <% }%>
            Bandeira do Cartão:<br>
            <input type="text" name="bandeira" value="<%=cliente.getBandeira()%>" readonly="" >
            <br><br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaCliente">Retorna</a>
        </form> 
    </body>
</html>
