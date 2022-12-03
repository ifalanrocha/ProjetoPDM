<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LOGIN - SISTEMA</title>
    <body>
        
        <div class="container"/>
             <nav>
        <div class="nav-wrapper teal lighten-1">
        <a href="#" class="brand-logo center">LOGIN</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">

                    </ul>
                </div>
            </nav>
            <form name="FORMLOGIN" action="menu.jsp" method="post">
                LOGIN: <input type="text" name ="LOGIN" required> <br>
                SENHA: <input type="password" name ="SENHA" required> <br>
            <button class="btn waves-effect waves-light" type="submit" name="ENVIAR">Entrar
            <i class="material-icons right">send</i>
            </button>
            </form>
        </div>
    </body>
</html>