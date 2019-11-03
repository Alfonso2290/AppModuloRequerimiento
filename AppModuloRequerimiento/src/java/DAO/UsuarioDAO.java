
package DAO;

import java.sql.*;
import UTIL.ConexionBD;
import BEAN.UsuarioBEAN;
import java.util.*;

public class UsuarioDAO 
{
    ConexionBD conexion=null;
    PreparedStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<UsuarioBEAN> lista;
    
    public void registrarUsuario(UsuarioBEAN usu){
        
        try {
            conexion=new ConexionBD();
            sql="INSERT INTO USUARIO(NOMBRE,CONTRASEÑA,TIPO) VALUES (?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usu.getNombreUsuario());
            instruccion.setString(2, usu.getClave());
            instruccion.setString(3, usu.getTipoUsuario());
            instruccion.executeUpdate();
            
        } catch (Exception e) {
        }
        
    }
    
    public int verificarNombreUsuario(String nombreUsuario){
        
        int i=0;
        try {
            
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) FROM USUARIO WHERE NOMBRE=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql); 
            instruccion.setString(1, nombreUsuario);
            tabla=instruccion.executeQuery();
            
            if(tabla.next()){
                
                i=tabla.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return i;
    }
    
    public int verificarCuentaUsuario(UsuarioBEAN usu){
        
        int i=0;
        try {
            
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) FROM USUARIO WHERE NOMBRE=? AND CONTRASEÑA=? AND TIPO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql); 
            instruccion.setString(1, usu.getNombreUsuario());
            instruccion.setString(2, usu.getClave());
            instruccion.setString(3, usu.getTipoUsuario());
            tabla=instruccion.executeQuery();
            
            if(tabla.next()){
                
                i=tabla.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return i;
    }
}
