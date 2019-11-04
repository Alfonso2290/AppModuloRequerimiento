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
            
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">  
               <%@include file="../PlantillasMenus/PlantifillaMenuAsistentePedido.jsp" %>
               <div class="CabeceraMenus">Listado de Cotizaciones</div>
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
                    <div class="container" style="width: 95%">
                        <table border="4" cellpadding="5" class="table table-bordered table-striped">

                            <tr>
                                <td>
                                    <button type="button" name="btnNuevo" onclick="nuevo()">
                                        Nuevo
                                    </button>
                                </td>
                                <td style="width: 40%">

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
                        </table>

                        <div class="form-group">
                            <select name="estado" id="maxRows" class="form-control" style="width: 150px;margin-left:-975px;">
                                <option value="5000">Nº Registros</option>
                                <option value="5">5</option>
                                <option value="10">10</option>
                                <option value="15">15</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                                <option value="75">75</option>
                                <option value="100">100</option>
                            </select>
                        </div>
                        <table border="4" id="miTabla" class="table table-bordered table-striped">
                            <thead>
                            <%
                                if(request.getAttribute("listacotizacion")!=null)
                                {

                            %>


                            <tr style="background: lightblue;">
                                <th>Nº</th>
                                <th>Nº de Cotización</th>
                                <th>Proveedor</th>
                                <th>Importe</th>
                                <th>Fecha de Envío</th>
                                <th>Fecha Límite</th>
                                <th>Estado</th>
                                <th>Modificar</th>
                                <th>Eliminar</th>
                            </tr>
                            </thead>
                            <tbody>
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
                            %>
                        </tbody>
                        </table>
                        <div class="pagination-container">
                                <nav>
                                    <ul class="pagination"></ul>
                                </nav>
                        </div>


                        <script>
                            var table='#miTabla';
                            $('#maxRows').on('change', function()
                            {
                               $('.pagination').html('');
                               var trnum = 0;
                               var maxRows = parseInt($(this).val());
                               var totalRows = $(table+' tbody tr').length;
                               $(table+' tr:gt(0)').each(function()
                               {
                                  trnum++;
                                  if(trnum > maxRows)
                                  {
                                      $(this).hide();
                                  }
                                  if(trnum <= maxRows)
                                  {
                                      $(this).show();
                                  }
                               });
                               if(totalRows > maxRows)
                               {
                                   var pagenum=Math.ceil(totalRows/maxRows);
                                   for(var i=1;i<=pagenum;)
                                   {
                                       $('.pagination').append('<li data-page="'+i+'">\<span>'+ i++ +'<span class="sr-only">(current)</span></span>\</li>').show();
                                   }
                               }
                               $('.pagination li:first-child').addClass('active');
                               $('.pagination li').on('click',function()
                               {
                                  var pageNum=$(this).attr('data-page');
                                  var trIndex=0;
                                  $('.pagination li').removeClass('active');
                                  $(this).addClass('active');
                                  $(table+' tr:gt(0)').each(function()
                                  {
                                     trIndex++;
                                     if(trIndex > (maxRows*pageNum) || trIndex <= ((maxRows*pageNum)-maxRows))
                                     {
                                         $(this).hide();
                                     }
                                     else
                                     {
                                         $(this).show();
                                     }
                                  });
                               });
                            });

                        </script>

                        <%

                            }

                        %>

                    </div>
                </div>
                <br><br><br><br>
            </center>
        </form>
    </body>
</html>

