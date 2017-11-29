/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DTO.ProductoDTO;
import INTERFAZ.INegocioDTO;
import NEGOCIO.Negocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "productoServlet", urlPatterns = {"/productoServlet"})
public class productoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void registrarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int valor = Integer.parseInt(request.getParameter("valor"));
            System.out.println("entramooooosss " + nombre + descripcion + cantidad + valor);
            INegocioDTO n = new Negocio();

            if (n.registrarProducto(nombre, descripcion, cantidad, valor)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(clienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList listarProductos(HttpServletRequest request) throws Exception {

        INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
        if (n == null) {
            n = new Negocio();
        }
        ArrayList<ProductoDTO> as = new ArrayList<>();
        as = n.listarProducto();
        
        for (ProductoDTO a : as) {
            System.out.println("producto desde servlet: "+ a.getNombre());
        }
        return as;
    }
    
    protected void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int idProducto = Integer.parseInt(request.getParameter("idproducto"));
            
            INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
            if (n == null) {
                n = new Negocio();
            }

            if (n.EliminarProducto(idProducto)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ProductoDTO buscarProducto(HttpServletRequest request, int id) throws Exception {
        INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
        if (n == null) {
            n = new Negocio();
        }
        ProductoDTO c = n.consultarProducto(id);
        return c;
    }
    
     protected void ActualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
     
            int idProd = Integer.parseInt(request.getParameter("id")); 
            System.out.println("id producto:" +idProd);
            String nombre = request.getParameter("nombre");
            double valor = Double.parseDouble(request.getParameter("valor"));
            int cantidad=Integer.parseInt(request.getParameter("cantidad"));
            System.out.println("can: "+cantidad);
            String descripcion = request.getParameter("descripcion");
          

            INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
            if (n == null) {
                n = new Negocio();
            }
            
            if (n.actualizarProducto(idProd, nombre, descripcion, cantidad, valor)) {
                //el servlet responde con este mensaje al ajax exito y fallo

                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(servicioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        registrarProducto(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if (request.getParameter("crearProducto") != null) {
            System.out.println("enntro1");
            registrarProducto(request, response);
        } else if (request.getParameter("eliminarProd") != null) {
            System.out.println("enntro2 a eliminar ");
            eliminarProducto(request, response);
        } if (request.getParameter("actualizarProducto") != null) {
            ActualizarProducto(request, response);
        } 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
