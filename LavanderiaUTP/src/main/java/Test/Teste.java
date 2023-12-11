/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Controlador.CreaConexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Frank
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Connection conn = null;
        try {
            conn = CreaConexion.getConnection();
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    CreaConexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
