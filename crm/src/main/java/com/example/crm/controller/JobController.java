package com.example.crm.controller;

import com.example.crm.entity.Job;
import com.example.crm.entity.Role;
import com.example.crm.service.JobService;
import com.example.crm.service.impl.JobServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "jobController", value = "/job")
public class JobController extends HttpServlet {
    private final JobService jobService = new JobServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> jobs = jobService.findAll();
        request.setAttribute("listJobs", jobs);
        request.getRequestDispatcher("groupwork.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}