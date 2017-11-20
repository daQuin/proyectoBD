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
public class ServicioDTO {
    
    private int id;
    private String nombre;
    private double valor;
    
    public ServicioDTO(){
    }

    public ServicioDTO(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
    @Override
    public String toString() {
        return "ProductoDTO {nombre=" + nombre +", Valor="+valor+'}';
    }
}
