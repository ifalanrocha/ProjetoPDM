<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    String nome = request.getParameter("NOME");
    String desc = request.getParameter("DESC");
 
    Boletim bol = new Boletim(nome,desc);
    ControllerBoletim stacont = new ControllerBoletim();
    bol = bolcont.inserir(bol);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirBoletim.jsp";
    response.sendRedirect(url);
%>