
package DAO;
import BEAN.DepartamentoBEAN;
import BEAN.DistritoBEAN;
import BEAN.ProvinciaBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class DistritoDAO 
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<DistritoBEAN> lista;
    
    public ArrayList<DistritoBEAN> listarDistritos(DepartamentoBEAN dep,ProvinciaBEAN pro)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DISTINCT COD_DISTRITO,NOMBRE FROM DISTRITO ";
            sql+="WHERE COD_DEPARTAMENTO=? AND COD_PROVINCIA=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setInt(1,dep.getCodDepartamento());
            instruccion.setInt(2,pro.getCodProvincia());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<DistritoBEAN>();
            
            while(tabla.next())
            {
                DistritoBEAN dis=new DistritoBEAN();
                dis.setCodDistrito(tabla.getInt(1));
                dis.setNombre(tabla.getString(2));
                
                lista.add(dis);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
}
