/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DTO.EmpleadoDTO;
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
 * @author nelsoncamilo
 */
@WebServlet(name = "empleadoServlet", urlPatterns = {"/empleadoServlet"})
public class empleadoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void registrarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String cedula = request.getParameter("cedula");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            String fecha = request.getParameter("fecha");
            System.out.println("entramooooosss " + nombre + apellido + cedula + direccion + telefono + fecha);
            INegocioDTO n = new Negocio();

            if (n.registrarEmpleado(nombre, apellido, cedula, direccion, telefono, correo, fecha)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(clienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList listarEmpleado(HttpServletRequest request) throws Exception {

        INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
        if (n == null) {
            n = new Negocio();
        }
        ArrayList<EmpleadoDTO> as = new ArrayList<>();
        as = n.listarEmpleadoDTO();

        for (EmpleadoDTO a : as) {
            System.out.println("producto desde servlet: " + a.getNombres());
        }
        return as;
    }

    protected void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
            
            INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
            if (n == null) {
                n = new Negocio();
            }

            if (n.EliminarEmpleado(idEmpleado)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(empleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            protected void doGet
            (HttpServletRequest request, HttpServletResponse response)
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
            protected void doPost
            (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                if(request.getParameter("crearEmpleado")!=null){
                registrarEmpleado(request, response);
            }
                if(request.getParameter("eliminarEmpleado")!=null){
                    eliminarEmpleado(request, response);
                }
            }

            /**
             * Returns a short description of the servlet.
             *
             * @return a String containing servlet description
             */
            @Override
            public String getServletInfo
            
            
            
                () {
        return "Short description";
            }// </editor-fold>

        }
