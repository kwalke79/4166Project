<%-- 
    Document   : signup
    Created on : Feb 16, 2017, 9:55:14 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ include file="header.jsp" %>

    </head>
    <body>
       <h2>Sign-up Form</h2>
        <form action="" name="registration" method="post">  
            <label for="firstName">First Name:</label>  
            <input type="text" name="firstName"/>  <br>
            <label for="lastName">Last Name:</label>  
            <input type="text" name="lastName"  /> <br>
            <label for="email">Email:</label>  
            <input type="text" name="email"  />  <br>
            <label for="userName">User Name:</label>  
            <input type="text" name="userName"/>  <br>
            <label for="password">Password:</label>  
            <input type="password" name="password"/>  <br>
            <input type="submit" name="submit" value="Sign Up" />
        </form>
    </body>
</html>
