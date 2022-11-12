<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerAluno"%>

<%
    String cod = request.getParameter("ID");
    int idalu = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String ra = request.getParameter("RA");
    String ano = request.getParameter("ANO");
    String idade = request.getParameter("IDADE");
    String pbusca = request.getParameter("PBUSCA");
    Aluno alu = new Aluno(idalu,nome,ra,ano,idade);
    ControllerAluno aluCont = new ControllerAluno();
    alu = aluCont.alterar(alu);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarAluno.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>