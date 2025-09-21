/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;
import Bean.StudentBean;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aarya_suthar
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
    
    String username = request.getParameter("username");
    String pwd = request.getParameter("pwd");

    // Hardcoded credentials
    String validUser = "aarya";
    String validPwd = "aarya";

    if (validUser.equals(username) && validPwd.equals(pwd)) {
        try {
            Class.forName("org.apache.derby.client.ClientAutoloadedDriver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/users", "arya", "arya")) {

                String query = "SELECT * FROM users_detail WHERE id = ?";
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setInt(1, 1); // fixed id for demo

                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            StudentBean std = new StudentBean();
                            std.setId(rs.getInt("id"));
                            std.setName(rs.getString("name"));
                            std.setEmail(rs.getString("email"));
                            std.setCity(rs.getString("city"));

                            request.setAttribute("std", std);

                            RequestDispatcher rd = request.getRequestDispatcher("student_info.jsp");
                            rd.forward(request, response);
                        } else {
                            response.getWriter().println("Student not found in DB!");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("DB error", e);
        }
    } else {
        // Invalid login
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>Invalid username and password</h1>");
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
