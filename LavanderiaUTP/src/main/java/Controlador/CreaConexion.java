package Controlador;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreaConexion {

    private static final String JDBC_URL ="jdbc:sqlite:E:/PruebasBaseDatos/LavanderiaUTP/Lavanderia_DB.db";
   

   public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection(JDBC_URL);
   }
   
   public static  void close(ResultSet rs) throws SQLException{
       rs.close();
   }
   public static  void close(Statement smtm) throws SQLException{
       smtm.close();
   }
   public static  void close(PreparedStatement smtm) throws SQLException{
       smtm.close();
   }
   public static void close(Connection conn) throws SQLException{
       conn.close();
   }
}

