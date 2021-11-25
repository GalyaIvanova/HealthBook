package com.server.jwt.service;

import com.server.jwt.dao.RoleDao;
import com.server.jwt.dao.UserDao;
import com.server.jwt.entity.Identifier;
import com.server.jwt.entity.Role;
import com.server.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }


}
