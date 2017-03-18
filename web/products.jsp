<%-- 
    Document   : products
    Created on : Feb 16, 2017, 9:53:43 AM
    Author     : Kassandra Walker & David McAlister
--%>

<%@ include file="header.jsp" %>
    </head>
    <body>
        <p> User <a href="#logoutLink">Logout</a> </p>
        
        <h2>Products</h2>
        <table>
            <tr><th> Code </th> <th> Description </th> <th> Price </th> 
                <th></th> <th></th> </tr>
            <!-- The For Each that Loops Through the Products -->
             <c:forEach>
             <tr>
                <td>8601</td>
                <td>86 (the band) - True Life Songs and Pictures</td> 
                <td class="align_right">$15.95</td>
                <td> 
                    <form action="productManagement?action=" method="post">
                        <input type="hidden" name="ProductID" value=""/>
                        <input type="submit" value="Edit" />
                    </form>
                </td> 
                <td> 
                    <form action="productManagement?action=confirmDelete" method="post">
                        <input type="hidden" name="ProductID" value=""/>
                        <input type="submit" value="Delete" />
                    </form>
                </td> 
            </tr>
             </c:forEach>
        </table>
        
        <a href="/FinalProject/product.jsp"> <button> Add Product </button> </a>
    </body>
</html>
