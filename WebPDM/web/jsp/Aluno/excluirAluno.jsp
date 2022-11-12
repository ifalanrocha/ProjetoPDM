<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerAluno"%>

<%
    String cod = request.getParameter("ID");
    int idalu = Integer.parseInt(cod);
    Aluno alu = new Aluno(idalu);
    ControllerAluno aluCont = new ControllerAluno();
    alu = aluCont.excluir(alu);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarAluno.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>