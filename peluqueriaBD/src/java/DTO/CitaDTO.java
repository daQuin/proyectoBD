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
    private ClienteDTO idCliente;
    private PromocionDTO idPromocion;

    public CitaDTO() {
    }

    public CitaDTO(String fecha, ClienteDTO idCliente, PromocionDTO idPromocion) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idPromocion = idPromocion;
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

    public PromocionDTO getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(PromocionDTO idPromocion) {
        this.idPromocion = idPromocion;
    }
    
    
    
     
    
    
}
