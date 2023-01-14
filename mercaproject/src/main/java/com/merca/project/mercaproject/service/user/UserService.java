package com.merca.project.mercaproject.service.user;

import com.merca.project.mercaproject.entity.UserEntity;

import java.util.List;

public interface UserService {

    public List<UserEntity> getUsers();
    UserEntity findById(Long id);
}
