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
            Nome: <input type="text" name="NOME" value="" required> <br>
            Ra: <input type="text" name="RA" value="" required > <br>
            Ano: <input type="text" name="ANO" value="" required > <br>
            Idade: <input type="text" name="IDADE" value="" required > <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
