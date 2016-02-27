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

@WebServlet(name = "FrontController", urlPatterns = {"*.do"})
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        CustomerDB customerDB = (CustomerDB) getServletContext().getAttribute("CustomerDB");
        if (customerDB == null) {
            customerDB = new CustomerDB();
            getServletContext().setAttribute("CustomerDB", customerDB);
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
                    response.sendRedirect(getServletContext().getContextPath() + "/Home");
                } else {
                    request.setAttribute("customerValidator", cv);
                    request.
                    getServletContext().getRequestDispatcher("/Add").forward(request, response);
                }
                break;
            case "/delete.do":
                customerDB.delete(request.getParameter("id"));
                response.sendRedirect(getServletContext().getContextPath() + "/Home");
                break;
            default:
                throw new ServerException(path);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
