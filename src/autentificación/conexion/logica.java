package autentificación.conexion;




///////////logica

/*
 * Esta clase hace un ainstancia a conexion y se crearon metodos para interactuar con BD.(insertar....).
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import autentificación.conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class logica{
    
public  java.sql.Connection DBConn;
public  java.sql.Connection close;
private java.sql.Connection GetConexion;
public ResultSet rs;
Statement stGetCount;
private int rst;
ResultSet hay;



public  ResultSet  ConsultaGeneralSQL(String consulta) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
{
conexion conexion = new conexion();   
try {
  DBConn = conexion.Get_conexion();
  stGetCount = DBConn.createStatement();
  rs = stGetCount.executeQuery(consulta);
  }catch (SQLException e) {
  System.out.println("No puede Ejecutar la consulta :" + consulta);
 }//finally {
          // conexion.cerrarConexion();
          //}
return rs;
}
/**
 * Permite insertar datos a las tablas recibe el sql con al estucutra insert into....
 * @param insertar
 * @return
 * @throws ClassNotFoundException
 * @throws InstantiationException
 * @throws IllegalAccessException
 * @throws SQLException
 * @throws ConnectionException 
 */
public   int InsertarGeneralSQL(String sql) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
{
 conexion conexion = new conexion();   
  try {
  DBConn = conexion.Get_conexion();
  stGetCount = DBConn.createStatement();
  rst = stGetCount.executeUpdate(sql);
   }catch (SQLException e) {
   System.out.println("No SE PUEDE INSETAR EN LA TABLA:" + sql);
   }finally {
 	    conexion.cerrarConexion();
            }
   return rst;
  }

public  int  DeleteGeneralSQL(String borrar) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
{
  conexion conexion = new conexion();   
  try {
  DBConn = conexion.Get_conexion();
  stGetCount = DBConn.createStatement();
  rst = stGetCount.executeUpdate(borrar);
  }catch (SQLException e) {
  System.out.println("No puede Ejecutar la consulta : " + borrar);
 }finally {
 	   conexion.cerrarConexion();
	   }
return  rst;
}
}