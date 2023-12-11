/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CategoriServicios;
import Modelo.Cliente;
import Modelo.Prenda;
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
public class ImplementacionCategoriaServicios implements Conexion<CategoriServicios> {

    private static final String SQL_SELECT = "SELECT idcategoria, nombreCategoria, descripcionCategoria FROM CATEGORIAS";
    private static final String SQL_INSERT = "INSERT INTO CATEGORIAS(idcategoria, nombreCategoria, descripcionCategoria) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE CATEGORIAS SET nombreCategoria=?, descripcionCategoria=? WHERE idcategoria=?";
    private static final String SQL_DELETE = "DELETE FROM CATEGORIAS WHERE idcategoria=?";
    private static final String SQL_SELECT_BY_ID = "SELECT idcategoria, nombreCategoria, descripcionCategoria FROM CATEGORIAS WHERE idcategoria=?";

    @Override
    public List<CategoriServicios> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CategoriServicios categoria = null;
        List<CategoriServicios> categorias = new ArrayList<>();

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("idcategoria");  // Corregido
                String nombre = rs.getString("nombreCategoria");  // Corregido
                String descripcion = rs.getString("descripcionCategoria");  // Corregido

                categoria = new CategoriServicios(codigo, nombre, descripcion);
                categorias.add(categoria);
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

        return categorias;
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
    public CategoriServicios buscarPorCodigo(String codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CategoriServicios categoria = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombreCategoria");
                String descripcion = rs.getString("descripcionCategoria");

                categoria = new CategoriServicios(codigo, nombre, descripcion);
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

        return categoria;
    }

    @Override
    public int actualizar(CategoriServicios elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, elemento.getNombre());
            stmt.setString(2, elemento.getDescripcion());
            stmt.setString(3, elemento.getCodigo());

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
    public int insertar(CategoriServicios elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, elemento.getCodigo());
            stmt.setString(2, elemento.getNombre());
            stmt.setString(3, elemento.getDescripcion());

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
    public List<CategoriServicios> buscarVariosCodigo(String codigoPrendasStr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
