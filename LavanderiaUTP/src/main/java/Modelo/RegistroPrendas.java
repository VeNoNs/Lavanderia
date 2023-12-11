/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Frank
 */
public class RegistroPrendas {
    private int idRegistroPrendas;
    private Date idFecha;
    private String codigoEmpleado;
    private String dniCliente;
    private String codigoServicio;
    private int codigoPrenda;

    public RegistroPrendas() {
    }

    public RegistroPrendas(int idRegistroPrendas, Date idFecha, String codigoEmpleado, String dniCliente, String codigoServicio, int codigoPrenda) {
        this.idRegistroPrendas = idRegistroPrendas;
        this.idFecha = idFecha;
        this.codigoEmpleado = codigoEmpleado;
        this.dniCliente = dniCliente;
        this.codigoServicio = codigoServicio;
        this.codigoPrenda = codigoPrenda;
    }
    

  public RegistroPrendas(Date idFecha, String codigoEmpleado, String dniCliente, String codigoServicio, int codigoPrenda) {
    this.idFecha = idFecha;
    this.codigoEmpleado = codigoEmpleado;
    this.dniCliente = dniCliente;
    this.codigoServicio = codigoServicio;
    this.codigoPrenda = codigoPrenda;
}
    
    

    public int getIdRegistroPrendas() {
        return idRegistroPrendas;
    }

    public void setIdRegistroPrendas(int idRegistroPrendas) {
        this.idRegistroPrendas = idRegistroPrendas;
    }

    public Date getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Date idFecha) {
        this.idFecha = idFecha;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public int getCodigoPrenda() {
        return codigoPrenda;
    }

    public void setCodigoPrenda(int codigoPrenda) {
        this.codigoPrenda = codigoPrenda;
    }
    
    
}
