
package servlets;

import INTERFAZ.INegocioDTO;
import NEGOCIO.Negocio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel Quintero
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void iniciar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //llamamos con los nombres que pusimos en el ajax
            String nom = request.getParameter("usuario");
            String pas = request.getParameter("pass");
            INegocioDTO n = new Negocio();
            
            System.out.println("INICIOO SESIOM");
            System.out.println(nom+"-"+pas);
            if (n.iniciarSesion(nom, pas)) {
                HttpSession session = request.getSession();
                session.setAttribute("sesion", "creada");
                session.setAttribute("negocio", n);
                
                //el servlet responde con este mensaje al ajax exito y fallo
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("fallo");
            }

        }
    }
    
     protected void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            INegocioDTO neg = (INegocioDTO) request.getSession().getAttribute("negocio");
            
            
            neg.cerrarSesion();
            request.getSession().invalidate();
            System.out.println("CERROOOOOO SESIONNN");
            response.sendRedirect("index.jsp");
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
       
        if (request.getParameter("cerrarSesion") != null) {
            cerrarSesion(request, response);
        }
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
        if (request.getParameter("iniSesion") != null) {
            iniciar(request, response);
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
