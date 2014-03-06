<%--

    Document   : Delete
    Created on : Mar 6, 2014, 9:38:30 AM
    Author     : danecek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Customer</h1>
        <jsp:useBean id="customerDB" scope="application" class="model.CustomerDB" />

        <form action="delete.do" method="post">
            <input type="hidden" name= "id" value="${param.id}" />
            <input type="submit" value="Delete Customer" />
        </form>

    </body>
</html>
