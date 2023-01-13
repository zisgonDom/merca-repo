package com.merca.project.mercaproject.controller.role;

import com.merca.project.mercaproject.model.Role;
import com.merca.project.mercaproject.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleGetController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/listRoles")
    public ResponseEntity<List<Role>> list(){
        List<Role> roleList = roleService.getRoles();
        if(!roleList.isEmpty()){
            return new ResponseEntity<>(roleList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
