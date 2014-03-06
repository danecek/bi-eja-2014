<%-- 
    Document   : Home
    Created on : Mar 4, 2014, 11:44:41 AM
    Author     : danecek
--%>

<%@page import="model.Customer"%>
<%@page import="model.CustomerDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customers</h1>
        <%
            CustomerDB customerDB = (CustomerDB) getServletContext().getAttribute("customerDB");
            if (customerDB == null) {
                customerDB = new CustomerDB();
                getServletContext().setAttribute("customerDB", customerDB);
            }
        %>
        <table border="1">
            <%
                for (Customer c : customerDB.getCustomers()) {
            %>
            <tr>
                <td>
                    <%= c.getId()%>

                </td>
                <td>
                    <%= c.getName()%>
                </td>
                <td>
                    <%= c.getAge()%>
                </td>
                <td>
                    <a href="Delete?id=<%= c.getId()%>" >Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="Add" >Add Customer</a>

    </body>
</html>
