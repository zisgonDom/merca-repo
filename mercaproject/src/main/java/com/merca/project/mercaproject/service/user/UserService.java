package com.merca.project.mercaproject.service.user;

import com.merca.project.mercaproject.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();
    User findById(Long id);
}
