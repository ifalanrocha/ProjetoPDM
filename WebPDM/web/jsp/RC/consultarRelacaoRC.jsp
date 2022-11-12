<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR RC</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR RC</h1>
       <form name="consultarUsuario" action="validaConsultarRelacaoRC.jsp" method="post">
           Observação: <input type="text" name ="OBS" value="" required > <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
