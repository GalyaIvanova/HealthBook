package com.server.jwt.controller;

import com.server.jwt.entity.Role;
import com.server.jwt.entity.User;
import com.server.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {

       // userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }


    @PostMapping({"/forAdmin"})
    @PreAuthorize("hasRole(0)")
    public Role forAdmin() {
        Role role=new Role();
        role.setRoleId(0);
        role.setRoleDescription("Admin");
        return role;
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole(2)")
    public String forUser() {
      return "This URL is only accessible to the user";
    }

    @GetMapping({"/forDoctor"})
    @PreAuthorize("hasRole(1)")
    public String forDoctor() {
        return "This URL is only accessible to the doctor";
    }
}
