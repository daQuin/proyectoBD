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
            stmt = super.getConn().prepareStatement("insert into cita (id,fecha,fechacreacion,cliente,promocion,"
                    + ") values (0,?,?,0,0)");
            stmt.setString(1, a.getFecha());
            stmt.setString(2, a.getFechaCreacion());
            stmt.setInt(3, a.getIdCliente().getId());
            stmt.setInt(4, a.getIdPromocion().getId());

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
                    stmt = super.getConn().prepareStatement("delete from cita where id='" + id + "'");
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
    public boolean actualizarCita(int id, String fecha, String fechaCreacion,int idCliente, int idPromocion) {
    boolean exito = false;
        PreparedStatement smtm = null;
        try {
            smtm = super.getConn().prepareStatement("update cita set fecha=?,fechacreacion=?,idcliente=?,"
                    + "idpromocion=? where id='" + id + "'");

            smtm.setString(1, fecha);
            smtm.setString(2, fechaCreacion);
            smtm.setInt(3, idCliente);
            smtm.setInt(4, idPromocion);

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
            stmt = super.getConn().prepareStatement("select * from cita where  "
                    + "id='" + id + "'");
            ResultSet a = stmt.executeQuery();
            while (a.next()) {
                aux = new CitaDTO();
                MySQLClienteDAO c = new MySQLClienteDAO(false);
                MySQLPromocionDAO  p= new MySQLPromocionDAO(false);
                aux.setFecha(a.getString(2));
                aux.setIdCliente(c.consultarCliente(a.getInt(3)));
                aux.setIdPromocion(p.consultarPromocion(a.getInt(4)));
             }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;}
    
        @Override
    public ArrayList<CitaDTO> listarCitaDTO() {

        ArrayList<CitaDTO> a = null;
        PreparedStatement stmt = null;
        PreparedStatement auxi = null;

        try {
            a = new ArrayList<CitaDTO>();
            stmt = super.getConn().prepareStatement("select * from cita");

            ResultSet aux = stmt.executeQuery();
            MySQLClienteDAO c = new MySQLClienteDAO(false);
            MySQLPromocionDAO  p= new MySQLPromocionDAO(false);
            while (aux.next()) {
                CitaDTO vis = new CitaDTO();
                vis.setId(aux.getInt(1));
                vis.setFecha(aux.getString(2));
                vis.setFechaCreacion(aux.getString(3));
                vis.setIdCliente(c.consultarCliente(aux.getInt(4)));
                vis.setIdPromocion(p.consultarPromocion(aux.getInt(5)));
                a.add(vis);
            }
            aux.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;

    }
    
    
    
}

