/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.CitaDTO;

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
public class MySQLCitaDAO extends MySQLconexion  implements INTERFAZ.ICitaDTO{
    
    public MySQLCitaDAO(boolean keepConnection) {
        super(keepConnection);
    }

    @Override
    public boolean registrarCita(CitaDTO a) {
        
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = super.getConn().prepareStatement("insert into cita (id,fecha,cliente,promocion,"
                    + ") values (0,?,0,0)");
            System.out.println("Entramos a registrar una cita");
            stmt.setString(1, a.getFecha());
            stmt.setInt(2, a.getIdCliente());
            stmt.setInt(3, a.getIdPromocion());

            int aux = stmt.executeUpdate();
            if(aux > 0){
                exito=true;
                stmt.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MySQLCitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!keepConnection) {
                if (super.getConn() != null) {
                    try {
                        super.getConn().close();
                        System.out.println("se cerro la conexion ");
                    } catch (Exception ex) {
                        Logger.getLogger(MySQLCitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
     }

    @Override
    public boolean eliminarCita(int id) {
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            stmt = super.getConn().prepareStatement("select id from cita");
            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                CitaDTO c = new CitaDTO();
                c.setId(aux.getInt(1));
                if (c.getId() == id) {
                    stmt = super.getConn().prepareStatement("delete from asistente where id='" + id + "'");
                    System.out.println("Se esta Eliminando un Asistente");
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
                        System.out.println("se cerro la conexion elim ");
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLCitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;}

    @Override
    public boolean actualizarCita(int id, String fecha, int idCliente, int idPromocion) {
    boolean exito = false;
        PreparedStatement smtm = null;
        try {
            smtm = super.getConn().prepareStatement("update asistente set fecha=?,idcliente=?,"
                    + "idpromocion=? where id='" + id + "'");
            System.out.println("Se encuentra actualizando el asistente con id = " + id);

            smtm.setString(1, fecha);
            smtm.setInt(2, idCliente);
            smtm.setInt(3, idPromocion);

            int total = smtm.executeUpdate();
            if (total > 0) {
                exito = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;}

    @Override
    public CitaDTO consultarCita(int id) {
        CitaDTO aux = null;
        PreparedStatement stmt = null;
        try {
            stmt = super.getConn().prepareStatement("select * from cliente where  "
                    + "id='" + id + "'");
            ResultSet a = stmt.executeQuery();
            while (a.next()) {
                aux = new CitaDTO();

                aux.setFecha(a.getString(1));
                aux.setIdCliente(a.getInt(2));
                aux.setIdPromocion(a.getInt(3));
             }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;}
    
    
}

