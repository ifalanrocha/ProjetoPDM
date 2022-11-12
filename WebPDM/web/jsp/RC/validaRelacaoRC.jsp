<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Usuario"%>
<%@page import="projetoPDM.controllers.ControllerUsuario"%>
<%@page import="projetoPDM.models.beans.Pessoa"%>
<%@page import="projetoPDM.controllers.ControllerPessoa"%>
<%@page import="projetoPDM.models.beans.UsuarioPessoa"%>
<%@page import="projetoPDM.controllers.ControllerUsuarioPessoa"%>

<%
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idPessoa = Integer.parseInt(request.getParameter("ID_PESSOA"));
    String obs = request.getParameter("OBS");
    UsuarioPessoa usupes = new UsuarioPessoa(idPessoa,idUsuario,obs);
    ControllerUsuarioPessoa usupescont = new ControllerUsuarioPessoa();
    usupes = usupescont.inserir(usupes);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoUsuarioPessoa.jsp";
    response.sendRedirect(url);

%>