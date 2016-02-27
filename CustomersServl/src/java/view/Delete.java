/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDB;

@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Delete</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Delete Customer</h1>");
            CustomerDB customerDB = (CustomerDB) getServletContext().getAttribute("CustomerDB");
            if (customerDB == null) {
                customerDB = new CustomerDB();
                getServletContext().setAttribute("CustomerDB", customerDB);
            }
            String id = request.getParameter("id");
            Customer cust = customerDB.get(id);
            out.println(cust.toString());
            out.println("<form action=\"delete.do\" method=\"post\">");
            out.println("<input type=\"hidden\" name= \"id\" value=\"" + cust.getId() + "\" />");

            out.println("<input type=\"submit\" value=\"Delete Customer\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
