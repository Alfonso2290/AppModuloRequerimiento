
package BEAN;

public class OrdenPedidoBEAN 
{
    private String codOrdenPedido,codOrdenRequerimiento,fechaRegistro,estado;

    public String getCodOrdenPedido() {
        return codOrdenPedido;
    }

    public String getCodOrdenRequerimiento() {
        return codOrdenRequerimiento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodOrdenPedido(String codOrdenPedido) {
        this.codOrdenPedido = codOrdenPedido;
    }

    public void setCodOrdenRequerimiento(String codOrdenRequerimiento) {
        this.codOrdenRequerimiento = codOrdenRequerimiento;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
