/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.Client;
import models.Hairdresser;

/**
 *
 * @author judith
 */
@WebServlet(name = "editClient", urlPatterns = {"/editClient"})
public class editClient extends HttpServlet {

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
        String dni = request.getParameter("dni");

        Client client = hairdresser.searchClient(dni);
        if (client == null) {
            String error = "Se ha producido un error al actualizar a el cliente.";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/client/onlyView.jsp").forward(request, response);
        }

        if (request.getParameter(
                "actualizar") != null) {
            client.setName(request.getParameter("name"));
            client.setLastName(request.getParameter("lastName"));

            //Date parse
            String requestDate = request.getParameter("bithDate");

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {

                date = format.parse(requestDate);
                client.setBirthDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            client.setCity(request.getParameter("city"));
            client.setPhone(Integer.parseInt(request.getParameter("phone")));
            try {
                hairdresser.updateClient(client);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + " : " + e.getMessage());
            }
            response.sendRedirect("onlyViewClient.jsp?option=2");
        } else {
            if (request.getParameter("eliminar") != null) {
                try {
                    hairdresser.deleteClient(dni);
                } catch (Exception e) {
                    String error = e.getMessage();
                    request.setAttribute("error", error);
                    getServletContext().getRequestDispatcher("/client/onlyView.jsp").forward(request, response);
                }
                response.sendRedirect("onlyViewClient.jsp?option=3");
                return;
            } else {
                request.setAttribute("name", client.getName());
                request.setAttribute("lastname", client.getLastName());
                request.setAttribute("BirthDate", client.getBirthDate());
                request.setAttribute("city", client.getCity());
                request.setAttribute("phone", client.getPhone());
                getServletContext().getRequestDispatcher("/client/onlyView.jsp").forward(request, response);
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
