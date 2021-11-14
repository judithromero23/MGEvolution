/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionSupplier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.Supplier;
import models.Hairdresser;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author judith
 */
@WebServlet(name = "addSupplier", urlPatterns = {"/addSupplier"})
public class addSupplier extends HttpServlet {

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
        String brandOriginal = request.getParameter("brand");
        String nameSupplier = request.getParameter("nameSupplier");
        Integer phoneSupplier = Integer.parseInt(request.getParameter("phoneSupplier"));
        String brand = StringUtils.lowerCase(brandOriginal);
      

        Supplier newSupplier = new Supplier();
        newSupplier.setBrand(brand);
        newSupplier.setNameSupplier(nameSupplier);
        newSupplier.setPhoneSupplier(phoneSupplier);
     
        System.out.println("Brand: " + brand + ", NameSupplier: " + nameSupplier + ", PhoneSupplier: " + phoneSupplier);
        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");
        System.out.println("Nuevo Proveedor " + newSupplier);
        try {
            hairdresser.addSupplier(newSupplier);
        } catch (Exception ex) {
            error = "Error al crear el proveedor '" + brand + "', pruebe con otro nombre";
        }
        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("brand", brand);
            request.setAttribute("nameSupplier", nameSupplier);
            request.setAttribute("phoneSupplier", phoneSupplier);
            getServletContext().getRequestDispatcher("/supplier/onlyView.jsp").forward(request, response);
        } else {
            response.sendRedirect(response.encodeRedirectURL("/MgEvolution/onlyViewSupplier.jsp?option=1"));
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
