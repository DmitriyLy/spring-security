package com.example.demo.app.dao.impl;

import com.example.demo.app.dao.UserDao;
import com.example.demo.app.entity.User;
import com.example.demo.app.security.UserRole;
import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("stub")
public class StubUserDao implements UserDao {

    private final List<User> users;
    private final PasswordEncoder passwordEncoder;

    public StubUserDao(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.users = Lists.newArrayList(
                new User(
                        "admin",
                        this.passwordEncoder.encode("password"),
                        UserRole.ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        "admintrainee",
                        this.passwordEncoder.encode("password"),
                        UserRole.ADMINTRAINEE.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        "user",
                        this.passwordEncoder.encode("password"),
                        UserRole.USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );;
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return users
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }

}
