
package DAO;

import BEAN.CatalogoBEAN;
import UTIL.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CatalogoDAO 
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<CatalogoBEAN> lista;
    
    public int consultarExistenciaCatalogo()
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM CATALOGO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                cont++;
            }
            
        } catch (Exception e) {}
        
        return cont;
    }
    
    public String retornarNumeroCatalogo(CatalogoBEAN cat)
    {
        String cod="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT NUM_CATALOGO FROM CATALOGO WHERE COD_PROVEEDOR=? AND COD_PRODUCTO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, cat.getCodProveedor());
            instruccion.setString(2, cat.getCodProducto());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                cod=tabla.getString(1); 
            }
        } 
        catch (Exception e) 
        {}
        
        return cod;
    }
    
    public String capturarCodigoCatalogo()
    {
        String cod="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT MAX(NUM_CATALOGO)+1 FROM CATALOGO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                cod=tabla.getString(1);
            }
            
        } catch (Exception e) {}
        
        return cod;
    }
    
    public void agregarCatalogo(CatalogoBEAN cat)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO CATALOGO VALUES (?,?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cat.getNumCatalogo());
            instruccion.setString(2,cat.getCodProducto());
            instruccion.setString(3,cat.getCodProveedor());
            instruccion.setString(4,cat.getFechaRegistro());
            instruccion.setDouble(5,cat.getCostoUnitario());
            instruccion.setString(6,cat.getUnidadMedida());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public void modificarCatalogo(CatalogoBEAN cat)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="UPDATE CATALOGO SET COSTO_UNITARIO=?,UNIDAD_MEDIDA=? ";
            sql+="WHERE NUM_CATALOGO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setDouble(1,cat.getCostoUnitario());
            instruccion.setString(2,cat.getUnidadMedida());
            instruccion.setString(3,cat.getNumCatalogo());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public void eliminarCatalogo(CatalogoBEAN cat)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="DELETE FROM CATALOGO WHERE COD_PROVEEDOR=? AND COD_PRODUCTO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cat.getCodProveedor());
            instruccion.setString(2,cat.getCodProducto());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
}
