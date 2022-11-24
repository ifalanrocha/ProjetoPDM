<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="projetoPDM.models.beans.Boletim"%>
<%@page import="projetoPDM.controllers.ControllerBoletim"%>

<%
    String cod = request.getParameter("ID");
    int idbol = Integer.parseInt(cod);
    Boletim bol = new Boletim(idbol);
    ControllerBoletim bolCont = new ControllerBoletim();
    bol = bolCont.buscar(bol);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - BOLETIM</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR BOLETIM</h1>
        <form name="alterarBoletim" action="validaAlterarBoletim.jsp" method="post">
            SEMESTRE: <input type="text" name="SEMESTRE" value="<%=bol.getSemestre()%>" required> <br>
            NMAT: <input type="text" name="NMAT" value="<%=bol.getNmat()%>" required> <br>
            NPOR: <input type="text" name="NPOR" value="<%=bol.getNpor()%>" required> <br>
            NGEO: <input type="text" name="NGEO" value="<%=bol.getNgeo()%>" required> <br>
            OBS: <input type="text" name="OBS" value="<%=bol.getObs()%>" required> <br>            
            <input type="HIDDEN" name="ID" value="<%=bol.getIdbol()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>