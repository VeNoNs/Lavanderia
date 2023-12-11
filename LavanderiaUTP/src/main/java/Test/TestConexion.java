/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Controlador.ClienteImplementacion;
import Controlador.Conexion;
import Controlador.CreaConexion;
import Modelo.Cliente;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Frank
 */
public class TestConexion {
    public static void main(String[] args) {
        Conexion clienentedao= new ClienteImplementacion();
        List<Cliente> clientes=clienentedao.seleccionar();
        
    }
}
