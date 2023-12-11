/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Prenda;
import Modelo.RegistroPrendas;
import Modelo.Servicios;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Frank
 */
public class GenerarReportes {

    public static List<Cliente> buscarPorDNI(String busqueda, Date fechaDesde, Date fechaHasta, String categoriaSeleccionada) {
    Conexion clienteImpl = new ClienteImplementacion();
    Conexion prendaImpl = new RegistroPrendasImplementacion();
    List<Cliente> clientesPorDNI = clienteImpl.buscarVariosCodigo(busqueda);
    List<Cliente> clientesCumplenCondicion = new ArrayList<>();

    for (Cliente cliente : clientesPorDNI) {
        List<RegistroPrendas> registroPrendas = prendaImpl.buscarVariosCodigo(cliente.getDni());

        boolean cumpleCondicion = false;
        for (RegistroPrendas registro : registroPrendas) {
            if (registro.getIdFecha().after(fechaDesde) && registro.getIdFecha().before(fechaHasta)
                    && registro.getCodigoServicio().equals(categoriaSeleccionada)) {
                cumpleCondicion = true;
                break;
            }
        }

        if (cumpleCondicion) {
            clientesCumplenCondicion.add(cliente);
        }
    }

    return clientesCumplenCondicion;
}

    public static List<Cliente> buscarPorNombre(String busqueda, Date fechaDesde, Date fechaHasta, String categoriaSeleccionada) {
        Conexion clienteImpl = new ClienteImplementacion();
        Conexion prendaImpl = new RegistroPrendasImplementacion();
        List<Cliente> clientesPorNombre = clienteImpl.buscarVariosCodigo(busqueda);
        List<Cliente> clientesCumplenCondicion = new ArrayList<>();

        for (Cliente cliente : clientesPorNombre) {
            List<RegistroPrendas> registroPrendas = prendaImpl.buscarVariosCodigo(cliente.getDni());

            // Verificar si hay registros que cumplan con los criterios
            boolean cumpleCondicion = false;
            for (RegistroPrendas registro : registroPrendas) {
                if (registro.getIdFecha().after(fechaDesde) && registro.getIdFecha().before(fechaHasta)
                        && registro.getCodigoServicio().equals(categoriaSeleccionada)) {
                    cumpleCondicion = true;
                    break;
                }
            }

            // Si el cliente tiene registros que cumplen los criterios, agregarlo a la lista
            if (cumpleCondicion) {
                clientesCumplenCondicion.add(cliente);
            }
        }

        return clientesCumplenCondicion;
    }

    public static List<Cliente> buscarPorApellido(String busqueda, Date fechaDesde, Date fechaHasta, String categoriaSeleccionada) {
    ClienteImplementacion clienteImpl = new ClienteImplementacion();
    Conexion prendaImpl = new RegistroPrendasImplementacion();
    List<Cliente> clientesPorApellido = clienteImpl.buscarPorApellido(busqueda);
    List<Cliente> clientesCumplenCondicion = new ArrayList<>();

    for (Cliente cliente : clientesPorApellido) {
        List<RegistroPrendas> registroPrendas = prendaImpl.buscarVariosCodigo(cliente.getDni());

        boolean cumpleCondicion = false;
        for (RegistroPrendas registro : registroPrendas) {
            if (registro.getIdFecha().after(fechaDesde) && registro.getIdFecha().before(fechaHasta)
                    && registro.getCodigoServicio().equals(categoriaSeleccionada)) {
                cumpleCondicion = true;
                break;
            }
        }

        if (cumpleCondicion) {
            clientesCumplenCondicion.add(cliente);
        }
    }

    return clientesCumplenCondicion;
}

