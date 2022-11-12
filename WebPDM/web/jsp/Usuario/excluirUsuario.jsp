<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerUsuario"%>

<%
    String cod = request.getParameter("ID");
    int idusu = Integer.parseInt(cod);
    Usuario usu = new Usuario(idusu);
    ControllerUsuario usuCont = new ControllerUsuario();
    usu = usuCont.excluir(usu);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarUsuario.jsp?LOGIN=" + pbusca;
    response.sendRedirect(url);
%>