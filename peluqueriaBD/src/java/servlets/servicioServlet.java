/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DTO.EmpleadoDTO;
import DTO.ProductoDTO;
import DTO.ServicioDTO;
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
@WebServlet(name = "servicioServlet", urlPatterns = {"/servicioServlet"})
public class servicioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void registrarServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nombre = request.getParameter("nombre");
            double valor = Double.parseDouble(request.getParameter("valor"));
            String descripcion = request.getParameter("descripcion");
            INegocioDTO n = new Negocio();

            System.out.println("Servlet: " + nombre + valor + descripcion);
            if (n.registrarServicio(nombre, valor, descripcion)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(clienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList listarServicios(HttpServletRequest request) throws Exception {

        INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
        if (n == null) {
            n = new Negocio();
        }
        ArrayList<ServicioDTO> as = new ArrayList<>();
        as = n.listarServicio();

        return as;
    }

    protected void eliminarServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            System.out.println("llegooooo");
            int idServicio = Integer.parseInt(request.getParameter("idservicio"));
            System.out.println("ELIMINAR SERVICIO: " + idServicio);
            INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
            if (n == null) {
                n = new Negocio();
            }

            if (n.EliminarServicio(idServicio)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServicioDTO buscarServicio(HttpServletRequest request, int id) throws Exception {
        INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
        if (n == null) {
            n = new Negocio();
        }
        ServicioDTO c = n.consultarServicio(id);
        return c;
    }
    
    
    protected void ActualizarServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
     
            int idServ = Integer.parseInt(request.getParameter("id"));
            System.out.println("IDDDDD:  "+ idServ);   
            String nombre = request.getParameter("nombre");
            double valor = Double.parseDouble(request.getParameter("valor"));
            String descripcion = request.getParameter("descripcion");
          

            INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
            if (n == null) {
                n = new Negocio();
            }
            
            if (n.actualizarServicio(idServ, nombre, valor, descripcion)) {
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
        registrarServicio(request, response);
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
        if (request.getParameter("crearServicio") != null) {
            registrarServicio(request, response);
        }
        if (request.getParameter("eliminarServicio") != null) {
            eliminarServicio(request, response);
        }
        
        if(request.getParameter("actualizarServicio")!=null){
            ActualizarServicio(request, response);
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