    public String actualizarInformacion(int idRegistroPrendas, Date fechaActual, String dniCliente, String servicioElegido, int codigoPrendas) {
        // Formatear la información para mostrarla en el JTextField
        Conexion clienteImpl = new ClienteImplementacion();
        Conexion servicioImpl = new ImplementacionServicios();
        Conexion prendaImpl = new ImplementacionPrendas();
        double totalSubtotal = 0.0;

        // Obtener detalles del cliente
        Cliente cliente = (Cliente) clienteImpl.buscarPorCodigo(dniCliente);
        String codigoCliente = cliente.getDni();
        String nombreCliente = cliente.getNombre();
        String apellidoCliente = cliente.getApellidoP();

        // Obtener detalles del servicio
        Servicios servicio = (Servicios) servicioImpl.buscarPorCodigo(servicioElegido);
        String codigoServicio = servicio.getCodigo();
        String nombreServicio = servicio.getNombre();
        String detalleServicio = servicio.getDescripcion();
        double precioServicio = servicio.getPrecio();

        // Crear una cadena para el contenido
        StringBuilder contenido = new StringBuilder();
        contenido.append("ID Registro Ingreso: ").append(idRegistroPrendas).append("\n");
        contenido.append("Fecha de Ingreso: ").append(fechaActual).append("\n");
        contenido.append("\n");
        contenido.append("Cliente: ").append(codigoCliente).append(" - ").append(nombreCliente).append(" ").append(apellidoCliente).append("\n");
        contenido.append("\n");
        contenido.append("Servicio: ").append(codigoServicio).append(" - ").append(nombreServicio).append("\n");
        contenido.append("Detalle: ").append(detalleServicio).append("\n");
        contenido.append("Costo del Servicio: ").append(precioServicio).append("\n");
        contenido.append("\n");
        // Obtener detalles de la prenda
        String codigoPrendasStr = String.valueOf(codigoPrendas); // Convertir el entero a cadena

        List<Prenda> prendasConMismoCodigo = prendaImpl.buscarVariosCodigo(codigoPrendasStr);
        double subtotalCodigo = 0.0;

        for (Prenda prenda : prendasConMismoCodigo) {
            String codigoPrendaStr = prenda.getCodigo();
            String nombrePrenda = prenda.getPrenda();
            int cantidadPrenda = prenda.getCantidad();
            // Asignar el precio del servicio a la prenda (según lo entiendo)
            double precioPrenda = precioServicio * cantidadPrenda; // Calcular el precio de la prenda

            totalSubtotal += precioPrenda;

            contenido.append("Prenda: ").append(codigoPrendaStr).append(" - ").append(nombrePrenda).append("\n");
            contenido.append("Cantidad: ").append(cantidadPrenda).append("\n");
            contenido.append("Precio por unidad: ").append(precioServicio).append("\n");
            contenido.append("Precio total: ").append(precioPrenda).append("\n");
            contenido.append("\n");
        }

        contenido.append("SubTotal:  ").append(totalSubtotal).append("\n");
        contenido.append("\n");

        return contenido.toString();

    }

