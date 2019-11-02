
package DAO;
import BEAN.DepartamentoBEAN;
import BEAN.ProvinciaBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
public class ProvinciaDAO 
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<ProvinciaBEAN> lista;
    
    public ArrayList<ProvinciaBEAN> listarProvincias(DepartamentoBEAN dep)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DISTINCT COD_PROVINCIA,NOMBRE FROM PROVINCIA ";
            sql+="WHERE COD_DEPARTAMENTO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setInt(1,dep.getCodDepartamento());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<ProvinciaBEAN>();
            
            while(tabla.next())
            {
                ProvinciaBEAN pro=new ProvinciaBEAN();
                pro.setCodProvincia(tabla.getInt(1));
                pro.setNombre(tabla.getString(2));
                
                lista.add(pro);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
}
