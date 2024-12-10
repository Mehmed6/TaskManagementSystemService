package com.doganmehmet.app.taskmanagementsystem.service.save.dto;

import com.doganmehmet.app.taskmanagementsystem.enums.Role;

import java.util.Set;

public class SaveUsersDTO {

    public String userName;

    public String password;

    public String email;

    public Role role = Role.USER;
    public Set<SaveProjectsDTO> projects;

}
