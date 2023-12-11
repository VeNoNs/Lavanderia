/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Frank
 */
public class Servicios {
    private String codigo;
    private String Nombre;
    private String Descripcion;
    private double precio;
    private String categoria;

    public Servicios() {
    }

    public Servicios(String codigo) {
        this.codigo = codigo;
    }

    public Servicios(String Nombre, String Descripcion, double precio, String categoria) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Servicios(String codigo, String Nombre, String Descripcion, double precio, String categoria) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

   
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    
    
    
}
