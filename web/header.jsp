<%-- 
    Document   : header
    Created on : Feb 16, 2017, 9:57:43 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${user == null}">
    <c:redirect url="/membership?action=login"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css" type="text/css" />       
        <title> Product Management </title>

       