<%@page import="br.DAO.Administrador"%>

<!DOCTYPE html>
<html >
<head>
  <title>Loja DW - Login</title>
  <link rel="stylesheet" href="css/style.css">
</head>

<body>
  
  <h2>Acesso Restrito</h2>
  <% 
//Administrador administrador = (Administrador) request.getAttribute("administrador"); 
  %>
    <form action="Login" method="POST">
        <input type="text" name="login" placeholder="Login" /><br><br>
        <input type="password" name="senha" placeholder="Senha" /><br><br>
        <input class="btn btn-success" type="submit" value="Login" /><br>
    </form>

  </body>
</html>
