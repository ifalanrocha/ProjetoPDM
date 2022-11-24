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
    int idUsu = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idAlu = Integer.parseInt(request.getParameter("ID_ALUNO"));
    int idBol = Integer.parseInt(request.getParameter("ID_BOLETIM"));
    String obs = request.getParameter("OBS");
    
    RC usupes = new RC (idUsu, idAlu, idBol, obs);
    ControllerRC usupescont = new ControllerRC();
    usupes = usupescont.inserir(usupes);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoRC.jsp";
    response.sendRedirect(url);
%>