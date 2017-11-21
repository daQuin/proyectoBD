/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProductoDTO;
import INTERFAZ.IProductoDTO;

/**
 *
 * @author DELL
 */
public class MySQLProductoDAO extends MySQLconexion implements IProductoDTO {
    
     public MySQLProductoDAO(boolean keepConnection) {
        super(keepConnection);
    }

    @Override
    public boolean registrarProducto(ProductoDTO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarProducto(int id, int cantidad, double valor, String descripcion, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductoDTO consultarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
