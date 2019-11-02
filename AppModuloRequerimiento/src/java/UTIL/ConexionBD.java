
package UTIL;
import java.sql.*;

public class ConexionBD {

    private Connection conexion;
    
    public Connection getConexionBD()
    {
        conexion=null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/dbferreteria","root","Lacronfonso");
            System.out.println("Conexión exitosa");
            
        } 
        catch (Exception e) 
        {
            System.out.println("Conexión errónea");
        }
        
        return conexion;
    }
    
    public static void main(String[] args) 
    {
        ConexionBD obj=new ConexionBD();
        obj.getConexionBD();
    }
    
}
