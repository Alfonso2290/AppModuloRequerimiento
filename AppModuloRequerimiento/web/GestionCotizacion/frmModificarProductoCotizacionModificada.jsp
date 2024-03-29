<%@page import="BEAN.DetalleCotizacionBEAN"%>
<%@page import="BEAN.ProductoBEAN"%>
<%@page import="BEAN.CotizacionBEAN"%>
<%@page import="BEAN.CatalogoBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.ProveedorBEAN"%>
<%!
    String dir,nom,ruc,tel,email,calle,codcot,est,codprov;
    int coddep,codpro,coddis,nume,numi;
    String numcat,codprod;
    String fechae,fechal;
    DetalleCotizacionBEAN objProd;
%>
<%
    
    if(request.getAttribute("numcat")!=null)
       numcat=(String)request.getAttribute("numcat");
    if(request.getAttribute("codprod")!=null)
        codprod=(String)request.getAttribute("codprod");
    if(request.getAttribute("dir")!=null)
       dir=(String)request.getAttribute("dir");
    if(request.getAttribute("nom")!=null)
        nom=(String)request.getAttribute("nom");
    if(request.getAttribute("ruc")!=null)
       ruc=(String)request.getAttribute("ruc");
    if(request.getAttribute("tel")!=null)
        tel=(String)request.getAttribute("tel");
    if(request.getAttribute("email")!=null)
       email=(String)request.getAttribute("email");
    if(request.getAttribute("calle")!=null)
        calle=(String)request.getAttribute("calle");
    if(request.getAttribute("codcot")!=null)
       codcot=(String)request.getAttribute("codcot");
    if(request.getAttribute("est")!=null)
        est=(String)request.getAttribute("est");
    if(request.getAttribute("codprov")!=null)
       codprov=(String)request.getAttribute("codprov");
    if(request.getAttribute("coddep")!=null)
        coddep=(int)request.getAttribute("coddep");
    if(request.getAttribute("codpro")!=null)
       codpro=(int)request.getAttribute("codpro");
    if(request.getAttribute("coddis")!=null)
        coddis=(int)request.getAttribute("coddis");
    if(request.getAttribute("nume")!=null)
       nume=(int)request.getAttribute("nume");
    if(request.getAttribute("numi")!=null)
        numi=(int)request.getAttribute("numi");
    if(request.getAttribute("fechae")!=null)
       fechae=(String)request.getAttribute("fechae");
    if(request.getAttribute("fechal")!=null)
        fechal=(String)request.getAttribute("fechal");
    objProd=(DetalleCotizacionBEAN)request.getAttribute("objetodetalle");
    
