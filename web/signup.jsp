<%-- 
    Document   : signup
    Created on : Feb 16, 2017, 9:55:14 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css" type="text/css" />       
        <title> Product Management </title>
    </head>
    <body>
       <h2>Sign-up Form</h2>
        <form action="membership?action=signup-attempt" name="registration" method="post">  
            <label for="firstName">First Name:</label>  
            <input type="text" name="firstName"/>  <br>
            <label for="lastName">Last Name:</label>  
            <input type="text" name="lastName"  /> <br>
            <label for="email">Email:</label>  
            <input type="text" name="email"  />  <br>
            <!--<label for="userName">User Name:</label>  
            <input type="text" name="userName"/>  <br> -->
            <label for="password">Password:</label>  
            <input type="password" name="password"/>  <br>
            <input type="submit" name="submit" value="Sign Up" />
        </form>
    </body>
</html>
