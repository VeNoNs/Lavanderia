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
public class Persona {
    protected String dni;
    protected String nombre;
    protected String apellidoM;
    protected String apellidoP;
    protected String direccion;
    protected String distrito;
    protected String correo;
    protected String celular;

    public Persona() {
    }

    public Persona(String dni) {
        this.dni = dni;
    }

    
    //Constructores ESCPECIFICOS PARA EL CLIENTE
    public Persona(String nombre, String apellidoM, String apellidoP, String direccion, String distrito, String correo, String celular) {
        this.nombre = nombre;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
        this.direccion = direccion;
        this.distrito = distrito;
        this.correo = correo;
        this.celular = celular;
    }

    public Persona(String dni, String nombre, String apellidoM, String apellidoP, String direccion, String distrito, String correo, String celular) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
        this.direccion = direccion;
        this.distrito = distrito;
        this.correo = correo;
        this.celular = celular;
    }
    
    //CONSTRUCTORES PARA EL EMPLEADO

    public Persona(String dni, String nombre, String apellidoM, String apellidoP) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
    }

    public Persona(String nombre, String apellidoM, String apellidoP) {
        this.nombre = nombre;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
    }
    
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("dni=").append(dni);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoM=").append(apellidoM);
        sb.append(", apellidoP=").append(apellidoP);
        sb.append(", direccion=").append(direccion);
        sb.append(", distrito=").append(distrito);
        sb.append(", correo=").append(correo);
        sb.append(", celular=").append(celular);
        sb.append('}');
        return sb.toString();
    }

    

    
    
    
}
