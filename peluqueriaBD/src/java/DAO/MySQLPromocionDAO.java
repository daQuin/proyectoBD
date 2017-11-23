/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.PromocionDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class MySQLPromocionDAO extends MySQLconexion implements INTERFAZ.IPromocionDTO {
    
    public MySQLPromocionDAO(boolean keepConnection) {
        super(keepConnection);
    }
    
     @Override
    public boolean registrarPromocion(PromocionDTO a) {
     boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = super.getConn().prepareStatement("insert into promocion (id,nombre,fechainicio,fechafin)"
                    + " values (0,?,?,?)");
            System.out.println("Entramos a registrar una promocion");
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getFechaInicio());
            stmt.setString(3, a.getFechaFin());

            int aux = stmt.executeUpdate();
            if(aux > 0){
                exito=true;
                stmt.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MySQLPromocionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!keepConnection) {
                if (super.getConn() != null) {
                    try {
                        super.getConn().close();
                        System.out.println("se cerro la conexion ");
                    } catch (Exception ex) {
                        Logger.getLogger(MySQLPromocionDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
    }

    @Override
    public boolean eliminarPromocion(int id) {
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            stmt = super.getConn().prepareStatement("select id from promocion");
            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                PromocionDTO c = new PromocionDTO();
                c.setId(aux.getInt(1));
                if (c.getId() == id) {
                    stmt = super.getConn().prepareStatement("delete from promocion   where id='" + id + "'");
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
                        Logger.getLogger(MySQLPromocionDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;

    }

    @Override
    public boolean actualizarPromocion(int id, String nombre, String fechaInicio, String fechaFin) {
        boolean exito = false;
        PreparedStatement smtm = null;
        try {
            smtm = super.getConn().prepareStatement("update promocion set nombre=?,fechainicio=?,"
                    + "fechafin=? where id='" + id + "'");

            smtm.setString(1, nombre);
            smtm.setString(2, fechaInicio);
            smtm.setString(3, fechaFin);

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
    public PromocionDTO consultarPromocion(int codigoUfps) {
        PromocionDTO aux = null;
        PreparedStatement stmt = null;
        try {
            stmt = super.getConn().prepareStatement("select * from promocion where  "
                    + "id='" + codigoUfps + "'");
            ResultSet a = stmt.executeQuery();
            while (a.next()) {
                aux = new PromocionDTO();

                aux.setNombre(a.getString(2));
                aux.setFechaInicio(a.getString(3));
                aux.setFechaFin(a.getString(4));
             }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    }
    
}
