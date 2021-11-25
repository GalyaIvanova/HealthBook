package com.server.jwt.controller;

import com.server.jwt.entity.Identifier;
import com.server.jwt.entity.Role;
import com.server.jwt.service.RoleService;
import com.server.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {

        //userService.initRoleAndUser();
    }

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }

    @PostMapping({"/editUserRoleAsDoctor"})
    @PreAuthorize("hasRole('Admin')")
    public String addRoleToExistingUser(@RequestBody Identifier username) {
        return userService.addRoleToExistingUser(username);
    }



}
