<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerAluno"%>


<%
    String nome = request.getParameter("NOME");
    Aluno alu = new Aluno(nome);
    ControllerAluno alucont = new ControllerAluno();
    List<Aluno> aluu = alucont.listar(alu);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA ALUNO</title>
    <body>
           <script>
             function goBack() 
             {
              window.history.back()
             }
          </script>

          <body>
                <button onclick="goBack()">Go Back</button>
          </body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Idalu">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Ra">Ra</th>
                  <th data-field="Ano">Ano</th>
                  <th data-field="Idade">Idade</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(aluu.isEmpty())) { %>    
                <tbody>
                    <% for (Aluno listaAluno : aluu) { %>
                        <tr>
                            <td><%=listaAluno.getIdalu()%></td>
                            <td><%=listaAluno.getNome()%></td>
                            <td><%=listaAluno.getRa()%></td>
                            <td><%=listaAluno.getAno()%></td>
                            <td><%=listaAluno.getIdade()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirAluno.jsp?<%=url + listaAluno.getIdalu()%>">Excluir</a></td>
                                <td><a href="alterarAluno.jsp?<%=url + listaAluno.getIdalu()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>