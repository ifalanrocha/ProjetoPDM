<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerUsuario"%>

<%
    String cod = request.getParameter("ID");
    int idusu = Integer.parseInt(cod);
    Usuario usu = new Usuario(idusu);
    ControllerUsuario usuCont = new ControllerUsuario();
    usu = usuCont.buscar(usu);
    String pbusca = request.getParameter("PBUSCA");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO</title>
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
       <h1>ALTERAR USUÁRIO</h1>
        <form name="alterarUsuario" action="validaAlterarUsuario.jsp" method="post">
            Login: <input type="text" name="LOGIN" value="<%=usu.getLogin()%>" required> <br>
            Senha: <input type="password" name="SENHA" value="<%=usu.getSenha()%>" required> <br>
            Status: <input type="text" name="STATUS" value="<%=usu.getStatus()%>" required> <br>
            Tipo: <input type="text" name="TIPO" value="<%=usu.getTipo()%>" required> <br>
            <input type="HIDDEN" name="ID" value="<%=usu.getIdusu()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>