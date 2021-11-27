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

/**
 *
 * @author judith
 */
@WebServlet(name = "editSupplier", urlPatterns = {"/editSupplier"})
public class editSupplier extends HttpServlet {

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
        Long id_brand = Long.parseLong(request.getParameter("id_brand"));
        String brand = request.getParameter("brand");
        System.out.println(brand);
        Supplier supplier = hairdresser.searchSupplier(id_brand);
        if (supplier == null) {
            String error = "Se ha producido un error al actualizar a el proveedor.";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/supplier/onlyView.jsp").forward(request, response);
        }

        if (request.getParameter("actualizar") != null) {
            supplier.setNameSupplier(request.getParameter("nameSupplier"));
            supplier.setPhoneSupplier(Integer.parseInt(request.getParameter("phoneSupplier")));
           
            try {
                hairdresser.updateSupplier(supplier);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + " : " + e.getMessage());
            }
            response.sendRedirect("onlyViewSupplier.jsp?option=2");
        } else {
            if (request.getParameter("eliminar") != null) {
                try {
                    hairdresser.deleteSupplier(id_brand);
                } catch (Exception e) {
                    String error = e.getMessage();
                    request.setAttribute("error", error);
                    getServletContext().getRequestDispatcher("/supplier/onlyView.jsp").forward(request, response);
                }
                response.sendRedirect("onlyViewSupplier.jsp?option=3");
                return;
            } else {
                request.setAttribute("brand", supplier.getBrand());
                request.setAttribute("nameSupplier", supplier.getNameSupplier());
                request.setAttribute("phoneSupplier", supplier.getPhoneSupplier());
                System.out.println(supplier);
                getServletContext().getRequestDispatcher("/supplier/onlyView.jsp").forward(request, response);
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
