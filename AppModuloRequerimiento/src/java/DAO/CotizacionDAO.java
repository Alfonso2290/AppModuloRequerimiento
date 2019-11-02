
package DAO;
import BEAN.CotizacionBEAN;
import BEAN.DetalleCotizacionBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;


public class CotizacionDAO 
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<CotizacionBEAN> listacot;
    
    public ArrayList<CotizacionBEAN> listarCotizacion()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DISTINCT A.COD_COTIZACION,B.NOMBRE,A.IMPORTE_TOTAL,A.FECHA_REGISTRO,A.FECHA_LIMITE,A.ESTADO,A.COD_PROVEEDOR ";
            sql+="FROM COTIZACION A INNER JOIN PROVEEDOR B ";
            sql+="ON A.COD_PROVEEDOR=B.COD_PROVEEDOR ";
            sql+="WHERE A.ESTADO='BORRADOR' OR A.ESTADO='OBSERVADO' OR A.ESTADO='ENVIADO' ";
            sql+="ORDER BY A.COD_COTIZACION";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            listacot=new ArrayList<CotizacionBEAN>();
            
            while(tabla.next())
            {
                CotizacionBEAN obj=new CotizacionBEAN();
                obj.setCodCotizacion(tabla.getString(1));
                obj.setNomProveedor(tabla.getString(2));
                obj.setImporteTotal(tabla.getDouble(3));
                obj.setFechaRegistro(tabla.getString(4));
                obj.setFechaLimite(tabla.getString(5));
                obj.setEstado(tabla.getString(6));
                obj.setCodProveedor(tabla.getString(7));
                listacot.add(obj);
            }
            
        } catch (Exception e) {}
        
        return listacot;
    }
    
    public CotizacionBEAN listarRegistroCotizacion(String codcot)
    {
        CotizacionBEAN obj=null;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DISTINCT A.COD_COTIZACION,B.NOMBRE,A.IMPORTE_TOTAL,A.FECHA_REGISTRO,A.FECHA_LIMITE,A.ESTADO ";
            sql+="FROM COTIZACION A INNER JOIN PROVEEDOR B ";
            sql+="ON A.COD_PROVEEDOR=B.COD_PROVEEDOR ";
            sql+="WHERE COD_COTIZACION=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, codcot);
            tabla=instruccion.executeQuery();
            obj=new CotizacionBEAN();
            
            while(tabla.next())
            {
                
                obj.setCodCotizacion(tabla.getString(1));
                obj.setNomProveedor(tabla.getString(2));
                obj.setImporteTotal(tabla.getDouble(3));
                obj.setFechaRegistro(tabla.getString(4));
                obj.setFechaLimite(tabla.getString(5));
                obj.setEstado(tabla.getString(6));
                
                
            }
            
        } catch (Exception e) {}
        
        return obj;
    }
    
    public int consultarExistenciaCotizacion()
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM COTIZACION";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                cont++;
            }
            
        } catch (Exception e) {}
        
        return cont;
    }
    
    public void actualizarEstado(CotizacionBEAN cot)
    {
        
        try 
        {
            conexion=new ConexionBD();
            sql="UPDATE COTIZACION SET ESTADO=? WHERE COD_COTIZACION=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cot.getEstado());
            instruccion.setString(2,cot.getCodCotizacion());
            instruccion.executeUpdate();

        }
        catch (Exception e) 
        {}   
    }
    
    public String capturarCodigoCotizacion()
    {
        String codcot="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT MAX(COD_COTIZACION)+1 FROM COTIZACION";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                codcot=tabla.getString(1);
            }
            
        } catch (Exception e) {}
        
        return codcot;
    }
    
    public void modificarCotizacion(CotizacionBEAN cot)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="UPDATE COTIZACION SET COD_PROVEEDOR=?,FECHA_REGISTRO=?,ESTADO=?,";
            sql+="FECHA_LIMITE=? ";
            sql+="WHERE COD_COTIZACION=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cot.getCodProveedor());
            instruccion.setString(2,cot.getFechaRegistro());
            instruccion.setString(3,cot.getEstado());
            instruccion.setString(4,cot.getFechaLimite());
            instruccion.setString(5,cot.getCodCotizacion());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public double RetornarImporteTotal(CotizacionBEAN det)
    {
        double it=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT SUM(B.IMPORTE_PARCIAL) FROM COTIZACION A INNER JOIN DETALLE_COTIZACION B ";
            sql+="ON A.COD_COTIZACION=B.COD_COTIZACION ";
            sql+="WHERE A.COD_COTIZACION=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,det.getCodCotizacion());
            tabla=instruccion.executeQuery();
            if(tabla.next() && tabla.getDouble(1)!=0)
            {
                it=tabla.getDouble(1);
            }
        } 
        catch (Exception e) 
        {}
        
        return it;
    }
    
    public void actualizarCotizacionEnviada(CotizacionBEAN cot)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="UPDATE COTIZACION SET ESTADO=?,IMPORTE_TOTAL=? WHERE COD_COTIZACION=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cot.getEstado());
            instruccion.setDouble(2,cot.getImporteTotal());
            instruccion.setString(3,cot.getCodCotizacion());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public String capturarCodigoProveedor(String codcot)
    {
        String codprov="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COD_PROVEEDOR FROM COTIZACION WHERE COD_COTIZACION=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,codcot);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                codprov=tabla.getString(1);
            }
            
        } catch (Exception e) {}
        
        return codprov;
    }
    public void agregarCotizacion(CotizacionBEAN cot)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO COTIZACION(COD_COTIZACION,COD_PROVEEDOR,FECHA_REGISTRO,ESTADO,FECHA_LIMITE) VALUES (?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cot.getCodCotizacion());
            instruccion.setString(2,cot.getCodProveedor());
            instruccion.setString(3,cot.getFechaRegistro());
            instruccion.setString(4,cot.getEstado());
            instruccion.setString(5,cot.getFechaLimite());
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public int eliminarCotizacion(CotizacionBEAN cot)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="DELETE FROM COTIZACION WHERE COD_COTIZACION=? ";
            sql+="AND ESTADO='BORRADOR' ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cot.getCodCotizacion());
            i=instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
        return i;
    }
    
    public String getEstado(String codigo){
        String estado="";
        
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT ESTADO FROM COTIZACION WHERE COD_COTIZACION=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,codigo);
            tabla=instruccion.executeQuery();
            
            if(tabla.next()){
                
                estado=tabla.getString(1);
            }
            
        } 
        catch (Exception e) {}
        
        return estado;
    }
    
    public double getImporteTotal(String codigo){
        double importe=0;
        
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT IMPORTE_TOTAL FROM COTIZACION WHERE COD_COTIZACION=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,codigo);
            tabla=instruccion.executeQuery();
            
            if(tabla.next()){
                
                importe=tabla.getDouble(1);
            }
            
        } 
        catch (Exception e) {}
        
        return importe;
    }
    
    
}
