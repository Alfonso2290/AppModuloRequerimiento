
<%@page import="BEAN.DetalleCotizacionBEAN"%>
<%@page import="BEAN.CotizacionBEAN"%>
<%@page import="BEAN.DistritoBEAN"%>
<%@page import="DAO.ProvinciaDAO"%>
<%@page import="BEAN.ProvinciaBEAN"%>
<%@page import="BEAN.DepartamentoBEAN"%>
<%@page import="BEAN.ProductoBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.ProveedorBEAN"%>
<%!
    String codprov="",codcot,est,nume,numi,nom,ruc,tel,email,calle,nomprov;
    ProveedorBEAN prov=null,objProv;
    CotizacionBEAN cot=null;
    ArrayList<DepartamentoBEAN> listadep;
    ArrayList<ProvinciaBEAN> listapro;
    ArrayList<DistritoBEAN> listadis;
    int codpro,coddep,coddis;
    double it=0;
    ArrayList<DetalleCotizacionBEAN> listadet=null;
    ArrayList<ProveedorBEAN> listaprov;
%>
<%
    if(request.getAttribute("codprov")!=null)
        codprov=(String)request.getAttribute("codprov");
    if(request.getAttribute("objeto")!=null)
        prov=(ProveedorBEAN)request.getAttribute("objeto");
    if(request.getAttribute("objetoCot")!=null)
        cot=(CotizacionBEAN)request.getAttribute("objetoCot");
    if(request.getAttribute("listadepartamentos")!=null)
        listadep=(ArrayList<DepartamentoBEAN>)request.getAttribute("listadepartamentos");
    if(request.getAttribute("listaprovincias")!=null)
        listapro=(ArrayList<ProvinciaBEAN>)request.getAttribute("listaprovincias");
    if(request.getAttribute("listadistritos")!=null)
        listadis=(ArrayList<DistritoBEAN>)request.getAttribute("listadistritos");
    if(request.getAttribute("coddep")!=null)
        coddep=(int)request.getAttribute("coddep");
    if(request.getAttribute("codpro")!=null)
        codpro=(int)request.getAttribute("codpro");
    if(request.getAttribute("coddis")!=null)
        coddis=(int)request.getAttribute("coddis");
    if(request.getAttribute("nume")!=null)
        nume=(String)request.getAttribute("nume");
    if(request.getAttribute("numi")!=null)
        numi=(String)request.getAttribute("numi");
    
    if(request.getAttribute("nom")!=null)
        nom=(String)request.getAttribute("nom");
    if(request.getAttribute("ruc")!=null)
        ruc=(String)request.getAttribute("ruc");
    if(request.getAttribute("email")!=null)
        email=(String)request.getAttribute("email");
    if(request.getAttribute("tel")!=null)
        tel=(String)request.getAttribute("tel");
    if(request.getAttribute("calle")!=null)
        calle=(String)request.getAttribute("calle");
    if(request.getAttribute("codcot")!=null)
        codcot=(String)request.getAttribute("codcot");
    if(request.getAttribute("est")!=null)
        est=(String)request.getAttribute("est");
    if(request.getAttribute("nomprov")!=null)
        nomprov=(String)request.getAttribute("nomprov");
    if(request.getAttribute("listadetalle")!=null)
        listadet=(ArrayList<DetalleCotizacionBEAN>)request.getAttribute("listadetalle");
    if(request.getAttribute("importeTotal")!=null)
        it=(Double)request.getAttribute("importeTotal");
    if(request.getAttribute("listaproveedor")!=null)
        listaprov=(ArrayList<ProveedorBEAN>)request.getAttribute("listaproveedor");
    if(request.getAttribute("objetoProv")!=null)
        objProv=(ProveedorBEAN)request.getAttribute("objetoProv");
