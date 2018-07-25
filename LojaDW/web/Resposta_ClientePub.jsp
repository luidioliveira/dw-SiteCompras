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
        <h1><% out.println(request.getAttribute("mensagem"));    %></h1>
        <p></p>
        <div><a href="index.jsp">Retornar ao início do site</a></div>
    </body>
</html>
