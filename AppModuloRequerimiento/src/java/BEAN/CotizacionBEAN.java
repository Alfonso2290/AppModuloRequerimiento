
package BEAN;

public class CotizacionBEAN 
{
    private String nomProveedor,codCotizacion,codProveedor,fechaRegistro,estado,fechaLimite;
    private double importeTotal;

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public String getCodCotizacion() {
        return codCotizacion;
    }

    public String getCodProveedor() {
        return codProveedor;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setCodCotizacion(String codCotizacion) {
        this.codCotizacion = codCotizacion;
    }

    public void setCodProveedor(String codProveedor) {
        this.codProveedor = codProveedor;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
    
}
