/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleaado;
import Modelo.Prenda;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author Frank
 */
public class ImplementacionEmpleados implements Login, Conexion<Empleaado> {

    private static final String SQL_USUARIO = "INSERT INTO USUARIO1 (IDUsuario, NivelAcceso, Password, DNIEmpleado) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT = "SELECT DNIEmpleado, nombreEmpleado, apellidoMEmpleado, apellidoPEmpleado, numero FROM EMPLEADO";
    private static final String SQL_DELETE = "DELETE FROM EMPLEADO WHERE DNIEmpleado=?";
    private static final String SQL_SELECT_BY_CODIGO = "SELECT DNIEmpleado, nombreEmpleado, apellidoMEmpleado, apellidoPEmpleado, numero FROM EMPLEADO WHERE DNIEmpleado=?";
    private static final String SQL_UPDATE = "UPDATE EMPLEADO SET nombreEmpleado=?, apellidoMEmpleado=?, apellidoPEmpleado=?, numero=? WHERE DNIEmpleado=?";
    private static final String SQL_INSERT = "INSERT INTO EMPLEADO (DNIEmpleado, nombreEmpleado, apellidoMEmpleado, apellidoPEmpleado, numero) VALUES (?, ?, ?, ?, ?)";
    private boolean loginExitoso;

    @Override
    public List<Empleaado> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleaado empleado = null;
        List<Empleaado> empleados = new ArrayList<>();

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String dni = rs.getString("DNIEmpleado");
                String nombre = rs.getString("nombreEmpleado");
                String apellidoM = rs.getString("apellidoMEmpleado");
                String apellidoP = rs.getString("apellidoPEmpleado");
                int turno = rs.getInt("numero");

                empleado = new Empleaado(turno, dni, nombre, apellidoM, apellidoP);
                empleados.add(empleado);
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

        return empleados;
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
    public Empleaado buscarPorCodigo(String codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleaado empleado = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_CODIGO);
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombreEmpleado");
                String apellidoM = rs.getString("apellidoMEmpleado");
                String apellidoP = rs.getString("apellidoPEmpleado");
                int turno = rs.getInt("numero");

                empleado = new Empleaado(turno, nombre, apellidoM, apellidoP);
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

        return empleado;
    }

    @Override
    public int actualizar(Empleaado elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, elemento.getNombre());
            stmt.setString(2, elemento.getApellidoM());
            stmt.setString(3, elemento.getApellidoP());
            stmt.setInt(4, elemento.getTurno());
            stmt.setString(5, elemento.getDni());

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
    public int insertar(Empleaado elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, elemento.getDni());
            stmt.setString(2, elemento.getNombre());
            stmt.setString(3, elemento.getApellidoM());
            stmt.setString(4, elemento.getApellidoP());
            stmt.setInt(5, elemento.getTurno());

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
    public void verificarLogin(String dniEmpleado, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM USUARIO1 WHERE DNIEmpleado = ? AND Password = ?");
            stmt.setString(1, dniEmpleado);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Login válido para " + dniEmpleado);
                    setLoginExitoso(true);  // Marcar como login exitoso
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas");
                    setLoginExitoso(false);  // Marcar como login fallido
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            setLoginExitoso(false);  // En caso de error, marcar como login fallido
        } finally {
            try {
                CreaConexion.close(rs);
                CreaConexion.close(stmt);
                CreaConexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void verificarNivelAcceso(String dniEmpleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement("SELECT NivelAcceso FROM USUARIO1 WHERE DNIEmpleado = ?");
            stmt.setString(1, dniEmpleado);

            rs = stmt.executeQuery();

            if (rs.next()) {
                int nivelAcceso = rs.getInt("NivelAcceso");
                String mensajeNivel = (nivelAcceso == 1) ? "Admin" : "Usuario Estándar"; // Ajusta según tus niveles de acceso
                JOptionPane.showMessageDialog(null, "Nivel de acceso para " + dniEmpleado + ": " + mensajeNivel);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
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
    }

    @Override
    public boolean enviarDatosABaseDeDatos(String nivelAcceso, String password, String dniEmpleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            conn = CreaConexion.getConnection();
            stmt = conn.prepareStatement(SQL_USUARIO);
            UUID idUsuario = UUID.randomUUID(); // Generar un UUID único

            // Obtener el valor long del UUID
            long idUsuarioLong = ByteBuffer.wrap(new byte[16])
                    .putLong(idUsuario.getMostSignificantBits())
                    .putLong(idUsuario.getLeastSignificantBits())
                    .getLong(0);

            stmt.setLong(1, idUsuarioLong);// Convertir el UUID a String y asignarlo al primer campo
            stmt.setString(2, nivelAcceso);
            stmt.setString(3, password);
            stmt.setString(4, dniEmpleado);

            int registrosInsertados = stmt.executeUpdate();
            exito = registrosInsertados > 0;
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
        return exito;

    }

    public boolean isLoginExitoso() {
        return loginExitoso;
    }

    public void setLoginExitoso(boolean loginExitoso) {
        this.loginExitoso = loginExitoso;
    }

    @Override
    public List<Empleaado> buscarVariosCodigo(String codigoPrendasStr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
