/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionStylist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.Stylist;
import models.Hairdresser;

/**
 *
 * @author judith
 */
@WebServlet(name = "editStylist", urlPatterns = {"/editStylist"})
public class editStylist extends HttpServlet {

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
        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");
        Long id = Long.parseLong(request.getParameter("id"));
        Stylist stylist = hairdresser.searchStylist(id);
        if (stylist == null) {
            String error = "Se ha producido un error al actualizar el estilista";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/stylist/onlyView.jsp").forward(request, response);
        }

        if (request.getParameter("actualizar") != null) {
            stylist.setName(request.getParameter("name"));
            stylist.setPassword(request.getParameter("password"));
            stylist.setEmail(request.getParameter("email"));
            stylist.setArea(request.getParameter("area"));
            stylist.setSalary(Float.parseFloat(request.getParameter("salary")));
            if (request.getParameter("admin") != null) {
                stylist.setAdmin(true);
            } else {
                stylist.setAdmin(false);
            }
            if (!request.getParameter("password").isEmpty()) {
                stylist.setPassword(request.getParameter("password"));
            }

            try {
                hairdresser.updateStylist(stylist);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + " : " + e.getMessage());
            }
            response.sendRedirect("onlyViewStylist.jsp?option=2");
        } else {
            if (request.getParameter("eliminar") != null) {
                try {
                    hairdresser.deleteStylist(id);
                } catch (Exception e) {
                    String error = e.getMessage();
                    request.setAttribute("error", error);
                    getServletContext().getRequestDispatcher("/stylist/onlyView.jsp").forward(request, response);
                }
                response.sendRedirect("onlyViewStylist.jsp?option=3");
                return;
            } else {
                request.setAttribute("id", stylist.getId());
                request.setAttribute("name", stylist.getName());
                request.setAttribute("login", stylist.getLogin());
                request.setAttribute("password", stylist.getPassword());
                request.setAttribute("area", stylist.getArea());
                request.setAttribute("salary", stylist.getSalary());
                request.setAttribute("email", stylist.getEmail());
                request.setAttribute("checked", stylist.getAdmin() ? "checked" : "");
                System.out.println(stylist);
                getServletContext().getRequestDispatcher("/stylist/onlyView.jsp").forward(request, response);
            }
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
