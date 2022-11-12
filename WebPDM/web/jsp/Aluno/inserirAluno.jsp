<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - ALUNO</title>
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
        <h1>INSERIR ALUNO</h1>
        <form name="inserirAluno" action="validaInserirAluno.jsp" method="post">
            Nome: <input type="text" name="nome" value="" required> <br>
            Ra: <input type="text" name="ra" value="" required > <br>
            Ano: <input type="text" name="ano" value="" required > <br>
            Idade: <input type="text" name="idade" value="" required > <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
