/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DTO.AdministradorDTO;
import DTO.ClienteDTO;
import DTO.EmpleadoDTO;
import DTO.ProductoDTO;
import DTO.PromocionDTO;
import DTO.ServicioDTO;
import INTERFAZ.INegocioDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Negocio implements INegocioDTO {

    private AdministradorDTO admin;

    public Negocio() {
        admin = new AdministradorDTO();
    }

    //---------------Metodos del Cliente------------------------------------------
    @Override
    public boolean registrarCliente(String nombres, String apellidos, String direccion, String telefono, String correo) {

        try {
            boolean rta = admin.registrarCliente(nombres, apellidos, direccion, telefono, correo);
            if (rta) {
                System.out.println("Cliente Registrado");
                return rta;
            } else {
                System.out.println("Cliente no Registrado");
            }

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean EliminarCliente(int id) {

        try {
            boolean rta = admin.eliminarCliente(id);
            if (rta == true) {
                System.out.println("Cliente #" + id + "  Eliminado");
                return rta;
            } else {
                System.out.println("Cliente no eliminado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean actualizarCliente(int id, String nombres, String apellidos, String direccion, String telefono, String correo) {
            try {
            boolean rta = admin.actualizarCliente(id, nombres, apellidos, direccion, telefono, correo);
            if (rta) {
                System.out.println("Empleado Registrado");
                return rta;
            } else {
                System.out.println("Empleado no Registrado");
            }

        } catch (Exception e) {
        }
        return false;
        
    }

    @Override
    public ClienteDTO consultarCliente(int id) {

        try {
            ClienteDTO rta = admin.consultarCliente(id);
            return rta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ClienteDTO> listarClienteDTO() {
        ArrayList<ClienteDTO> a = null;
        try {
            a = admin.listarClientes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    //---------------Metodos del Producto------------------------------------------
    @Override
    public boolean registrarProducto(String nombre, String descripcion, int cantidad, int valor) {

        try {
            boolean rta = admin.registrarProducto(nombre, descripcion, cantidad, valor);
            if (rta) {
                System.out.println("producto Registrado");
                return rta;
            } else {
                System.out.println("producto no Registrado");
            }

        } catch (Exception e) {
        }
        return false;

    }

    @Override
    public boolean actualizarProducto(int id, String nombre, String descripcion, int cantidad, int valor) {
        try {
            boolean rta = admin.actualizarProducto(id, nombre, descripcion, cantidad, valor);
            if (rta) {
                System.out.println("producto Registrado");
                return rta;
            } else {
                System.out.println("producto no Registrado");
            }

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public ProductoDTO consultarProducto(int id) {

        try {
            ProductoDTO rta = admin.consultarProducto(id);
            return rta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ProductoDTO> listarProducto() {

        ArrayList<ProductoDTO> a = null;
        try {
            a = admin.listarProductos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;

    }

    @Override
    public boolean EliminarProducto(int id) {

        try {
            boolean rta = admin.eliminarProducto(id);
            if (rta == true) {

                return rta;
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
    //---------------Metodos del servicio------------------------------------------

    @Override
    public boolean registrarServicio(String nombre, double valor) {

        try {
            boolean rta = admin.registrarServicio(nombre, valor);
            if (rta) {
                System.out.println("Servicio Registrado");
                return rta;
            } else {
                System.out.println("Servicio no Registrado");
            }

        } catch (Exception e) {
        }
        return false;

    }

    @Override
    public boolean actualizarServicio(int id, String nombre, double valor) {
        try {
            boolean rta = admin.actualizarServicio(id, nombre, valor);
            if (rta) {
                System.out.println("producto Registrado");
                return rta;
            } else {
                System.out.println("producto no Registrado");
            }

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public ServicioDTO consultarServicio(int id) {

        try {
            ServicioDTO rta = admin.consultarServicio(id);
            return rta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ServicioDTO> listarServicio() {

        ArrayList<ServicioDTO> a = null;
        try {
            a = admin.listarServicios();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;

    }

    @Override
    public boolean EliminarServicio(int id) {

        try {
            boolean rta = admin.eliminarServicio(id);
            if (rta == true) {

                return rta;
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    //------------------Metodos del Empleado------------------------------------
    @Override
   public boolean registrarEmpleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo,String fechaIngreso) {

        try {
            boolean rta = admin.registrarEmpleado(nombre, apellido, cedula, direccion, telefono, correo, fechaIngreso);
            if (rta) {
                System.out.println("Empleado Registrado");
                return rta;
            } else {
                System.out.println("Empleado no Registrado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("LLEGOO A NEGOCIO " + nombre);

        return true;
    }
   
    @Override
    public boolean EliminarEmpleado(int id) {

        try {
            boolean rta = admin.eliminarEmpleado(id);
            if (rta == true) {
                System.out.println("Empleado #" + id + "  Eliminado");
                return rta;
            } else {
                System.out.println("Empleado no eliminado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean actualizarEmpleado(int id, String nombres,String apellidos,String cedula,String direccion, String telefono,String correo,String fechaIngreso) {
     
    try {
            boolean rta = admin.actualizarEmpleado(id, nombres, apellidos, cedula, direccion, telefono, correo, fechaIngreso);
            if (rta) {
                System.out.println("Empleado Registrado");
                return rta;
            } else {
                System.out.println("Empleado no Registrado");
            }

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public EmpleadoDTO consultarEmpleado(int id) {

        try {
            EmpleadoDTO rta = admin.consultarEmpleado(id);
            return rta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<EmpleadoDTO> listarEmpleadoDTO() {
        ArrayList<EmpleadoDTO> a = null;
        try {
            a = admin.listarEmpleados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
   
    //-------------------metodos de promocion-----------------------------------------
   
    
    @Override
    public boolean registrarPromocion(String nombre, String FechaInicio, String FechaFin) {

        try {
            boolean rta = admin.registrarPromocion(nombre, FechaInicio, FechaFin);
            if (rta) {
                System.out.println("Promocion Registrada");
                return rta;
            } else {
                System.out.println("Promocion no Registrado");
            }

        } catch (Exception e) {
        }
        return false;

    }

    @Override
    public boolean actualizarPromocion(int id,String nombre, String FechaInicio, String FechaFin) {
        try {
            boolean rta = admin.actualizarPromocion(id, nombre, FechaInicio, FechaFin);
            if (rta) {
                System.out.println("Promocion Registrado");
                return rta;
            } else {
                System.out.println("Promocion no Registrado");
            }

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public PromocionDTO consultarPromocion(int id) {

        try {
            PromocionDTO rta = admin.consultarPromocion(id);
            return rta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

 

    @Override
    public boolean EliminarPromocion(int id) {

        try {
            boolean rta = admin.eliminarPromocion(id);
            if (rta == true) {

                return rta;
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

   

    //------------------Metodos de inicio de sesion------------------------------------
    @Override
    public boolean iniciarSesion(String nom, String pas) {

        if (nom.equalsIgnoreCase("daniel") && pas.equalsIgnoreCase("pass")) {
            return true;
        }

        return false;
    }

    @Override
    public void cerrarSesion() {

    }

}
