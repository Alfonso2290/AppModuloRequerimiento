
package DAO;
import BEAN.CotizacionBEAN;
import BEAN.DetalleCotizacionBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class DetalleCotizacionDAO
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<DetalleCotizacionBEAN> listacot;
    
    public ArrayList<DetalleCotizacionBEAN> listarDetalleCotizacion(CotizacionBEAN cot)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DISTINCT A.COD_PRODUCTO,A.NOMBRE,B.UNIDAD_MEDIDA,B.CANTIDAD,B.PRECIO_UNITARIO,B.IMPORTE_PARCIAL ";
            sql+="FROM PRODUCTO A INNER JOIN DETALLE_COTIZACION B ";
            sql+="ON A.COD_PRODUCTO=B.COD_PRODUCTO ";
            sql+="WHERE B.COD_COTIZACION=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cot.getCodCotizacion());
            tabla=instruccion.executeQuery();
            listacot=new ArrayList<DetalleCotizacionBEAN>();
            
            while(tabla.next())
            {
                DetalleCotizacionBEAN det=new DetalleCotizacionBEAN();
                det.setCodProducto(tabla.getString(1));
                det.setNomProducto(tabla.getString(2));
                det.setUnidadMedida(tabla.getString(3));
                det.setCantidad(tabla.getInt(4));
                det.setPrecioUnitario(tabla.getDouble(5));
                det.setImporteParcial(tabla.getDouble(6));
                
                listacot.add(det);
            }
            
        } catch (Exception e) {}
        
        return listacot;
    }
    
    public String fechaActual()
    {
        String fecha="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT CURDATE()";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            if(tabla.next())
            {
                fecha=tabla.getString(1);
            }
        } 
        catch (Exception e) 
        {}
        
        return fecha;
    }
    
    public void agregarDetalleCotizacion(DetalleCotizacionBEAN det)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO DETALLE_COTIZACION VALUES (?,?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,det.getCodProducto());
            instruccion.setString(2,det.getCodCotizacion());
            instruccion.setInt(3,det.getCantidad());
            instruccion.setDouble(4,det.getPrecioUnitario());
            instruccion.setDouble(5,det.getImporteParcial());
            instruccion.setString(6,det.getUnidadMedida());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public void eliminarDetalleCotizacion(DetalleCotizacionBEAN det)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="DELETE FROM DETALLE_COTIZACION WHERE COD_COTIZACION=? AND COD_PRODUCTO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,det.getCodCotizacion());
            instruccion.setString(2,det.getCodProducto());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public void modificarDetalleCotizacion(DetalleCotizacionBEAN det)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="UPDATE DETALLE_COTIZACION SET CANTIDAD=?,PRECIO_UNITARIO=?,";
            sql+="IMPORTE_PARCIAL=?,UNIDAD_MEDIDA=? ";
            sql+="WHERE COD_PRODUCTO=? AND COD_COTIZACION=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setInt(1,det.getCantidad());
            instruccion.setDouble(2,det.getPrecioUnitario());
            instruccion.setDouble(3,det.getImporteParcial());
            instruccion.setString(4,det.getUnidadMedida());
            instruccion.setString(5,det.getCodProducto());
            instruccion.setString(6,det.getCodCotizacion());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public DetalleCotizacionBEAN retornarObjeto(DetalleCotizacionBEAN det)
    {
        DetalleCotizacionBEAN obj=null;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT A.*,B.NOMBRE ";
            sql+="FROM DETALLE_COTIZACION A INNER JOIN PRODUCTO B ";
            sql+="ON A.COD_PRODUCTO=B.COD_PRODUCTO ";
            sql+="WHERE A.COD_COTIZACION=? AND A.COD_PRODUCTO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, det.getCodCotizacion());
            instruccion.setString(2, det.getCodProducto());
            tabla=instruccion.executeQuery();
            obj=new DetalleCotizacionBEAN();
            while(tabla.next())
            {
                obj.setCodProducto(tabla.getString(1));
                obj.setCodCotizacion(tabla.getString(2));
                obj.setCantidad(tabla.getInt(3));
                obj.setPrecioUnitario(tabla.getDouble(4));
                obj.setImporteParcial(tabla.getDouble(5));
                obj.setUnidadMedida(tabla.getString(6));
                obj.setNomProducto(tabla.getString(7));
            }
        } 
        catch (Exception e) 
        {}
        
        return obj;
    }
}
