/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACTORY;

import DAO.MySQLAdministradorDAO;
import DAO.MySQLCitaDAO;
import DAO.MySQLClienteDAO;
import DAO.MySQLEmpleadoDAO;
import DAO.MySQLFacturaDAO;
import DAO.MySQLProductoDAO;
import DAO.MySQLPromocionDAO;
import DAO.MySQLServicioDAO;

import INTERFAZ.IAdministradorDTO;
import INTERFAZ.ICitaDTO;
import INTERFAZ.IClienteDTO;
import INTERFAZ.IEmpleadoDTO;
import INTERFAZ.IFacturaDTO;
import INTERFAZ.IProductoDTO;
import INTERFAZ.IPromocionDTO;
import INTERFAZ.IServicioDTO;


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
 public IPromocionDTO obtenerConexionPromocion(boolean keepConnection) {
        return new MySQLPromocionDAO(keepConnection);
    }
  public IServicioDTO obtenerConexionServicio(boolean keepConnection) {
        return new MySQLServicioDAO(keepConnection);
    }
    public ICitaDTO obtenerConexionCita(boolean keepConnection) {
        return new MySQLCitaDAO(keepConnection);
    }
    public IFacturaDTO obtenerConexionFactura(boolean keepConnection) {
        return new MySQLFacturaDAO(keepConnection);
    }
 
}
