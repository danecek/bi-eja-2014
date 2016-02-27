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
import model.CustomerValidator;

@WebServlet(name = "Add", urlPatterns = {"/Add"})
public class Add extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Add Customer</h1>");
            CustomerValidator customerValidator = (CustomerValidator) request.getAttribute("customerValidator");
            if (customerValidator == null) {
                customerValidator = new CustomerValidator();
                getServletContext().setAttribute("customerValidator", customerValidator);
            }
            out.println("<h3>" + customerValidator.getValidationError() + "</h3>");

            out.println("<form action=\"add.do\" method=\"post\">");
            out.println("<label for=\"name\">Name:</label>");
            out.println("<input id = \"name\" type=\"text\" name=\"name\" value=\"" + customerValidator.getName() + "\" />");
            out.println("<br>");
            out.println("<label for=\"age\">Age:</label>");
            out.println("<input id = \"age\" type=\"text\" name=\"age\" value=\"" + customerValidator.getAge() + "\"/>");
            out.println("<input type=\"submit\" value=\"Add Customer\" />");

            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
