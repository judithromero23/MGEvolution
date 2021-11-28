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
@WebServlet(name = "addClient", urlPatterns = {"/addClient"})
public class addClient extends HttpServlet {

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
        String error = null;
        String dni = request.getParameter("dni");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        Integer phone = Integer.parseInt(request.getParameter("phone"));

        Client newClient = new Client();
        newClient.setDNI(dni);
        newClient.setName(name);
        newClient.setLastName(lastName);
        newClient.setCity(city);
        newClient.setPhone(phone);

        //Date parse
        String requestDate = request.getParameter("bithDate");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {

            date = format.parse(requestDate);
            newClient.setBirthDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");

        try {
            hairdresser.addClient(newClient);
        } catch (Exception ex) {
            error = "Error al añadir a el cliente '" + dni + "', pruebe con otro dni.";
        }
        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("DNI", dni);
            request.setAttribute("name", name);
            request.setAttribute("lastName", lastName);
            request.setAttribute("city", city);
            request.setAttribute("phone", phone);
            getServletContext().getRequestDispatcher("/client/onlyView.jsp").forward(request, response);
        } else {
            response.sendRedirect(response.encodeRedirectURL("/MgEvolution/onlyViewClient.jsp?option=1"));
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
