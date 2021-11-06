package autentificación.conexion;

import java.sql.*;

public class conexion{
private java.sql.Connection DBConn;
Statement stGetCount;


public Connection    Get_conexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
{
            
    String controlador = "com.mysql.jdbc.Driver";
    Object newInstance = Class.forName(controlador).newInstance();
    String URL_bd = "jdbc:mysql://localhost:3306/ejemplo-basico-java-swing";
    String usuario = "root";
    String contraseña = "";

try{
DBConn = java.sql.DriverManager.getConnection(URL_bd,usuario,contraseña);
stGetCount = DBConn.createStatement();
}
catch ( Exception e ){
System.out.println(e.getMessage()+ "No se puede establecer conexión");
}
return DBConn;
}

public void cerrarConexion() 
{
    try {
   if (stGetCount != null) stGetCount.close();
   if (DBConn != null) DBConn.close();
   }catch (SQLException  sqle){
                                       
    }
}

}
