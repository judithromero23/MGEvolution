/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "addService", urlPatterns = {"/addService"})
public class addService extends HttpServlet {

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

        //Stylist id
        String stylistInput = request.getParameter("stylist");
        String[] infoStylist = stylistInput.split(" ");
        Long idStylist = Long.parseLong(infoStylist[0]);
        Stylist stylist = Hairdresser.searchStylist(idStylist);

        //Client dni
        String clientInput = request.getParameter("client");
        String[] infoClient = clientInput.split(" ");
        String idClient = infoClient[0];
        Client client = Hairdresser.searchClient(idClient);

        /*Date Version 1
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateTime = localDate.format(formatter);
        */
        
        //Date Version 2
        String date = request.getParameter("date");
        date = date.replace("T", " ");
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
       // LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        
        Service newService = new Service();
        newService.setDate(date);
        newService.setStylist(stylist);
        newService.setClient(client);

        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");

        try {
            hairdresser.addService(newService);
        } catch (Exception ex) {
            error = "Error al crear el servicio .";
        }
        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("stylist", stylist);
            request.setAttribute("client", client);
            getServletContext().getRequestDispatcher("/service/onlyView.jsp").forward(request, response);
        } else {
            response.sendRedirect(response.encodeRedirectURL("/MgEvolution/onlyViewService.jsp?option=1"));
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
