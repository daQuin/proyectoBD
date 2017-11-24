/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ClienteDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLClienteDAO extends MySQLconexion implements INTERFAZ.IClienteDTO {

    public MySQLClienteDAO(boolean keepConnection) {
        super(keepConnection);
    }

    @Override
    public boolean registrarCliente(ClienteDTO a) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = super.getConn().prepareStatement("insert into cliente (id,nombre,apellido,direccion,"
                    + "telefono,correo"
                    + ") values (0,?,?,?,?,?)");
            System.out.println("Entramos a registrar una cliente");
            stmt.setString(1, a.getNombres());
            stmt.setString(2, a.getApellidos());
            stmt.setString(3, a.getDireccion());
            stmt.setString(4, a.getTelefono());
            stmt.setString(5, a.getCorreo());

            int aux = stmt.executeUpdate();
            if (aux > 0) {
                exito = true;
                stmt.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!keepConnection) {
                if (super.getConn() != null) {
                    try {
                        super.getConn().close();
                        System.out.println("se cerro la conexion ");
                    } catch (Exception ex) {
                        Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
    }

    @Override
    public boolean eliminarCliente(int id) {
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            stmt = super.getConn().prepareStatement("select id from cliente");
            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                ClienteDTO c = new ClienteDTO();
                c.setId(aux.getInt(1));
                if (c.getId() == id) {
                    stmt = super.getConn().prepareStatement("delete from cliente where id='" + id + "'");
                    System.out.println("Se esta Eliminando un Cliente");
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
                        Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;

    }

    @Override
    public boolean actualizarCliente(int id, String nombres, String apellidos, String direccion, String telefono, String correo) {
        boolean exito = false;
        PreparedStatement smtm = null;
        try {
            smtm = super.getConn().prepareStatement("update cliente set nombre=?,apellido=?,"
                    + "direccion=?,telefono=?,correo=? where id='" + id + "'");
            System.out.println("Se encuentra actualizando el cliente con id = " + id);

            smtm.setString(1, nombres);
            smtm.setString(2, apellidos);
            smtm.setString(3, direccion);
            smtm.setString(4, telefono);
            smtm.setString(5, correo);

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
    public ClienteDTO consultarCliente(int codigoUfps) {
        ClienteDTO aux = null;
        PreparedStatement stmt = null;
        try {
            stmt = super.getConn().prepareStatement("select * from cliente where  "
                    + "id='" + codigoUfps + "'");
            ResultSet a = stmt.executeQuery();
            while (a.next()) {
                aux = new ClienteDTO();

                aux.setNombres(a.getString(2));
                aux.setApellidos(a.getString(3));
                aux.setDireccion(a.getString(4));
                aux.setTelefono(a.getString(5));
                aux.setCorreo(a.getString(6));
            }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    }

    @Override
    public ArrayList<ClienteDTO> listarClienteDTO() {

        ArrayList<ClienteDTO> a = null;
        PreparedStatement stmt = null;
        PreparedStatement auxi = null;

        try {
            a = new ArrayList<ClienteDTO>();
            stmt = super.getConn().prepareStatement("select * from cliente");

            ResultSet aux = stmt.executeQuery();
            while (aux.next()) {
                ClienteDTO vis = new ClienteDTO();
                vis.setId(aux.getInt(1));
                vis.setNombres(aux.getString(2));
                vis.setApellidos(aux.getString(3));
                vis.setDireccion(aux.getString(4));
                vis.setTelefono(aux.getString(5));
                vis.setCorreo(aux.getString(6));
                a.add(vis);
            }
            aux.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;

    }

    @Override
    public ClienteDTO consultarClienteNC(String nombre, String correo) {
    
        ClienteDTO aux = null;
        PreparedStatement stmt = null;
        try {
            stmt = super.getConn().prepareStatement("select * from cliente where  "
                    + "nombre='" + nombre +"' AND correo='" + correo + "'");
            ResultSet a = stmt.executeQuery();
            while (a.next()) {
                aux = new ClienteDTO();
                aux.setId(a.getInt(1));
                aux.setNombres(a.getString(2));
                aux.setApellidos(a.getString(3));
                aux.setDireccion(a.getString(4));
                aux.setTelefono(a.getString(5));
                aux.setCorreo(a.getString(6));
            }

            a.close();
            return aux;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    
    }

}
