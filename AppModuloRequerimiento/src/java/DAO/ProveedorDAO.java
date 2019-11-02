package DAO;
import BEAN.ProveedorBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class ProveedorDAO 
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<ProveedorBEAN> listapro;
    
    public int consultarExistenciaProveedor()
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM PROVEEDOR";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                cont++;
            }
            
        } catch (Exception e) {}
        
        return cont;
    }
    
    public String capturarCodigoProveedor()
    {
        String codprov="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT MAX(COD_PROVEEDOR)+1 FROM PROVEEDOR";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                codprov=tabla.getString(1);
            }
            
        } catch (Exception e) {}
        
        return codprov;
    }
    
    public void agregarProveedor(ProveedorBEAN prov)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO PROVEEDOR VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,prov.getCodProveedor());
            instruccion.setString(2,prov.getNombre());
            instruccion.setString(3,prov.getRuc());
            instruccion.setInt(4,prov.getCodDepartamento());
            instruccion.setInt(5,prov.getCodProvincia());
            instruccion.setInt(6,prov.getCodDistrito());
            instruccion.setString(7,prov.getCalle());
            instruccion.setInt(8,prov.getNumExterno());
            instruccion.setInt(9,prov.getNumInterno());
            instruccion.setString(10,prov.getDireccion());
            instruccion.setString(11,prov.getTelefono());
            instruccion.setString(12,prov.getEmail());
            
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
    public void modificarProveedor(ProveedorBEAN prov)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="UPDATE PROVEEDOR SET NOMBRE=?,RUC=?,COD_DEPARTAMENTO=?,COD_PROVINCIA=?,";
            sql+="COD_DISTRITO=?,CALLE=?,NUM_EXTERNO=?,NUM_INTERNO=?,DIRECCION=?, ";
            sql+="TELEFONO=?,EMAIL=? ";
            sql+="WHERE COD_PROVEEDOR=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            
            instruccion.setString(1,prov.getNombre());
            instruccion.setString(2,prov.getRuc());
            instruccion.setInt(3,prov.getCodDepartamento());
            instruccion.setInt(4,prov.getCodProvincia());
            instruccion.setInt(5,prov.getCodDistrito());
            instruccion.setString(6,prov.getCalle());
            instruccion.setInt(7,prov.getNumExterno());
            instruccion.setInt(8,prov.getNumInterno());
            instruccion.setString(9,prov.getDireccion());
            instruccion.setString(10,prov.getTelefono());
            instruccion.setString(11,prov.getEmail());
            instruccion.setString(12,prov.getCodProveedor());
            
            instruccion.executeUpdate();
        } 
        catch (Exception e) {}
        
    }
    
     public String NombreProveedor(String codprov)
    {
        String nom="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT NOMBRE FROM PROVEEDOR WHERE COD_PROVEEDOR=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,codprov);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                nom=tabla.getString(1);
            }
            
        } catch (Exception e) {}
        
        return nom;
    }
    
    public ArrayList<ProveedorBEAN> listarProveedor()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COD_PROVEEDOR,NOMBRE FROM PROVEEDOR";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            listapro=new ArrayList<ProveedorBEAN>();
            
            while(tabla.next())
            {
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCodProveedor(tabla.getString(1));
                prov.setNombre(tabla.getString(2));
                
                listapro.add(prov);
            }
            
        } catch (Exception e) {}
        
        return listapro;
    }
    
    public ProveedorBEAN listarRegistroProveedor(String codprov)
    {
        ProveedorBEAN prov=null;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT A.*,B.NOMBRE,C.NOMBRE,D.NOMBRE ";
            sql+="FROM PROVEEDOR A INNER JOIN DEPARTAMENTO B ";
            sql+="ON A.COD_DEPARTAMENTO=B.COD_DEPARTAMENTO ";
            sql+="INNER JOIN PROVINCIA C ";
            sql+="ON A.COD_PROVINCIA=C.COD_PROVINCIA AND B.COD_DEPARTAMENTO=C.COD_DEPARTAMENTO ";
            sql+="INNER JOIN DISTRITO D ";
            sql+="ON A.COD_DISTRITO=D.COD_DISTRITO AND C.COD_PROVINCIA=D.COD_PROVINCIA AND B.COD_DEPARTAMENTO=D.COD_DEPARTAMENTO ";
            sql+="WHERE COD_PROVEEDOR=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,codprov);
            tabla=instruccion.executeQuery();
            
            
            while(tabla.next())
            {
                prov=new ProveedorBEAN();
                prov.setCodProveedor(tabla.getString(1));
                prov.setNombre(tabla.getString(2));
                prov.setRuc(tabla.getString(3));
                prov.setCodDepartamento(tabla.getInt(4));
                prov.setCodProvincia(tabla.getInt(5));
                prov.setCodDistrito(tabla.getInt(6));
                prov.setCalle(tabla.getString(7));
                prov.setNumExterno(tabla.getInt(8));
                prov.setNumInterno(tabla.getInt(9));
                prov.setDireccion(tabla.getString(10));
                prov.setTelefono(tabla.getString(11));
                prov.setEmail(tabla.getString(12));
                prov.setNomDepartamento(tabla.getString(13));
                prov.setNomProvincia(tabla.getString(14));
                prov.setNomDistrito(tabla.getString(15));
                
                
            }
            
        } catch (Exception e) {}
        
        return prov;
    }
    
   
}

