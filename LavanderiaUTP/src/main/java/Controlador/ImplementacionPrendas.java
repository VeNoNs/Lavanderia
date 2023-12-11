/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CategoriServicios;
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
public class ImplementacionPrendas implements Conexion<Prenda> {

    private static final String SQL_SELECT = "SELECT idPrenda, nombrePrenda, CantidadPrendas FROM PRENDA";
    private static final String SQL_INSERT = "INSERT INTO PRENDA(idPrenda, nombrePrenda, CantidadPrendas, precio, subTotal) VALUES(?, ?, ?, ?, NULL)";
    private static final String SQL_UPDATE = "UPDATE PRENDA SET nombrePrenda=?, CantidadPrendas=? WHERE idPrenda=?";
    private static final String SQL_DELETE = "DELETE FROM PRENDA WHERE idPrenda=?";
    private static final String SQL_SELECT_BY_ID = "SELECT nombrePrenda, CantidadPrendas FROM PRENDA WHERE precio=?";

    @Override
    public List<Prenda> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Prenda> prendas = new ArrayList<>();

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String idPrenda = rs.getString("idPrenda");
                String tipoPrenda = rs.getString("nombrePrenda");
                int precio = rs.getInt("CantidadPrendas");

                Prenda prenda = new Prenda(idPrenda, tipoPrenda, precio);
                prendas.add(prenda);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                CreaConexion.close(rs);
                CreaConexion.close(stmt);
                CreaConexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return prendas;
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
    public Prenda buscarPorCodigo(String codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Prenda prenda = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String tipoPrenda = rs.getString("nombrePrenda");
                int precio = rs.getInt("CantidadPrendas");

                prenda = new Prenda(codigo, tipoPrenda, precio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                CreaConexion.close(rs);
                CreaConexion.close(stmt);
                CreaConexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return prenda;
    }

    @Override
    public int actualizar(Prenda prenda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, prenda.getPrenda());
            stmt.setDouble(2, prenda.getCantidad());
            stmt.setString(3, prenda.getCodigo());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
    public int insertar(Prenda prenda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, prenda.getCodigo());
            stmt.setString(2, prenda.getPrenda());
            stmt.setDouble(3, prenda.getCantidad());
            stmt.setInt(4, prenda.getPrecio());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
    
    public List<Prenda> buscarVariosCodigo(String codigo) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Prenda> prendas = new ArrayList<>();

    try {
        conn = CreaConexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
        stmt.setString(1, codigo);
        rs = stmt.executeQuery();

        while (rs.next()) {
            String tipoPrenda = rs.getString("nombrePrenda");
            int cantidadPrenda = rs.getInt("CantidadPrendas");

            Prenda prenda = new Prenda(codigo, tipoPrenda, cantidadPrenda);
            prendas.add(prenda);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            CreaConexion.close(rs);
            CreaConexion.close(stmt);
            CreaConexion.close(conn);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    return prendas;
}

}
