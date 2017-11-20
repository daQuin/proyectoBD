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
public class EmpleadoDTO {
     private int id;
   private String nombres;
   private String apellidos;
   private String cedula;
   private String direccion;
   private String telefono;
   private String correo;
   private String fechaIngreso;
  
   

    public EmpleadoDTO() {
    }

    public EmpleadoDTO( String nombres, String apellidos,String cedula, String direccion, String telefono, String correo,String fechaIngreso) {
        
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula=cedula;
        this.direccion = direccion;
        this.telefono=telefono;
        this.correo = correo;
        this.fechaIngreso=fechaIngreso;
         
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
      @Override
    public String toString() {
        return "EmpleadoDTO {nombres=" + nombres + ", apellidos=" + apellidos +", cedula="+cedula + ", direccion="+ direccion+ ", tele=" + telefono + ", correo=" + correo + ", fecha de Ingreso="+fechaIngreso+'}';
    }
    
}
