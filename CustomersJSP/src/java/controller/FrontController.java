/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDB;
import model.CustomerValidator;

/**
 *
 * @author danecek
 */
@WebServlet(name = "FrontController", urlPatterns = {"*.do"})
public class FrontController extends HttpServlet {

    public static final String HOME = "/Home.jsp";

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
        CustomerDB customerDB = (CustomerDB) getServletContext().getAttribute("customerDB");
        if (customerDB == null) {
            customerDB = new CustomerDB();
            getServletContext().setAttribute("customerDB", customerDB);
        }
        switch (path) {
            case "/add.do":
                CustomerValidator cv
                        = new CustomerValidator(
                                request.getParameter("name"),
                                request.getParameter("age"));
                Customer c = cv.validate();
                if (c != null) {
                    customerDB.add(c);
                    response.sendRedirect(getServletContext().getContextPath() + HOME);
                } else {
                    request.setAttribute("customerValidator", cv);
                    getServletContext().getRequestDispatcher("/Add.jsp").forward(request, response);
                }
                break;
            case "/delete.do":
                customerDB.delete(request.getParameter("id"));
                response.sendRedirect(getServletContext().getContextPath() + HOME);
                break;
            default:
                throw new ServerException(path);

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
