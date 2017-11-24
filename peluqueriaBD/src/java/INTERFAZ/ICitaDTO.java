/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;


import DTO.CitaDTO;
import java.util.ArrayList;

/**
 *
 * @author Dismar
 */
public interface ICitaDTO {
  public boolean registrarCita(CitaDTO a);
  public boolean eliminarCita(int id);
  public boolean actualizarCita(int id, String fecha,String fechaCreacion, int idCliente,String servicio);
  public CitaDTO consultarCita(int id);  
  public ArrayList<CitaDTO> listarCitaDTO();
}
