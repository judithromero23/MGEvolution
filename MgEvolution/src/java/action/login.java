/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.controllers.StylistJpaController;
import model.entities.Stylist;
import models.Hairdresser;

/**
 *
 * @author judith
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loginOriginal = request.getParameter("login");
        String password = request.getParameter("password");
        /*Login usuario pasado a minusculas con lowerCase*/
        String login = StringUtils.lowerCase(loginOriginal);
        String error = null;
        if (login == null || password == null) {
            error = "Debe acceder por la página de login";
        } else {
            if (login.isEmpty() || password.isEmpty()) {
                error = "Se deben rellenar los campos usuario y contraseña";
            } else {
                StylistJpaController ejc = new StylistJpaController(Persistence.createEntityManagerFactory("MgEvolutionPU"));
                List<Stylist> stylists = ejc.findStylistEntities();
                System.out.println(stylists.toString());
                for (Stylist stylist : stylists) {
                    if (stylist.getLogin().equals(login) && stylist.getPassword().equals(password) && stylist.getAdmin().equals(true)) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("stylist", stylist);
                        sesion.setAttribute("hairdresser", new Hairdresser());
                        response.sendRedirect("adminOption.jsp");
                        return;
                    }
                }
                error ="El usuario con el que intenta acceder no es estilista o no es administrador. Prueba con otro usuario o otra contraseña.";
            }

        }
        request.setAttribute("error", error);
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
