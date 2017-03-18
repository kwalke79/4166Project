<%-- 
    Document   : login
    Created on : Feb 16, 2017, 9:54:22 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ include file="header.jsp" %>

    </head>
    <body>
        <h2>Login</h2>
        <form action="membership?action=login" name="registration" method="post">  
            <label for="userName">User Name:</label>  
            <input type="text" name="userName"/>  <br />
            <label for="password">Password:</label>  
            <input type="password" name="password"/>  <br />
            <input type="submit" name="submit" value="Login"/>  <br />
        </form>
            <a href="membership?action=signup">New user? Click here to register"</a>
    </body>
</html>
