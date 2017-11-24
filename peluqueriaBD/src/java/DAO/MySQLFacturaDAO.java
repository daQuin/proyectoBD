/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FacturaDTO;
import DTO.ProductoDTO;
import INTERFAZ.IFacturaDTO;
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
public class MySQLFacturaDAO extends MySQLconexion implements IFacturaDTO{

     public MySQLFacturaDAO(boolean keepConnection) {
        super(keepConnection);
    }
    
    @Override
    public boolean generarFactura(FacturaDTO a) {
    
          boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = super.getConn().prepareStatement("insert into factura (id,tipopago,fecha,totalpagar,"
                    + "cliente_id,producto,servicio,cantidad"
                    + ") values (0,?,?,?,?,?,?,?)");
            stmt.setString(1, a.getTipoPago());
            stmt.setString(2, a.getFecha());
            stmt.setDouble(3, a.getTotalPagar());
            stmt.setInt(4, a.getIdCliente().getId());
            stmt.setString(5, a.getProducto());
            stmt.setString(6, a.getServicio());
            stmt.setInt(7, a.getCantidad());

            System.out.println("CLIENTEEE: "+a.getIdCliente().getId());
            int aux = stmt.executeUpdate();
            if (aux > 0) {
                exito = true;
                stmt.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!keepConnection) {
                if (super.getConn() != null) {
                    try {
                        super.getConn().close();
                    } catch (Exception ex) {
                        Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
    
    }

    @Override
    public boolean eliminarFactura(int id) {
    
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            stmt = super.getConn().prepareStatement("select id from factura");
            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                ProductoDTO c = new ProductoDTO();
                c.setId(aux.getInt(1));
                if (c.getId() == id) {
                    stmt = super.getConn().prepareStatement("delete from factura where id='" + id + "'");
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
                        Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
    }

    @Override
    public boolean actualizarFactura(int id, String tipoPago, String fecha, int idCliente, double totalPagar) {

         boolean exito = false;
        PreparedStatement smtm = null;
        try {
            smtm = super.getConn().prepareStatement("update factura set tipopago=?,fecha=?,"
                    + "totalpagar=?,cliente_id=? where id='" + id + "'");

            smtm.setString(1, tipoPago);
            smtm.setString(2, fecha);
            smtm.setDouble(3, totalPagar);
            smtm.setInt(4, idCliente);

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
    public FacturaDTO consultarFactura(int id) {

         FacturaDTO aux = null;
        PreparedStatement stmt = null;
        try {
            stmt = super.getConn().prepareStatement("select * from factura where  "
                    + "id='" + id + "'");
            ResultSet a = stmt.executeQuery();
            MySQLClienteDAO c = new MySQLClienteDAO(keepConnection);
            while (a.next()) {
                aux = new FacturaDTO();

                aux.setTipoPago(a.getString(2));
                aux.setFecha(a.getString(3));
                aux.setTotalPagar(a.getDouble(4));
                
                aux.setIdCliente(c.consultarCliente(a.getInt(5)));
            }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    }

    @Override
    public ArrayList<FacturaDTO> listarFactura() {
    
        ArrayList<FacturaDTO> a = null;
        PreparedStatement stmt = null;
        PreparedStatement auxi = null;

        try {
            a = new ArrayList<FacturaDTO>();
            stmt = super.getConn().prepareStatement("select * from factura");

            ResultSet aux = stmt.executeQuery();
            MySQLClienteDAO c = new MySQLClienteDAO(keepConnection);
            while (aux.next()) {
                FacturaDTO vis = new FacturaDTO();
                vis.setId(aux.getInt(1));
                vis.setTipoPago(aux.getString(2));
                vis.setFecha(aux.getString(3));
                vis.setTotalPagar(aux.getInt(4));
                vis.setIdCliente(c.consultarCliente(aux.getInt(5)));
                vis.setProducto(aux.getString(6));
                vis.setServicio(aux.getString(7));
                vis.setCantidad(aux.getInt(8));
                a.add(vis);
            }
            aux.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;

        
    }
    
}
