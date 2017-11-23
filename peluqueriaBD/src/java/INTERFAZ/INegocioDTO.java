/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;

import DTO.ClienteDTO;
import DTO.EmpleadoDTO;
import DTO.ProductoDTO;
import DTO.ServicioDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface INegocioDTO {

    public boolean registrarCliente(String nombres, String apellidos, String direccion, String telefono,
            String correo);
    public boolean EliminarCliente(int id);
    public boolean actualizarCliente(int id, String nombres, String apellidos, String direccion, String telefono,
            String correo);
    public ClienteDTO consultarCliente(int id);
    public ArrayList<ClienteDTO> listarClienteDTO();
    

    public boolean registrarProducto(String nombre, String descripcion, int cantidad, int valor);
    public boolean EliminarProducto(int id);
    public boolean actualizarProducto(int id,String nombre, String descripcion, int cantidad, int valor);
    public ProductoDTO consultarProducto(int id);
    public ArrayList<ProductoDTO> listarProducto();
    
    public boolean registrarServicio(String nombre,double valor);
    public boolean EliminarServicio(int id);
    public boolean actualizarServicio(int id, String nombre,double valor);
    public ServicioDTO consultarServicio(int id);
    public ArrayList<ServicioDTO> listarServicio();

    public boolean registrarEmpleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo,String fecha);
    public boolean EliminarEmpleado(int id);
    public boolean actualizarEmpleado(int id, String nombres,String apellidos,String cedula,String direccion,
            String telefono,String correo,String fechaIngreso);
    public EmpleadoDTO consultarEmpleado(int id);
    public ArrayList<EmpleadoDTO> listarEmpleadoDTO();
    
     public boolean iniciarSesion(String nom,  String pas);
     
    public void cerrarSesion();
}
