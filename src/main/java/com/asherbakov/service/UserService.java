package com.asherbakov.service;

import com.asherbakov.entity.User;

public interface UserService {
    User getUser(String username);

    User getUser();
}
