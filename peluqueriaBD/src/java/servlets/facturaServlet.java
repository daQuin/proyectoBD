/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DTO.FacturaDTO;
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
@WebServlet(name = "facturaServlet", urlPatterns = {"/facturaServlet"})
public class facturaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void registrarFactura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int servicio = Integer.parseInt(request.getParameter("servicio"));
            int producto = Integer.parseInt(request.getParameter("producto"));
            String pago = request.getParameter("pago");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int cliente = Integer.parseInt(request.getParameter("cliente"));
            System.out.println("SERVLlllllllllllllllllET: "+ servicio + producto + cliente + pago);
            INegocioDTO n = new Negocio();

            if (n.registrarFactura(pago, producto, servicio, cliente, cantidad)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(clienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   
   public ArrayList listarFactura(HttpServletRequest request) throws Exception {

        INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
        if (n == null) {
            n = new Negocio();
        }
        ArrayList<FacturaDTO> as = n.listarFactura();
        return as;
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
       if (request.getParameter("registrarFactura") != null) {
              registrarFactura(request, response);
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
