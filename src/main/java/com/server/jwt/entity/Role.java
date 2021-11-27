package com.server.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private int roleId;
    private String roleDescription;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleName) {
        this.roleId = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
