
<html>
    <head>
       <title>INICIO DE SESIÓN</title>
       <!-- boostrap y estilo del login-->
       <link href="<%=request.getContextPath()%>/css/boostrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
       <link href="<%=request.getContextPath()%>/css/Login.css" rel="stylesheet" type="text/css"/>
       <script src="<%=request.getContextPath()%>/javascript/Metodos.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos1.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos2.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos3.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos5.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/jquery_3.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min5.js"></script>
        <script src="<%=request.getContextPath()%>/js/jssor.slider-22.0.15.mini.js" type="text/javascript" data-library="jssor.slider.mini" data-version="22.0.15"></script>
        <script src="<%=request.getContextPath()%>/js/responsiveslides.min.js"></script>   
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flexisel.js"></script>
        <script src="<%=request.getContextPath()%>/js/javascript.js" type="text/javascript"></script>
        
        <script>
            function FocoUsuario()
            {
               document.form.txtUsu.focus();
            }
            
            function EnlazarRegistroUsuario(op){
                
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value=op;
                document.form.submit();
                
            }
            
            function RegistroUsuario(){
                
                var tipo=document.form.cbTipo.value;
                var usu=document.form.txtUsu.value;
                var pas=document.form.txtPas.value;
                
                if(tipo=="--Tipo Usuario--"){
                    alert("Ud. debe seleccionar el campo Tipo Usuario");
                    
                }else if(usu.length==0){
                    alert("Ud. debe llenar el campo Usuario");
                    document.form.txtUsu.focus();
                }else if(pas.length==0){
                    alert("Ud. debe llenar el campo Contraseña");
                    document.form.txtPas.focus();
                }else{
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value=48;
                    document.form.submit();
                }
            }
        </script>
        
    </head>
    <body onload="FocoUsuario()">
        <div class="fullDiv">
            <div class="innerLeftBlurred"></div>
        </div>
                
        <div class="innerRightBlurred"></div>
        
            <div class="innerRight">
                <div class="row">
                    <h1 class="titulologin">Inicio de Sesión</h1>
                    <div class="account-wall">      
                        <img class="profile-img"  src="<%=request.getContextPath()%>/imagenes/perfil.jpg" alt=""/>           
                        <form name="form" class="form-signin">
                            <input type="hidden" name="op"> 
                            <select name="cbTipo" class="form-control" required autofocus>
                                <option value="--Tipo Usuario--">--Tipo Usuario--</option>
                                <option value="Asistente de Pedido">Asistente de Pedido</option>
                                <option value="Jefe de Pedido">Jefe de Pedido</option>
                                <option value="Gerente General">Gerente General</option>
                            </select>
                            <br>
                            <input type="text" name="txtUsu" class="form-control" placeholder="Usuario" required >
                            <input type="password" name="txtPas" class="form-control" placeholder="Contraseña" required>
                             
                            <button type="button" class="btn btn-lg btn-primary btn-block sign-in" onclick="RegistroUsuario()" >
                                INICIAR SESIÓN		
                            </button>
                            
                                <a  href="javascript:EnlazarRegistroUsuario(46)" class="text-center new-account">Registrarse</a>                             
        
                        </form>
   
                    </div>
                    <div class="alert alert-success" style="width: 90%;font-size: 10pt;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <strong>
                            
                                
                                <%
                                    if(request.getAttribute("MENSAJE")!=null)
                                    {
                                %>                                   
                                    
                                    <%=request.getAttribute("MENSAJE")%>
                                    
                                <%
                                    }
                                %>
                           
                        </strong>
                    </div>         
                             
		</div>
                            
            </div>
                            
    </body>
</html>

