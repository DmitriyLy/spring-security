package com.example.demo.app.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.app.security.UserPermission.*;

public enum UserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
