<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - USUÁRIO</title>
    <body>
          <script>
             function goBack() 
             {
              window.history.back()
             }
          </script>

          <body>
                <button onclick="goBack()">Go Back</button>
          </body>
       <div class="container"/>
        <h1>INSERIR USUÁRIO</h1>
        <form name="inserirUsuario" action="validaInserirUsuario.jsp" method="post">
            Login: <input type="text" name="LOGIN" value="" required> <br>
            Senha: <input type="password" name="SENHA" value="" required> <br>
            Status: <input type="text" name="STATUS" value="" required> <br>
            Tipo: <input type="text" name="TIPO" value="" required> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
