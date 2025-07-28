package com.example.buoi1;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//Annotaion : @
@WebServlet(name = "helloServlet", urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
        String message = "Hello Thế Giới!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("hello.jsp");
        dispatcher.forward(request,response);
    }

    public void destroy() {
    }
}