<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usuEntrada = new Usuario(login,senha);
    ControllerUsuario usucont = new ControllerUsuario();
    Usuario usuSaida = usucont.validaWeb(usuEntrada);
    session.setAttribute("UsuarioLogado",usuSaida);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>SISTEMA </title>
    
    
    <body>
        <div class="center"/>
        <% if (usuSaida != null) { %>
            <!-- Dropdown1 Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Usuário</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Aluno</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter RC</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Manter Boletim</a>        

            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../Usuario/inserirUsuario.jsp"> Inserir Usuário </a></li>
                    <li><a href="../Usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../Usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../Aluno/inserirAluno.jsp"> Inserir Aluno </a></li>
                    <li><a href="../Aluno/consultarAluno.jsp"> Consultar Aluno </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../Aluno/consultarAluno.jsp"> Consultar Aluno </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../RC/inserirRelacaoRC.jsp"> Inserir RC </a></li>
                    <li><a href="../RC/consultarRelacaoRC.jsp"> Consultar RC </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../usuario/consultarRelacaoRC.jsp"> Consultar RC </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../Boletim/inserirBoletim.jsp"> Inserir Boletim </a></li>
                    <li><a href="../Boletim/consultarBoletim.jsp"> Consultar Boletim </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../Boletim/consultarBoletim.jsp"> Consultar Boletim </a></li>
                </ul>
            <% } %>

            <% } else { %>
                <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
        </div>
    </body>
</html>