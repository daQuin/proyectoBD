/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;

import DTO.ProductoDTO;
import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public interface IProductoDTO {
  public boolean registrarProducto(ProductoDTO a);
  public boolean eliminarProducto(int id);
  public boolean actualizarProducto(int id,  String nombre, String descripcion,int cantidad, double valor);
  
  public ProductoDTO consultarProducto(int id);  
  public ArrayList<ProductoDTO> listarProductoDTO();
}
