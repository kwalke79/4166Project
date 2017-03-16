<%-- 
    Document   : confirmDelete
    Created on : Feb 16, 2017, 9:54:07 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ include file="header.jsp" %>
    </head>
    <body>
        <p> User <a href="#logoutLink">Logout</a> </p>
        
        <h2>Are you sure you want to delete this product?</h2>
        <form action="url" method="POST">
            <label> Code: </label>
            <p> ${product.code} <br />
            <label> Description: </label>
            <p> ${product.description} </p> <br />
            <label> Price: </label>
            <p> ${product.price} </p> <br />
            
            <input type="submit" value="Update Products" />
            <input type="button" value="View Products" onclick="location.href='/FinalProject/products.jsp';" />
        </form>
    </body>
</html>
