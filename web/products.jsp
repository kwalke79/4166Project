<%-- 
    Document   : products
    Created on : Feb 16, 2017, 9:53:43 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ include file="header.jsp" %>
    </head>
    <body>
        <p> Welcome back, <c:out value='${user.firstName}'/>. <br/>
            <a href="membership?action=logout">Logout</a> </p>
        
        <h2>Products</h2>
        <table>
            <tr><th> Code </th> <th> Description </th> <th> Price </th> 
                <th></th> <th></th> </tr>
            <!-- The For Each that Loops Through the Products -->
            <c:forEach var="Product" items="${products}">
             <tr>
                <td>${Product.code}</td>
                <td>${Product.description}</td> 
                <td>$ ${Product.price}</td>
                <td> 
                    <form action="productManagement?action=displayProduct" method="post">
                        <input type="hidden" name="productCode" value="<c:out value='${Product.code}'/>"/>
                        <input type="submit" value="Edit" />
                    </form>
                </td> 
                <td> 
                    <form action="productManagement?action=deleteProduct" method="post">
                        <input type="hidden" name="productCode" value="<c:out value='${Product.code}'/>"/>
                        <input type="submit" value="Delete" />
                    </form>
                </td> 
            </tr>
             </c:forEach>
        </table>
        
        <a href="/FinalProject/product.jsp"> <button> Add Product </button> </a>
    </body>
</html>
