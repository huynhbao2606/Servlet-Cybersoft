package com.example.crm.service.impl;

import com.example.crm.entity.Role;
import com.example.crm.repository.RoleRepository;
import com.example.crm.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository = new RoleRepository();

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
