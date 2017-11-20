/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.EmpleadoDTO;

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
public class MySQLEmpleadoDAO extends MySQLconexion implements INTERFAZ.IEmpleadoDTO{
    
    public MySQLEmpleadoDAO(boolean keepConnection) {
        super(keepConnection);
    }
    
    
     @Override
    public boolean registrarEmpleado(EmpleadoDTO a) {
     boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = super.getConn().prepareStatement("insert into cliente (id,nombre,apellido,cedula,direccion,"
                    + "telefono,correo,fechaingreso"
                    + ") values (0,?,?,?,?,?,?,?)");
            System.out.println("Entramos a registrar un empleado");
            stmt.setString(1, a.getNombres());
            stmt.setString(2, a.getApellidos());
            stmt.setString(3, a.getCedula());
            stmt.setString(4, a.getDireccion());
            stmt.setString(5, a.getTelefono());
            stmt.setString(6, a.getCorreo());
            stmt.setString(7, a.getFechaIngreso());

            int aux = stmt.executeUpdate();
            if(aux > 0){
                exito=true;
                stmt.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MySQLEmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!keepConnection) {
                if (super.getConn() != null) {
                    try {
                        super.getConn().close();
                        System.out.println("se cerro la conexion ");
                    } catch (Exception ex) {
                        Logger.getLogger(MySQLEmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
    }

    @Override
    public boolean eliminarEmpleado(int id) {
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            stmt = super.getConn().prepareStatement("select id from empleado");
            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                EmpleadoDTO c = new EmpleadoDTO();
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
                        Logger.getLogger(MySQLEmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;

    }

    @Override
    public boolean actualizarEmpleado(int id, String nombres, String apellidos,String cedula, String direccion, String telefono, String correo,String fechaIngreso) {
        boolean exito = false;
        PreparedStatement smtm = null;
        try {
            smtm = super.getConn().prepareStatement("update asistente set nombres=?,apellidos=?,"
                    + "cedula=?,direccion=?,telefono=?,correo=?,fechaInicio=?,where id='" + id + "'");
            System.out.println("Se encuentra actualizando el asistente con id = " + id);

            smtm.setString(1, nombres);
            smtm.setString(2, apellidos);
            smtm.setString(3, cedula); 
            smtm.setString(4, direccion);
            smtm.setString(5, telefono);
            smtm.setString(6, correo);
            smtm.setString(7, fechaIngreso);

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
    public EmpleadoDTO consultarEmpleado(int codigoUfps) {
        EmpleadoDTO aux = null;
        PreparedStatement stmt = null;
        try {
            stmt = super.getConn().prepareStatement("select * from empleado where  "
                    + "id='" + codigoUfps + "'");
            ResultSet a = stmt.executeQuery();
            while (a.next()) {
                aux = new EmpleadoDTO();

                aux.setNombres(a.getString(1));
                aux.setApellidos(a.getString(2));
                aux.setCedula(a.getString(3));
                aux.setDireccion(a.getString(4));
                aux.setTelefono(a.getString(5));
                aux.setCorreo(a.getString(6));
                aux.setFechaIngreso(a.getString(7));
             }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    }
    
    
}
