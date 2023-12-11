/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Prenda;
import java.util.List;

/**
 *
 * @author Frank
 */
public interface Conexion<T> {

    public List<T> seleccionar();

    public int eliminar(String codigo);

    public T buscarPorCodigo(String codigo);

    public int actualizar(T elemento);

    public int insertar(T elemento);

    public List<T> buscarVariosCodigo(String codigoPrendasStr);


}
