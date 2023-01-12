package com.merca.project.mercaproject.service;

import com.merca.project.mercaproject.model.Role;
import com.merca.project.mercaproject.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Role> getRoles() {
        return (List<Role>) roleRepository.findAll();
    }
}
