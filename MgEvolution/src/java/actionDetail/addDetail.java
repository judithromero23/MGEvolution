/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionDetail;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.DetailService;
import model.entities.Product;
import model.entities.Service;
import models.Hairdresser;

/**
 *
 * @author judit
 */
@WebServlet(name = "addDetail", urlPatterns = {"/addDetail"})
public class addDetail extends HttpServlet {

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
        System.out.println("Id Service: " + request.getParameter("idService"));
        Long idService = Long.parseLong(request.getParameter("idService"));
        
        Integer amount = Integer.parseInt(request.getParameter("amount"));
        
        //Product CODBARRAS
        String productInput = request.getParameter("product");
        String[] infoproduct = productInput.split(" ");
        Long codBarras = Long.parseLong(infoproduct[0]);
        
        //Find codBarras in product and idService in Service
        Product product = Hairdresser.searchProduct(codBarras);
        Service service = Hairdresser.searchService(idService);
        
        DetailService detail = new DetailService();
        detail.setProduct(product);
        detail.setAmount(amount);
        detail.setService(service);
                
                
        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");

        try {
            hairdresser.addDetailService(detail);
        } catch (Exception ex) {
            error = "Error al añadir el producto '" + codBarras + "', pruebe con otro código de barras.";
        }
        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("product", product);
            request.setAttribute("service", service);
            request.setAttribute("amount", amount);
             response.sendRedirect("detailService/allDetail.jsp?idService=" + idService);
        } else {
             response.sendRedirect("detailService/allDetail.jsp?idService=" + idService);
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
