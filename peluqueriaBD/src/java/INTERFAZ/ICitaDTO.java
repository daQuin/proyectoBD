/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;


import DTO.CitaDTO;

/**
 *
 * @author Dismar
 */
public interface ICitaDTO {
  public boolean registrarCita(CitaDTO a);
  public boolean eliminarCita(int id);
  public boolean actualizarCita(int id, String fecha,int idCliente,int idPromocion);
  public CitaDTO consultarCita(int id);  
}
