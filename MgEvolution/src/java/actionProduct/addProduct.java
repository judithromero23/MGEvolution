/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionProduct;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.Product;
import model.entities.Supplier;
import models.Hairdresser;

/**
 *
 * @author judith
 */
@WebServlet(name = "addProduct", urlPatterns = {"/addProduct"})
public class addProduct extends HttpServlet {

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
        Long codBarras = Long.parseLong(request.getParameter("codBarras"));
        String name = request.getParameter("name");
        Float costClient = Float.parseFloat(request.getParameter("costClient"));
        Float costSupplier = Float.parseFloat(request.getParameter("costSupplier"));
        String category = request.getParameter("category");
        Integer stock = Integer.parseInt(request.getParameter("stock"));
        //Supplier brand
        String supplierInput = request.getParameter("supplier");
        String[] infoSupplier = supplierInput.split(" ");
        Long id_Brand = Long.parseLong(infoSupplier[0]);
        //Find Brand in supplier
        Supplier supplier = Hairdresser.searchSupplier(id_Brand);
        
        Product newProduct = new Product();
        newProduct.setCodBarras(codBarras);
        newProduct.setName(name);
        newProduct.setCostClient(costClient);
        newProduct.setCostSupplier(costSupplier);
        newProduct.setCategory(category);
        newProduct.setStock(stock);
        newProduct.setId_brand(supplier);        
                
        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");

        try {
            hairdresser.addProduct(newProduct);
        } catch (Exception ex) {
            error = "Error al añadir el producto '" + codBarras + "', pruebe con otro código de barras.";
        }
        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("codBarras", codBarras);
            request.setAttribute("name", name);
            request.setAttribute("costClient", costClient);
            request.setAttribute("costSupplier", costSupplier);
            request.setAttribute("category", category);
            request.setAttribute("stock", stock);
            getServletContext().getRequestDispatcher("/product/onlyView.jsp").forward(request, response);
        } else {
            response.sendRedirect(response.encodeRedirectURL("/MgEvolution/onlyViewProduct.jsp?option=1"));
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
