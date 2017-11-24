/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.ServicioDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dismar
 */
public class MySQLServicioDAO  extends MySQLconexion implements INTERFAZ.IServicioDTO{
    
    public MySQLServicioDAO(boolean keepConnection) {
        super(keepConnection);
    }
    
     @Override
    public boolean registrarServicio(ServicioDTO a) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = super.getConn().prepareStatement("insert into servicio (id,nombre,valor,descripcion)"
                    + " values (0,?,?,?)");
            stmt.setString(1, a.getNombre());
            stmt.setDouble(2, a.getValor());
            stmt.setString(3, a.getDescripcion());

            int aux = stmt.executeUpdate();
            if (aux > 0) {
                exito = true;
                stmt.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MySQLServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!keepConnection) {
                if (super.getConn() != null) {
                    try {
                        super.getConn().close();
                    } catch (Exception ex) {
                        Logger.getLogger(MySQLServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
    }

    @Override
    public boolean eliminarServicio(int id) {
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            stmt = super.getConn().prepareStatement("select id from servicio");
            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                ServicioDTO c = new ServicioDTO();
                c.setId(aux.getInt(1));
                if (c.getId() == id) {
                    stmt = super.getConn().prepareStatement("delete from servicio where id='" + id + "'");
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
                        Logger.getLogger(MySQLServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;

    }

    @Override
    public boolean actualizarServicio(int id,String nombre, double valor,String descripcion) {
        boolean exito = false;
        PreparedStatement smtm = null;
        try {
            smtm = super.getConn().prepareStatement("update servicio set nombre=?,valor=?,descripcion=?"
                    + " where id='" + id + "'");

            smtm.setString(1, nombre);
            smtm.setDouble(2, valor);
            smtm.setString(3, descripcion);

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
    public ServicioDTO consultarServicio(int cod) {
        ServicioDTO aux = null;
        PreparedStatement stmt = null;
        try {
            stmt = super.getConn().prepareStatement("select * from servicio where  "
                    + "id='" + cod + "'");
            ResultSet a = stmt.executeQuery();
            while (a.next()) {
                aux = new ServicioDTO();
                aux.setId(a.getInt(1));

                aux.setNombre(a.getString(2));
                aux.setValor(a.getDouble(3));
                aux.setDescripcion(a.getString(4));
            }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    }

    @Override
    public ArrayList<ServicioDTO> listarServicioDTO() {

        ArrayList<ServicioDTO> a = null;
        PreparedStatement stmt = null;
        PreparedStatement auxi = null;

        try {
            a = new ArrayList<ServicioDTO>();
            stmt = super.getConn().prepareStatement("select * from servicio");

            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                ServicioDTO vis = new ServicioDTO();
                vis.setId(aux.getInt(1));
                vis.setNombre(aux.getString(2));
                vis.setValor(aux.getDouble(3));
                vis.setDescripcion(aux.getString(4));
                a.add(vis);
            }
            aux.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;

    }
    
    
    
}
