package com.server.jwt.controller;

import com.server.jwt.entity.MedicalPractitioner;
import com.server.jwt.models.supporting.Identifier;
import com.server.jwt.entity.Role;
import com.server.jwt.service.MedicService;
import com.server.jwt.service.RoleService;
import com.server.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MedicService medicService;

    @PostConstruct
    public void initRoleAndUser() {

        //userService.initRoleAndUser();
    }

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
        /*
        {
           "roleId": 0,
           "roleDescription":"..."
        }
         */
    }

    @PostMapping({"/editUserRoleAsDoctor"})
    @PreAuthorize("hasRole(0)")
    public String addRoleToExistingUser(@RequestBody MedicalPractitioner mp) throws SQLIntegrityConstraintViolationException {

        return medicService.addRoleDoctorToExistingUser(mp);

        /*
            {
                "medicUsername":
                {
                    "userName":"..."(, ...)
                }
                ,
                "medicNumberOfPractice":"nfksafhkls"
            }
         */
    }



}
