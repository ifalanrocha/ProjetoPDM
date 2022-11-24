<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerUsuario"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerAluno"%>
<%@page import="projetoPDM.models.beans.RC"%>
<%@page import="projetoPDM.controllers.ControllerRC"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    ControllerAluno aluCont = new ControllerAluno();
    Aluno pf = new Aluno("");
    List<Aluno> aluu = aluCont.listar(pf);

    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Usuario> usus = usuCont.listar(usuEnt);
    
    ControllerBoletim bolCont = new ControllerBoletim();
    Boletim bolEnt = new Boletim("");
    List<Boletim> bols = bolCont.listar(bolEnt);

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
        <form name="alterarRelacaoRC" action="validaAlterarRelacaoRC.jsp" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <% if( usu.getIdusu() == regCo.getIdusu()) { %>
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
                                    <% if( alu.getIdalu()== regCo.getIdalu()) { %>
                                        <option selected value="<%=alu.getIdalu()%>"><%=alu.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=alu.getIdalu()%>"><%=alu.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                    <tr>
                        <td>Pessoa:</td>
                        <td>
                            <select NAME ="ID_BOLETIM" class="browser-default">
                                <% for (Boletim bol : bols) { %>
                                    <% if( bol.getIdbol()== regCo.getIdbol()) { %>
                                        <option selected value="<%=bol.getIdbol()%>"><%=bol.getObs()%></option>
                                    <% } else { %>
                                        <option value="<%=bol.getIdbol()%>"><%=bol.getObs()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=regCo.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=regCo.getIdrc()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>