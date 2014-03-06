<%-- 
    Document   : Home
    Created on : Mar 4, 2014, 11:44:41 AM
    Author     : danecek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <jsp:useBean id="customerDB" scope="application" class="model.CustomerDB" />
        <table border="1">
            <c:forEach var="c" items="${customerDB.customers}">
                <tr>
                    <td>
                        ${c.id}
                    </td>
                    <td>
                        ${c.name}
                    </td>
                    <td>
                        ${c.age}
                    </td>
                    <td>
                        <a href="Delete?id=${c.id}" >Delete</a>
                    </td>
                </tr>
            </c:forEach>   
        </table>
        <a href="Add" >Add Customer</a>
    </body>
</html>
