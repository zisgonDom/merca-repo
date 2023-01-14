package com.merca.project.mercaproject.service.user;

import com.merca.project.mercaproject.entity.UserEntity;
import com.merca.project.mercaproject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