%>
<html>
    <head>
        <title>Agregar Producto</title>
        <link href="<%=request.getContextPath()%>/css/HojaEstilo01.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/css/bootstrap.min2.css" rel="stylesheet"> 
        <link href="<%=request.getContextPath()%>/css/modern-business.css" rel="stylesheet">   
        <link href="<%=request.getContextPath()%>/css/style2.css" rel="stylesheet" type="text/css" media="all" />
        <script src="<%=request.getContextPath()%>/js/jquery_3.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min5.js"></script>
        <script src="<%=request.getContextPath()%>/js/jssor.slider-22.0.15.mini.js" type="text/javascript" data-library="jssor.slider.mini" data-version="22.0.15"></script>
        <script src="<%=request.getContextPath()%>/js/responsiveslides.min.js"></script>   
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flexisel.js"></script>
        <script src="<%=request.getContextPath()%>/js/javascript.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/javascript/Metodo.js" type="text/javascript"></script>
        <script>
            function focoCodProd()
            {
                document.form.cbUnidad.focus();
            }
            
            function cancelar()
            {
                
                document.form.txtCantidad.value="";
                document.form.cbUnidad.value="";
                document.form.txtPrecio.value="";
                
                document.form.cbUnidad.focus();
            }
            
            function soloNumeros(evt)
            {
                if (window.event) 
                {
                    keynum = evt.keyCode;
             
                } else 
                {
                    keynum = evt.which;
                }
                if ((keynum == 8) || (keynum > 47 && keynum<58))
                    return true;
                else
                    return false;  
            }
            
            function retornar()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="42";
                document.form.submit();
            }

            function modificar()
            {
                var pre,unid,cant;
                unid=document.form.cbUnidad.value;
                cant=document.form.txtCantidad.value;
                pre=document.form.txtPrecio.value;
                if(unid=="")
                {
                    alert("Usted debe seleccionar el campo Unidad ");
                    document.form.cbUnidad.focus();
                    return;
                }
                else if(cant.length==0)
                {
                    alert("Usted debe llenar el campo Cantidad ");
                    document.form.txtCantidad.focus();
                    return;
                }
                else if(pre=="")
                {
                    alert("Usted debe llenar el campo Precio Unitario");
                    document.form.cbPrecio.focus();
                    return;
                }
                else
                {
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value="43";
                    document.form.txtNom.disabled=false;
                    document.form.submit();
                }
            }
        </script>
        
    </head>
    <body onload="focoCodProd()">
        <form name="form">
            <input type="hidden" name="op">
            <input type="hidden" name="dir" value="<%=dir%>">
            <input type="hidden" name="nom" value="<%=nom%>">
            <input type="hidden" name="ruc" value="<%=ruc%>">
            <input type="hidden" name="tel" value="<%=tel%>">
            <input type="hidden" name="email" value="<%=email%>">
            <input type="hidden" name="calle" value="<%=calle%>">
            <input type="hidden" name="codcot" value="<%=codcot%>">
            <input type="hidden" name="est" value="<%=est%>">
            <input type="hidden" name="codprov" value="<%=codprov%>">
            <input type="hidden" name="coddep" value="<%=coddep%>">
            <input type="hidden" name="codpro" value="<%=codpro%>">
            <input type="hidden" name="coddis" value="<%=coddis%>">
            <input type="hidden" name="nume" value="<%=nume%>">
            <input type="hidden" name="numi" value="<%=numi%>">
            <input type="hidden" name="fechae" value="<%=fechae%>">
            <input type="hidden" name="fechal" value="<%=fechal%>">
            
            <input type="hidden" name="codprod" value="<%=codprod%>">
            <input type="hidden" name="numcat" value="<%=numcat%>">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">  
               <%@include file="../PlantillasMenus/PlantifillaMenuAsistentePedido.jsp" %>
               <div class="CabeceraMenus">Modificar Producto</div>
            </nav>
            <center>
                <div class="DivPrincipalMantenimientoRegistrar">
                    <br><br>
                    <table border="4" cellpadding="5">
                        
                        <tr>
                            <td>C�digo Producto:</td>
                            <td><%=codprod%></td>
                        </tr>
                        <tr>
                            <td>Nombre Producto:</td>
                            <td><input type="text" name="txtNom" value="<%=objProd.getNomProducto()%>" disabled></td>
                        </tr>
                        <tr>
                            <td>Unidad:</td>
                            <td>
                                <%
                                    if(request.getAttribute("objetodetalle")!=null)
                                    {

                                        if(objProd.getUnidadMedida().compareTo("Kilogramo")==0)
                                        {
                                %>
                                <select name="cbUnidad">
                                   <option value="" >--Seleccionar--</option>
                                   <option value="Kilogramo" selected>Kilogramo</option>
                                   <option value="Metros">Metros</option>
                                   <option value="Metros cubicos">Metros cubicos</option>
                                </select>
                                    <%
                                        }else if(objProd.getUnidadMedida().compareTo("Metros")==0){
                                    %>
                                <select name="cbUnidad">
                                   <option value="" >--Seleccionar--</option>
                                   <option value="Kilogramo" >Kilogramo</option>
                                   <option value="Metros" selected>Metros</option>
                                   <option value="Metros cubicos">Metros cubicos</option>
                                </select>
                                    <%
                                        }else if(objProd.getUnidadMedida().compareTo("Metros cubicos")==0){


                                %>
                                <select name="cbUnidad">
                                   <option value="" >--Seleccionar--</option>
                                   <option value="Kilogramo" >Kilogramo</option>
                                   <option value="Metros" >Metros</option>
                                   <option value="Metros cubicos" selected>Metros cubicos</option>
                                </select>


                                <%
                                        }else{

                                %>
                                <select name="cbUnidad">
                                   <option value="" selected>--Seleccionar--</option>
                                   <option value="Kilogramo">Kilogramo</option>
                                   <option value="Metros">Metros</option>
                                   <option value="Metros cubicos">Metros cubicos</option>
                                </select>
                                <%
                                        }
                                    }else {
                                %>

                                <select name="cbUnidad">
                                   <option value="" selected>--Seleccionar--</option>
                                   <option value="Kilogramo">Kilogramo</option>
                                   <option value="Metros">Metros</option>
                                   <option value="Metros cubicos">Metros cubicos</option>
                                </select>

                                <%
                                    }
                                %>

                            </td>
                        </tr>
                        <tr>
                            <td>Cantidad:</td>
                            <td>
                                <%
                                    if(request.getAttribute("objetodetalle")!=null){

                                %>

                                <input type="text" name="txtCantidad" value="<%=objProd.getCantidad()%>" onkeypress="return soloNumeros(event)">
                                <%
                                    }else{
                                %>
                                <input type="text" name="txtCantidad" onkeypress="return soloNumeros(event)">
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                        <tr>
                            <td>Precio Unitario:</td>
                            <td>S/.
                                <%
                                    if(request.getAttribute("objetodetalle")!=null){

                                %>

                                <input type="text" name="txtPrecio" value="<%=objProd.getPrecioUnitario()%>" onkeypress="return soloNumeros(event)">
                                <%
                                    }else{
                                %>
                                <input type="text" name="txtPrecio" onkeypress="return soloNumeros(event)">
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button type="button" onclick="modificar()">
                                    Modificar
                                </button>
                            </td>
                            <td>
                                <button type="button" onclick="cancelar()">
                                    Cancelar
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <center>
                                    <button type="button" onclick="retornar()">
                                        Retornar
                                    </button>
                                </center>
                            </td>
                        </tr>
                    </table>
                </div>
                <br><br><br><br>
            </center>
        </form>
    </body>
</html>
                    
                            
                            
                            
                    


