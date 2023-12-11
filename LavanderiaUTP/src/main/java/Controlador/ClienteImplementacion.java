/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Prenda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frank
 */
public class ClienteImplementacion implements Conexion<Cliente> {

    private static final String SQL_SELECT = "SELECT dni,nombre,apellidoM,apellidoP,direccion,distrito,correo,celular FROM CLIENTES";
    private static final String SQL_INSERT = "INSERT INTO CLIENTES(dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE CLIENTES SET nombre=?, apellidoM=?, apellidoP=?, direccion=?, distrito=?, correo=?, celular=? WHERE dni=?";
    private static final String SQL_DELETE = "DELETE FROM CLIENTES WHERE dni=?";
    private static final String SQL_SELECT_BY_DNI = "SELECT dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular FROM CLIENTES WHERE dni=?";
    private static final String SQL_SELECT_BY_NOMBRE = "SELECT dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular FROM CLIENTES WHERE nombre=?";
    private static final String SQL_SELECT_BY_APELLIDO = "SELECT dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular FROM CLIENTES WHERE apellidoP=? OR apellidoM=?";

    @Override
    public List<Cliente> seleccionar() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidoM = rs.getString("apellidoM");
                String apellidoP = rs.getString("apellidoP");
                String direccion = rs.getString("direccion");
                String distrito = rs.getString("distrito");
                String correo = rs.getString("correo");
                String celular = rs.getString("celular");

                cliente = new Cliente(dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular);
                clientes.add(cliente);
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

        return clientes;
    }

    @Override
    public int insertar(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getDni()); // Agregamos el campo dni
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellidoM());
            stmt.setString(4, cliente.getApellidoP());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getDistrito());
            stmt.setString(7, cliente.getCorreo());
            stmt.setString(8, cliente.getCelular());

            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Aquí deberías manejar el error adecuadamente
            return -1; // Retorna un valor que indique un error
        } finally {
            try {
                if (stmt != null) {
                    CreaConexion.close(stmt);
                }
                if (conn != null) {
                    CreaConexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Manejar el error al cerrar las conexiones
            }
        }

        return registros;
    }

    @Override
    public int actualizar(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidoM());
            stmt.setString(3, cliente.getApellidoP());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getDistrito());
            stmt.setString(6, cliente.getCorreo());
            stmt.setString(7, cliente.getCelular());
            stmt.setString(8, cliente.getDni());

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
    public Cliente buscarPorCodigo(String dni) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_DNI);
            stmt.setString(1, dni);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidoM = rs.getString("apellidoM");
                String apellidoP = rs.getString("apellidoP");
                String direccion = rs.getString("direccion");
                String distrito = rs.getString("distrito");
                String correo = rs.getString("correo");
                String celular = rs.getString("celular");

                cliente = new Cliente(dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular);
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

        return cliente;
    }

    @Override
    public int eliminar(String dni) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, dni);
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
    public List<Cliente> buscarVariosCodigo(String nombre) {
        List<Cliente> listaClientes = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_NOMBRE);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String dni = rs.getString("dni");
                String apellidoM = rs.getString("apellidoM");
                String apellidoP = rs.getString("apellidoP");
                String direccion = rs.getString("direccion");
                String distrito = rs.getString("distrito");
                String correo = rs.getString("correo");
                String celular = rs.getString("celular");

                Cliente cliente = new Cliente(dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular);
                listaClientes.add(cliente);
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

        return listaClientes;

    }

    public List<Cliente> buscarPorApellido(String apellido) {
        List<Cliente> listaClientes = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_APELLIDO);
            stmt.setString(1, apellido);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidoM = rs.getString("apellidoM");
                String direccion = rs.getString("direccion");
                String distrito = rs.getString("distrito");
                String correo = rs.getString("correo");
                String celular = rs.getString("celular");

                Cliente cliente = new Cliente(dni, nombre, apellidoM, apellido, direccion, distrito, correo, celular);
                listaClientes.add(cliente);
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

        return listaClientes;
    }

}
