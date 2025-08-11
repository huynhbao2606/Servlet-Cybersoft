package com.example.crm.controller;

import com.example.crm.entity.Role;
import com.example.crm.service.RoleService;
import com.example.crm.service.UserService;
import com.example.crm.service.impl.RoleServiceImpl;
import com.example.crm.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "roleController", value = "/role")
public class RoleController extends HttpServlet {
    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role> roles = roleService.findAll();
        request.setAttribute("listRoles", roles);
        request.getRequestDispatcher("role-table.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}