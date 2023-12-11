/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

/**
 *
 * @author Frank
 */
public interface Login {
    
    void verificarLogin(String dniEmpleado, String password);
    void verificarNivelAcceso(String dniEmpleado);
    boolean enviarDatosABaseDeDatos(String nivelAcceso, String password, String dniEmpleado);
}
