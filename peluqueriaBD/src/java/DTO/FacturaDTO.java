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
    private String producto;
    private String servicio;
    private int cantidad;

    public FacturaDTO() {
    }

    public FacturaDTO(double totalPagar, String tipoPago, String fecha, ClienteDTO idCliente, String producto, String servicio, int cantidad) {
        this.totalPagar = totalPagar;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.producto = producto;
        this.servicio = servicio;
        this.cantidad = cantidad;
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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
}
