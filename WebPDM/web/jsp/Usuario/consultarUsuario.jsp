<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - USUÁRIO</title>
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
       <h1>CONSULTAR USUÁRIO</h1>
       <form name="consultarUsuario" action="validaConsultarUsuario.jsp" method="post">
           LOGIN <input type="text" name ="LOGIN" value="" required> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
