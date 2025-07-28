package com.example.buoi1;

import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> products =  (List<Product>) session.getAttribute("products");

        if(products == null) {
            products = new ArrayList<>();
            session.setAttribute("products", products);
        }

        request.setAttribute("productList", products);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> products =  (List<Product>) session.getAttribute("products");

        if(products == null) {
            products = new ArrayList<>();
            session.setAttribute("products", products);
        }

        String name = request.getParameter("name");
        String quantityStr = request.getParameter("quantity");
        String priceStr = request.getParameter("price");


        if (name != null && quantityStr != null && priceStr != null) {
            try {
                int quantity = Integer.parseInt(quantityStr);
                double price = Double.parseDouble(priceStr);
                products.add(new Product(name, quantity, price));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        response.sendRedirect("product");
    }
}