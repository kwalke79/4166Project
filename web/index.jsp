<%-- 
    Document   : index
    Created on : Feb 16, 2017, 9:53:30 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${user == null}">
    <c:redirect url="/membership?action=login" context="2"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css" type="text/css" />       
        <title> Product Management </title>
    </head>
    <body>
        <h2>Product Management</h2>
        <a href="productManagement?action=displayProducts"> View Products </a>
    </body>
</html>
