<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.RC"%>
<%@page import="projetoPDM.controllers.ControllerRC"%>

<%
    String cod = request.getParameter("ID");
    int idrc = Integer.parseInt(cod);
    RC usuPes = new RC(idrc);
    ControllerRC usuPesCont = new ControllerRC();
    usuPes = usuPesCont.excluir(usuPes);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoRC.jsp?OBS=" + pbusca;
    response.sendRedirect(url);

%>

