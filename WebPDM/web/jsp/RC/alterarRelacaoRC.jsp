<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerUsuario"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerAluno"%>
<%@page import="projetoPDM.models.beans.RC"%>
<%@page import="projetoPDM.controllers.ControllerRC"%>

<%
    ControllerAluno aluCont = new ControllerAluno();
    Aluno pf = new Aluno("");
    List<Aluno> aluu = aluCont.listar(pf);

    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Usuario> usus = usuCont.listar(usuEnt);

    String cod = request.getParameter("ID");
    int idrc = Integer.parseInt(cod);
    RC regCo = new RC (idrc);
    ControllerRC regCoCont = new ControllerRC();
    regCo = regCoCont.buscar(regCo);
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - RC</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - RC</h1>
        <form name="alterarUsuarioPessoa" action="validaAlterarRelacaoUsuarioPessoa.jsp" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <% if( usu.getId() == rc.getIdrc()) { %>
                                        <option selected value="<%=usu.getIdusu()%>"><%=usu.getLogin()%></option>
                                    <% } else { %>
                                        <option value="<%=usu.getIdusu()%>"><%=usu.getLogin()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>Pessoa:</td>
                        <td>
                            <select NAME ="ID_ALUNO" class="browser-default">
                                <% for (Aluno alu : aluu) { %>
                                    <% if( alu.getIdalu()== rc.getIdAluno()) { %>
                                        <option selected value="<%=alu.getIdalu()%>"><%=alu.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=alu.getIdalu()%>"><%=alu.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=rc.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=rc.getIdusu()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>