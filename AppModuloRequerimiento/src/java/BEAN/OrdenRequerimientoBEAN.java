
package BEAN;

public class OrdenRequerimientoBEAN
{
    private String codOrdenRequerimiento,codCotizacion,fechaRegistro,estado;

    public String getCodOrdenRequerimiento() {
        return codOrdenRequerimiento;
    }

    public String getCodCotizacion() {
        return codCotizacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodOrdenRequerimiento(String codOrdenRequerimiento) {
        this.codOrdenRequerimiento = codOrdenRequerimiento;
    }

    public void setCodCotizacion(String codCotizacion) {
        this.codCotizacion = codCotizacion;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
