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
        <form action="productManagement?action=displayProducts" method="POST">
            <label> Code: </label>
            <p> <c:out value='${product.code}' /> <br />
            <label> Description: </label>
            <p> <c:out value='${product.description}' /> </p> <br />
            <label> Price: </label>
            <p> <c:out value='${product.price}' /> </p> <br />
            
            <input type="hidden" name="delete" value="Yes" />
            <input type="hidden" name="code" value="<c:out value='${product.code}'/>"/>
            <input type="submit" value="Yes" /> 
        </form>
            <a href="productManagement?action=displayProducts"> <button class="left"> No </button></a>
    </body>
</html>
