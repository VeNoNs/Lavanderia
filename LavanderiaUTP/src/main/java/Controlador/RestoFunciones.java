/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.RegistroPrendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Frank
 */
public class RestoFunciones {

    private static final String SQL_INSERT_REGISTRO_PRENDAS = "INSERT INTO REGISTRO (IDregistro, IDFECHA, DNIEmpleado, DNIcliente, codigoServicio, codigoPrenda) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String consulta = "SELECT MAX(IDregistro) AS maxID FROM REGISTRO";
    private static final String consulta2 = "SELECT MAX(idPrenda) AS maxID FROM PRENDA";

    public int insertarRegistroPrendas(RegistroPrendas elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_REGISTRO_PRENDAS);
            stmt.setInt(1, elemento.getIdRegistroPrendas());
            stmt.setDate(2, new java.sql.Date(elemento.getIdFecha().getTime()));
            stmt.setString(3, elemento.getCodigoEmpleado());
            stmt.setString(4, elemento.getDniCliente());
            stmt.setString(5, elemento.getCodigoServicio());
            stmt.setInt(6, elemento.getCodigoPrenda());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                CreaConexion.close(stmt);
                CreaConexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int obtenerProximoIDRegistro() throws SQLException {
        int primerID = 1; // Establecer el primer ID en 1 si la tabla está vacía

        // Se obtiene la conexión directamente desde la clase CreaConexion
        Connection conn = CreaConexion.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(consulta); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int maxID = rs.getInt("maxID");
                if (!rs.wasNull()) {
                    primerID = maxID + 1;
                }
            }
        }

        return primerID;
    }

    public String obtenerProximoIDPrenda() throws SQLException {
        int primerID = 1; // Establecer el primer ID en 1 si la tabla está vacía

        Connection conn = CreaConexion.getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(consulta2); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int maxID = rs.getInt("maxID");
                if (!rs.wasNull()) {
                    primerID = maxID + 1;
                }
            }
        }

        return String.valueOf(primerID);
    }

}
