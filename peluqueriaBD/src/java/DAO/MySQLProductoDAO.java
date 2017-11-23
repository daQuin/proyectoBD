/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProductoDTO;
import INTERFAZ.IProductoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = super.getConn().prepareStatement("insert into producto (id,nombre,descripcion,cantidad,"
                    + "valor"
                    + ") values (0,?,?,?,?)");
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getDescripcion());
            stmt.setInt(3, a.getCantidad());
            stmt.setDouble(4, a.getValor());

            int aux = stmt.executeUpdate();
            if (aux > 0) {
                exito = true;
                stmt.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MySQLProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!keepConnection) {
                if (super.getConn() != null) {
                    try {
                        super.getConn().close();
                    } catch (Exception ex) {
                        Logger.getLogger(MySQLProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
    }

    @Override
    public boolean eliminarProducto(int id) {
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            stmt = super.getConn().prepareStatement("select id from producto");
            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                ProductoDTO c = new ProductoDTO();
                c.setId(aux.getInt(1));
                if (c.getId() == id) {
                    stmt = super.getConn().prepareStatement("delete from producto where id='" + id + "'");
                    stmt.executeUpdate();

                    exito = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!keepConnection) {
                if (super.getConn() != null) {
                    try {
                        super.getConn().close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;

    }

    @Override
    public boolean actualizarProducto(int id,  String nombre, String descripcion,int cantidad, double valor) {
        boolean exito = false;
        PreparedStatement smtm = null;
        try {
            smtm = super.getConn().prepareStatement("update producto set nombre=?,descripcion=?,"
                    + "cantidad=?,valor=? where id='" + id + "'");

            smtm.setString(1, nombre);
            smtm.setString(2, descripcion);
            smtm.setInt(3, cantidad);
            smtm.setDouble(4, valor);

            int total = smtm.executeUpdate();
            if (total > 0) {
                exito = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    @Override
    public ProductoDTO consultarProducto(int cod) {
        ProductoDTO aux = null;
        PreparedStatement stmt = null;
        try {
            stmt = super.getConn().prepareStatement("select * from producto where  "
                    + "id='" + cod + "'");
            ResultSet a = stmt.executeQuery();
            while (a.next()) {
                aux = new ProductoDTO();

                aux.setNombre(a.getString(2));
                aux.setDescripcion(a.getString(3));
                aux.setCantidad(a.getInt(4));
                aux.setValor(a.getDouble(5));
            }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    }

    @Override
    public ArrayList<ProductoDTO> listarProductoDTO() {

        ArrayList<ProductoDTO> a = null;
        PreparedStatement stmt = null;
        PreparedStatement auxi = null;

        try {
            a = new ArrayList<ProductoDTO>();
            stmt = super.getConn().prepareStatement("select * from producto");

            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                ProductoDTO vis = new ProductoDTO();
                vis.setId(aux.getInt(1));
                vis.setNombre(aux.getString(2));
                vis.setDescripcion(aux.getString(3));
                vis.setCantidad(aux.getInt(4));
                vis.setValor(aux.getDouble(5));
                a.add(vis);
            }
            aux.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;

    }
}
