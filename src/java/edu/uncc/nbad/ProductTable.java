package edu.uncc.nbad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.StringTokenizer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class ProductTable {
    static String url = "jdbc:mysql://localhost:3306/shop";  //I called my db "shop"
    static String username = "project";
    static String password = "1234";

    static Connection connection = null;
    static PreparedStatement ps = null;
    static ResultSet resultset = null;
    
    static {
        System.out.println("this was called");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        try {
        connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            for (Throwable t: e)
                t.printStackTrace();
        }
    }
    
    public static List<Product> selectProducts() {
        System.out.println("get list");
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

    public static Product selectProduct(String productCode) {
        Product product = null;             
        String qString = "select * from products where code = ?";
        try {
            System.out.println("get single product");
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
            System.out.println("select failed");
            return null;
        }
    }
    
    public static boolean exists(String productCode) {
        String qString = "select code from products where code = ?";
        try {
            System.out.println("check existence " + productCode);
            ps = connection.prepareStatement(qString);
            ps.setString(1, productCode);
            resultset = ps.executeQuery();
            
            if(resultset.next()){
                System.out.println("it exists");
                return true;
            } else {
                System.out.println("does not exist");
            }
            
        }
        catch(SQLException e){
            System.out.println(e);
            System.out.println("exists failed");
        }
        return false;
    }    
    
    private static void saveProducts(List<Product> products) {
		//throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static void insertProduct(Product product) {
	System.out.println("product inserted");
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
            System.out.println("insert failed");
        } 
                
    }

    public static void updateProduct(Product product) {
     String qString = "update products set code=?, description=?, price=? where code=?";
        try {
            System.out.println("updating");
            ps = connection.prepareStatement(qString);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCode());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
            System.out.println("update failed");
        }
    }

    public static void deleteProduct(Product product) {
        String qString = "delete from products where code = ?";
        try {
            System.out.println("delete product");
            ps = connection.prepareStatement(qString);
            ps.setString(1, product.getCode());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
            System.out.println("delete failed");
        } 
    }    
}
