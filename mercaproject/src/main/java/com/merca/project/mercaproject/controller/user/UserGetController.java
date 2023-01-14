package com.merca.project.mercaproject.controller.user;

import com.merca.project.mercaproject.entity.UserEntity;
import com.merca.project.mercaproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserGetController {

    @Autowired
    private UserService userService;

    @GetMapping("/listUsers")
    public ResponseEntity<List<UserEntity>> list(){
        List<UserEntity> userEntityList = userService.getUsers();
        if(!userEntityList.isEmpty()){
            return new ResponseEntity<>(userEntityList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserEntity> findUser(@PathVariable Long id){
        UserEntity userEntity = userService.findById(id);
        if(userEntity != null){
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
