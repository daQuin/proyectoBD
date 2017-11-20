/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;

import DTO.PromocionDTO;

/**
 *
 * @author estudiante
 */
public interface IPromocionDTO {
  public boolean registrarPromocion(PromocionDTO a);
  public boolean eliminarPromocion(int id);
  public boolean actualizarPromocion(int id,String nombre, String FechaInicio, String FechaFin);
  public PromocionDTO consultarPromocion(int id);   
    
}
