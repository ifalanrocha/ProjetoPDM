<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerAluno"%>

<%
    String cod = request.getParameter("ID");
    int idalu = Integer.parseInt(cod);
    Aluno alu = new Aluno(idalu);
    ControllerAluno aluCont = new ControllerAluno();
    alu = aluCont.buscar(alu);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - ALUNO</title>
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
       <h1>ALTERAR ALUNO</h1>
        <form name="alterarAluno" action="validaAlterarAluno.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=alu.getNome()%>" required > <br>
            Ra: <input type="text" name="RA" value="<%=alu.getRa()%>" required > <br>
            Ano: <input type="text" name="ANO" value="<%=alu.getAno()%>" required > <br>
            Idade: <input type="text" name="IDADE" value="<%=alu.getIdade()%>" required > <br>
            <input type="HIDDEN" name="ID" value="<%=alu.getIdalu()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>