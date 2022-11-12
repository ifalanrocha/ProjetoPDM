<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - ALUNO</title>
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
       <h1>CONSULTAR ALUNO</h1>
       <form name="consultarAluno" action="validaConsultarAluno.jsp" method="post">
           NOME <input type="text" name ="NOME" value="" required> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
