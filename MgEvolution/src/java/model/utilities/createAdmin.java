/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import Controller.entities.StylistJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.Stylist;

/**
 *
 * @author judith
 */
@WebServlet(name = "createAdmin", urlPatterns = {"/createAdmin"})
public class createAdmin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*Creo un estilista el cual es el unico administrador.
            El administrador es un estilista ya que tambien es un trabajador mas especialidades*/
            Stylist stylistAdmin = new Stylist();
            stylistAdmin.setName("Administrador");
            stylistAdmin.setLastName("");
            stylistAdmin.setArea("Corte, Colorimetría");
            stylistAdmin.setSalary(0);
            stylistAdmin.setAdmin(true);
            
            
            String message = "Stylist Admin Created Successfully";
            StylistJpaController ejc
                    = new StylistJpaController(Persistence.createEntityManagerFactory("MgEvolution"));
            try {
                ejc.create(stylistAdmin);
            } catch (Exception ex) {
                message = "An error occurred while creating the admin stylist";
                System.err.println(ex.getClass().getName() + ":" + ex.getMessage());
                ex.printStackTrace();
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
