<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - BOLETIM</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR BOLETIM</h1>
       <form name="consultarAluno" action="validaConsultarBoletim.jsp" method="post">
           NOME <input type="text" name ="NOME" value="" required > <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
