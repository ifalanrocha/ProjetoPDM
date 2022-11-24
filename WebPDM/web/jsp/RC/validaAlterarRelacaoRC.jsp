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
    String cod = request.getParameter("ID");
    int idRc = Integer.parseInt(cod);
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idAluno = Integer.parseInt(request.getParameter("ID_ALUNO"));
    int idBoletim = Integer.parseInt(request.getParameter("ID_BOLETIM"));
    String obs = request.getParameter("OBS");
    
    String pbusca = request.getParameter("PBUSCA");
    RC usupes = new RC(idRc,idUsuario,idAluno,idBoletim,obs);
    ControllerRC usupescont = new ControllerRC();
    usupes = usupescont.alterar(usupes);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoRC.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    