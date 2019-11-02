
package BEAN;

public class DetalleCotizacionBEAN 
{
    private String codProducto,codCotizacion,unidadMedida,nomProducto;
    private int cantidad;
    private double precioUnitario,importeParcial;

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public String getCodCotizacion() {
        return codCotizacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getImporteParcial() {
        return importeParcial;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public void setCodCotizacion(String codCotizacion) {
        this.codCotizacion = codCotizacion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setImporteParcial(double importeParcial) {
        this.importeParcial = importeParcial;
    }
    
}
