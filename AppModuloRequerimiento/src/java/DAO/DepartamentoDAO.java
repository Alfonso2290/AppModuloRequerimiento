
package DAO;
import BEAN.DepartamentoBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
public class DepartamentoDAO 
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<DepartamentoBEAN> lista;
    
    public ArrayList<DepartamentoBEAN> listarDepartamentos()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DISTINCT COD_DEPARTAMENTO,NOMBRE FROM DEPARTAMENTO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<DepartamentoBEAN>();
            
            while(tabla.next())
            {
                DepartamentoBEAN dep=new DepartamentoBEAN();
                dep.setCodDepartamento(tabla.getInt(1));
                dep.setNombre(tabla.getString(2));
                
                lista.add(dep);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
}
