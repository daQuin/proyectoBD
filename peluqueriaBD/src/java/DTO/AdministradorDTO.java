/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import FACTORY.DaoFactory;
import INTERFAZ.IAdministradorDTO;
import INTERFAZ.ICitaDTO;
import java.util.ArrayList;
import INTERFAZ.IClienteDTO;
import INTERFAZ.IEmpleadoDTO;
import INTERFAZ.IFacturaDTO;
import INTERFAZ.IProductoDTO;
import INTERFAZ.IPromocionDTO;
import INTERFAZ.IServicioDTO;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Angel Aparicio
 */
public class AdministradorDTO {

    private String usuario;
    private String contraseña;
    private FACTORY.DaoFactory factor;

    public AdministradorDTO() {
        factor = new DaoFactory();
    }

    public AdministradorDTO(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        factor = new DaoFactory();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "AdministradorDTO{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }

    public AdministradorDTO obtenerUsuario(String usuario) {
        IAdministradorDTO u = factor.obtenerUsuario(false);
        if (consultarUsuario(usuario).equalsIgnoreCase("")) {
            System.out.println("No existe este usuario");
            return null;
        }
        return u.consultarUsuario(usuario);
    }

    public String consultarUsuario(String usuario) {
        IAdministradorDTO u = factor.obtenerUsuario(false);
        AdministradorDTO u2 = u.consultarUsuario(usuario);
        if (u2 == null) {
            return "";
        }
        return u2.toString();
    }

    //---------------------CLIENTE----------------------------------------------------------
    public boolean registrarCliente(String nombres, String apellidos, String direccion, String telefono,
            String correo) {
        IClienteDTO a = factor.obtenerConexionCliente(false);
        ClienteDTO aux = new ClienteDTO(nombres, apellidos, direccion, telefono, correo);
        return a.registrarCliente(aux);
    }

    public boolean actualizarCliente(int id, String nombres, String apellidos, String direccion, String telefono,
            String correo) {
        IClienteDTO a = factor.obtenerConexionCliente(false);
        return a.actualizarCliente(id, nombres, apellidos, direccion, telefono, correo);
    }

    public boolean eliminarCliente(int id) {
        IClienteDTO a = factor.obtenerConexionCliente(false);
        return a.eliminarCliente(id);
    }

    public ClienteDTO consultarCliente(int id) {
        IClienteDTO a = factor.obtenerConexionCliente(false);
        return a.consultarCliente(id);
    }
    
     public ClienteDTO consultarClienteNC(String nombre, String correo) {
        IClienteDTO a = factor.obtenerConexionCliente(false);
        return a.consultarClienteNC(nombre, correo);
    }

    public ArrayList<ClienteDTO> listarClientes() {
        IClienteDTO a = factor.obtenerConexionCliente(false);
        return a.listarClienteDTO();
    }

    //---------------------PRODUCTO----------------------------------------------------------
    public boolean registrarProducto(String nombre, String Descripcion, int cantidad, int valor) {
        IProductoDTO a = factor.obtenerConexionProducto(false);
        ProductoDTO p = new ProductoDTO(nombre, Descripcion, cantidad, valor);
        return a.registrarProducto(p);
    }

    public boolean actualizarProducto(int id, String nombre, String descripcion, int cantidad, double valor) {
        IProductoDTO a = factor.obtenerConexionProducto(false);
        return a.actualizarProducto(id, nombre, descripcion, cantidad, valor);
    }

    public ArrayList<ProductoDTO> listarProductos() {
        IProductoDTO a = factor.obtenerConexionProducto(false);
        return a.listarProductoDTO();
    }

    public ProductoDTO consultarProducto(int id) {
        IProductoDTO a = factor.obtenerConexionProducto(false);
        return a.consultarProducto(id);
    }

    public boolean eliminarProducto(int id) {
        IProductoDTO a = factor.obtenerConexionProducto(false);
        return a.eliminarProducto(id);
    }

    //---------------------SERVICIO----------------------------------------------------------
    public boolean registrarServicio(String nombre, double valor,String descripcion) {
        IServicioDTO a = factor.obtenerConexionServicio(false);
        ServicioDTO p = new ServicioDTO(nombre, valor,descripcion);
        return a.registrarServicio(p);
    }

    public boolean actualizarServicio(int id, String nombre, double valor,String descripcion) {
        IServicioDTO a = factor.obtenerConexionServicio(false);
        return a.actualizarServicio(id, nombre, valor,descripcion);
    }

    public ArrayList<ServicioDTO> listarServicios() {
        IServicioDTO a = factor.obtenerConexionServicio(false);
        return a.listarServicioDTO();
    }

    public ServicioDTO consultarServicio(int id) {
        IServicioDTO a = factor.obtenerConexionServicio(false);
        return a.consultarServicio(id);
    }

    public boolean eliminarServicio(int id) {
        IServicioDTO a = factor.obtenerConexionServicio(false);
        return a.eliminarServicio(id);
    }

    //---------------------EMPLEADO----------------------------------------------------------
    public boolean registrarEmpleado(String nombres, String apellidos, String cedula, String direccion, String telefono, String correo, String fechaIngreso) {
        IEmpleadoDTO a = factor.obtenerConexionEmpleado(false);
        EmpleadoDTO aux = new EmpleadoDTO(nombres, apellidos, cedula, direccion, telefono, correo, fechaIngreso);
        return a.registrarEmpleado(aux);
    }

    public boolean actualizarEmpleado(int id, String nombres, String apellidos, String cedula, String direccion, String telefono, String correo, String fechaIngreso) {
        IEmpleadoDTO a = factor.obtenerConexionEmpleado(false);
        return a.actualizarEmpleado(id, nombres, apellidos, cedula, direccion, telefono, correo, fechaIngreso);
    }

    public boolean eliminarEmpleado(int id) {
        IEmpleadoDTO a = factor.obtenerConexionEmpleado(false);
        return a.eliminarEmpleado(id);
    }

    public EmpleadoDTO consultarEmpleado(int id) {
        IEmpleadoDTO a = factor.obtenerConexionEmpleado(false);
        return a.consultarEmpleado(id);
    }

    public ArrayList<EmpleadoDTO> listarEmpleados() {
        IEmpleadoDTO a = factor.obtenerConexionEmpleado(false);
        return a.listarEmpleadoDTO();
    }

    //---------------------PROMOCION---------------------------------------------------------
    public boolean registrarPromocion(String nombre, String FechaInicio, String FechaFin) {
        IPromocionDTO a = factor.obtenerConexionPromocion(false);
        PromocionDTO p = new PromocionDTO(nombre, FechaInicio, FechaFin);
        return a.registrarPromocion(p);
    }

    public boolean actualizarPromocion(int id, String nombre, String FechaInicio, String FechaFin) {
        IPromocionDTO a = factor.obtenerConexionPromocion(false);
        return a.actualizarPromocion(id, nombre, FechaInicio, FechaFin);
    }

//    public ArrayList<PromocionDTO> listarPromocion() {
//        IPromocionDTO a = factor.obtenerConexionPromocion(false);
//        return a.listarPromocionDTO();
//    }
    public PromocionDTO consultarPromocion(int id) {
        IPromocionDTO a = factor.obtenerConexionPromocion(false);
        return a.consultarPromocion(id);
    }

    public boolean eliminarPromocion(int id) {
        IPromocionDTO a = factor.obtenerConexionPromocion(false);
        return a.eliminarPromocion(id);
    }
     //---------------------CITA--------------------------------------------------------
    
    public String ObtenerFechaActual(){
         Calendar fecha = new GregorianCalendar();
     
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
       return (dia + "/" + (mes+1) + "/" + año);
       
    }
    
     public boolean registrarCita(String fecha,String fechaCreacion, String nombre, String correo, String servicio) {
        ICitaDTO a = factor.obtenerConexionCita(false);
        ClienteDTO c = new ClienteDTO();
        c=consultarClienteNC(nombre, correo);
        if(c!=null||c.getCorreo()!=null ){
        CitaDTO p = new CitaDTO(ObtenerFechaActual(), fechaCreacion, c, servicio);
        return a.registrarCita(p);
    }
        return false;
     }
    public boolean actualizarCita(int id, String fecha,String fechaCreacion, int idCliente,String servicio) {
        ICitaDTO a = factor.obtenerConexionCita(false);
        return a.actualizarCita(id, fecha, fechaCreacion, idCliente, servicio);
    }

    public ArrayList<CitaDTO> listarCita() {
        ICitaDTO a = factor.obtenerConexionCita(false);
        return a.listarCitaDTO();
    }
    public CitaDTO consultarCita(int id) {
        ICitaDTO a = factor.obtenerConexionCita(false);
        return a.consultarCita(id);
    }

    public boolean eliminarCita(int id) {
        ICitaDTO a = factor.obtenerConexionCita(false);
        return a.eliminarCita(id);
    }
    
    
     public boolean registrarFactura(String tipoPago,int producto, int servicio, int idCliente, int cantidad) {
         double totalPagar =0;
         totalPagar = cantidad*consultarProducto(producto).getValor();
        IFacturaDTO a = factor.obtenerConexionFactura(false);
        FacturaDTO p = new FacturaDTO(totalPagar, tipoPago, ObtenerFechaActual(), consultarCliente(idCliente),
                consultarProducto(producto).getNombre(), consultarServicio(servicio).getNombre(), cantidad);
        return a.generarFactura(p);
    }

    public ArrayList<FacturaDTO> listarFactura() {
    
        IFacturaDTO a = factor.obtenerConexionFactura(false);
        return a.listarFactura();
    }
    
     public ArrayList<FacturaDTO> realizarConsulta(double valorCompra, String nombre, String mes) {
    
        IFacturaDTO a = factor.obtenerConexionFactura(false);
        return a.realizarConsultas(valorCompra,nombre,mes);
    }

    public boolean iniciarSesion(String nom, String pas) throws Exception {

        IAdministradorDTO a = factor.obtenerConexionAdmin(false);
        return a.iniciarSesion(nom, pas);
    }

    
    
}
