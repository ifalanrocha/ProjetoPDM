<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    String nome = request.getParameter("NOME");
    Boletim bol = new Boletim(nome);
    ControllerBoletim bolcont = new ControllerBoletim();
    List<Boletim> boll = bolcont.listar(bol);
    Aluno aluLogado = (Aluno) session.getAttribute("AlunoLogado");
    String url = "PBUSCA=" + nome+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA ALUNOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Desc">Email</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(stass.isEmpty())) { %>    
                <tbody>
                    <% for (Status listaStatus : stass) { %>
                        <tr>
                            <td><%=listaStatus.getId()%></td>
                            <td><%=listaStatus.getNome()%></td>
                            <td><%=listaStatus.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirBoletim.jsp?<%=url + listaStatus.getId()%>">Excluir</a></td>
                                <td><a href="alterarBoletim.jsp?<%=url + listaStatus.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>