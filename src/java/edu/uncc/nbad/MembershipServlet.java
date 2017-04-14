/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kassandra Walker
 */
public class MembershipServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MembershipServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MembershipServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "/index.jsp";
        
        if (!action.isEmpty() || action != null) {
            if (action.equals("login")) {
                // If action is equal to login go to login.jsp
                url = "/login.jsp";
            } else if (action.equals("signup")) {
            // If action is equal to signup go to signup.jsp
                url = "/signup.jsp";
            } 
            else if (action.equals("logout")) {
                // invalidates the session
                session.removeAttribute("user");
                session.invalidate();
                url = "/index.jsp";
            }
             getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        HttpSession session = request.getSession();
        
        //read action parameter
        String action = request.getParameter("action");
        String url = "/index.jsp";
        String path = getServletContext().getRealPath("/WEB-INF/users.txt");
        
        if (!action.isEmpty() || action != null) {
            if (action.equals("login-attempt")) {
                // Validate user
                String email = request.getParameter("email").trim();
                String password = request.getParameter("password").trim();
                
                if (email.isEmpty() || email == null || password.isEmpty() || password == null) {
                    url="/login.jsp";
                    request.setAttribute("error", "You cannot leave fields blank!");
                } else {
                    // check this logic out.. now sure
                    if (UserTable.getUser(email).getEmail() != null){  
                        //User user = UserIO.getUser(email, path);
                        User user = UserTable.getUser(email);

                        if (password.equals(user.getPassword())) {
                            session.setAttribute("user", user);
                            url="/productManagement?action=displayProducts";
                        } else {
                            url="/login.jsp";
                            request.setAttribute("error", "Wrong password!");
                        }
                    } else {  
                        url = "/login.jsp";
                        request.setAttribute("error", "Email not found!");
                   }
                }
            } else if (action.equals("signup-attempt")) {
            // If action is equal to signup go to signup.jsp
                url = "/signup.jsp";
                
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                
               // if any input is empty or null, return an error to the registration page
                if (firstName.trim().isEmpty() || firstName == null || lastName.trim().isEmpty() || lastName == null ||
                            email.trim().isEmpty() || email == null || password.trim().isEmpty() || password == null) {
                    request.setAttribute("error", "You cannot leave fields blank!");
                } else {
                    if (email.contains("@") && password.length() > 8) {    
                        // IF VALIDATED
                        url = "/login.jsp";
                        User u = new User(firstName, lastName, email, password);
                        // UserIO.addRecord(u, path);
                        UserTable.addRecord(u);

                        request.setAttribute("error", "Registration Successful");
                        // END IF VALIDATED
                    } else if (!email.contains("@")) {
                        request.setAttribute("error", "Invalid email address.");
                    } else if (password.length() <= 8) {
                        request.setAttribute("error", "Password must be more than 8 characters.");
                    }
                }  
            } 
             getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
