/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACTORY;

import DAO.MySQLAdministradorDAO;
import DAO.MySQLClienteDAO;
import DAO.MySQLEmpleadoDAO;
import DAO.MySQLProductoDAO;
import DAO.MySQLPromocionDAO;

import INTERFAZ.IAdministradorDTO;
import INTERFAZ.IClienteDTO;
import INTERFAZ.IEmpleadoDTO;
import INTERFAZ.IProductoDTO;
import INTERFAZ.IPromocionDTO;


/**
 *
 * @author Angel Aparicio
 */
public class DaoFactory {
 public IAdministradorDTO obtenerUsuario(boolean keepConnection) {
        return new MySQLAdministradorDAO(keepConnection);
    }
 public IClienteDTO obtenerConexionCliente(boolean keepConnection) {
        return new MySQLClienteDAO(keepConnection);
    }
 
  public IProductoDTO obtenerConexionProducto(boolean keepConnection) {
        return new MySQLProductoDAO(keepConnection);
    }
 public IEmpleadoDTO obtenerConexionEmpleado(boolean keepConnection) {
        return new MySQLEmpleadoDAO(keepConnection);
    }
 public IPromocionDTO obtenerConexionPeomocion(boolean keepConnection) {
        return new MySQLPromocionDAO(keepConnection);
    }
 
}
