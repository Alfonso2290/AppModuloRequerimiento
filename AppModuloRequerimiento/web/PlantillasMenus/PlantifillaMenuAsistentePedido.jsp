<div class="container">

    <!-- IMAGEN DEL LOGO -->
    <div class="navbar-header" style="width: 30%;height: 160px;">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <div class="logo" style="margin-top: 15px;margin-left: -70px;">
            <img src="<%=request.getContextPath()%>/imagenes/logo.png" style="width: 80%;height: 120px;" >
        </div>
    </div>

    <!-- BARRA DE DESPLIEGUE -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

        <ul class="nav navbar-nav navbar-right">
            <li class="active">
                <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','RequerimientoServlet',45)">Inicio</a>
            </li>                          
            <li>
                <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','RequerimientoServlet',1)">Cotización</a>
            </li> 
            <li>
                <a href="#">Requerimiento</a>
            </li> 
            <li>
                <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','RequerimientoServlet',45)" ><img src="">Cerrar Sesion </a>
            </li>
        </ul>
    </div>
</div>
