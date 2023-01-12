package com.merca.project.mercaproject.controller.product.user;

import com.merca.project.mercaproject.model.Product;
import com.merca.project.mercaproject.model.User;
import com.merca.project.mercaproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listUsers")
    public ResponseEntity<List<User>> list(){
        List<User> userList = userService.getUsers();
        if(!userList.isEmpty()){
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        User user = userService.findById(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
