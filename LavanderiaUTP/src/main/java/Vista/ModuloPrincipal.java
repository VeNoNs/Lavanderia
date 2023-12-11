/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ClienteImplementacion;
import Controlador.Conexion;
import Controlador.GenerarReportes;
import Controlador.ImplementacionCategoriaServicios;
import Controlador.ImplementacionEmpleados;
import Controlador.ImplementacionPrendas;
import Controlador.ImplementacionServicios;
import Controlador.Login;
import Controlador.RegistroPrendasImplementacion;
import Controlador.RestoFunciones;
import Modelo.CategoriServicios;
import Modelo.Cliente;
import Modelo.Empleaado;
import Modelo.Prenda;
import Modelo.RegistroPrendas;
import Modelo.Servicios;
import java.awt.CardLayout;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frank
 */
public class ModuloPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ModuloPrincipal
     */
    private Conexion implementacionCategoriaServicios = new ImplementacionCategoriaServicios();
    private Conexion clienteImplementacion = new ClienteImplementacion();
    private Conexion implementacionEmpleado = new ImplementacionEmpleados();
    private Conexion implementacionServicios = new ImplementacionServicios();
    private Conexion implementacionPrendas = new ImplementacionPrendas();
    private Conexion registroPrendasImplementacion = new RegistroPrendasImplementacion();
    private Login implementacionEmpleado2 = new ImplementacionEmpleados();
    private List<Prenda> prendasTemporales = new ArrayList<>();

    public ModuloPrincipal() {
        initComponents();
        SetImageLabel(logo2, "src/main/java/Recursos/logo2.png");
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarPanel(ClientesCard);
                cargarDatosClientes();
            }
        });

        btnServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarPanel(ServiciosCard);
                List<CategoriServicios> categorias = implementacionCategoriaServicios.seleccionar();

                // Limpiar el JComboBox antes de agregar nuevos elementos
                EscogerCategoriaBD.removeAllItems();
                for (CategoriServicios categoria : categorias) {
                    EscogerCategoriaBD.addItem(categoria.getNombre());
                }
                cargarDatosServicios();
            }
        });
        btnCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarPanel(CategoriasCard);
                cargarDatosCategorias();
            }
        });
        btnEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarPanel(EmpleadosCard);
                boxNivelAcceso.removeAllItems();
                boxNivelAcceso.addItem("Rango 1");
                boxNivelAcceso.addItem("Rango 2");
                boxNivelAcceso.addItem("Rango 3");
                cargarDatosEmpleados();
            }
        });
        btnIngresoPrendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarPanel(IngresoPrendas);
                List<Cliente> clientes = clienteImplementacion.seleccionar();
                List<Servicios> serviciosmm = implementacionServicios.seleccionar();
                // Limpiar el JComboBox antes de agregar nuevos elementos
                cbxdni.removeAllItems();
                cbxServicio.removeAllItems();
                for (Servicios servicio : serviciosmm) {
                    cbxServicio.addItem(servicio.getCodigo()); // Agregar solo los nombres de los servicios al JComboBox cbxServicio
                }
                for (Cliente cliente : clientes) {
                    cbxdni.addItem(cliente.getDni());
                }
            }
        });
        btnSalidaPrendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarPanel(SalidaPrendas);
                List<RegistroPrendas> idregistros = registroPrendasImplementacion.seleccionar();
                cbxIDRegistro.removeAllItems();
                for (RegistroPrendas registro : idregistros) {
                    cbxIDRegistro.addItem(String.valueOf(registro.getIdRegistroPrendas()));
                }
            }
        });
        btnConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarPanel(ConsultarServicios);
                List<Servicios> serviciosmm = implementacionServicios.seleccionar();
                // Limpiar el JComboBox antes de agregar nuevos elementos

                ConCategoria.removeAllItems();
                for (Servicios servicio : serviciosmm) {
                    ConCategoria.addItem(servicio.getCodigo()); // Agregar solo los nombres de los servicios al JComboBox cbxServicio
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GRUPO1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnConsultas = new javax.swing.JLabel();
        btnmodulo = new javax.swing.JLabel();
        btnClientes = new javax.swing.JLabel();
        btnServicios = new javax.swing.JLabel();
        btnEmpleados = new javax.swing.JLabel();
        btnSalidaPrendas = new javax.swing.JLabel();
        btnIngresoPrendas = new javax.swing.JLabel();
        btnCategorias = new javax.swing.JLabel();
        PrincipalCard = new javax.swing.JPanel();
        Primero = new javax.swing.JPanel();
        logo2 = new javax.swing.JLabel();
        ClientesCard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDniCliente1 = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidosPCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDistritoCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCelularCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnModificarCliente = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnEliminarCliente = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2Cliente = new javax.swing.JScrollPane();
        visorClientes = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtApellidosMCliente = new javax.swing.JTextField();
        btnLimpiarCli = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JTextField();
        ServiciosCard = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visorServicios = new javax.swing.JTable();
        btnEliminarS = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        btnModificarS = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btnRegistrarS = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        EscogerCategoriaBD = new javax.swing.JComboBox<>();
        btnBuscarS = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtCodigoS1 = new javax.swing.JTextField();
        txtnombreS = new javax.swing.JTextField();
        txtPrecioS = new javax.swing.JTextField();
        txtDescripcionS = new javax.swing.JTextField();
        btnLimpiarServicios = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        CategoriasCard = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtCodigoCA = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtNombreCA = new javax.swing.JTextField();
        txtDescripcionCA = new javax.swing.JTextField();
        btnGuardarCA = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnBuscarCA = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnModificarCA = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnEliminarCA = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane2Cliente1 = new javax.swing.JScrollPane();
        visorCategorias1 = new javax.swing.JTable();
        LimpiarCategoriaServi = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        EmpleadosCard = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtDNIE = new javax.swing.JTextField();
        txtNombreE = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtApellidoPEm = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtApellidoMEm = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtTurnoEmple = new javax.swing.JTextField();
        btnBuscarEm = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        btnGuardarEm = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        btnModificarEm = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        btnEliminarEm = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        visorEmpleado = new javax.swing.JTable();
        btnLimpiarEmpledos = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        btnPassEmple = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        boxNivelAcceso = new javax.swing.JComboBox<>();
        IngresoPrendas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbxdni = new javax.swing.JComboBox<>();
        cbxServicio = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        txtCantidadPrenda = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePrendas = new javax.swing.JTable();
        btnEliminarPrendas = new javax.swing.JButton();
        btnGuardarPrendas = new javax.swing.JButton();
        btnGuardarIngreso = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBoleta = new javax.swing.JTextArea();
        txtNombrePrenda = new javax.swing.JTextField();
        btnImprimirIngreso = new javax.swing.JButton();
        SalidaPrendas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtSalidaPrendas = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        cbxIDRegistro = new javax.swing.JComboBox<>();
        btnSlidaPrendas = new javax.swing.JButton();
        btnImprimirBoleta = new javax.swing.JButton();
        ConsultarServicios = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        CTEXTBuscar = new javax.swing.JTextField();
        PorApellido = new javax.swing.JRadioButton();
        PorDNI = new javax.swing.JRadioButton();
        PorNombre = new javax.swing.JRadioButton();
        DesdeFecha = new com.toedter.calendar.JDateChooser();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        HastaFecha = new com.toedter.calendar.JDateChooser();
        jLabel52 = new javax.swing.JLabel();
        ConCategoria = new javax.swing.JComboBox<>();
        BtnExporPDF = new javax.swing.JButton();
        CbtnBuscar = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TodoCliente = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaConsultasM = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 174, 107));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConsultas.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnConsultas.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultas.setText("CONSULTAS");
        btnConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 150, 30));

        btnmodulo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnmodulo.setForeground(new java.awt.Color(255, 255, 255));
        btnmodulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnmodulo.setText("MODULOS");
        jPanel2.add(btnmodulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        btnClientes.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClientes.setText("CLIENTES");
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 150, 40));

        btnServicios.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnServicios.setForeground(new java.awt.Color(255, 255, 255));
        btnServicios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnServicios.setText("SERVICIOS");
        btnServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 40));

        btnEmpleados.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEmpleados.setText("EMPLEADOS");
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 150, 40));

        btnSalidaPrendas.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnSalidaPrendas.setForeground(new java.awt.Color(255, 255, 255));
        btnSalidaPrendas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalidaPrendas.setText("SALIDA PRENDAS");
        btnSalidaPrendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnSalidaPrendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 150, 40));

        btnIngresoPrendas.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnIngresoPrendas.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresoPrendas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIngresoPrendas.setText("INGRESO PRENDAS");
        btnIngresoPrendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnIngresoPrendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 150, 40));

        btnCategorias.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btnCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCategorias.setText("CATEGORIAS");
        btnCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCategoriasMouseClicked(evt);
            }
        });
        jPanel2.add(btnCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 150, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 500));

        PrincipalCard.setBackground(new java.awt.Color(255, 255, 255));
        PrincipalCard.setLayout(new java.awt.CardLayout());

        Primero.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PrimeroLayout = new javax.swing.GroupLayout(Primero);
        Primero.setLayout(PrimeroLayout);
        PrimeroLayout.setHorizontalGroup(
            PrimeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrimeroLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        PrimeroLayout.setVerticalGroup(
            PrimeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrimeroLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        PrincipalCard.add(Primero, "card4");

        ClientesCard.setBackground(new java.awt.Color(255, 255, 255));
        ClientesCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DNI:");
        ClientesCard.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, 80, 20));

        txtDniCliente1.setBackground(new java.awt.Color(255, 255, 255));
        txtDniCliente1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDniCliente1.setForeground(new java.awt.Color(0, 0, 0));
        txtDniCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });
        ClientesCard.add(txtDniCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 240, -1));

        txtNombreCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreCliente.setForeground(new java.awt.Color(0, 0, 0));
        ClientesCard.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 240, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE:");
        ClientesCard.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 30, 70, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("APELLIDO P:");
        ClientesCard.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 20));

        txtApellidosPCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidosPCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtApellidosPCliente.setForeground(new java.awt.Color(0, 0, 0));
        ClientesCard.add(txtApellidosPCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 240, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DIRECCION:");
        ClientesCard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 150, 70, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("DISTRITO:");
        ClientesCard.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 180, 80, 20));

        txtDistritoCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtDistritoCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDistritoCliente.setForeground(new java.awt.Color(0, 0, 0));
        ClientesCard.add(txtDistritoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 240, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CORREO:");
        ClientesCard.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 120, 70, 20));

        txtCorreoCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreoCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCorreoCliente.setForeground(new java.awt.Color(0, 0, 0));
        ClientesCard.add(txtCorreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 240, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("CELULAR:");
        ClientesCard.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 210, 80, 20));

        txtCelularCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtCelularCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCelularCliente.setForeground(new java.awt.Color(0, 0, 0));
        ClientesCard.add(txtCelularCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 240, -1));

        btnBuscarCliente.setBackground(new java.awt.Color(255, 102, 102));
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarClienteMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BUSCAR");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnBuscarClienteLayout = new javax.swing.GroupLayout(btnBuscarCliente);
        btnBuscarCliente.setLayout(btnBuscarClienteLayout);
        btnBuscarClienteLayout.setHorizontalGroup(
            btnBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnBuscarClienteLayout.setVerticalGroup(
            btnBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ClientesCard.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        btnRegistrarCliente.setBackground(new java.awt.Color(255, 102, 102));
        btnRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarClienteMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("REGISTRAR");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnRegistrarClienteLayout = new javax.swing.GroupLayout(btnRegistrarCliente);
        btnRegistrarCliente.setLayout(btnRegistrarClienteLayout);
        btnRegistrarClienteLayout.setHorizontalGroup(
            btnRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegistrarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnRegistrarClienteLayout.setVerticalGroup(
            btnRegistrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegistrarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ClientesCard.add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 100, -1));

        btnModificarCliente.setBackground(new java.awt.Color(255, 102, 102));
        btnModificarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarClienteMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("MODIFICAR");

        javax.swing.GroupLayout btnModificarClienteLayout = new javax.swing.GroupLayout(btnModificarCliente);
        btnModificarCliente.setLayout(btnModificarClienteLayout);
        btnModificarClienteLayout.setHorizontalGroup(
            btnModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnModificarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnModificarClienteLayout.setVerticalGroup(
            btnModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnModificarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ClientesCard.add(btnModificarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        btnEliminarCliente.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarClienteMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ELIMINAR");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnEliminarClienteLayout = new javax.swing.GroupLayout(btnEliminarCliente);
        btnEliminarCliente.setLayout(btnEliminarClienteLayout);
        btnEliminarClienteLayout.setHorizontalGroup(
            btnEliminarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEliminarClienteLayout.setVerticalGroup(
            btnEliminarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ClientesCard.add(btnEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        visorClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDO_P", "APELLIDO_M", "DIRECCION", "DISTRITO", "CORREO", "CELULAR"
            }
        ));
        jScrollPane2Cliente.setViewportView(visorClientes);
        if (visorClientes.getColumnModel().getColumnCount() > 0) {
            visorClientes.getColumnModel().getColumn(3).setHeaderValue("APELLIDO_M");
            visorClientes.getColumnModel().getColumn(4).setHeaderValue("DIRECCION");
            visorClientes.getColumnModel().getColumn(5).setHeaderValue("DISTRITO");
            visorClientes.getColumnModel().getColumn(6).setHeaderValue("CORREO");
            visorClientes.getColumnModel().getColumn(7).setHeaderValue("CELULAR");
        }

        ClientesCard.add(jScrollPane2Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 540, 250));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("APELLIDO M:");
        ClientesCard.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        txtApellidosMCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidosMCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtApellidosMCliente.setForeground(new java.awt.Color(0, 0, 0));
        ClientesCard.add(txtApellidosMCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 240, -1));

        btnLimpiarCli.setBackground(new java.awt.Color(255, 102, 102));
        btnLimpiarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarCliMouseClicked(evt);
            }
        });

        jLabel44.setBackground(new java.awt.Color(204, 255, 204));
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("LIMPIAR");

        javax.swing.GroupLayout btnLimpiarCliLayout = new javax.swing.GroupLayout(btnLimpiarCli);
        btnLimpiarCli.setLayout(btnLimpiarCliLayout);
        btnLimpiarCliLayout.setHorizontalGroup(
            btnLimpiarCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLimpiarCliLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnLimpiarCliLayout.setVerticalGroup(
            btnLimpiarCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLimpiarCliLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ClientesCard.add(btnLimpiarCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, 30));
        ClientesCard.add(txtDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 240, -1));

        PrincipalCard.add(ClientesCard, "card2");

        ServiciosCard.setBackground(new java.awt.Color(255, 255, 255));
        ServiciosCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("CODIGO:");
        ServiciosCard.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("CATEGORIA:");
        ServiciosCard.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 146, 80, 20));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("NOMBRE:");
        ServiciosCard.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("DESCRIPCION:");
        ServiciosCard.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 186, 80, 20));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("PRECIO:");
        ServiciosCard.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 106, 70, 20));

        visorServicios.setBackground(new java.awt.Color(255, 255, 255));
        visorServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Categoria", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(visorServicios);

        ServiciosCard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 521, 270));

        btnEliminarS.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarSMouseClicked(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ELIMINAR");

        javax.swing.GroupLayout btnEliminarSLayout = new javax.swing.GroupLayout(btnEliminarS);
        btnEliminarS.setLayout(btnEliminarSLayout);
        btnEliminarSLayout.setHorizontalGroup(
            btnEliminarSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEliminarSLayout.setVerticalGroup(
            btnEliminarSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ServiciosCard.add(btnEliminarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 100, 40));

        btnModificarS.setBackground(new java.awt.Color(255, 102, 102));
        btnModificarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarSMouseClicked(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("MODIFICAR");

        javax.swing.GroupLayout btnModificarSLayout = new javax.swing.GroupLayout(btnModificarS);
        btnModificarS.setLayout(btnModificarSLayout);
        btnModificarSLayout.setHorizontalGroup(
            btnModificarSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnModificarSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnModificarSLayout.setVerticalGroup(
            btnModificarSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnModificarSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ServiciosCard.add(btnModificarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 100, 40));

        btnRegistrarS.setBackground(new java.awt.Color(255, 102, 102));
        btnRegistrarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarSMouseClicked(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(51, 255, 153));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("REGISTRAR");

        javax.swing.GroupLayout btnRegistrarSLayout = new javax.swing.GroupLayout(btnRegistrarS);
        btnRegistrarS.setLayout(btnRegistrarSLayout);
        btnRegistrarSLayout.setHorizontalGroup(
            btnRegistrarSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegistrarSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnRegistrarSLayout.setVerticalGroup(
            btnRegistrarSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegistrarSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ServiciosCard.add(btnRegistrarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, 40));

        EscogerCategoriaBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        EscogerCategoriaBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscogerCategoriaBDActionPerformed(evt);
            }
        });
        ServiciosCard.add(EscogerCategoriaBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 130, 30));

        btnBuscarS.setBackground(new java.awt.Color(255, 102, 102));
        btnBuscarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarSMouseClicked(evt);
            }
        });

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("BUSCAR");

        javax.swing.GroupLayout btnBuscarSLayout = new javax.swing.GroupLayout(btnBuscarS);
        btnBuscarS.setLayout(btnBuscarSLayout);
        btnBuscarSLayout.setHorizontalGroup(
            btnBuscarSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnBuscarSLayout.setVerticalGroup(
            btnBuscarSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ServiciosCard.add(btnBuscarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 40));
        ServiciosCard.add(txtCodigoS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 30));
        ServiciosCard.add(txtnombreS, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 130, 30));
        ServiciosCard.add(txtPrecioS, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, 30));
        ServiciosCard.add(txtDescripcionS, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 230, 30));

        btnLimpiarServicios.setBackground(new java.awt.Color(255, 102, 102));
        btnLimpiarServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarServiciosMouseClicked(evt);
            }
        });

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("LIMPIAR");

        javax.swing.GroupLayout btnLimpiarServiciosLayout = new javax.swing.GroupLayout(btnLimpiarServicios);
        btnLimpiarServicios.setLayout(btnLimpiarServiciosLayout);
        btnLimpiarServiciosLayout.setHorizontalGroup(
            btnLimpiarServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        btnLimpiarServiciosLayout.setVerticalGroup(
            btnLimpiarServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLimpiarServiciosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ServiciosCard.add(btnLimpiarServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 70, 40));

        PrincipalCard.add(ServiciosCard, "card4");

        CategoriasCard.setBackground(new java.awt.Color(255, 255, 255));
        CategoriasCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setText("CODIGO:");
        CategoriasCard.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 23, 77, -1));

        txtCodigoCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCAActionPerformed(evt);
            }
        });
        CategoriasCard.add(txtCodigoCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 20, 219, -1));

        jLabel24.setText("NOMBRE:");
        CategoriasCard.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 51, 77, -1));

        jLabel25.setText("DESCRIPCION:");
        CategoriasCard.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 79, -1, -1));
        CategoriasCard.add(txtNombreCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 48, 219, -1));
        CategoriasCard.add(txtDescripcionCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 76, 220, -1));

        btnGuardarCA.setBackground(new java.awt.Color(255, 102, 102));
        btnGuardarCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarCAMouseClicked(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("REGISTRAR");

        javax.swing.GroupLayout btnGuardarCALayout = new javax.swing.GroupLayout(btnGuardarCA);
        btnGuardarCA.setLayout(btnGuardarCALayout);
        btnGuardarCALayout.setHorizontalGroup(
            btnGuardarCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnGuardarCALayout.setVerticalGroup(
            btnGuardarCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        CategoriasCard.add(btnGuardarCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 30));

        btnBuscarCA.setBackground(new java.awt.Color(255, 102, 102));
        btnBuscarCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarCAMouseClicked(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("BUSCAR");

        javax.swing.GroupLayout btnBuscarCALayout = new javax.swing.GroupLayout(btnBuscarCA);
        btnBuscarCA.setLayout(btnBuscarCALayout);
        btnBuscarCALayout.setHorizontalGroup(
            btnBuscarCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnBuscarCALayout.setVerticalGroup(
            btnBuscarCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        CategoriasCard.add(btnBuscarCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        btnModificarCA.setBackground(new java.awt.Color(255, 102, 102));
        btnModificarCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarCAMouseClicked(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("MODIFICAR");

        javax.swing.GroupLayout btnModificarCALayout = new javax.swing.GroupLayout(btnModificarCA);
        btnModificarCA.setLayout(btnModificarCALayout);
        btnModificarCALayout.setHorizontalGroup(
            btnModificarCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnModificarCALayout.setVerticalGroup(
            btnModificarCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        CategoriasCard.add(btnModificarCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        btnEliminarCA.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarCAMouseClicked(evt);
            }
        });

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("ELIMINAR");

        javax.swing.GroupLayout btnEliminarCALayout = new javax.swing.GroupLayout(btnEliminarCA);
        btnEliminarCA.setLayout(btnEliminarCALayout);
        btnEliminarCALayout.setHorizontalGroup(
            btnEliminarCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnEliminarCALayout.setVerticalGroup(
            btnEliminarCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        CategoriasCard.add(btnEliminarCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        visorCategorias1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "DESCRIPCION"
            }
        ));
        jScrollPane2Cliente1.setViewportView(visorCategorias1);

        CategoriasCard.add(jScrollPane2Cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 520, 300));

        LimpiarCategoriaServi.setBackground(new java.awt.Color(255, 102, 102));
        LimpiarCategoriaServi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LimpiarCategoriaServi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimpiarCategoriaServiMouseClicked(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("L");

        javax.swing.GroupLayout LimpiarCategoriaServiLayout = new javax.swing.GroupLayout(LimpiarCategoriaServi);
        LimpiarCategoriaServi.setLayout(LimpiarCategoriaServiLayout);
        LimpiarCategoriaServiLayout.setHorizontalGroup(
            LimpiarCategoriaServiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        LimpiarCategoriaServiLayout.setVerticalGroup(
            LimpiarCategoriaServiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        CategoriasCard.add(LimpiarCategoriaServi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 30, 20));

        PrincipalCard.add(CategoriasCard, "card5");

        EmpleadosCard.setBackground(new java.awt.Color(255, 255, 255));
        EmpleadosCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("DNI:");
        EmpleadosCard.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("NOMBRE:");
        EmpleadosCard.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));
        EmpleadosCard.add(txtDNIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, -1));
        EmpleadosCard.add(txtNombreE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, -1));

        jLabel34.setText("APELLIDO PATERNO:");
        EmpleadosCard.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        EmpleadosCard.add(txtApellidoPEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 150, -1));

        jLabel35.setText("APELLIDO MATERNO:");
        EmpleadosCard.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        EmpleadosCard.add(txtApellidoMEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 150, -1));

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("TURNO:");
        EmpleadosCard.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, -1));
        EmpleadosCard.add(txtTurnoEmple, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 150, -1));

        btnBuscarEm.setBackground(new java.awt.Color(255, 102, 102));
        btnBuscarEm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarEmMouseClicked(evt);
            }
        });

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("BUSCAR");

        javax.swing.GroupLayout btnBuscarEmLayout = new javax.swing.GroupLayout(btnBuscarEm);
        btnBuscarEm.setLayout(btnBuscarEmLayout);
        btnBuscarEmLayout.setHorizontalGroup(
            btnBuscarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnBuscarEmLayout.setVerticalGroup(
            btnBuscarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EmpleadosCard.add(btnBuscarEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 120, 40));

        btnGuardarEm.setBackground(new java.awt.Color(255, 102, 102));
        btnGuardarEm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarEmMouseClicked(evt);
            }
        });

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("REGISTRAR");

        javax.swing.GroupLayout btnGuardarEmLayout = new javax.swing.GroupLayout(btnGuardarEm);
        btnGuardarEm.setLayout(btnGuardarEmLayout);
        btnGuardarEmLayout.setHorizontalGroup(
            btnGuardarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGuardarEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnGuardarEmLayout.setVerticalGroup(
            btnGuardarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGuardarEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EmpleadosCard.add(btnGuardarEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 120, 40));

        btnModificarEm.setBackground(new java.awt.Color(255, 102, 102));
        btnModificarEm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarEmMouseClicked(evt);
            }
        });

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("MODIFICAR");

        javax.swing.GroupLayout btnModificarEmLayout = new javax.swing.GroupLayout(btnModificarEm);
        btnModificarEm.setLayout(btnModificarEmLayout);
        btnModificarEmLayout.setHorizontalGroup(
            btnModificarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnModificarEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnModificarEmLayout.setVerticalGroup(
            btnModificarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnModificarEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EmpleadosCard.add(btnModificarEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 120, 40));

        btnEliminarEm.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarEm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarEmMouseClicked(evt);
            }
        });

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("ELIMINAR");

        javax.swing.GroupLayout btnEliminarEmLayout = new javax.swing.GroupLayout(btnEliminarEm);
        btnEliminarEm.setLayout(btnEliminarEmLayout);
        btnEliminarEmLayout.setHorizontalGroup(
            btnEliminarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEliminarEmLayout.setVerticalGroup(
            btnEliminarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarEmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EmpleadosCard.add(btnEliminarEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 120, 40));

        visorEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "TURNO"
            }
        ));
        jScrollPane3.setViewportView(visorEmpleado);

        EmpleadosCard.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 530, 270));

        btnLimpiarEmpledos.setBackground(new java.awt.Color(255, 102, 102));
        btnLimpiarEmpledos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarEmpledos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarEmpledosMouseClicked(evt);
            }
        });

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("LIMPIAR");

        javax.swing.GroupLayout btnLimpiarEmpledosLayout = new javax.swing.GroupLayout(btnLimpiarEmpledos);
        btnLimpiarEmpledos.setLayout(btnLimpiarEmpledosLayout);
        btnLimpiarEmpledosLayout.setHorizontalGroup(
            btnLimpiarEmpledosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnLimpiarEmpledosLayout.setVerticalGroup(
            btnLimpiarEmpledosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        EmpleadosCard.add(btnLimpiarEmpledos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 120, 40));

        btnPassEmple.setBackground(new java.awt.Color(255, 102, 102));
        btnPassEmple.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPassEmple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPassEmpleMouseClicked(evt);
            }
        });

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("PASSWORD");

        javax.swing.GroupLayout btnPassEmpleLayout = new javax.swing.GroupLayout(btnPassEmple);
        btnPassEmple.setLayout(btnPassEmpleLayout);
        btnPassEmpleLayout.setHorizontalGroup(
            btnPassEmpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnPassEmpleLayout.setVerticalGroup(
            btnPassEmpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        EmpleadosCard.add(btnPassEmple, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 120, 40));

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("NIVEL ACCESO:");
        EmpleadosCard.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, -1));

        boxNivelAcceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        EmpleadosCard.add(boxNivelAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 150, -1));

        PrincipalCard.add(EmpleadosCard, "card6");

        IngresoPrendas.setBackground(new java.awt.Color(255, 255, 255));
        IngresoPrendas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("SELECCION SERVICIO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        IngresoPrendas.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 30));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SELECCION DNI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        IngresoPrendas.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        cbxdni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IngresoPrendas.add(cbxdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 120, 30));

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        IngresoPrendas.add(cbxServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 120, 30));

        jTextField1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("INGRESO DE PRENDAS");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        IngresoPrendas.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 280, 30));

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));

        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("PRENDA");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        IngresoPrendas.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 30));

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));

        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("CANTIDAD");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        IngresoPrendas.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, 30));

        txtCantidadPrenda.setBackground(new java.awt.Color(153, 153, 153));
        IngresoPrendas.add(txtCantidadPrenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 100, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        IngresoPrendas.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 10, 410));

        tablePrendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRENDA", "CANTIDAD"
            }
        ));
        jScrollPane4.setViewportView(tablePrendas);

        IngresoPrendas.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 280, 160));

        btnEliminarPrendas.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminarPrendas.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminarPrendas.setText("Eliminar");
        btnEliminarPrendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPrendasActionPerformed(evt);
            }
        });
        IngresoPrendas.add(btnEliminarPrendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 90, -1));

        btnGuardarPrendas.setBackground(new java.awt.Color(255, 102, 102));
        btnGuardarPrendas.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardarPrendas.setText("Guardar");
        btnGuardarPrendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPrendasActionPerformed(evt);
            }
        });
        IngresoPrendas.add(btnGuardarPrendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 80, -1));

        btnGuardarIngreso.setBackground(new java.awt.Color(255, 102, 102));
        btnGuardarIngreso.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardarIngreso.setText("GUARDARINGRESO");
        btnGuardarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarIngresoActionPerformed(evt);
            }
        });
        IngresoPrendas.add(btnGuardarIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 150, 40));

        txtBoleta.setEditable(false);
        txtBoleta.setBackground(new java.awt.Color(0, 0, 0));
        txtBoleta.setColumns(20);
        txtBoleta.setForeground(new java.awt.Color(255, 255, 255));
        txtBoleta.setRows(5);
        jScrollPane2.setViewportView(txtBoleta);

        IngresoPrendas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 420));

        txtNombrePrenda.setBackground(new java.awt.Color(153, 153, 153));
        IngresoPrendas.add(txtNombrePrenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 100, -1));

        btnImprimirIngreso.setBackground(new java.awt.Color(255, 102, 102));
        btnImprimirIngreso.setForeground(new java.awt.Color(0, 0, 0));
        btnImprimirIngreso.setText("IMPRIMIR");
        btnImprimirIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirIngresoActionPerformed(evt);
            }
        });
        IngresoPrendas.add(btnImprimirIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 140, 40));

        PrincipalCard.add(IngresoPrendas, "card7");

        SalidaPrendas.setBackground(new java.awt.Color(255, 255, 255));
        SalidaPrendas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSalidaPrendas.setBackground(new java.awt.Color(0, 0, 0));
        txtSalidaPrendas.setColumns(20);
        txtSalidaPrendas.setForeground(new java.awt.Color(255, 255, 255));
        txtSalidaPrendas.setRows(5);
        jScrollPane5.setViewportView(txtSalidaPrendas);

        SalidaPrendas.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 290, 440));

        jPanel5.setBackground(new java.awt.Color(51, 255, 204));
        jPanel5.setForeground(new java.awt.Color(255, 102, 102));

        jLabel46.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("ID Ingreso Registro");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        SalidaPrendas.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 170, 50));

        cbxIDRegistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SalidaPrendas.add(cbxIDRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 170, 50));

        btnSlidaPrendas.setBackground(new java.awt.Color(51, 255, 204));
        btnSlidaPrendas.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnSlidaPrendas.setForeground(new java.awt.Color(0, 0, 0));
        btnSlidaPrendas.setText("GuardarSalida");
        btnSlidaPrendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSlidaPrendasActionPerformed(evt);
            }
        });
        SalidaPrendas.add(btnSlidaPrendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 170, 50));

        btnImprimirBoleta.setBackground(new java.awt.Color(0, 255, 204));
        btnImprimirBoleta.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnImprimirBoleta.setForeground(new java.awt.Color(0, 0, 0));
        btnImprimirBoleta.setText("IMPRIMIR");
        btnImprimirBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirBoletaActionPerformed(evt);
            }
        });
        SalidaPrendas.add(btnImprimirBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 170, 50));

        PrincipalCard.add(SalidaPrendas, "card8");

        ConsultarServicios.setBackground(new java.awt.Color(255, 255, 255));
        ConsultarServicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("HASTA:");
        ConsultarServicios.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        ConsultarServicios.add(CTEXTBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 30));

        GRUPO1.add(PorApellido);
        PorApellido.setText("APELLIDOS");
        ConsultarServicios.add(PorApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 30));

        GRUPO1.add(PorDNI);
        PorDNI.setText("DNI");
        ConsultarServicios.add(PorDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, 30));

        GRUPO1.add(PorNombre);
        PorNombre.setText("NOMBRES");
        ConsultarServicios.add(PorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 110, 30));
        ConsultarServicios.add(DesdeFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 170, -1));

        jLabel50.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("CATEGORIA:");
        ConsultarServicios.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel51.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("DESDE:");
        ConsultarServicios.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        ConsultarServicios.add(HastaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 170, -1));

        jLabel52.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("BUSCAR");
        ConsultarServicios.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        ConCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ConsultarServicios.add(ConCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 130, 30));

        BtnExporPDF.setText("PDF");
        BtnExporPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExporPDFActionPerformed(evt);
            }
        });
        ConsultarServicios.add(BtnExporPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 120, 40));

        CbtnBuscar.setText("BUSCAR");
        CbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbtnBuscarActionPerformed(evt);
            }
        });
        ConsultarServicios.add(CbtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 120, 40));

        TodoCliente.setColumns(20);
        TodoCliente.setRows(5);
        jScrollPane7.setViewportView(TodoCliente);

        ConsultarServicios.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 270, 380));

        TablaConsultasM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDO"
            }
        ));
        TablaConsultasM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaConsultasMMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TablaConsultasM);

        ConsultarServicios.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 270, 170));

        PrincipalCard.add(ConsultarServicios, "card9");

        jPanel1.add(PrincipalCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 600, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//-------------------------CLIENTES--------------------------------
    private void btnRegistrarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarClienteMouseClicked
        // TODO add your handling code here:
        String dni = txtDniCliente1.getText();
        String nombre = txtNombreCliente.getText();
        String apellidoM = txtApellidosMCliente.getText();
        String apellidoP = txtApellidosPCliente.getText();
        String direccion = txtDireccionCliente.getText();
        String distrito = txtDistritoCliente.getText();
        String correo = txtCorreoCliente.getText();
        String celular = txtCelularCliente.getText();

        Cliente nuevoCliente = new Cliente(dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular);
        int registrosInsertados = clienteImplementacion.insertar(nuevoCliente);

        if (registrosInsertados > 0) {
            JOptionPane.showMessageDialog(this, "Cliente registrado correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar el cliente.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarClienteMouseClicked

    private void btnEliminarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseClicked
        // TODO add your handling code here:
        String dniAEliminar = txtDniCliente1.getText();
        clienteImplementacion.eliminar(dniAEliminar);
    }//GEN-LAST:event_btnEliminarClienteMouseClicked

    private void btnBuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarClienteMouseClicked
        // TODO add your handling code here:
        String dni = txtDniCliente1.getText(); // 1. Obtener el DNI del campo de texto

        Cliente clienteEncontrado = (Cliente) clienteImplementacion.buscarPorCodigo(dni); // 2. Buscar el cliente por DNI

        if (clienteEncontrado != null) {
            // 3. Actualizar los campos si se encuentra el cliente
            txtNombreCliente.setText(clienteEncontrado.getNombre());
            txtApellidosMCliente.setText(clienteEncontrado.getApellidoM());
            txtApellidosPCliente.setText(clienteEncontrado.getApellidoP());
            txtDireccionCliente.setText(clienteEncontrado.getDireccion());
            txtDistritoCliente.setText(clienteEncontrado.getDistrito());
            txtCorreoCliente.setText(clienteEncontrado.getCorreo());
            txtCelularCliente.setText(clienteEncontrado.getCelular());
        } else {
            // Manejar el caso en el que no se encuentre el cliente
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Busqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarClienteMouseClicked

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void cargarDatosClientes() {
        DefaultTableModel modelo = (DefaultTableModel) visorClientes.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        List<Cliente> clientes = clienteImplementacion.seleccionar(); // Llama a seleccionar

        for (Cliente cliente : clientes) {
            modelo.addRow(new Object[]{
                cliente.getDni(),
                cliente.getNombre(),
                cliente.getApellidoM(),
                cliente.getApellidoP(),
                cliente.getDireccion(),
                cliente.getDistrito(),
                cliente.getCorreo(),
                cliente.getCelular()
            });
        }
    }
    private void btnModificarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarClienteMouseClicked
        // TODO add your handling code here:
        String dni = txtDniCliente1.getText();
        String nombre = txtNombreCliente.getText();
        String apellidoM = txtApellidosMCliente.getText();
        String apellidoP = txtApellidosPCliente.getText();
        String direccion = txtDireccionCliente.getText();
        String distrito = txtDistritoCliente.getText();
        String correo = txtCorreoCliente.getText();
        String celular = txtCelularCliente.getText();

        Cliente clienteModificado = new Cliente(dni, nombre, apellidoM, apellidoP, direccion, distrito, correo, celular);
        int registrosActualizados = clienteImplementacion.actualizar(clienteModificado);

        if (registrosActualizados > 0) {
            JOptionPane.showMessageDialog(this, "Cliente modificado correctamente.", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al modificar el cliente.", "Error de Modificación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarClienteMouseClicked

    private void txtCodigoCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCAActionPerformed

    private void btnCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoriasMouseClicked

    private void btnGuardarCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCAMouseClicked
        // TODO add your handling code here:
        String codigo = txtCodigoCA.getText(); // Obtener el código de la categoría
        String nombre = txtNombreCA.getText(); // Obtener el nombre de la categoría
        String descripcion = txtDescripcionCA.getText(); // Obtener la descripción de la categoría

        CategoriServicios nuevaCategoria = new CategoriServicios(codigo, nombre, descripcion); // Crear un nuevo objeto de categoría
        int registrosInsertados = implementacionCategoriaServicios.insertar(nuevaCategoria); // Insertar la categoría en la base de datos

        if (registrosInsertados > 0) {
            JOptionPane.showMessageDialog(this, "Categoría registrada correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE); // Mostrar mensaje de éxito
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la categoría.", "Error de Registro", JOptionPane.ERROR_MESSAGE); // Mostrar mensaje de error
        }
    }//GEN-LAST:event_btnGuardarCAMouseClicked

    private void btnEliminarCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarCAMouseClicked
        // TODO add your handling code here:
        String codigoAEliminar = txtCodigoCA.getText(); // Obtener el código de la categoría a eliminar
        int registrosEliminados = implementacionCategoriaServicios.eliminar(codigoAEliminar); // Eliminar la categoría de la base de datos

        if (registrosEliminados > 0) {
            JOptionPane.showMessageDialog(this, "Categoría eliminada correctamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE); // Mostrar mensaje de éxito
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar la categoría.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE); // Mostrar mensaje de error
        }
    }//GEN-LAST:event_btnEliminarCAMouseClicked

    private void btnBuscarCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCAMouseClicked
        // TODO add your handling code here:
        String codigo = txtCodigoCA.getText(); // 1. Obtener el código de la categoría del campo de texto

        CategoriServicios categoriaEncontrada = (CategoriServicios) implementacionCategoriaServicios.buscarPorCodigo(codigo); // 2. Buscar la categoría por código

        if (categoriaEncontrada != null) {
            // 3. Actualizar los campos si se encuentra la categoría
            txtNombreCA.setText(categoriaEncontrada.getNombre());
            txtDescripcionCA.setText(categoriaEncontrada.getDescripcion());
        } else {
            // Manejar el caso en el que no se encuentre la categoría
            JOptionPane.showMessageDialog(this, "No se encontró la categoría.", "Búsqueda Fallida", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarCAMouseClicked
    private void cargarDatosCategorias() {
        DefaultTableModel modelo = (DefaultTableModel) visorCategorias1.getModel();
        modelo.setRowCount(0);

        List<CategoriServicios> categorias = implementacionCategoriaServicios.seleccionar();

        for (CategoriServicios categoria : categorias) {
            modelo.addRow(new Object[]{
                categoria.getCodigo(),
                categoria.getNombre(),
                categoria.getDescripcion()
            });
        }
    }

    private void btnModificarCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarCAMouseClicked
        // TODO add your handling code here:
        // Obtener datos de los campos
        String codigo = txtCodigoCA.getText();
        String nombre = txtNombreCA.getText();
        String descripcion = txtDescripcionCA.getText();

        // Crear una categoría de servicios con los datos modificados
        CategoriServicios categoriaModificada = new CategoriServicios(codigo, nombre, descripcion);

        // Actualizar la categoría en la base de datos
        int registrosActualizados = implementacionCategoriaServicios.actualizar(categoriaModificada);

        if (registrosActualizados > 0) {
            JOptionPane.showMessageDialog(this, "Categoría de servicios modificada correctamente.", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al modificar la categoría de servicios.", "Error de Modificación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarCAMouseClicked

    private void btnRegistrarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarSMouseClicked
        // TODO add your handling code here:
        String codigo = txtCodigoS1.getText();
        String nombre = txtnombreS.getText();
        String descripcion = txtDescripcionS.getText();
        double precio = Double.parseDouble(txtPrecioS.getText());
        String categoria = (String) EscogerCategoriaBD.getSelectedItem();

        // Crear un servicio con los datos proporcionados
        Servicios nuevoServicio = new Servicios(codigo, nombre, descripcion, precio, categoria);

        // Insertar el servicio en la base de datos
        int registrosInsertados = implementacionServicios.insertar(nuevoServicio);

        if (registrosInsertados > 0) {
            JOptionPane.showMessageDialog(this, "Servicio registrado correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar el servicio.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarSMouseClicked

    private void btnEliminarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarSMouseClicked
        // TODO add your handling code here:
        // Obtener el código del servicio a eliminar
        String codigoAEliminar = txtCodigoS1.getText();

        // Eliminar el servicio de la base de datos
        implementacionServicios.eliminar(codigoAEliminar);
    }//GEN-LAST:event_btnEliminarSMouseClicked

    private void btnBuscarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarSMouseClicked
        // TODO add your handling code here:
        String codigo = txtCodigoS1.getText();

        // Buscar el servicio por su código
        Servicios servicioEncontrado = (Servicios) implementacionServicios.buscarPorCodigo(codigo);

        if (servicioEncontrado != null) {
            // Actualizar los campos si se encuentra el servicio
            txtnombreS.setText(servicioEncontrado.getNombre());
            txtDescripcionS.setText(servicioEncontrado.getDescripcion());
            txtPrecioS.setText(String.valueOf(servicioEncontrado.getPrecio()));
            EscogerCategoriaBD.setSelectedItem(servicioEncontrado.getCategoria());
        } else {
            // Manejar el caso en el que no se encuentre el servicio
        }
    }//GEN-LAST:event_btnBuscarSMouseClicked
    private void cargarDatosServicios() {
        DefaultTableModel modelo = (DefaultTableModel) visorServicios.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        List<Servicios> servicios = implementacionServicios.seleccionar(); // Llama a seleccionar

        for (Servicios servicio : servicios) {
            modelo.addRow(new Object[]{
                servicio.getCodigo(),
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getPrecio(),
                servicio.getCategoria()
            });
        }
    }
    private void btnModificarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarSMouseClicked
        // TODO add your handling code here:
        String codigo = txtCodigoS1.getText();
        String nombre = txtnombreS.getText();
        String descripcion = txtDescripcionS.getText();
        double precio = Double.parseDouble(txtPrecioS.getText());
        String categoria = EscogerCategoriaBD.getSelectedItem().toString(); // Obtener el elemento seleccionado del JComboBox

        // Crear un servicio con los datos modificados
        Servicios servicioModificado = new Servicios(codigo, nombre, descripcion, precio, categoria);

        // Actualizar el servicio en la base de datos
        int registrosActualizados = implementacionServicios.actualizar(servicioModificado);

        if (registrosActualizados > 0) {
            JOptionPane.showMessageDialog(this, "Servicio modificado correctamente.", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al modificar el servicio.", "Error de Modificación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarSMouseClicked

    private void btnEliminarEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmMouseClicked
        // TODO add your handling code here:
        // Obtener el DNI del empleado a eliminar
        String dniAEliminar = txtDNIE.getText();

        // Eliminar el empleado de la base de datos
        int registrosEliminados = implementacionEmpleado.eliminar(dniAEliminar);

        if (registrosEliminados > 0) {
            JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el empleado.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarEmMouseClicked

    private void btnGuardarEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarEmMouseClicked
        // TODO add your handling code here:
        // Obtener datos de los campos
        String dni = txtDNIE.getText();
        String nombre = txtNombreE.getText();
        String apellidoM = txtApellidoMEm.getText();
        String apellidoP = txtApellidoPEm.getText();
        int turno = Integer.parseInt(txtTurnoEmple.getText());

        // Crear un empleado con los datos proporcionados
        Empleaado nuevoEmpleado = new Empleaado(turno, dni, nombre, apellidoM, apellidoP);

        // Insertar el empleado en la base de datos
        int registrosInsertados = implementacionEmpleado.insertar(nuevoEmpleado);

        if (registrosInsertados > 0) {
            JOptionPane.showMessageDialog(this, "Empleado registrado correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar el empleado.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarEmMouseClicked

    private void btnBuscarEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarEmMouseClicked
        // TODO add your handling code here:
        // Obtener el DNI del empleado a buscar
        String dni = txtDNIE.getText();

        // Buscar el empleado por DNI
        Empleaado empleadoEncontrado = (Empleaado) implementacionEmpleado.buscarPorCodigo(dni);

        if (empleadoEncontrado != null) {
            // Actualizar los campos si se encuentra el empleado
            txtNombreE.setText(empleadoEncontrado.getNombre());
            txtApellidoMEm.setText(empleadoEncontrado.getApellidoM());
            txtApellidoPEm.setText(empleadoEncontrado.getApellidoP());
            txtTurnoEmple.setText(String.valueOf(empleadoEncontrado.getTurno()));
        } else {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado.", "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
            // Manejar el caso en el que no se encuentre el empleado
        }
    }//GEN-LAST:event_btnBuscarEmMouseClicked
    private void cargarDatosEmpleados() {
        DefaultTableModel modelo = (DefaultTableModel) visorEmpleado.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        List<Empleaado> empleados = implementacionEmpleado.seleccionar(); // Llama a seleccionar

        for (Empleaado empleado : empleados) {
            modelo.addRow(new Object[]{
                empleado.getDni(),
                empleado.getNombre(),
                empleado.getApellidoM(),
                empleado.getApellidoP(),
                empleado.getTurno()
            });
        }
    }
    private void btnModificarEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEmMouseClicked
        // TODO add your handling code here:
        // Obtener datos de los campos
        String dni = txtDNIE.getText();
        String nombre = txtNombreE.getText();
        String apellidoM = txtApellidoMEm.getText();
        String apellidoP = txtApellidoPEm.getText();
        int turno = Integer.parseInt(txtTurnoEmple.getText());

        // Crear un empleado con los datos modificados
        Empleaado empleadoModificado = new Empleaado(turno, dni, nombre, apellidoM, apellidoP);

        // Actualizar el empleado en la base de datos
        int registrosActualizados = implementacionEmpleado.actualizar(empleadoModificado);

        if (registrosActualizados > 0) {
            JOptionPane.showMessageDialog(this, "Empleado modificado correctamente.", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al modificar el empleado.", "Error de Modificación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarEmMouseClicked

    private void btnPassEmpleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPassEmpleMouseClicked
        // TODO add your handling code here:
        // Obtener datos del ComboBox y del campo de texto
        String nivelAcceso = boxNivelAcceso.getSelectedItem().toString();
        String dniEmpleado = txtDNIE.getText();

        // Solicitar contraseña al usuario mediante JOptionPane
        String password = JOptionPane.showInputDialog(this, "Ingrese la contraseña:");

        // Llamar al método en ImplementacionEmpleado
        boolean insercionExitosa = implementacionEmpleado2.enviarDatosABaseDeDatos(nivelAcceso, password, dniEmpleado);

        if (insercionExitosa) {
            JOptionPane.showMessageDialog(this, "Usuario creado correctamente.", "Creación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al crear el usuario.", "Error de Creación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPassEmpleMouseClicked

    private void btnLimpiarCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarCliMouseClicked
        // TODO add your handling code here:
        txtDniCliente1.setText(" ");
        txtNombreCliente.setText(" ");
        txtApellidosPCliente.setText(" ");
        txtApellidosMCliente.setText(" ");
        txtDistritoCliente.setText(" ");
        txtCelularCliente.setText(" ");
        txtCorreoCliente.setText(" ");
        txtDireccionCliente.setText(" ");
    }//GEN-LAST:event_btnLimpiarCliMouseClicked

    private void btnLimpiarServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarServiciosMouseClicked
        // TODO add your handling code here:
        txtCodigoS1.setText(" ");
        txtnombreS.setText(" ");
        txtPrecioS.setText(" ");
        txtDescripcionS.setText(" ");
    }//GEN-LAST:event_btnLimpiarServiciosMouseClicked

    private void LimpiarCategoriaServiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimpiarCategoriaServiMouseClicked
        // TODO add your handling code here:
        txtCodigoCA.setText(" ");
        txtNombreCA.setText(" ");
        txtDescripcionCA.setText(" ");
    }//GEN-LAST:event_LimpiarCategoriaServiMouseClicked

    private void btnLimpiarEmpledosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEmpledosMouseClicked
        // TODO add your handling code here:
        txtDNIE.setText(" ");
        txtNombreE.setText(" ");
        txtApellidoPEm.setText(" ");
        txtApellidoMEm.setText(" ");
        txtTurnoEmple.setText(" ");
    }//GEN-LAST:event_btnLimpiarEmpledosMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void EscogerCategoriaBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscogerCategoriaBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EscogerCategoriaBDActionPerformed

    private void btnGuardarPrendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPrendasActionPerformed
        // TODO add your handling code here:
//       String codigo = txtIdPrenda.getText();
//        String nombrePrendas = txtNombrePrenda.getText();
//        int cantidadPrendas = Integer.parseInt(txtCantidadPrenda.getText());
//
//        // Crear un empleado con los datos proporcionados
//         Prenda prendaNueva = new Prenda(codigo, nombrePrendas, cantidadPrendas);
//         prendasTemporales.add(prendaNueva);
//        // Insertar el empleado en la base de datos
//        
//        int registrosInsertados = implementacionPrendas.insertar(prendaNueva);
//
//        if (registrosInsertados > 0) {
//            JOptionPane.showMessageDialog(this, "Prenda registrado correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la prenda.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
//        }
        //  String codigo = txtIdPrenda.getText();
        String nombrePrendas = txtNombrePrenda.getText();
        int cantidadPrendas = Integer.parseInt(txtCantidadPrenda.getText());

        // Crear un objeto Prenda con los datos proporcionados
        Prenda prendaNueva = new Prenda(nombrePrendas, cantidadPrendas);

        // Agregar la nueva prenda a la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablePrendas.getModel();
        modelo.addRow(new Object[]{
            prendaNueva.getPrenda(),
            prendaNueva.getCantidad()
        });

        // Limpiar los campos después de agregar la prenda a la tabla
        txtNombrePrenda.setText("");
        txtCantidadPrenda.setText("");
    }//GEN-LAST:event_btnGuardarPrendasActionPerformed

    private void btnEliminarPrendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPrendasActionPerformed
//        // TODO add your handling code here:
//        String codigo = txtIdPrenda.getText();
//
//        // Eliminar el empleado de la base de datos
//        int registrosEliminados = implementacionPrendas.eliminar(codigo);
//
//        if (registrosEliminados > 0) {
//            JOptionPane.showMessageDialog(this, "Prenda eliminado correctamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el prenda.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
//        }
// Obtener el índice de la fila seleccionada en la tabla
        int selectedRow = tablePrendas.getSelectedRow();

        // Verificar si hay una fila seleccionada para eliminar
        if (selectedRow != -1) {
            // Eliminar la fila seleccionada de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablePrendas.getModel();
            modelo.removeRow(selectedRow);
        } else {
            // Si no se seleccionó ninguna fila, mostrar un mensaje de advertencia
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para eliminar.", "Selección requerida", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarPrendasActionPerformed

    private void btnGuardarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarIngresoActionPerformed

        RestoFunciones funciones = new RestoFunciones();
        String dniCliente = cbxdni.getSelectedItem().toString();
        String servicioElegido = cbxServicio.getSelectedItem().toString();
        java.util.Date fechaActual = new java.util.Date();
        int idRegistroPrendas = 0;

        try {
            idRegistroPrendas = funciones.obtenerProximoIDRegistro(); // Obtener el mismo ID para idRegistroPrendas y codigoPrenda
        } catch (SQLException ex) {
            Logger.getLogger(ModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        int codigoPrenda = idRegistroPrendas;

        // Guardar registros de prendas temporales
        DefaultTableModel modeloPrendas = (DefaultTableModel) tablePrendas.getModel();
        int filasPrendas = modeloPrendas.getRowCount();

        for (int i = 0; i < filasPrendas; i++) {
            // String codigoPrendaTemp = modeloPrendas.getValueAt(i, 0).toString();
            String nombrePrenda = modeloPrendas.getValueAt(i, 0).toString(); // Suponiendo que el nombre está en la columna 1
            int cantidadPrenda = Integer.parseInt(modeloPrendas.getValueAt(i, 1).toString()); // Suponiendo que la cantidad está en la columna 2
            String codigoPrendaTemp = null;
            try {
                codigoPrendaTemp = funciones.obtenerProximoIDPrenda();
            } catch (SQLException ex) {
                Logger.getLogger(ModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Crear objeto Prenda con los datos de la tabla temporal
            Prenda prendaTemporal = new Prenda(codigoPrendaTemp, nombrePrenda, cantidadPrenda, codigoPrenda);

            // Insertar la prenda en la base de datos
            int registrosInsertados = implementacionPrendas.insertar(prendaTemporal);

            if (registrosInsertados > 0) {
                // Aquí podrías agregar lógica adicional si lo necesitas
            }
        }

        // Luego de guardar las prendas, ahora guardamos el registro de ingreso
        RegistroPrendas registro = new RegistroPrendas(idRegistroPrendas, fechaActual, servicioElegido, dniCliente, servicioElegido, codigoPrenda);
        int registrosInsertados = funciones.insertarRegistroPrendas(registro);

        if (registrosInsertados > 0) {
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Limpiar la tabla o realizar otras acciones después de guardar
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        GenerarReportes generador = new GenerarReportes();
        String contenido = generador.actualizarInformacion(idRegistroPrendas, fechaActual, dniCliente, servicioElegido, codigoPrenda);

        txtBoleta.setText(contenido);
    }//GEN-LAST:event_btnGuardarIngresoActionPerformed

    private void btnSlidaPrendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlidaPrendasActionPerformed
        // TODO add your handling code here:
        String idRegistroPrendas = cbxIDRegistro.getSelectedItem().toString();
        GenerarReportes generador = new GenerarReportes();
        String contenido = generador.actualizarSalida(idRegistroPrendas);

        txtSalidaPrendas.setText(contenido);

    }//GEN-LAST:event_btnSlidaPrendasActionPerformed

    private void btnImprimirBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirBoletaActionPerformed
        String contenido = txtSalidaPrendas.getText();

        // Generar un nombre de archivo único
        String nombreArchivo = "boleta_SALIDA_" + System.currentTimeMillis() + ".txt";

        // Llamar a un método para guardar el contenido en un archivo con el nombre generado
        GenerarReportes generador = new GenerarReportes();
        String llamada = generador.guardarEnArchivo(contenido, nombreArchivo);
        System.out.println("Archivo creado: " + llamada);
    }//GEN-LAST:event_btnImprimirBoletaActionPerformed

    private void btnImprimirIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirIngresoActionPerformed
        // TODO add your handling code here:
        String contenido = txtBoleta.getText();

        // Generar un nombre de archivo único
        String nombreArchivo = "boleta_ENTRADA_" + System.currentTimeMillis() + ".txt";

        // Llamar a un método para guardar el contenido en un archivo con el nombre generado
        GenerarReportes generador = new GenerarReportes();
        String llamada = generador.guardarEnArchivo(contenido, nombreArchivo);
        System.out.println("Archivo creado: " + llamada);
    }//GEN-LAST:event_btnImprimirIngresoActionPerformed

    private void CbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbtnBuscarActionPerformed
        String busqueda = CTEXTBuscar.getText(); // Obtener el texto de búsqueda

        // Obtener el tipo de búsqueda seleccionado
        String tipoBusqueda = "";
        if (PorDNI.isSelected()) {
            tipoBusqueda = "dni";
        } else if (PorNombre.isSelected()) {
            tipoBusqueda = "nombre";
        } else if (PorApellido.isSelected()) {
            tipoBusqueda = "apellido";
        }

        // Obtener las fechas
        Date fechaDesde = DesdeFecha.getDate();
        Date fechaHasta = HastaFecha.getDate();

        // Obtener la categoría seleccionada
        String categoriaSeleccionada = ConCategoria.getSelectedItem().toString();

        // Realizar la búsqueda según el tipo seleccionado
        List<Cliente> resultadosBusqueda = new ArrayList<>();
        if ("dni".equals(tipoBusqueda)) {
            resultadosBusqueda = GenerarReportes.buscarPorDNI(busqueda, fechaDesde, fechaHasta, categoriaSeleccionada);
        } else if ("nombre".equals(tipoBusqueda)) {
            resultadosBusqueda = GenerarReportes.buscarPorNombre(busqueda, fechaDesde, fechaHasta, categoriaSeleccionada);
        } else if ("apellido".equals(tipoBusqueda)) {
            resultadosBusqueda = GenerarReportes.buscarPorApellido(busqueda, fechaDesde, fechaHasta, categoriaSeleccionada);
        }

        // Mostrar los resultados en la tabla
        DefaultTableModel modelo = (DefaultTableModel) TablaConsultasM.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de mostrar nuevos resultados

        for (Cliente cliente : resultadosBusqueda) {
            modelo.addRow(new Object[]{
                cliente.getDni(),
                cliente.getNombre(),
                cliente.getApellidoP(),});
        }


    }//GEN-LAST:event_CbtnBuscarActionPerformed

    private void TablaConsultasMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaConsultasMMouseClicked
        JTable target = (JTable) evt.getSource();
        int row = target.getSelectedRow(); // Obtiene la fila seleccionada

        // Obtiene el DNI de la fila seleccionada
        String dni = target.getValueAt(row, 0).toString();
        RegistroPrendasImplementacion implementacion = new RegistroPrendasImplementacion();

        // Llamar al método buscarVariosCodigo para obtener la lista de registros
        List<RegistroPrendas> registros = implementacion.buscarVariosCodigo(dni);
        Date fechaDesde = DesdeFecha.getDate();
        Date fechaHasta = HastaFecha.getDate();

        // Obtener la categoría seleccionada
        String categoriaSeleccionada = ConCategoria.getSelectedItem().toString();

        // Crear un JComboBox para mostrar las fechas
        JComboBox<Date> fechaComboBox = new JComboBox<>();
        for (RegistroPrendas registro : registros) {
            // Filtrar por el servicio deseado y el rango de fechas
            if (registro.getIdFecha().after(fechaDesde) && registro.getIdFecha().before(fechaHasta)
                    && registro.getCodigoServicio().equals(categoriaSeleccionada)) {
                fechaComboBox.addItem(registro.getIdFecha());
            }
        }

        // Mostrar el JOptionPane con el JComboBox
        int option = JOptionPane.showConfirmDialog(null, fechaComboBox, "Seleccione una fecha", JOptionPane.OK_CANCEL_OPTION);

        // Si se seleccionó una fecha y se presionó OK
        if (option == JOptionPane.OK_OPTION) {
            // Obtener la fecha seleccionada del JComboBox
            Date fechaSeleccionada = (Date) fechaComboBox.getSelectedItem();
            System.out.println("Fecha seleccionada: " + fechaSeleccionada);

            // Buscar el idRegistroPrendas correspondiente a la fecha seleccionada
            int idRegistroPrendasSeleccionado = -1; // Valor predeterminado si no se encuentra
            for (RegistroPrendas registro : registros) {
                if (registro.getIdFecha().equals(fechaSeleccionada)) {
                    idRegistroPrendasSeleccionado = registro.getIdRegistroPrendas();

                    break;
                }
            }

            GenerarReportes generador = new GenerarReportes();
            String idRegistroPrendasString = String.valueOf(idRegistroPrendasSeleccionado);
            String contenido = generador.actualizarSalida(idRegistroPrendasString);

            TodoCliente.setText(contenido);
            // Imprimir el idRegistroPrendas seleccionado
            if (idRegistroPrendasSeleccionado != -1) {
                System.out.println("idRegistroPrendas seleccionado: " + idRegistroPrendasSeleccionado);

            } else {
                System.out.println("No se encontró el idRegistroPrendas para la fecha seleccionada");
            }
        }
    }//GEN-LAST:event_TablaConsultasMMouseClicked

    private void BtnExporPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExporPDFActionPerformed
        // Obtener el contenido del JTextArea
        String contenido = TodoCliente.getText();

        // Crear una instancia de GenerarReportes y llamar al método exportarAPDF
        GenerarReportes generador = new GenerarReportes();
        generador.exportarAPDF(contenido);
    }//GEN-LAST:event_BtnExporPDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModuloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloPrincipal().setVisible(true);
            }
        });
    }

    private void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }

    private void cambiarPanel(javax.swing.JPanel panel) {
        PrincipalCard.removeAll();
        PrincipalCard.add(panel);
        PrincipalCard.repaint();
        PrincipalCard.revalidate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExporPDF;
    private javax.swing.JTextField CTEXTBuscar;
    private javax.swing.JPanel CategoriasCard;
    private javax.swing.JButton CbtnBuscar;
    private javax.swing.JPanel ClientesCard;
    private javax.swing.JComboBox<String> ConCategoria;
    private javax.swing.JPanel ConsultarServicios;
    private com.toedter.calendar.JDateChooser DesdeFecha;
    private javax.swing.JPanel EmpleadosCard;
    private javax.swing.JComboBox<String> EscogerCategoriaBD;
    private javax.swing.ButtonGroup GRUPO1;
    private com.toedter.calendar.JDateChooser HastaFecha;
    private javax.swing.JPanel IngresoPrendas;
    private javax.swing.JPanel LimpiarCategoriaServi;
    private javax.swing.JRadioButton PorApellido;
    private javax.swing.JRadioButton PorDNI;
    private javax.swing.JRadioButton PorNombre;
    private javax.swing.JPanel Primero;
    private javax.swing.JPanel PrincipalCard;
    private javax.swing.JPanel SalidaPrendas;
    private javax.swing.JPanel ServiciosCard;
    private javax.swing.JTable TablaConsultasM;
    private javax.swing.JTextArea TodoCliente;
    private javax.swing.JComboBox<String> boxNivelAcceso;
    private javax.swing.JPanel btnBuscarCA;
    private javax.swing.JPanel btnBuscarCliente;
    private javax.swing.JPanel btnBuscarEm;
    private javax.swing.JPanel btnBuscarS;
    private javax.swing.JLabel btnCategorias;
    private javax.swing.JLabel btnClientes;
    private javax.swing.JLabel btnConsultas;
    private javax.swing.JPanel btnEliminarCA;
    private javax.swing.JPanel btnEliminarCliente;
    private javax.swing.JPanel btnEliminarEm;
    private javax.swing.JButton btnEliminarPrendas;
    private javax.swing.JPanel btnEliminarS;
    private javax.swing.JLabel btnEmpleados;
    private javax.swing.JPanel btnGuardarCA;
    private javax.swing.JPanel btnGuardarEm;
    private javax.swing.JButton btnGuardarIngreso;
    private javax.swing.JButton btnGuardarPrendas;
    private javax.swing.JButton btnImprimirBoleta;
    private javax.swing.JButton btnImprimirIngreso;
    private javax.swing.JLabel btnIngresoPrendas;
    private javax.swing.JPanel btnLimpiarCli;
    private javax.swing.JPanel btnLimpiarEmpledos;
    private javax.swing.JPanel btnLimpiarServicios;
    private javax.swing.JPanel btnModificarCA;
    private javax.swing.JPanel btnModificarCliente;
    private javax.swing.JPanel btnModificarEm;
    private javax.swing.JPanel btnModificarS;
    private javax.swing.JPanel btnPassEmple;
    private javax.swing.JPanel btnRegistrarCliente;
    private javax.swing.JPanel btnRegistrarS;
    private javax.swing.JLabel btnSalidaPrendas;
    private javax.swing.JLabel btnServicios;
    private javax.swing.JButton btnSlidaPrendas;
    private javax.swing.JLabel btnmodulo;
    private javax.swing.JComboBox<String> cbxIDRegistro;
    private javax.swing.JComboBox<String> cbxServicio;
    private javax.swing.JComboBox<String> cbxdni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane2Cliente;
    private javax.swing.JScrollPane jScrollPane2Cliente1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel logo2;
    private javax.swing.JTable tablePrendas;
    private javax.swing.JTextField txtApellidoMEm;
    private javax.swing.JTextField txtApellidoPEm;
    private javax.swing.JTextField txtApellidosMCliente;
    private javax.swing.JTextField txtApellidosPCliente;
    private javax.swing.JTextArea txtBoleta;
    private javax.swing.JTextField txtCantidadPrenda;
    private javax.swing.JTextField txtCelularCliente;
    private javax.swing.JTextField txtCodigoCA;
    private javax.swing.JTextField txtCodigoS1;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtDNIE;
    private javax.swing.JTextField txtDescripcionCA;
    private javax.swing.JTextField txtDescripcionS;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDistritoCliente;
    private javax.swing.JTextField txtDniCliente1;
    private javax.swing.JTextField txtNombreCA;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreE;
    private javax.swing.JTextField txtNombrePrenda;
    private javax.swing.JTextField txtPrecioS;
    private javax.swing.JTextArea txtSalidaPrendas;
    private javax.swing.JTextField txtTurnoEmple;
    private javax.swing.JTextField txtnombreS;
    private javax.swing.JTable visorCategorias1;
    private javax.swing.JTable visorClientes;
    private javax.swing.JTable visorEmpleado;
    private javax.swing.JTable visorServicios;
    // End of variables declaration//GEN-END:variables
}
