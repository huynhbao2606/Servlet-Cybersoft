package com.example.crm.service.impl;

import com.example.crm.entity.Job;
import com.example.crm.repository.JobRepository;
import com.example.crm.service.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository = new JobRepository();

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
}
