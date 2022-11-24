<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.RC"%>
<%@page import="projetoPDM.controllers.ControllerRC"%>

<%
    String cod = request.getParameter("ID");
    int idrc = Integer.parseInt(cod);
    RC rce = new RC(idrc);
    ControllerRC rcCont = new ControllerRC();
    rce = rcCont.excluir(rce);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoRC.jsp?OBS=" + pbusca;
    response.sendRedirect(url);

%>

