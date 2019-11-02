
package DAO;

import BEAN.ProductoBEAN;
import UTIL.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO 
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<ProductoBEAN> lista;
    
    public int consultarExistenciaProducto()
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM PRODUCTO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                cont++;
            }
            
        } catch (Exception e) {}
        
        return cont;
    }
    
    public ArrayList<ProductoBEAN> listarProductoComboBox()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COD_PRODUCTO,NOMBRE FROM PRODUCTO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<ProductoBEAN>();
            
            while(tabla.next())
            {
                ProductoBEAN prod=new ProductoBEAN();
                prod.setCodProducto(tabla.getString(1));
                prod.setNombre(tabla.getString(2));
                
                lista.add(prod);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
    
    public ProductoBEAN listarRegistroProducto(String codprod)
    {
        ProductoBEAN prod=null;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM PRODUCTO ";
            sql+="WHERE COD_PRODUCTO=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,codprod);
            tabla=instruccion.executeQuery();
            
            
            while(tabla.next())
            {
                prod=new ProductoBEAN();
                prod.setCodProducto(tabla.getString(1));
                prod.setNombre(tabla.getString(2));
            }
            
        } catch (Exception e) {}
        
        return prod;
    }
    
    public String capturarCodigoProducto()
    {
        String cod="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT MAX(COD_PRODUCTO)+1 FROM PRODUCTO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                cod=tabla.getString(1);
            }
            
        } catch (Exception e) {}
        
        return cod;
    }
    
    public void agregarProductoRequerido(ProductoBEAN prod)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO PRODUCTO VALUES (?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,prod.getCodProducto());
            instruccion.setString(2,prod.getNombre());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
}
