<%@page import="DAO.CotizacionDAO"%>
<%@page import="BEAN.CotizacionBEAN"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<CotizacionBEAN> lista;
    int cont=0;

%>
<%
    lista=(ArrayList<CotizacionBEAN>)request.getAttribute("listacotizacion");
%>
<html>
    <head>
        <title>Cotizaciones</title>
        <script>
            function nuevo()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="2";
                document.form.submit();
            }
            function retornar()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="6";
                document.form.submit();
            }
            function seleccion()
            {
                var x;
                x=document.getElementsByName("rbCot");
                for(var i=0;i<x.length;i++)
                {
                    if(x[i].checked)
                    {
                        return x[i].value;
                    }
                }
            }
            function detalle()
            {
                var sel=seleccion();
                if(sel==null)
                {
                    alert("Usted debe seleccionar una cotizacion");
                }
                else
                {
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value="16";
                    document.form.sel.value=sel;
                    document.form.submit();
                }
                
            }
            function cambiarEstado()
            {
                var sel=seleccion();
                var estado=document.form.cbEstado.value;
                if(sel==null)
                {
                    alert("Usted debe seleccionar una cotizacion");
                }
                else if(estado=="")
                {
                    alert("Usted debe seleccionar un Estado");
                }
                else
                {
                    if(estado=="Enviado")
                        alert("Para cambiar el estado de la cotización a enviado es necesario que se haya culminado el proceso de registro de cotizacion. De no ser así el estado no se modificará");
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value="44";
                    document.form.sel.value=sel;
                    document.form.submit();
                }
                
            }
            function Habilitar()
            {
                document.form.cbEstado.disabled=false;
                alert("Si desea cambiar el estado del registro seleccionado...Seleccione un nuevo estado");
            }
            function eliminarCotizacion(codcotizacion)
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="25";
                document.form.codcotizacion.value=codcotizacion;
                document.form.submit();
            }
            
            function modificarCotizacion(codcotizacion,codproveedor,nomproveedor,imppar,fechae,fechal,estado)
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="26";
                document.form.codcotizacion.value=codcotizacion;
                document.form.nomproveedor.value=nomproveedor;
                document.form.codproveedor.value=codproveedor;
                document.form.fechae.value=fechae;
                document.form.fechal.value=fechal;
                document.form.imppar.value=imppar;
                document.form.estado.value=estado;
                document.form.submit();
            }
 
        </script>
    </head>
    <body>
        <form name="form">
            <input type="hidden" name="op">
            <input type="hidden" name="sel">
            <input type="hidden" name="codcotizacion">
            <input type="hidden" name="nomproveedor">
            <input type="hidden" name="codproveedor">
            <input type="hidden" name="fechae">
            <input type="hidden" name="fechal">
            <input type="hidden" name="imppar">
            <input type="hidden" name="estado">
            <center>
                <table border="4" cellpadding="5">
                    <tr>
                        <td>
                            <button type="button" name="btnNuevo" onclick="nuevo()">
                                Nuevo
                            </button>
                        </td>
                        <td colspan="5">
                            <%
                                if(request.getAttribute("mensaje")!=null){ 
                            %>
                                <center><%=request.getAttribute("mensaje")%></center>
                            <%
                                }
                            %>
                        </td>
                        
                        <td>
                            <select name="cbEstado" disabled>
                                <option value="" selected>--Seleccionar--</option>
                                <option value="Borrador">Borrador</option>
                                <option value="Enviado">Enviado</option>
                            </select>
                        </td>
                        <td>
                            <button type="button" onclick="cambiarEstado()">
                                Editar Estado
                            </button>
                        </td>
                        <td>
                            <button type="button" name="btnDetalle" onclick="detalle()">
                                Detalle
                            </button>
                        </td>
                    </tr>
                    <%
                        if(request.getAttribute("listacotizacion")!=null)
                        {
                            
                    %>
                    <tr>
                        <td>Nº</td>
                        <td>Nº de Cotización</td>
                        <td>Proveedor</td>
                        <td>Importe</td>
                        <td>Fecha de Envío</td>
                        <td>Fecha Límite</td>
                        <td>Estado</td>
                        <td>Modificar</td>
                        <td>Eliminar</td>
                    </tr>
                    <%
                        for(CotizacionBEAN obj:lista)
                        {
                            cont++;
                    %>
                    <tr>
                        <td><input type="radio" name="rbCot" value="<%=obj.getCodCotizacion()%>" onclick="Habilitar()"><%=cont%></td>
                        <td><%=obj.getCodCotizacion()%></td>
                        <td><%=obj.getNomProveedor()%></td>
                        <td><%=obj.getImporteTotal()%></td>
                        <td><%=obj.getFechaRegistro()%></td>
                        <td><%=obj.getFechaLimite()%></td>
                        <td><%=obj.getEstado()%></td>
                        <td>
                            <center>
                                <button type="button" onclick="modificarCotizacion('<%=obj.getCodCotizacion()%>','<%=obj.getCodProveedor()%>','<%=obj.getNomProveedor()%>','<%=obj.getImporteTotal()%>','<%=obj.getFechaRegistro()%>','<%=obj.getFechaLimite()%>','<%=obj.getEstado()%>')">
                                    Modificar
                                </button>
                            </center>
                        </td>
                        <td>
                            <center>
                                <button type="button" onclick="eliminarCotizacion('<%=obj.getCodCotizacion()%>')">
                                    Eliminar
                                </button>
                            </center>
                        </td>
                    </tr>
                    
                    <%
                            }
                        }
                        else if(request.getAttribute("mensaje")!=null){
                    %>
                    <tr>
                        <td colspan="9"><center><%=request.getAttribute("mensaje")%></center></td>
                    </tr>
                    <%
                        }
                    %>
                    
                    <tr>
                        <td colspan="9" onclick="retornar()">
                            <button>
                                Retornar
                            </button>
                        </td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>

