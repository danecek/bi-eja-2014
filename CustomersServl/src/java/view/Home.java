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

/**
 *
 * @author danecek
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Customers</h1>");
            CustomerDB customerDB = (CustomerDB) getServletContext().getAttribute("CustomerDB");
            if (customerDB == null) {
                customerDB = new CustomerDB();
                getServletContext().setAttribute("CustomerDB", customerDB);
            }
            out.print("<table border=\"1\">");
            for (Customer c : customerDB.getCustomers()) {
                out.println("<tr>");
                out.println("<td>");
                out.println(c.getId());

                out.println("</td>");
                out.println("<td>");
                out.println(c.getName());
                out.println("</td>");
                out.println("<td>");
                out.println(c.getAge());
                out.println("</td>");
                out.println("<td>");
                out.println("<a href=\"Delete?id=" + c.getId() + "\" >Delete</a>");
                out.println("</td>");
                out.println("</tr>");

            }
            out.print("</table>");
            out.print("<a href=\"Add\" >Add Customer</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
