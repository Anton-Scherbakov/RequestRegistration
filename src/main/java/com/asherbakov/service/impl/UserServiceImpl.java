package com.asherbakov.service.impl;

import com.asherbakov.entity.User;
import com.asherbakov.repository.UserRepository;
import com.asherbakov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName());
    }
}
