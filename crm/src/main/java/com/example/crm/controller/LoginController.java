package com.example.crm.controller;

import com.example.crm.config.MySQLConfig;
import com.example.crm.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();

                if (name.equals("email")){
                    request.setAttribute("email", value);
                }

                if (name.equals("password")){
                    request.setAttribute("password", value);
                }
            }
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email =  request.getParameter("email");
        String password = request.getParameter("password");

        String query = "SELECT * FROM users u WHERE u.email = ? AND u.password = ?";

        String remember = request.getParameter("remember");



        Connection conn = MySQLConfig.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
//            ExecuteQuery : Select
//            executeUpdate : Khong phai la cau Select
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();
            List<User> listUsers = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullname(resultSet.getString("fullname"));
                user.setAvatar(resultSet.getString("avatar"));

                listUsers.add(user);
            }

            String alert;
            if(listUsers.isEmpty()){
                alert = "Đăng Nhập Thất bại";
            }else{
                if(remember != null){
                    Cookie cEmail =  new Cookie("email", email);
                    Cookie cPassword =  new Cookie("password", password);
                    cEmail.setMaxAge(60*60*24*30);
                    cPassword.setMaxAge(60*60*24*30);
                    response.addCookie(cEmail);
                    response.addCookie(cPassword);
                }

                alert = "Đăng Nhập Thành Công";
                System.out.println(listUsers);
            }
            request.setAttribute("alertMessage", alert);
        } catch (SQLException e) {
            System.out.println("Lỗi thực thi câu truy vấn: " + e.getMessage());
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}