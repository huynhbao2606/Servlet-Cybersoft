package com.example.buoi1;

import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    int count = 5;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "iPhone 15", 999.99));
        products.add(new Product(2, "Samsung Galaxy S24", 899.99));
        products.add(new Product(3, "MacBook Pro", 1999.99));
        products.add(new Product(4, "Dell XPS 13", 1299.49));
        products.add(new Product(5, "iPad Air", 649.99));
        products.add(new Product(6, "Sony WH-1000XM5", 349.99));
        products.add(new Product(7, "Apple Watch Series 9", 399.00));
        products.add(new Product(8, "Google Pixel 8", 799.00));
        products.add(new Product(9, "Logitech MX Master 3S", 99.99));
        products.add(new Product(10, "Kindle Paperwhite", 149.99));


        request.setAttribute("products", products);

        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}