package com.example.buoi1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    //2 Cách truyền và nhận tham số từ phía client
    //- Truyền tham số ( dữ liệu ) trực tiếp trên trình duyệt ( URL ) : GET
    // Có giới ha tham số tuỳ browsers hỗ trợ bao nhiêu ký tự
    // Ví dụ: http://localhost?tenthamso=giatri&tenthamso=giatri&...
    //
     //- Truyền ngầm: Các phươnng thức còn lại (POST)
    // Không giới hạn.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String alert = "Giá trị: " + email + "-" + password;


        if(email != null && password != null) {
            request.setAttribute("alertMessage", alert);
        }
        

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}