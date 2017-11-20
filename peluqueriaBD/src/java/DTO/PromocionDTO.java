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
public class PromocionDTO {
    private int id;
    private String nombre;
    private String FechaInicio;
    private String FechaFin;

    public PromocionDTO() {
    }

    public PromocionDTO(String nombre, String FechaInicio, String FechaFin) {
        this.nombre = nombre;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }
    
    
    
    
}