    public String actualizarSalida(String idRegistroPrendas) {
        // Formatear la información para mostrarla en el JTextField
        Conexion registroimpl = new RegistroPrendasImplementacion();
        Conexion clienteImpl = new ClienteImplementacion();
        Conexion servicioImpl = new ImplementacionServicios();
        Conexion prendaImpl = new ImplementacionPrendas();
        double totalSubtotal = 0.0;
        //
        RegistroPrendas registro = (RegistroPrendas) registroimpl.buscarPorCodigo(idRegistroPrendas);
        // int idRegistroPrendasSSSS = registro.getIdRegistroPrendas();//AQUI PASA EL ERROR
        Date idFecha = registro.getIdFecha();
        System.out.println("codigo empleado" + idFecha);
        String codigoEmpleado = registro.getCodigoEmpleado();
        System.out.println("codigo empleado" + codigoEmpleado);
        String codigoServicio = registro.getCodigoServicio();
        System.out.println("codigo empleado" + codigoServicio);
        int codigoPrenda = registro.getCodigoPrenda();
        System.out.println("codigo empleado" + codigoPrenda);
        String dniCliente = registro.getDniCliente();
        System.out.println("Codigo cliente" + dniCliente);
        // Obtener detalles del cliente
        Cliente cliente = (Cliente) clienteImpl.buscarPorCodigo(dniCliente);
        String codigoCliente = cliente.getDni();
        String nombreCliente = cliente.getNombre();
        String apellidoCliente = cliente.getApellidoP();

        // Obtener detalles del servicio
        Servicios servicio = (Servicios) servicioImpl.buscarPorCodigo(codigoServicio);
        String codigoServicio1 = servicio.getCodigo();
        String nombreServicio = servicio.getNombre();
        String detalleServicio = servicio.getDescripcion();
        double precioServicio = servicio.getPrecio();

        // Crear una cadena para el contenido
        StringBuilder contenido = new StringBuilder();
        contenido.append("ID Registro Ingreso: ").append(idRegistroPrendas).append("\n");
        contenido.append("Fecha de Ingreso: ").append(idFecha).append("\n");
        contenido.append("\n");
        contenido.append("Cliente: ").append("nada").append(" - ").append(nombreCliente).append(" ").append(apellidoCliente).append("\n");
        contenido.append("\n");
        contenido.append("Servicio: ").append(codigoServicio).append(" - ").append(nombreServicio).append("\n");
        contenido.append("Detalle: ").append(detalleServicio).append("\n");
        contenido.append("Costo del Servicio: ").append(precioServicio).append("\n");
        contenido.append("\n");
        // Obtener detalles de la prenda
        String codigoPrendasStr = String.valueOf(codigoPrenda); // Convertir el entero a cadena

        List<Prenda> prendasConMismoCodigo = prendaImpl.buscarVariosCodigo(codigoPrendasStr);
        double subtotalCodigo = 0.0;

        for (Prenda prenda : prendasConMismoCodigo) {
            String codigoPrendaStr = prenda.getCodigo();
            String nombrePrenda = prenda.getPrenda();
            int cantidadPrenda = prenda.getCantidad();
            // Asignar el precio del servicio a la prenda (según lo entiendo)
            double precioPrenda = precioServicio * cantidadPrenda; // Calcular el precio de la prenda

            totalSubtotal += precioPrenda;

            contenido.append("Prenda: ").append(codigoPrendaStr).append(" - ").append(nombrePrenda).append("\n");
            contenido.append("Cantidad: ").append(cantidadPrenda).append("\n");
            contenido.append("Precio por unidad: ").append(precioServicio).append("\n");
            contenido.append("Precio total: ").append(precioPrenda).append("\n");
            contenido.append("\n");
        }

        contenido.append("SubTotal:  ").append(totalSubtotal).append("\n");
        contenido.append("\n");
        // Obtener la fecha actual
        LocalDate fechaSalida = LocalDate.now();
        // o también puedes usar la clase Date si prefieres: 
        // Date fechaSalida = new Date();

        contenido.append("Fecha de Salida: ").append(fechaSalida).append("\n");
        contenido.append("\n");

        return contenido.toString();

    }

    public String guardarEnArchivo(String texto, String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            writer.write(texto);
            writer.close();
            System.out.println("Contenido guardado en " + nombreArchivo);
            return nombreArchivo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
     public void exportarAPDF(String contenido) {
        // Nombre del archivo PDF que se generará
        String nombreArchivoPDF = "archivo_salida.pdf"; // Cambia el nombre si lo deseas

        // Crear un documento PDF usando iText
        Document documento = new Document();
        try {
            // Crear el archivo PDF
            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivoPDF));

            // Abrir el documento
            documento.open();

            // Agregar el contenido al documento PDF
            documento.add(new Paragraph(contenido));

            // Cerrar el documento
            documento.close();

            // Notificar al usuario que se ha exportado correctamente
            JOptionPane.showMessageDialog(null, "El archivo PDF se ha exportado exitosamente.");

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al exportar el archivo PDF: " + e.getMessage());
        }
    }
}
