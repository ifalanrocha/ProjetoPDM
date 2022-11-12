<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LOGIN - SISTEMA</title>
    <body>
        <div class="container"/>
            <h1>LOGIN</h1>
            <form name="FORMLOGIN" action="menu.jsp" method="post">
                LOGIN: <input type="text" name ="LOGIN" required> <br>
                SENHA: <input type="password" name ="SENHA" required> <br>
                <input type="submit" name="ENVIAR" value="ENVIAR">
            </form>
        </div>
    </body>
</html>