/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import FACTORY.DaoFactory;
import INTERFAZ.IAdministradorDTO;
import java.util.ArrayList;
import INTERFAZ.IClienteDTO;
import INTERFAZ.IProductoDTO;
import INTERFAZ.IServicioDTO;

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

    public ArrayList<ClienteDTO> listarClientes() {
        IClienteDTO a = factor.obtenerConexionCliente(false);
        return a.listarClienteDTO();
    }

    public boolean registrarProducto(String nombre, String Descripcion, int cantidad, int valor) {
        IProductoDTO a = factor.obtenerConexionProducto(false);
        ProductoDTO p = new ProductoDTO(nombre, Descripcion, cantidad, valor);
        return a.registrarProducto(p);
    }

    public boolean actualizarProducto(int id, String nombre, String descripcion, int cantidad, int valor) {
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

    public boolean registrarServicio(String nombre, double valor) {
        IServicioDTO a = factor.obtenerConexionServicio(false);
        ServicioDTO p = new ServicioDTO(nombre, valor);
        return a.registrarServicio(p);
    }

    public boolean actualizarServicio(int id, String nombre, double valor) {
        IServicioDTO a = factor.obtenerConexionServicio(false);
        return a.actualizarServicio(id, nombre, valor);
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

}
