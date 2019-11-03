
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
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
            function limpiarCampos(){
                
                document.form.cbTipo.value="--Tipo Usuario--";
                document.form.txtUsu.value="";
                document.form.txtPas.value="";
                document.form.txtPas2.value="";
                document.form.txtUsu.focus();
            }
            
            function registrarUsuario(){
                
                var tipo=document.form.cbTipo.value;
                var usu=document.form.txtUsu.value;
                var pas=document.form.txtPas.value;
                var pas2=document.form.txtPas2.value;
                
                if(tipo=="--Tipo Usuario--"){
                    alert("Ud. debe seleccionar el campo Tipo Usuario");
                    
                }else if(usu.length==0){
                    alert("Ud. debe llenar el campo Usuario");
                    document.form.txtUsu.focus();
                }else if(pas.length==0){
                    alert("Ud. debe llenar el campo Contraseña");
                    document.form.txtPas.focus();
                }else if(pas2.length==0){
                    alert("Ud. debe llenar el campo Repetir Contraseña");
                    document.form.txtPas2.focus();
                }else if(pas!=pas2){
                    alert("Las contraseñas ingresadas no coinciden");
                    document.form.txtPas.value="";
                    document.form.txtPas2.value="";
                    document.form.txtPas.focus();
                }
                else{
                    
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value="47";
                    document.form.submit();
                }   
            }
            
            function enviarLogin(){
                
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="45";
                document.form.submit();
            
            }
        </script>
    </head>
    <body>
        <form name="form">
            <input type="hidden" name="op">
            <center>
                <table border="3" cellpadding="4">
                    
                    <tr>
                        <td colspan="2">Registrar Usuario</td>
                    </tr>
                    <tr>
                        <td>Tipo Usuario:</td>
                        <td>
                            <select name="cbTipo">
                                <option value="--Tipo Usuario--">--Tipo Usuario--</option>
                                <option value="Asistente de Pedido">Asistente de Pedido</option>
                                <option value="Jefe de Pedido">Jefe de Pedido</option>
                                <option value="Gerente General">Gerente General</option>
                            </select>
                            
                        </td>
                        
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td><input type="text" name="txtUsu" placeholder="Usuario"></td>
                    </tr>
                    <tr>
                        <td>Contraseña:</td>
                        <td><input type="password" name="txtPas" placeholder="Contraseña"></td>
                    </tr>
                    <tr>
                        <td>Repetir Contraseña:</td>
                        <td><input type="password" name="txtPas2" placeholder="Repetir Contraseña"></td>
                    </tr>
                    
                    <tr>
                        <td><center><input type="button" value="Registrar" onclick="registrarUsuario()"></center></td>
                        <td><center><input type="button" value="Cancelar" onclick="limpiarCampos()"></center></td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <center>
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
                            </center>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="button" value="Retornar" onclick="enviarLogin()"></td>
                    </tr>
                </table>
            </center>            
        </form>
         
        
    </body>
</html>
