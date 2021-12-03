/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionDetail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.DetailService;
import models.Hairdresser;

/**
 *
 * @author judith
 */
@WebServlet(name = "editDetail", urlPatterns = {"/editDetail"})
public class editDetail extends HttpServlet {

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
        Long idDetail = Long.parseLong(request.getParameter("idDetail"));
        Long idService = Long.parseLong(request.getParameter("idService"));
        String nameClient = request.getParameter("nameClient");
        DetailService detail = hairdresser.searchDetailService(idDetail);
        
        if (idDetail == null) {
            String error = "Se ha producido un error al actualizar el producto del servicio.";
            request.setAttribute("error", error);
          //getServletContext().getRequestDispatcher("/product/onlyView.jsp").forward(request, response);
        }

        if (request.getParameter("actualizarMas") != null) {
            
            Integer amount = Integer.parseInt(request.getParameter("amount"));
            amount++;
            detail.setAmount(amount);
            try {
                hairdresser.updateDetailService(detail);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + " : " + e.getMessage());
            }
            response.sendRedirect("detailService/allDetail.jsp?idService=" + idService);
        } else if(request.getParameter("actualizarMenos") != null) {
           
            Integer amount = Integer.parseInt(request.getParameter("amount"));
            if(amount > 1){
            amount--;
            detail.setAmount(amount);
            }
           
            
            try {
                hairdresser.updateDetailService(detail);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + " : " + e.getMessage());
            }
            response.sendRedirect("detailService/allDetail.jsp?idService=" + idService);
             } else{
            if (request.getParameter("eliminar") != null) {
                try {
                    hairdresser.deleteDetailService(idDetail);
                } catch (Exception e) {
                    String error = e.getMessage();
                    request.setAttribute("error", error);
                    //getServletContext().getRequestDispatcher("/product/onlyView.jsp").forward(request, response);
                }
               response.sendRedirect("detailService/allDetail.jsp?idService=" + idService);
                return;
            } else {
                request.setAttribute("cantidad", detail.getAmount());
                  response.sendRedirect("detailService/allDetail.jsp?idService=" + idService);
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
