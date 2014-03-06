/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CustomerDB;
import model.CustomerException;
import model.CustomerValidator;

/**
 *
 * @author danecek
 */
@WebServlet(name = "FrontController", urlPatterns = {"*.do"})
public class FrontController extends HttpServlet {

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
        String path = request.getServletPath();
        CustomerDB customerDB = (CustomerDB) getServletContext().getAttribute("CustomerDB");
        if (customerDB == null) {
            customerDB = new CustomerDB();
            getServletContext().setAttribute("CustomerDB", customerDB);
        }
        if ("/add.do".equals(path)) {
            CustomerValidator customerValidator =
                    new CustomerValidator(request.getParameter("name"), request.getParameter("age"));
            
            
            try {
                customerDB.add(customerValidator.validate());
//            getServletContext().getRequestDispatcher("/Home").forward(request, response);
                response.sendRedirect(getServletContext().getContextPath() + "/Home");
            } catch (CustomerException ex) {
                request.setAttribute("error", ex);
                request.setAttribute("customerValidator", customerValidator);
                getServletContext().getRequestDispatcher("/Add").forward(request, response);
            }
        } else if ("/delete.do".equals(path)) {
            customerDB.delete(request.getParameter("id"));
            response.sendRedirect(getServletContext().getContextPath() + "/Home");
//            getServletContext().getRequestDispatcher("/Home").forward(request, response);

        }
        //   throw new ServerException(path);

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
