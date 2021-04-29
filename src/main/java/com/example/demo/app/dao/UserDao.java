package com.example.demo.app.dao;

import com.example.demo.app.entity.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> selectUserByUsername(String username);
}
