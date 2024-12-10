package com.doganmehmet.app.taskmanagementsystem.service.save.dto;

import com.doganmehmet.app.taskmanagementsystem.enums.Role;

public class UpdateUsersDTO {
    public String userName;

    public String password;

    public String email;

    public Role role = Role.USER;
}
