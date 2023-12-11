/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;




/**
 *
 * @author Frank
 */
public class Cliente extends Persona{

   

    public Cliente() {
    }

    public Cliente(String dni) {
        super(dni);
    }

    public Cliente(String nombre, String apellidoM, String apellidoP, String direccion, String distrito, String correo, String celular) {
        super(nombre, apellidoM, apellidoP, direccion, distrito, correo, celular);
    }

    public Cliente(String dni, String nombre, String apellidoM, String apellidoP, String direccion, String distrito, String correo, String celular) {
        super(dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular);
    }

    

    

    
    
    
}
