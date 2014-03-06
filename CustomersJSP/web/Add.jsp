<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Add
    Created on : Mar 6, 2014, 9:26:17 AM
    Author     : danecek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Customer</h1>
        <jsp:useBean id="customerValidator" scope="request" class="model.CustomerValidator"/>
        <c:if test="${not empty customerValidator.validationError}">
            <div style="color: red">Error: ${customerValidator.validationError}</div>
        </c:if>
        <form action="add.do" method="post">
            Name:
            <input type="text" name="name" value="${customerValidator.name}" /><br>
            Age:
            <input type="text" name="age" value="${customerValidator.age}"/><br>
            <input type="submit" value="Add Customer" />
        </form>
    </body>
</html>
