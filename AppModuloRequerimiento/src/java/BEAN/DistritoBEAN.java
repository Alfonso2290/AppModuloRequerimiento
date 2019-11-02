
package BEAN;

public class DistritoBEAN 
{
    private int codDepartamento,codProvincia,codDistrito;
    private String nombre;

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public void setCodProvincia(int codProvincia) {
        this.codProvincia = codProvincia;
    }

    public void setCodDistrito(int codDistrito) {
        this.codDistrito = codDistrito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public int getCodProvincia() {
        return codProvincia;
    }

    public int getCodDistrito() {
        return codDistrito;
    }

    public String getNombre() {
        return nombre;
    }
    
}
