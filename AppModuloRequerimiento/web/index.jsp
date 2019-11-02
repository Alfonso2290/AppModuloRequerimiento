
<html>
    <head>
        <title>Pagina Inicio</title>
        <script>
           function ingresarCotizacion()
           {
               document.form.action="<%=request.getContextPath()%>/RequerimientoServlet";
               document.form.method="POST";
               document.form.op.value=1;
               document.form.submit();
           }
       </script>
    </head>
    <body>
        <form name="form">
            <input type="hidden" name="op">
            <center>
                <table cellpadding="5">
                    <tr>
                        <td>Seleccione Operación</td>
                    </tr>
                    <tr>
                        <td>
                            <center>
                                <button type="button" onclick="ingresarCotizacion()">
                                    Cotización
                                </button>
                            </center>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <center>
                                <button type="button">
                                    Requerimiento
                                </button>
                            </center>
                        </td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>
