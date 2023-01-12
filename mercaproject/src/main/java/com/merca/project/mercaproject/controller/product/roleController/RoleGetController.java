package com.merca.project.mercaproject.controller.product.roleController;

import com.merca.project.mercaproject.model.Role;
import com.merca.project.mercaproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleGetController {

    @Autowired
    private RoleService roleService;

    @GetMapping(name = "/listRoles")
    public List<Role> list(){
        return roleService.getRoles();
    }
}
