<%-- 
    Document   : login
    Created on : Feb 16, 2017, 9:54:22 AM
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
        <h2>Login</h2>
        <c:out value='${error}' />
        <form action="membership?action=login-attempt" method="post">  
            <label for="email">Email:</label>  
            <input type="text" name="email"/>  <br />
            <label for="password">Password:</label>  
            <input type="password" name="password"/>  <br />
            
            <input type="submit" value="Login"/>  <br />
        </form>
            <a href="membership?action=signup">New user? Click here to register"</a>
    </body>
</html>
