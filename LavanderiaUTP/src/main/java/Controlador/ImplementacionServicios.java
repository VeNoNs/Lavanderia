/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CategoriServicios;
import Modelo.Prenda;
import Modelo.Servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frank
 */
public class ImplementacionServicios implements Conexion<Servicios> {

     private static final String SQL_SELECT = "SELECT idServicio, nombreServicio, descripcionServicio, precio, idCategoria FROM SERVICIOS";
    private static final String SQL_DELETE = "DELETE FROM SERVICIOS WHERE idServicio=?";
    private static final String SQL_SELECT_BY_CODIGO = "SELECT idServicio, nombreServicio, descripcionServicio, precio, idCategoria FROM SERVICIOS WHERE idServicio=?";
    private static final String SQL_UPDATE = "UPDATE SERVICIOS SET nombreServicio=?, descripcionServicio=?, precio=?, idCategoria=? WHERE idServicio=?";
    private static final String SQL_INSERT = "INSERT INTO SERVICIOS (idServicio, nombreServicio, descripcionServicio, precio, idCategoria) VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Servicios> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicios servicio = null;
        List<Servicios> servicios = new ArrayList<>();

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("idServicio");
                String nombre = rs.getString("nombreServicio");
                String descripcion = rs.getString("descripcionServicio");
                double precio = rs.getDouble("precio");
                String categoriaCodigo = rs.getString("idCategoria");

                servicio = new Servicios(codigo, nombre, descripcion, precio, categoriaCodigo);
                servicios.add(servicio);
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

        return servicios;
    }

    @Override
    public int eliminar(String codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, codigo);
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
    public Servicios buscarPorCodigo(String codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicios servicio = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_CODIGO);
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombreServicio");
                String descripcion = rs.getString("descripcionServicio");
                double precio = rs.getDouble("precio");
                String categoriaCodigo = rs.getString("idCategoria");

                servicio = new Servicios(codigo, nombre, descripcion, precio, categoriaCodigo);
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

        return servicio;
    }

    @Override
    public int actualizar(Servicios elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, elemento.getNombre());
            stmt.setString(2, elemento.getDescripcion());
            stmt.setDouble(3, elemento.getPrecio());
            stmt.setString(4, elemento.getCategoria());
            stmt.setString(5, elemento.getCodigo());

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
    public int insertar(Servicios elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, elemento.getCodigo());
            stmt.setString(2, elemento.getNombre());
            stmt.setString(3, elemento.getDescripcion());
            stmt.setDouble(4, elemento.getPrecio());
            stmt.setString(5, elemento.getCategoria());

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
    public List<Servicios> buscarVariosCodigo(String codigoPrendasStr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
