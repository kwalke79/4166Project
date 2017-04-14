package edu.uncc.nbad;
// implemented by Kassandra Walker

import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserTable {

    private static String url = "jdbc:mysql://localhost:3306/shop";  //I called my db "shop"
    private static String username = "project";
    private static String password = "1234";

    private static Connection connection = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    //Static initializer, it runs when the class is intialized (it is executed once)
    static {
        // connects to the driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        // connects to the database
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public static void addRecord(User user) throws IOException {
        String SQL = "INSERT INTO `users` (firstName, lastName, email, password) VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(SQL);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception thrown: " + e);
        }
    }

    public static User getUser(String emailAddress) throws IOException {
       String SQL = "SELECT * FROM `users` WHERE email = ?";
       User u = new User();
        try {
            ps = connection.prepareStatement(SQL);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            while(rs.next()) {
                u.setEmail(emailAddress);
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Exception thrown: " + e);
        }
        
        return u;
    }

    public static ArrayList<User> getUsers() throws IOException {
       String SQL = "SELECT * FROM `users`";
       ArrayList<User> users = new ArrayList<User>();
        try {
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            // get the results and add them to the array list
            while(rs.next()) {
                User u = new User();
                u.setEmail(rs.getString("email"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setPassword(rs.getString("password"));
                users.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception thrown: " + e);
        }
        
        return users;
    }
/*
    public static HashMap<String, User> getUsersMap() throws IOException {
        throw new NotImplementedException(); // remove this line and implement the logic
    }
*/
}
