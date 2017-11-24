/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;


import DTO.FacturaDTO;
import DTO.ProductoDTO;
import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public interface IFacturaDTO {
  public boolean generarFactura(FacturaDTO a);
  public boolean eliminarFactura(int id);
  public boolean actualizarFactura(int id,String tipoPago, String fecha, int idCliente, double totalPagar);
  public FacturaDTO consultarFactura(int id);   
  public ArrayList<FacturaDTO> listarFactura();
}