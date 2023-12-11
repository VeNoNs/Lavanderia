/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Frank
 */
public class Empleaado extends Persona{
    protected String codigoEmpleado;
    protected String password;
    protected int nivelAcceso;
    protected int turno;

    public Empleaado() {
    }

    public Empleaado(String dni) {
        super(dni);
    }

    public Empleaado(int turno, String dni, String nombre, String apellidoM, String apellidoP) {
        super(dni, nombre, apellidoM, apellidoP);
        this.turno = turno;
    }

    public Empleaado(int turno, String nombre, String apellidoM, String apellidoP) {
        super(nombre, apellidoM, apellidoP);
        this.turno = turno;
    }

    public Empleaado(String codigoEmpleado, String password, int nivelAcceso, String dni) {
        super(dni);
        this.codigoEmpleado = codigoEmpleado;
        this.password = password;
        this.nivelAcceso = nivelAcceso;
    }

    public Empleaado(String password, int nivelAcceso, String dni) {
        super(dni);
        this.password = password;
        this.nivelAcceso = nivelAcceso;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
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

    
    
    

   
    
}