%>
<html>
    <head>
        <title>Agregar Cotización</title>
        <script>
            function foco()
            {
                document.form.txtNom.focus();
            }
            
            function listarProvincias()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="3";
                document.form.submit();
            }
            function listarDistritos()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="4";
                document.form.submit();
            }
            
            function cancelar()
            {
                document.form.txtNom.value="";
                document.form.txtRuc.value="";
                document.form.txtEmail.value="";
                document.form.txtCalle.value="";
                document.form.txtTel.value="";
                document.form.txtNumExt.value="";
                document.form.txtNumInt.value="";
                document.form.cbProvincia.value=0;
                document.form.cbDistrito.value=0;
                document.form.cbDepartamento.value=0;
                document.form.txtNom.focus();
            }
            function retornar()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="5";
                document.form.submit();
            }
            
            function guardar()
            {
                var nom,ruc,tel,email,calle,dis,dep,pro,numi,nume;
                nom=document.form.txtNom.value;
                ruc=document.form.txtRuc.value;
                email=document.form.txtEmail.value;
                tel=document.form.txtTel.value;
                dep=document.form.cbDepartamento.value;
                pro=document.form.cbProvincia.value;
                dis=document.form.cbDistrito.value;
                calle=document.form.txtCalle.value;
                nume=document.form.txtNumExt.value;
                numi=document.form.txtNumInt.value;
                if(nom.length==0)
                {
                    alert("Usted debe llenar el campo Nombre de Proveedor");
                    document.form.txtNom.focus();
                }
                else if(ruc.length==0)
                {
                    alert("Usted debe llenar el campo RUC");
                    document.form.txtRuc.focus();
                }
                else if(email.length==0)
                {
                    alert("Usted debe llenar el campo Email");
                    document.form.txtEmail.focus();
                }
                else if(tel.length==0)
                {
                    alert("Usted debe llenar el campo Telefono");
                    document.form.txtTel.focus();
                }
                else if(dep==0)
                {
                    alert("Usted debe seleccionar el campo Departamento");
                    document.form.cbDepartamento.focus();
                }
                else if(pro==0)
                {
                    alert("Usted debe seleccionar el campo Provincia");
                    document.form.cbProvincia.focus();
                }
                else if(dis==0)
                {
                    alert("Usted debe seleccionar el campo Distrito");
                    document.form.cbDistrito.focus();
                }
                else if(calle.length==0)
                {
                    alert("Usted debe llenar el campo Calle");
                    document.form.txtCalle.focus();
                }
                else if(nume.length==0)
                {
                    alert("Usted debe llenar el campo Número Externo");
                    document.form.txtNumExt.focus();
                }
                else if(numi.length==0)
                {
                    alert("Usted debe llenar el campo Número Interno");
                    document.form.txtNumInt.focus();
                }
                else
                {
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value="7";
                    document.form.submit();
                }
                
            }
            
            function cancelarCot()
            {
                document.form.txtFechaE.value="";
                document.form.txtFechaL.value="";
            }
            
            function guardarCot()
            {
                var fechae,fechal;
                fechae=document.form.txtFechaE.value;
                fechal=document.form.txtFechaL.value;
                if(fechae=="")
                {
                    alert("Usted debe llenar el campo Fecha de Envio");
                }
                else if(fechal=="")
                {
                    alert("Usted debe llenar el campo Fecha Limite");
                }
                else if(fechal<fechae)
                {
                    alert("Las fechas ingresados son invalidas");
                }
                else
                {
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value="8";
                    document.form.txtNom.disabled=false;
                    document.form.txtRuc.disabled=false;
                    document.form.txtEmail.disabled=false;
                    document.form.txtCalle.disabled=false;
                    document.form.txtTel.disabled=false;
                    document.form.txtNumExt.disabled=false;
                    document.form.txtNumInt.disabled=false;
                    document.form.cbProvincia.disabled=false;
                    document.form.cbDistrito.disabled=false;
                    document.form.cbDepartamento.disabled=false;
                    document.form.submit();
                }
            }
            function seleccion()
            {
                var x;
                x=document.getElementsByName("rbProd");
                for(var i=0;i<x.length;i++)
                {
                    if(x[i].checked)
                    {
                        return x[i].value;
                    }
                }
            }
            function modificarProducto()
            {
                var sel=seleccion();
                if(sel==null)
                {
                    alert("Usted debe seleccionar un producto");
                }
                else
                {
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value="22";
                    document.form.sel.value=sel;
                    document.form.txtNom.disabled=false;
                    document.form.txtRuc.disabled=false;
                    document.form.txtEmail.disabled=false;
                    document.form.txtCalle.disabled=false;
                    document.form.txtTel.disabled=false;
                    document.form.txtNumExt.disabled=false;
                    document.form.txtNumInt.disabled=false;
                    document.form.cbProvincia.disabled=false;
                    document.form.cbDistrito.disabled=false;
                    document.form.cbDepartamento.disabled=false;
                    document.form.txtFechaE.disabled=false;
                    document.form.txtFechaL.disabled=false;
                    document.form.submit();
                }
                
            }
            
            function eliminarProducto()
            {
                var sel=seleccion();
                if(sel==null)
                {
                    alert("Usted debe seleccionar un producto");
                }
                else
                {
                    document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                    document.form.method="POST";
                    document.form.op.value="21";
                    document.form.sel.value=sel;
                    document.form.txtNom.disabled=false;
                    document.form.txtRuc.disabled=false;
                    document.form.txtEmail.disabled=false;
                    document.form.txtCalle.disabled=false;
                    document.form.txtTel.disabled=false;
                    document.form.txtNumExt.disabled=false;
                    document.form.txtNumInt.disabled=false;
                    document.form.cbProvincia.disabled=false;
                    document.form.cbDistrito.disabled=false;
                    document.form.cbDepartamento.disabled=false;
                    document.form.txtFechaE.disabled=false;
                    document.form.txtFechaL.disabled=false;
                    document.form.submit();
                }
                
            }
            function detallar(id)
            {
                var nom=document.form.txtNom.value;
                if(nom.length==0)
                {
                    alert("Usted debe seleccionar el campo Proveedor");
                }
                else
                {
                    //OcultarDiv();
                    var xmlhtpp="";
                    xmlhtpp+="<table border='4'>";
                        xmlhtpp+="<tr>";
                            xmlhtpp+="<td colspan='2'><center>Registrar Cotización</center></td>";
                        xmlhtpp+="</tr>";
                        xmlhtpp+="<tr>";
                            xmlhtpp+="<td>Código de Cotización:</td>";
                            xmlhtpp+="<td><%=codcot%></td>";
                        xmlhtpp+="</tr>";
                        xmlhtpp+="<tr>";
                            xmlhtpp+="<td>Estado:</td>";
                            xmlhtpp+="<td><%=est%></td>";
                        xmlhtpp+="</tr>";
                        xmlhtpp+="<tr>";
                            xmlhtpp+="<td>Fecha de Envío:</td>";
                            xmlhtpp+="<td>";
                                <%
                                    if(request.getAttribute("objetoCot")!=null){
                                %>
                                    xmlhtpp+="<input type='text' name='txtFechaE' value='<%=cot.getFechaRegistro()%>' disabled>";
                                <%
                                    }else{
                                %>

                                    xmlhtpp+="<input type='date' name='txtFechaE'>";
                                <%
                                    }
                                %>
                            xmlhtpp+="</td>";
                        xmlhtpp+="</tr>";
                        xmlhtpp+="<tr>";
                            xmlhtpp+="<td>Fecha Límite:</td>";
                            xmlhtpp+="<td>";
                                <%
                                    if(request.getAttribute("objetoCot")!=null){
                                %>
                                    xmlhtpp+="<input type='text' name='txtFechaL' value='<%=cot.getFechaLimite()%>' disabled>";
                                <%
                                    }else{
                                %>

                                    xmlhtpp+="<input type='date' name='txtFechaL'>";
                                <%
                                    }
                                %>
                            xmlhtpp+="</td>";
                        xmlhtpp+="</tr>";
                        xmlhtpp+="<tr>";
                            xmlhtpp+="<td>";
                                <%
                                    if(request.getAttribute("objetoCot")!=null){
                                %>
                                xmlhtpp+="<button type='button' onclick='guardarCot()' disabled>";
                                    xmlhtpp+="Guardar";
                                xmlhtpp+="</button>";
                                <%
                                    }else{
                                %>
                                xmlhtpp+="<button type='button' onclick='guardarCot()'>";
                                    xmlhtpp+="Guardar";
                                xmlhtpp+="</button>";
                                <%
                                    }
                                %>
                            xmlhtpp+="</td>";
                            xmlhtpp+="<td>";
                                <%
                                    if(request.getAttribute("objetoCot")!=null){
                                %>
                                xmlhtpp+="<button type='button' onclick='cancelarCot()' disabled>";
                                    xmlhtpp+="Cancelar";
                                xmlhtpp+="</button>";
                                <%
                                    }else{
                                %>

                                xmlhtpp+="<button type='button' onclick='cancelarCot()'>";
                                    xmlhtpp+="Cancelar";
                                xmlhtpp+="</button>";
                                <%
                                    }
                                %>
                            xmlhtpp+="</td>";

                        xmlhtpp+="</tr>"; 
                        xmlhtpp+="<tr>"; 
                            xmlhtpp+="<td colspan='2'>";
                                xmlhtpp+="<center>";
                                <%
                                    if(request.getAttribute("objetoCot")!=null){
                                %>
                                xmlhtpp+="<button type='button' onclick='detallarProducto()' >";
                                    xmlhtpp+="Detalle Producto";
                                xmlhtpp+="</button>";
                                <%
                                    }else{
                                %>
                                xmlhtpp+="<button type='button' onclick='detallarProducto()' disabled>";
                                    xmlhtpp+="Detalle Producto";
                                xmlhtpp+="</button>";
                                <%
                                    }
                                %> 
                                xmlhtpp+="</center>";
                            xmlhtpp+="</td>";
                        xmlhtpp+="</tr>";         
                    xmlhtpp+="</table>"; 

                    document.getElementById(id).innerHTML=xmlhtpp;
                }
            }
            
            function detallarProducto()
            {
                //OcultarDiv();
                var id="oculto2";
                var xmlhtpp="";
                xmlhtpp+="<table border='4'>";
                    xmlhtpp+="<tr>";
                        xmlhtpp+="<td colspan='3'><center>Detalle Producto</center></td>";
                    xmlhtpp+="</tr>";
                    xmlhtpp+="<tr>";
                        xmlhtpp+="<td>";
                            xmlhtpp+="<center>";
                                xmlhtpp+="<button type='button' onclick='agregarProducto()'>";//
                                    xmlhtpp+="Agregar";
                                xmlhtpp+="</button>";
                            xmlhtpp+="</center>";
                        xmlhtpp+="</td>";
 
                        xmlhtpp+="<td>";
                            xmlhtpp+="<center>";
                                xmlhtpp+="<button type='button' onclick='modificarProducto()'>";//
                                    xmlhtpp+="Modificar";
                                xmlhtpp+="</button>";
                            xmlhtpp+="</center>";
                        xmlhtpp+="</td>";
                    
                        xmlhtpp+="<td>";
                            xmlhtpp+="<center>";
                                xmlhtpp+="<button type='button' onclick='eliminarProducto()'>";//
                                    xmlhtpp+="Eliminar";
                                xmlhtpp+="</button>";
                            xmlhtpp+="</center>";
                        xmlhtpp+="</td>";
                    xmlhtpp+="</tr>";
                    xmlhtpp+="</table>";
                    <%
                        if(request.getAttribute("listadetalle")!=null){
                    %>
                    xmlhtpp+="<div id='DivOc'>";
                    xmlhtpp+="<table border='4'>";
                    xmlhtpp+="<tr>";
                        xmlhtpp+="<td>Código</td>";
                        xmlhtpp+="<td>Nombre</td>";
                        xmlhtpp+="<td>Unidad</td>";
                        xmlhtpp+="<td>Cantidad</td>";
                        xmlhtpp+="<td>Precio Unitario</td>";
                        xmlhtpp+="<td>Importe</td>";
                    xmlhtpp+="</tr>";
                    
                    <%
                        for(DetalleCotizacionBEAN obj: listadet){
                    %>
                    
                    xmlhtpp+="<tr>";
                        xmlhtpp+="<td><input type='radio' name='rbProd' value='<%=obj.getCodProducto()%>' ><%=obj.getCodProducto()%></td>";
                        xmlhtpp+="<td><%=obj.getNomProducto()%></td>";
                        xmlhtpp+="<td><%=obj.getUnidadMedida()%></td>";
                        xmlhtpp+="<td><%=obj.getCantidad()%></td>";
                        xmlhtpp+="<td><%=obj.getPrecioUnitario()%></td>";
                        xmlhtpp+="<td><%=obj.getImporteParcial()%></td>";
                    xmlhtpp+="</tr>";
                    
                
                <%
                       }
                    
                    
                %>
                        
                xmlhtpp+="</table>";
                xmlhtpp+="</div>";   
                <%
                    }
                    if(request.getAttribute("importeTotal")!=null){
                %>
                xmlhtpp+="<center>"; 
                xmlhtpp+="TOTAL:S/.<%=it%>";
                xmlhtpp+="<button type='button' onclick='enviarCotizacion()'>";
                    xmlhtpp+="Enviar Cotización";
                xmlhtpp+="</button>";
                xmlhtpp+="</center>"; 
                <%
                    }
                %>
                document.getElementById(id).innerHTML=xmlhtpp;
            }
            
            function Busqueda()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="9";
                document.form.submit();
            }
            
            function cerrar()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="10";
                document.form.submit();
            }
            
            function llenarCampos()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="11";
                document.form.submit();
            }

            function agregarProducto()
            {              
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="POST";
                document.form.op.value="12";
                
                document.form.txtNom.disabled=false;
                document.form.txtRuc.disabled=false;
                document.form.txtEmail.disabled=false;
                document.form.txtCalle.disabled=false;
                document.form.txtTel.disabled=false;
                document.form.txtNumExt.disabled=false;
                document.form.txtNumInt.disabled=false;
                document.form.cbProvincia.disabled=false;
                document.form.cbDistrito.disabled=false;
                document.form.cbDepartamento.disabled=false;
                document.form.txtFechaE.disabled=false;
                document.form.txtFechaL.disabled=false;
                document.form.submit();
            }
            
            function enviarCotizacion()
            {
                document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
                document.form.method="GET";
                document.form.op.value="15";
                document.form.submit();
            }
            
        </script>
    </head>
    <body onload="foco()">
        <form name="form">
            <input type="hidden" name="op">
            <input type="hidden" name="sel">
            <input type="hidden" name="codprov" value="<%=codprov%>">
            <input type="hidden" name="codcot" value="<%=codcot%>">
            <input type="hidden" name="est" value="<%=est%>">
            <center>
                <table border="4" cellpadding="5">
                    <tr>
                        <td colspan="4"><center>Registro de Proveedor</center></td>
                    </tr>
                    <tr>
                        <td>Código de Proveedor:</td>
                        <td>
                            <%
                                if(request.getAttribute("listaproveedor")!=null){
                            %>
                            
                            <%
                                if(request.getAttribute("objeto")!=null){  
                            %>
                            <select name="cbProveedor" disabled>
                                
                                <option value="<%=codprov%>" selected><%=nomprov%></option>
                                
                            </select>
                            <button type="button" onclick="cerrar()">
                                X
                            </button>

                            <%
                                }
                                else if(request.getAttribute("codprov")!=null){
                            %>
                            
                            <select name="cbProveedor" onchange="llenarCampos()">
                                <option value="">--Seleccionar--</option>
                                <%
                                    for(ProveedorBEAN prov:listaprov)
                                    {
                                        if(((String)request.getAttribute("codprov")).compareTo(prov.getCodProveedor())==0)
                                        {
                                %>
                                
                                <option value="<%=prov.getCodProveedor()%>" selected><%=prov.getNombre()%></option>
                                
                                <%
                                        }
                                        else{
                                    
                                %>
                                
                                <option value="<%=prov.getCodProveedor()%>"><%=prov.getNombre()%></option>
                                
                                <%
                                        }
                                    }
                                %>
                            
                            </select>
                            <button type="button" onclick="cerrar()">
                                X
                            </button>
                            
                            <%
                                }else{
                            %>
                            
                            <select name="cbProveedor" onchange="llenarCampos()">
                                <option value="" selected>--Seleccionar--</option>
                                <%
                                    for(ProveedorBEAN prov:listaprov)
                                    {
                                %>
                                
                                <option value="<%=prov.getCodProveedor()%>"><%=prov.getNombre()%></option>
                                
                                <%
                                    }
                                %>
                            </select>
                            <button type="button" onclick="cerrar()">
                                X
                            </button>
                            <%
                                }
                            %>
                            
                            <%
                                }else{
                            %>
                            <%
                                if(request.getAttribute("codprov")!=null){   
                            %>
                            
                            <%=request.getAttribute("codprov")%>
                            
                            <%
                                if(request.getAttribute("objeto")!=null){
                            %>
                            <button type="button" onclick="Busqueda()" disabled>
                                Buscar
                            </button>
                            <%
                                }else{
                            %>
                            <button type="button" onclick="Busqueda()">
                                Buscar
                            </button>
                            <%
                                }
                            %>
                            
                            <%
                                    }
                                }
                            %>
                        </td>
                        <td>Departamento</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <select name="cbDepartamento" onchange="listarProvincias()" disabled>
                                <option value="<%=objProv.getCodDepartamento()%>"><%=objProv.getNomDepartamento()%></option>
                            </select>
                            
                            <%
                                }else{
                            %>
                            <select name="cbDepartamento" onchange="listarProvincias()" disabled>
                                <option value=0>--Seleccionar--</option>
                            </select>
                            <%
                                }
                               }else if(request.getAttribute("objeto")!=null){
                            %>
                            <select name="cbDepartamento" onchange="listarProvincias()" disabled>
                                
                                <%
                                    if(request.getAttribute("coddep")!=null)
                                    {
                                        
                                %>
                                        <option value=0>--Seleccionar--</option>
                                <%
                                    if(request.getAttribute("listadepartamentos")!=null)
                                    for(DepartamentoBEAN obj:listadep){
                                %>

                                <%
                                    if(obj.getCodDepartamento()==coddep)
                                    {

                                %>

                                <option value="<%=obj.getCodDepartamento()%>" selected><%=obj.getNombre()%></option>

                                <%
                                    }
                                    else
                                    {

                                %>

                                <option value="<%=obj.getCodDepartamento()%>"><%=obj.getNombre()%></option>
                                <%
                                    }
                                   }

                                %>

                                <%
                                    }
                                    else
                                    {
                                %>

                                    <option value=0 selected>--Seleccionar--</option>

                                <%
                                    if(request.getAttribute("listadepartamentos")!=null)
                                    for(DepartamentoBEAN obj:listadep){
                                %>

                                <option value="<%=obj.getCodDepartamento()%>"><%=obj.getNombre()%></option>

                                <%
                                      }
                                    }
                                %>

                            </select>
                                
                            
                            <%
                                }else{
                            %>
                            <select name="cbDepartamento" onchange="listarProvincias()">
                                
                                <%
                                    if(request.getAttribute("coddep")!=null)
                                    {
                                        
                                %>
                                        <option value=0>--Seleccionar--</option>
                                <%
                                    if(request.getAttribute("listadepartamentos")!=null)
                                    for(DepartamentoBEAN obj:listadep){
                                %>

                                <%
                                    if(obj.getCodDepartamento()==coddep)
                                    {

                                %>

                                <option value="<%=obj.getCodDepartamento()%>" selected><%=obj.getNombre()%></option>

                                <%
                                    }
                                    else
                                    {

                                %>

                                <option value="<%=obj.getCodDepartamento()%>"><%=obj.getNombre()%></option>
                                <%
                                    }
                                   }

                                %>

                                <%
                                    }
                                    else
                                    {
                                %>

                                    <option value=0 selected>--Seleccionar--</option>

                                <%
                                    if(request.getAttribute("listadepartamentos")!=null)
                                    for(DepartamentoBEAN obj:listadep){
                                %>

                                <option value="<%=obj.getCodDepartamento()%>"><%=obj.getNombre()%></option>

                                <%
                                      }
                                    }
                                %>

                            </select>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td>Nombre de Proveedor:</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <input type="text" name="txtNom" value="<%=objProv.getNombre()%>" disabled>
                            <%
                                }else{
                            %>   
                            <input type="text" name="txtNom" disabled>
                            
                            <%
                                }
                                }else if(request.getAttribute("objeto")!=null){
                            %>
                                <input type="text" name="txtNom" value="<%=prov.getNombre()%>" disabled>
                            <%
                                }else if(request.getAttribute("nom")!=null){
                            %>
                                <input type="text" name="txtNom" value="<%=nom%>" >
                            <%
                                }else{
                            %>
                            
                            <input type="text" name="txtNom">
                            
                            <%
                                }
                            %>
                        </td>
                        <td>Provincia:</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <select name="cbProvincia" onchange="listarDistritos()" disabled>
                                <option value="<%=objProv.getCodProvincia()%>"><%=objProv.getNomProvincia()%></option>
                            </select>
                            
                            <%
                                }else{
                            %>
                            <select name="cbProvincia" onchange="listarDistritos()" disabled>
                                <option value=0>--Seleccionar--</option>
                            </select>
                               
          
                            <%
                                }
                                }else if(request.getAttribute("objeto")!=null){
                            %>
                            <select name="cbProvincia" onchange="listarDistritos()" disabled>
                                
                                <%
                                    if(request.getAttribute("codpro")!=null)
                                    {
                                        
                                %>
                                        <option value=0>--Seleccionar--</option>
                                <%
                                    if(request.getAttribute("listaprovincias")!=null)
                                    for(ProvinciaBEAN obj:listapro){
                                %>

                                <%
                                    if(obj.getCodProvincia()==codpro)
                                    {

                                %>

                                <option value="<%=obj.getCodProvincia()%>" selected><%=obj.getNombre()%></option>

                                <%
                                    }
                                    else
                                    {

                                %>

                                <option value="<%=obj.getCodProvincia()%>"><%=obj.getNombre()%></option>
                                <%
                                    }
                                   }

                                %>

                                <%
                                    }
                                    else
                                    {
                                %>

                                    <option value=0 selected>--Seleccionar--</option>

                                <%
                                    if(request.getAttribute("listaprovincias")!=null)
                                    for(ProvinciaBEAN obj:listapro){
                                %>

                                <option value="<%=obj.getCodProvincia()%>"><%=obj.getNombre()%></option>

                                <%
                                      }
                                    }
                                %>

                            </select>
                            <%
                                }else{
                            %>
                            <select name="cbProvincia" onchange="listarDistritos()">
                                
                                <%
                                    if(request.getAttribute("codpro")!=null)
                                    {
                                        
                                %>
                                        <option value=0>--Seleccionar--</option>
                                <%
                                    if(request.getAttribute("listaprovincias")!=null)
                                    for(ProvinciaBEAN obj:listapro){
                                %>

                                <%
                                    if(obj.getCodProvincia()==codpro)
                                    {

                                %>

                                <option value="<%=obj.getCodProvincia()%>" selected><%=obj.getNombre()%></option>

                                <%
                                    }
                                    else
                                    {

                                %>

                                <option value="<%=obj.getCodProvincia()%>"><%=obj.getNombre()%></option>
                                <%
                                    }
                                   }

                                %>

                                <%
                                    }
                                    else
                                    {
                                %>

                                    <option value=0 selected>--Seleccionar--</option>

                                <%
                                    if(request.getAttribute("listaprovincias")!=null)
                                    for(ProvinciaBEAN obj:listapro){
                                %>

                                <option value="<%=obj.getCodProvincia()%>"><%=obj.getNombre()%></option>

                                <%
                                      }
                                    }
                                %>

                            </select>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td>RUC</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <input name="txtRuc" type="text" value="<%=objProv.getRuc()%>" disabled>
                            <%
                                }else{
                            %>
                            <input type="text" name="txtRuc" disabled>
                            <%
                                }
                                }else if(request.getAttribute("objeto")!=null){
                            %>
                                <input type="text" name="txtRuc" value="<%=prov.getRuc()%>" disabled>
                            <%
                                }else if(request.getAttribute("ruc")!=null){
                            %>
                                <input type="text" name="txtRuc" value="<%=ruc%>">
                                
                            <%
                                }else{
                            %>
                            
                            <input type="text" name="txtRuc">
                            <%
                                }
                            %>
                        </td>
                        <td>
                            Distrito:
                        </td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <select name="cbDistrito" disabled>
                                <option value="<%=objProv.getCodDistrito()%>"><%=objProv.getNomDistrito()%></option>
                            </select>
                            
                            <%
                                }else{
                            %>
                            <select name="cbDistrito" disabled>
                                <option value=0>--Seleccionar--</option>
                            </select>
                            <%
                                }
                              }else  if(request.getAttribute("objeto")!=null){
                            %>
                            <select name="cbDistrito" disabled>
                                
                                <%
                                    if(request.getAttribute("coddis")!=null)
                                    {
                                        
                                %>
                                        <option value=0>--Seleccionar--</option>
                                <%
                                    if(request.getAttribute("listadistritos")!=null)
                                    for(DistritoBEAN obj:listadis){
                                %>

                                <%
                                    if(obj.getCodDistrito()==coddis)
                                    {

                                %>

                                <option value="<%=obj.getCodDistrito()%>" selected><%=obj.getNombre()%></option>

                                <%
                                    }
                                    else
                                    {

                                %>

                                <option value="<%=obj.getCodDistrito()%>"><%=obj.getNombre()%></option>
                                <%
                                    }
                                   }

                                %>

                                <%
                                    }
                                    else
                                    {
                                %>

                                    <option value=0 selected>--Seleccionar--</option>

                                <%
                                    if(request.getAttribute("listadistritos")!=null)
                                    for(DistritoBEAN obj:listadis){
                                %>

                                <option value="<%=obj.getCodDistrito()%>"><%=obj.getNombre()%></option>

                                <%
                                      }
                                    }
                                %>

                            </select>
                            <%
                                }else{
                            %>
                            <select name="cbDistrito">
                                
                                <%
                                    if(request.getAttribute("coddis")!=null)
                                    {
                                        
                                %>
                                        <option value=0>--Seleccionar--</option>
                                <%
                                    if(request.getAttribute("listadistritos")!=null)
                                    for(DistritoBEAN obj:listadis){
                                %>

                                <%
                                    if(obj.getCodDistrito()==coddis)
                                    {

                                %>

                                <option value="<%=obj.getCodDistrito()%>" selected><%=obj.getNombre()%></option>

                                <%
                                    }
                                    else
                                    {

                                %>

                                <option value="<%=obj.getCodDistrito()%>"><%=obj.getNombre()%></option>
                                <%
                                    }
                                   }

                                %>

                                <%
                                    }
                                    else
                                    {
                                %>

                                    <option value=0 selected>--Seleccionar--</option>

                                <%
                                    if(request.getAttribute("listadistritos")!=null)
                                    for(DistritoBEAN obj:listadis){
                                %>

                                <option value="<%=obj.getCodDistrito()%>"><%=obj.getNombre()%></option>

                                <%
                                      }
                                    }
                                %>

                            </select>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <input name="txtEmail" type="text" value="<%=objProv.getEmail()%>" disabled>
                            <%
                                }else{
                            %>
                            
                            <input type="email" name="txtEmail" disabled>
                            
                            <%
                                }
                                }else if(request.getAttribute("objeto")!=null){
                            %>
                            <input type="email" name="txtEmail" value="<%=prov.getEmail()%>" disabled>
                            <%
                                }else if(request.getAttribute("email")!=null){
                            %>
                            
                            <input type="email" name="txtEmail" value="<%=email%>">
                            <%
                                }else{
                            %>
                            <input type="email" name="txtEmail">
                            <%
                                }
                            %>
                            
                        </td>
                        <td>Calle:</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <input name="txtCalle" type="text" value="<%=objProv.getCalle()%>" disabled>
                            <%
                                }else{
                            %>
                            <input type="text" name="txtCalle" disabled>
                            <%
                                }
                              }else  if(request.getAttribute("objeto")!=null){
                            %>
                            <input type="text" name="txtCalle" value="<%=prov.getCalle()%>" disabled>
                            <%
                                }else if(request.getAttribute("calle")!=null){
                            %>
                            <input type="text" name="txtCalle" value="<%=calle%>">
                            <%
                                }else{
                            %>
                            <input type="text" name="txtCalle">
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td>Teléfono:</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <input name="txtTel" type="text" value="<%=objProv.getTelefono()%>" disabled>
                            <%
                                }else{
                            %>
                            <input type="tel" name="txtTel" disabled>
                            <%
                                }
                              }else  if(request.getAttribute("objeto")!=null){
                            %>
                            <input type="tel" name="txtTel" value="<%=prov.getTelefono()%>" disabled>
                            <%
                                }else if(request.getAttribute("tel")!=null){
                            %>
                            <input type="tel" name="txtTel" value="<%=tel%>">
                            <%
                                }else{
                            %>
                            <input type="tel" name="txtTel">
                            <%
                                }
                            %> 
                        </td>
                        <td>Número Externo:</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <input name="txtNumExt" type="text" value="<%=objProv.getNumExterno()%>" disabled>
                            <%
                                }else{
                            %>
                            <input type="text" name="txtNumExt" disabled>
                            <%
                                }
                                }else  if(request.getAttribute("objeto")!=null){
                            %>
                            <input type="text" name="txtNumExt" value="<%=prov.getNumExterno()%>" disabled>
                            <%
                                }else if(request.getAttribute("nume")!=null){
                            %>
                            <input type="text" name="txtNumExt" value="<%=nume%>">
                            <%
                                }else{
                            %>
                            <input type="text" name="txtNumExt">
                            <%
                                }
                            %> 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"></td>
                        <td>Número Interno:</td>
                        <td>
                            <%if(request.getAttribute("listaproveedor")!=null){
                                if(request.getAttribute("objetoProv")!=null){
                            %>
                            <input name="txtNumInt" type="text" value="<%=objProv.getNumInterno()%>" disabled>
                            <%
                                }else{
                            %>
                            
                            <input type="text" name="txtNumInt" disabled>
                            <%
                                }
                              }else  if(request.getAttribute("objeto")!=null){
                            %>
                            <input type="text" name="txtNumInt" value="<%=prov.getNumInterno()%>" disabled>
                            
                            <%
                                }else if(request.getAttribute("numi")!=null){
                            %>
                            <input type="text" name="txtNumInt" value="<%=numi%>" >
                            
                            <%
                                }else{
                            %>
                            <input type="text" name="txtNumInt">
                            <%
                                }
                            %> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%
                                if(request.getAttribute("objeto")!=null || request.getAttribute("listaproveedor")!=null){
                            %>
                            <button type="button" onclick="guardar()" disabled>
                                Guardar
                            </button>
                            <%
                                }else{
                            %>
                            <button type="button" onclick="guardar()">
                                Guardar
                            </button>
                            <%
                                }
                            %>
                        </td>
                        <td>
                            <%
                                if(request.getAttribute("objeto")!=null || request.getAttribute("listaproveedor")!=null){
                            %>
                            <button type="button" onclick="cancelar()" disabled>
                                Cancelar
                            </button>
                            <%
                                }else{
                            %>
                            
                            <button type="button" onclick="cancelar()">
                                Cancelar
                            </button>
                            <%
                                }
                            %>
                        </td>
                        <td>
                            <%
                                if(request.getAttribute("objeto")!=null || request.getAttribute("listaproveedor")!=null){
                            %>
                            <button type="button" onclick="detallar('oculto')" >
                                Ir Cotización
                            </button>
                            <%
                                }else{
                            %>
                            <button type="button" onclick="detallar('oculto')" disabled>
                                Ir Cotización
                            </button>
                            <%
                                }
                            %> 
                        </td>
                        <td>
                            <center>
                                <button type="button" onclick="retornar()">
                                    Retornar
                                </button>
                            </center>
                        </td>
                    </tr>
                </table>
                <div id="oculto"></div>
                <div id="oculto2"></div>
            </center>
        </form>
    </body>
</html>

