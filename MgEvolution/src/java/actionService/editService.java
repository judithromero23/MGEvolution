/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionService;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.Client;
import model.entities.Service;
import model.entities.Stylist;
import models.Hairdresser;

/**
 *
 * @author judith
 */
@WebServlet(name = "editService", urlPatterns = {"/editService"})
public class editService extends HttpServlet {

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
        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");
        Long idService = Long.parseLong(request.getParameter("idService"));
        Service service = hairdresser.searchService(idService);
        
        if (service == null) {
            String error = "Se ha producido un error al actualizar el servicio";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/service/onlyView.jsp").forward(request, response);
        }

            if (request.getParameter("eliminar") != null) {
                try {
                    hairdresser.deleteService(idService);
                } catch (Exception e) {
                    String error = e.getMessage();
                    request.setAttribute("error", error);
                    getServletContext().getRequestDispatcher("/service/onlyView.jsp").forward(request, response);
                }
                response.sendRedirect("onlyViewService.jsp?option=3");
                return;
            } else {
                request.setAttribute("idService", service.getId());
                request.setAttribute("stylist", service.getStylist());
                request.setAttribute("client", service.getClient());
                getServletContext().getRequestDispatcher("/service/onlyView.jsp").forward(request, response);
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
