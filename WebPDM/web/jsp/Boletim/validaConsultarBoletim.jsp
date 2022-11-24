<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    String obs = request.getParameter("OBS");
    Boletim bolEnt = new Boletim(obs);
    ControllerBoletim bolcont = new ControllerBoletim();
    List<Boletim> boll = bolcont.listar(bolEnt);
    
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + obs+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA BOLETIM</title>
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
                  <th data-field="Idbol">ID</th>
                  <th data-field="Semestre">SEMESTRE</th>
                  <th data-field="Nmat">NMAT</th>
                  <th data-field="Npor">NPOR</th>
                  <th data-field="Ngeo">NGEO</th>
                  <th data-field="Obs">OBS</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(boll.isEmpty())) { %>    
                <tbody>
                    <% for (Boletim listaBoletim : boll) { %>
                        <tr>
                            <td><%=listaBoletim.getIdbol()%></td>
                            <td><%=listaBoletim.getSemestre()%></td>
                            <td><%=listaBoletim.getNmat()%></td>
                            <td><%=listaBoletim.getNpor()%></td>
                            <td><%=listaBoletim.getNgeo()%></td>
                            <td><%=listaBoletim.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirBoletim.jsp?<%=url + listaBoletim.getIdbol()%>">Excluir</a></td>
                                <td><a href="alterarBoletim.jsp?<%=url + listaBoletim.getIdbol()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>