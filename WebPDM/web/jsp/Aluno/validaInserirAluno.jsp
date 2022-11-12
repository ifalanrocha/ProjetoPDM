<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerAluno"%>

<%
    String nome = request.getParameter("NOME");
    String ra = request.getParameter("RA");
    String ano = request.getParameter("ANO");
    String idade = request.getParameter("IDADE");
 
    Aluno alu = new Aluno(nome, ra, ano, idade);
    ControllerAluno alucont = new ControllerAluno();
    alu = alucont.inserir(alu);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirAluno.jsp";
    response.sendRedirect(url);
%>

