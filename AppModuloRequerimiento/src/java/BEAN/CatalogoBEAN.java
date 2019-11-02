
package BEAN;

public class CatalogoBEAN 
{
    private String numCatalogo,codProducto,codProveedor,fechaRegistro,unidadMedida;
    private double costoUnitario;

    public String getNumCatalogo() {
        return numCatalogo;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public String getCodProveedor() {
        return codProveedor;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setNumCatalogo(String numCatalogo) {
        this.numCatalogo = numCatalogo;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public void setCodProveedor(String codProveedor) {
        this.codProveedor = codProveedor;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    
}
