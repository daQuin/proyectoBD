/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;

import DTO.ServicioDTO;

/**
 *
 * @author estudiante
 */
public interface IServicioDTO {
  public boolean registrarServicio(ServicioDTO a);
  public boolean eliminarServicio(int id);
  public boolean actualizarServicio(int id, String nombre,double valor);
  public ServicioDTO consultarServicio(int id);

    
}
