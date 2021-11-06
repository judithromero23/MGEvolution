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
@WebServlet(name = "addStylist", urlPatterns = {"/addStylist"})
public class addStylist extends HttpServlet {

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
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String area = request.getParameter("area");
        Integer salary = Integer.parseInt(request.getParameter("salary"));
        String email = request.getParameter("email");
        boolean admin = (request.getParameter("admin") != null);

        Stylist newStylist = new Stylist();
        newStylist.setName(name);
        newStylist.setLogin(login);
        newStylist.setPassword(password);
        newStylist.setArea(area);
        newStylist.setSalary(salary);
        newStylist.setEmail(email);
        newStylist.setAdmin(admin);
        System.out.println(name + " " + login + " " + password + " " + area + " " + salary + " " + email+ " " + admin);
        System.out.println(newStylist);
        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");
        System.out.println("Nuevo Estilista " + newStylist);
        try {
            hairdresser.addStylist(newStylist);
        } catch (Exception ex) {
            error = "Error al crear el usuario '" + login + "', pruebe con otro nombre";
        }
        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("name", name);
            request.setAttribute("login", login);
            request.setAttribute("password", password);
            request.setAttribute("area", area);
            request.setAttribute("email", email);
            request.setAttribute("checked", admin ? "checked" : "");
            System.out.println(newStylist);
            getServletContext().getRequestDispatcher("/stylist/onlyView.jsp").forward(request, response);
        } else {
            response.sendRedirect(response.encodeRedirectURL("/MgEvolution/onlyViewStylist.jsp?mensaje="));
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
