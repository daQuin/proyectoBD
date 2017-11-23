/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DTO.ClienteDTO;
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
@WebServlet(name = "clienteServlet", urlPatterns = {"/clienteServlet"})
public class clienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void registrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

       
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String tel = request.getParameter("tel");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            System.out.println(nombre + apellido + tel + correo);
            INegocioDTO n = new Negocio();

            if (n.registrarCliente(nombre, apellido, direccion, tel, correo)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(clienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int idconvocatoria = Integer.parseInt(request.getParameter("idconvocatoria"));
            System.out.println("entro a eliminarrrr  " + idconvocatoria);
            INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
            if (n == null) {
                n = new Negocio();
            }

            if (n.EliminarCliente(idconvocatoria)) {
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(clienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void actualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nom = request.getParameter("usuario");
            String pas = request.getParameter("pass");

            int idConv = Integer.parseInt(request.getParameter("idConv"));
            String fechainicio = request.getParameter("fechainicio");
            String fechafin = request.getParameter("fechafin");
            String tipo = request.getParameter("tipo");
            String fechainciovisita = request.getParameter("fechainiciovisita");
            String fechafinvisita = request.getParameter("fechafinvisita");
            int cupos = Integer.parseInt(request.getParameter("cupos"));
            double invercionestudiante = Double.parseDouble(request.getParameter("invercionestudiante"));
            String nombreempresa = request.getParameter("nombreempresa");
            String pais = request.getParameter("pais");
            String ciudad = request.getParameter("ciudad");
            String direccion = request.getParameter("direccion");

            INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
            if (n == null) {
                n = new Negocio();
            }

            if (n.actualizarCliente(idConv, nom, pais, direccion, tipo, ciudad)) {
                //el servlet responde con este mensaje al ajax exito y fallo

                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }
        } catch (Exception ex) {
            Logger.getLogger(clienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ClienteDTO buscarVisita(HttpServletRequest request, int id) throws Exception {
        INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
        if (n == null) {
            n = new Negocio();
        }
        ClienteDTO c = n.consultarCliente(id);
        return c;
    }

    public ArrayList listarClientes(HttpServletRequest request) throws Exception {

        INegocioDTO n = (INegocioDTO) request.getSession().getAttribute("negocio");
        if (n == null) {
            n = new Negocio();
        }
        ArrayList<ClienteDTO> as = n.listarClienteDTO();
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
        if (request.getParameter("inscribirce") != null) {
            registrarCliente(request, response);
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
