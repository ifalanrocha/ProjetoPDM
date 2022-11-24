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
    Aluno aluEnt = new Aluno("");
    List<Aluno> aluu = aluCont.listar(aluEnt);

    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Usuario> usus = usuCont.listar(usuEnt);
    
    ControllerBoletim bolCont = new ControllerBoletim();
    Boletim bolEnt = new Boletim("");
    List<Boletim> bols = bolCont.listar(bolEnt);
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR REGISTRO COMPLETO</title>
    <body>
        <div class="container"/>
            <h1>Inserir Registro Completo</h1>
            <form name="inserirRC" action="validaRelacaoRC.jsp" method="POST">
                <table>
                    <tr>
                        <td>Aluno:</td>
                        <td>
                            <select NAME ="ID_ALUNO" class="browser-default">
                                <% for (Aluno alu : aluu) { %>
                                    <option value="<%=alu.getIdalu()%>"><%=alu.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <option value="<%=usu.getIdusu()%>"><%=usu.getLogin()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Boletim:</td>
                        <td>
                            <select NAME ="ID_BOLETIM" class="browser-default">
                                <% for (Boletim bol : bols) { %>
                                        <option selected value="<%=bol.getIdbol()%>"><%=bol.getObs()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="" required ></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
