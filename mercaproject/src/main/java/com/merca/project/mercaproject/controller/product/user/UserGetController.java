package com.merca.project.mercaproject.controller.product.user;

import com.merca.project.mercaproject.model.User;
import com.merca.project.mercaproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.MXBean;
import java.util.List;

@RestController
public class UserGetController {

    @Autowired
    private UserService userService;

    @GetMapping(name = "/listUsers")
    public List<User> metodoa(){
        return userService.getUsers();
    }

}
