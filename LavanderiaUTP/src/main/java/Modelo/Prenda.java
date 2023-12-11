/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Frank
 */
public class Prenda {
    private String codigo;
    private String prenda;
    private int cantidad;
    private int precio;

    public Prenda() {
    }

    public Prenda(String prenda, int cantidad) {
        this.prenda = prenda;
        this.cantidad = cantidad;
    }

    public Prenda(String codigo, String prenda, int cantidad) {
        this.codigo = codigo;
        this.prenda = prenda;
        this.cantidad = cantidad;
    }

    public Prenda(String codigo, String prenda, int cantidad, int precio) {
        this.codigo = codigo;
        this.prenda = prenda;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrenda() {
        return prenda;
    }

    public void setPrenda(String prenda) {
        this.prenda = prenda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    
    
    
}
