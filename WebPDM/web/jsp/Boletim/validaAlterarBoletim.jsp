<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    int idbol = Integer.parseInt(request.getParameter("ID"));
    int semestre = Integer.parseInt(request.getParameter("SEMESTRE"));
    int nmat = Integer.parseInt(request.getParameter("NMAT"));
    int npor = Integer.parseInt(request.getParameter("NPOR"));
    int ngeo = Integer.parseInt(request.getParameter("NGEO"));
    String pbusca = request.getParameter("PBUSCA");
    Boletim bol = new Boletim(idbol, semestre, nmat, npor, ngeo);
    ControllerBoletim bolCont = new ControllerBoletim();
    bol = bolCont.alterar(bol);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarBoletim.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>