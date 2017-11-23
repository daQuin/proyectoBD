/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DTO.AdministradorDTO;
import DTO.ClienteDTO;
import DTO.ProductoDTO;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean actualizarProducto(int id,String nombre, String descripcion, int cantidad, int valor) {
       try {
            boolean rta = admin.actualizarProducto(id,nombre, descripcion, cantidad, valor);
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
    public boolean registrarServicio(String nombre,double valor) {

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
    public boolean actualizarServicio(int id, String nombre,double valor) {
       try {
            boolean rta = admin.actualizarServicio(id,nombre,  valor);
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

}
