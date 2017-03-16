<%-- 
    Document   : product
    Created on : Feb 16, 2017, 9:53:43 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ include file="header.jsp" %>
    </head>
    <body>
        <p> User <a href="#logoutLink">Logout</a> </p>
        
        <h2>Product</h2>
        <form action="url" method="POST">
            <label> Code: </label>
            <input type="text" name="code" /> <br />
            <label> Description: </label>
            <textarea name="description" height="50px;"></textarea> <br />
            <label> Price: </label>
            <input type="text" name="price" /> <br />
            
            <label> </label>
            input type="submit" value="Update Products" />
            <input type="button" value="View Products" onclick="location.href='/FinalProject/products.jsp';" />
        </form>
    </body>
</html>
