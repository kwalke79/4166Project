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
            <tr> 
                <td>8601</td>
                <td>86 (the band) - True Life Songs and Pictures</td> 
                <td class="align_right">$15.95</td>
                <td> <a href="#link"> Edit </a> </td> 
                <td> <a href="confirmDelete.jsp"> Delete </a> </td> 
            </tr>
            <tr> 
                <td>pf01</td>
                <td>Paddlefoot - The First CD</td> 
                <td class="align_right">$12.95</td>
                <td> <a href="#link"> Edit </a> </td> 
                <td> <a href="confirmDelete.jsp"> Delete </a> </td> 
            </tr>
            <tr> 
                <td>pf02</td>
                <td>Paddlefoot - The Second CD</td> 
                <td class="align_right">$14.95</td>
                <td> <a href="#link"> Edit </a> </td> 
                <td> <a href="confirmDelete.jsp"> Delete </a> </td> 
            </tr>
            <tr>  
                <td>jr01</td>
                <td>Joe Rut-Genuine WOod Grained Finish</td> 
                <td class="align_right">$14.95</td>
                <td> <a href="#link"> Edit </a> </td> 
                <td> <a href="confirmDelete.jsp"> Delete </a> </td> 
            </tr>
        </table>
        
        <a href="/FinalProject/product.jsp"> <button> Add Product </button> </a>
    </body>
</html>
