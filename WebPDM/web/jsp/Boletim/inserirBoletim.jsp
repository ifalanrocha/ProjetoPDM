<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - BOLETIM</title>
    <body>
       <div class="container"/>
        <h1>INSERIR BOLETIM</h1>
        <form name="inserirBoletim" action="validaInserirBoletim.jsp" method="post">
            SEMESTRE: <input type="text" name="SEMESTRE" value="" required > <br>
            NMAT: <input type="text" name="NMAT" value="" required > <br>
            NPOR: <input type="text" name="NPOR" value="" required > <br>
            NGEO: <input type="text" name="NGEO" value="" required > <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
