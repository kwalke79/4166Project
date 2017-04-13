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
    static PreparedStatement selectProducts = null;
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
        
        String qString = "SELECT * FROM products";
        try {
            selectProducts = connection.prepareStatement(qString);
            //selectProduct.setInt(1, id);
            resultset = selectProducts.executeQuery();
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
        System.out.println("get single product");
        Product product = null;
                
        String qString = "SELECT * FROM products where code = ?";
        try {
            selectProducts = connection.prepareStatement(qString);
            selectProducts.setString(1, productCode);
            resultset = selectProducts.executeQuery();
             
            product = new Product();
            return product;
        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
        
        
    }
    public static boolean exists(String productCode) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }    
    
    private static void saveProducts(List<Product> products) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static void insertProduct(Product product) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static void updateProduct(Product product) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static void deleteProduct(Product product) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }    
}
