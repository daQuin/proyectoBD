/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Dismar
 */
public class CitaDTO {
    private int id;
    private String fecha;
    private String fechaCreacion;
    private ClienteDTO idCliente;
    private String servicio;

    public CitaDTO() {
    }

    public CitaDTO(String fecha, String fechaCreacion, ClienteDTO idCliente, String servicio) {
        this.fechaCreacion=fechaCreacion;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.servicio = servicio;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ClienteDTO getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteDTO idCliente) {
        this.idCliente = idCliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

   
    
    
}
