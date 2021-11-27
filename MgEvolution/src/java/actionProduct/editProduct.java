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
import models.Hairdresser;

/**
 *
 * @author judith
 */
@WebServlet(name = "editProduct", urlPatterns = {"/editProduct"})
public class editProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Hairdresser hairdresser = (Hairdresser) request.getSession().getAttribute("hairdresser");
        Long codBarras = Long.parseLong(request.getParameter("codBarras"));
        String brand = request.getParameter("brand");

        System.out.println(brand);
        Product product = hairdresser.searchProduct(codBarras);
        if (product == null) {
            String error = "Se ha producido un error al actualizar el producto.";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/product/onlyView.jsp").forward(request, response);
        }

        if (request.getParameter(
                "actualizar") != null) {
            product.setName(request.getParameter("name"));
            product.setCategory(request.getParameter("category"));
            product.setCostClient(Float.parseFloat(request.getParameter("costClient")));
            product.setCostSupplier(Float.parseFloat(request.getParameter("costSupplier")));
            product.setStock(Integer.parseInt(request.getParameter("stock")));
            try {
                hairdresser.updateProduct(product);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + " : " + e.getMessage());
            }
            response.sendRedirect("onlyViewProduct.jsp?option=2");
        } else {
            if (request.getParameter("eliminar") != null) {
                try {
                    hairdresser.deleteProduct(codBarras);
                } catch (Exception e) {
                    String error = e.getMessage();
                    request.setAttribute("error", error);
                    getServletContext().getRequestDispatcher("/product/onlyView.jsp").forward(request, response);
                }
                response.sendRedirect("onlyViewProduct.jsp?option=3");
                return;
            } else {
                request.setAttribute("name", product.getName());
                request.setAttribute("category", product.getCategory());
                request.setAttribute("costClient", product.getCostClient());
                request.setAttribute("costSupplier", product.getCostSupplier());
                request.setAttribute("stock", product.getStock());
                System.out.println(product);
                getServletContext().getRequestDispatcher("/product/onlyView.jsp").forward(request, response);
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
