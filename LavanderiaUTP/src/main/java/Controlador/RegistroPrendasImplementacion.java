/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Prenda;
import Modelo.RegistroPrendas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frank
 */
public class RegistroPrendasImplementacion implements Conexion<RegistroPrendas> {

    private static final String SQL_INSERT_REGISTRO_PRENDAS = "INSERT INTO REGISTRO (IDregistro, IDFECHA, DNIEmpleado, DNIcliente, codigoServicio, codigoPrenda) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT = "SELECT IDregistro, IDFECHA, DNIEmpleado, DNIcliente, codigoServicio,codigoPrenda FROM REGISTRO";
    private static final String SQL_SELECT_BY_CODIGO = "SELECT IDFECHA, DNIEmpleado, DNIcliente, codigoServicio, codigoPrenda FROM REGISTRO WHERE IDregistro=?";

    @Override
    public List<RegistroPrendas> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        RegistroPrendas registro = null;
        List<RegistroPrendas> registros = new ArrayList<>();

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idRegistroPrendas = rs.getInt("IDregistro");
                Date idFecha = rs.getDate("IDFECHA");
                String codigoEmpleado = rs.getString("DNIEmpleado");
                String dniCliente = rs.getNString("DNIcliente");
                String codigoServicio = rs.getString("codigoServicio");
                int codigoPrenda = rs.getInt("codigoPrenda");

                registro = new RegistroPrendas(idRegistroPrendas, idFecha, codigoEmpleado, dniCliente, codigoServicio, codigoPrenda);
                registros.add(registro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                CreaConexion.close(rs);
                CreaConexion.close(stmt);
                CreaConexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int eliminar(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RegistroPrendas buscarPorCodigo(String codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        RegistroPrendas registro = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_CODIGO);
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {

                Date idFecha = rs.getDate("IDFECHA");
                String codigoEmpleado = rs.getString("DNIEmpleado");
                String dniCliente = rs.getString("DNIcliente");
                String codigoServicio = rs.getString("codigoServicio");
                int codigoPrenda = rs.getInt("codigoPrenda");

                System.out.println(" " + idFecha + " " + dniCliente);//DESDE AQUI SE ESTA OBTENIENDO NULL
                registro = new RegistroPrendas(idFecha, codigoEmpleado, dniCliente, codigoServicio, codigoPrenda);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                CreaConexion.close(rs);
                CreaConexion.close(stmt);
                CreaConexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registro;
    }

    @Override
    public int actualizar(RegistroPrendas elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertar(RegistroPrendas elemento) {
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

    @Override
    public List<RegistroPrendas> buscarVariosCodigo(String dniCliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RegistroPrendas> registros = new ArrayList<>();

        try {
            conn = CreaConexion.getConnection();
            String sql = "SELECT IDregistro, IDFECHA, DNIEmpleado, DNIcliente, codigoServicio, codigoPrenda FROM REGISTRO WHERE DNIcliente = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dniCliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idRegistroPrendas = rs.getInt("IDregistro");
                Date idFecha = rs.getDate("IDFECHA");
                String codigoEmpleado = rs.getString("DNIEmpleado");
                String clienteDni = rs.getString("DNIcliente");
                String codigoServicio = rs.getString("codigoServicio");
                int codigoPrenda = rs.getInt("codigoPrenda");

                RegistroPrendas registro = new RegistroPrendas(idRegistroPrendas, idFecha, codigoEmpleado, clienteDni, codigoServicio, codigoPrenda);
                registros.add(registro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                CreaConexion.close(rs);
                CreaConexion.close(stmt);
                CreaConexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

}
