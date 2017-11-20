/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author estudiante
 */
public class FacturaDTO {
    private int id;
    private double totalPagar;
    private String tipoPago;
    private String fecha;
    private ClienteDTO idCliente;

    public FacturaDTO() {
    }

    public FacturaDTO( String tipoPago, String fecha, ClienteDTO idCliente, double totalPagar) {
       
        this.totalPagar = totalPagar;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
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
    
    
    
    
}
