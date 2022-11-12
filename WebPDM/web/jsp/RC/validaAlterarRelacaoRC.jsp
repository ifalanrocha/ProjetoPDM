<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerUsuario"%>
<%@page import="projetoPDM.models.beans.Pessoa"%>
<%@page import="projetoPDM.controllers.ControllerPessoa"%>
<%@page import="projetoPDM.models.beans.UsuarioPessoa"%>
<%@page import="projetoPDM.controllers.ControllerUsuarioPessoa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idPessoa = Integer.parseInt(request.getParameter("ID_PESSOA"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    UsuarioPessoa usupes = new UsuarioPessoa(id,idPessoa,idUsuario,obs);
    ControllerUsuarioPessoa usupescont = new ControllerUsuarioPessoa();
    usupes = usupescont.alterar(usupes);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoUsuarioPessoa.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    