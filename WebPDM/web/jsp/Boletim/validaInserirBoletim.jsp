<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    String sem = request.getParameter("SEMESTRE");
    int semestre = Integer.parseInt(sem);
    String nm = request.getParameter("NMAT");
    int nmat = Integer.parseInt(nm);
    String np = request.getParameter("NPOR");
    int npor = Integer.parseInt(np);
    String ng = request.getParameter("NGEO");
    int ngeo = Integer.parseInt(ng);
    String obs = request.getParameter("OBS");
 
    Boletim bol = new Boletim(semestre, nmat, npor, ngeo, obs);
    ControllerBoletim bolcont = new ControllerBoletim();
    bol = bolcont.inserir(bol);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirBoletim.jsp";
    response.sendRedirect(url);
%>