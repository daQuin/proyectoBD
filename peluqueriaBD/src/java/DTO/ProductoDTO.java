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
public class ProductoDTO {
   private int id;
   private int cantidad;
   private double valor;
   private String descripcion;
   private String nombre;

   public ProductoDTO(){
   }
   
    public ProductoDTO( int cantidad, double valor, String color, String nombre) {
        this.cantidad = cantidad;
        this.valor = valor;
        this.descripcion = color;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String color) {
        this.descripcion = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
      @Override
    public String toString() {
        return "ProductoDTO {nombre=" + nombre +  ",Descripcion="+descripcion+", Valor="+valor+", Cantidad="+cantidad+'}';
    }
   
    
}


