<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    String cod = request.getParameter("ID");
    int idbol = Integer.parseInt(cod);
    Boletim bol = new Boletim(idbol);
    ControllerBoletim bolCont = new ControllerBoletim();
    bol = bolCont.excluir(bol);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarBoletim.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>