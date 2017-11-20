/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;

import DTO.EmpleadoDTO;

/**
 *
 * @author Dismar
 */
public interface IEmpleadoDTO {
  public boolean registrarEmpleado(EmpleadoDTO a);
  public boolean eliminarEmpleado(int id);
  public boolean actualizarEmpleado(int id, String nombres,String apellidos,String cedula,String direccion, String telefono,String correo,String fechaIngreso);
  public EmpleadoDTO consultarEmpleado(int id);

    
}
