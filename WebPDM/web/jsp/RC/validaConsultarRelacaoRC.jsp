<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerUsuario"%>
<%@page import="projetoPDM.models.beans.Aluno"%>
<%@page import="projetoPDM.controllers.ControllerAluno"%>
<%@page import="projetoPDM.models.beans.RC"%>
<%@page import="projetoPDM.controllers.ControllerRC"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    String obs = request.getParameter("OBS");
    RC usupes = new RC(obs);
    ControllerRC usupescont = new ControllerRC();
    List<RC> usupess = usupescont.listar(usupes);
    
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + usupes.getObs()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA REGISTRO COMPLETO</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Idrc">Idrc</th>
                  <th data-field="Idalu">Idalu</th>
                  <th data-field="Idbol">Idbol</th>
                  <th data-field="Idusu">Idusu</th>
                  <th data-field="Observacao">Observacao</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(usupess.isEmpty())) { %>    
                <tbody>
                    <% for (RC listaUsuarioPessoa : usupess) { %>
                        <tr>
                           <td><%=listaUsuarioPessoa.getIdrc()%></td>
                            <td><%=listaUsuarioPessoa.getIdalu()%></td>
                            <td><%=listaUsuarioPessoa.getIdbol()%></td>
                            <td><%=listaUsuarioPessoa.getIdusu()%></td>
                            <td><%=listaUsuarioPessoa.getObs()%></td>            
                                <td><a href="excluirRelacaoRC.jsp?<%=url + listaUsuarioPessoa.getIdrc()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoRC.jsp?<%=url + listaUsuarioPessoa.getIdrc()%>">Alterar</a></td>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>