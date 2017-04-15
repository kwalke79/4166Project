package edu.uncc.nbad;
// implemented by David McAlister
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ProductTable {
    //url to database called 'shop'
    static String url = "jdbc:mysql://localhost:3306/shop";
    static String username = "project";
    static String password = "1234";

    static Connection connection = null;
    static PreparedStatement ps = null;
    static ResultSet resultset = null;
   
    //Static initializer, it runs when the class is intialized (it is executed once)
    static {
        // connects to the driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        // connects to the database
        try {
        connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            for (Throwable t: e)
                t.printStackTrace();
        }
    }
    //Returns a list of all products
    public static List<Product> selectProducts() {
        Product product = null;
        String qString = "select * FROM products";
        try {
            ps = connection.prepareStatement(qString);
            //selectProduct.setInt(1, id);
            resultset = ps.executeQuery();
            ArrayList<Product> productList = new ArrayList<>();
            while (resultset.next())
            {
                product = new Product();
                product.setCode(resultset.getString("code"));
                product.setDescription(resultset.getString("description"));
                product.setPrice(resultset.getDouble("price"));
                productList.add(product);
            }  
            return productList;
        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    //returns item with matching product code
    public static Product selectProduct(String productCode) {
        Product product = null;             
        String qString = "select * from products where code = ?";
        try {
            ps = connection.prepareStatement(qString);
            ps.setString(1, productCode);
            resultset = ps.executeQuery();
            while (resultset.next())
            {
                product = new Product();
                product.setCode(resultset.getString("code"));
                product.setDescription(resultset.getString("description"));
                product.setPrice(resultset.getDouble("price"));
            }
            return product;
        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    //checks if an item exists
    public static boolean exists(String productCode) {
        String qString = "select code from products where code = ?";
        try {
            ps = connection.prepareStatement(qString);
            ps.setString(1, productCode);
            resultset = ps.executeQuery();
            
            if(resultset.next())
                return true;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }    
    //adds a new product to the products table
    public static void insertProduct(Product product) {
        String qString = "insert into products (code, description, price) values (?,?,?)";
        try {
            ps = connection.prepareStatement(qString);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }        
    }
    //updates the product with matching product code
    public static void updateProduct(Product product) {
     String qString = "update products set code=?, description=?, price=? where code=?";
        try {
            ps = connection.prepareStatement(qString);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCode());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    //deletes product form products table
    public static void deleteProduct(Product product) {
        String qString = "delete from products where code = ?";
        try {
            ps = connection.prepareStatement(qString);
            ps.setString(1, product.getCode());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        } 
    }  
    /*
    private static void saveProducts(List<Product> products) {
            //throw new NotImplementedException(); // remove this line and implement the logic
    }
    */
}
