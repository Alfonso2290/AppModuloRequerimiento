<%@page import="BEAN.DetalleCotizacionBEAN"%>
<%@page import="BEAN.ProveedorBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.CotizacionBEAN"%>
<%
   CotizacionBEAN cot=null; 
   ProveedorBEAN prov=null;
   ArrayList<DetalleCotizacionBEAN> listadet=null;
   int cont=0;
%>
<%
    if(request.getAttribute("cot")!=null)
        cot=(CotizacionBEAN)request.getAttribute("cot");
    if(request.getAttribute("prov")!=null)
        prov=(ProveedorBEAN)request.getAttribute("prov");
    if(request.getAttribute("listadet")!=null)
        listadet=(ArrayList<DetalleCotizacionBEAN>)request.getAttribute("listadet");
%>
<html>
    <head>
        <title>Detalle Cotizacion</title>
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
            function retornar()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="17";
                document.form.submit();
            }
        </script>
    </head>
    <body>
        <form name="form">
            <input type="hidden" name="op">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">  
               <%@include file="../PlantillasMenus/PlantifillaMenuAsistentePedido.jsp" %>
               <div class="CabeceraMenus">Detalle de Cotización</div>
            </nav>
            <center>
                <div class="DivPrincipalMantenimiento">
                    <br><br>
                    <div class="alert alert-success">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <strong>
                                
                                <%
                                    if(request.getAttribute("mensaje")!=null)
                                    {
                                %>                                   

                                    <%=request.getAttribute("mensaje")%>

                                <%
                                    }
                                %>
                         
                        </strong>
                    </div>
                    <table cellpadding="5">
                        <tr>
                            <td colspan="4"><center>Detalle Cotización</center></td>
                        </tr>
                        <tr>
                            <td colspan="4"><hr></td>
                        </tr>
                        <tr>
                            <td>Código de Cotización:</td>
                            <td><%=cot.getCodCotizacion()%></td>
                            <td>Fecha de Envío:</td>
                            <td><%=cot.getFechaRegistro()%></td>
                        </tr>
                        <tr>
                            <td>Estado:</td>
                            <td><%=cot.getEstado()%></td>
                            <td>Fecha Límite:</td>
                            <td><%=cot.getFechaLimite()%></td>
                        </tr>
                        <tr>
                            <td>Proveedor:</td>
                            <td><%=cot.getNomProveedor()%></td>
                            <td>Importe Total:</td>
                            <td>S/.<%=cot.getImporteTotal()%></td>
                    </table>

                    <table cellpadding="5">
                        <tr>
                            <td colspan="4"><center>Detalle Proveedor</center></td>
                        </tr>
                        <tr>
                            <td colspan="4"><hr></td>
                        </tr>
                        <tr>
                            <td>RUC:</td>
                            <td><%=prov.getRuc()%></td>
                            <td>Departamento:</td>
                            <td><%=prov.getNomDepartamento()%></td>
                        </tr>
                        <tr>
                            <td>Teléfono:</td>
                            <td><%=prov.getTelefono()%></td>
                            <td>Provincia:</td>
                            <td><%=prov.getNomProvincia()%></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><%=prov.getEmail()%></td>
                            <td>Distrito:</td>
                            <td><%=prov.getNomDistrito()%></td>
                        <tr>
                            <td>Dirección:</td>
                            <td><%=prov.getDireccion()%></td>
                            <td colspan="2"></td>
                        </tr>
                    </table> 
                    <table cellpadding="5">
                        <tr>
                            <td colspan="7"><center>Detalle Producto</center></td>
                        </tr>
                        <tr>
                            <td colspan="7"><hr></td>
                        </tr>
                        <%
                            if(request.getAttribute("listadet")!=null)
                            {

                        %>
                        <tr>
                            <td>Nº</td>
                            <td>Código</td>
                            <td>Nombre</td>
                            <td>Unidad</td>
                            <td>Cantidad</td>
                            <td>P/U</td>
                            <td>Importe</td>
                        </tr>
                        <%
                            for(DetalleCotizacionBEAN obj:listadet)
                            {
                                cont++;
                        %>
                        <tr>
                            <td><%=cont%></td>
                            <td><%=obj.getCodProducto()%></td>
                            <td><%=obj.getNomProducto()%></td>
                            <td><%=obj.getUnidadMedida()%></td>
                            <td><%=obj.getCantidad()%></td>
                            <td><%=obj.getPrecioUnitario()%></td>
                            <td><%=obj.getImporteParcial()%></td>

                        </tr>

                        <%
                                }
                            }

                        %>
                    </table>
                </div>
                <br><br><br><br>
            </center>
        </form>
    </body>
</html>
