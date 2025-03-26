package com.doganmehmet.app.taskmanagementsystem.service.find.dto;

import com.doganmehmet.app.taskmanagementsystem.enums.Role;

import java.util.Set;

public class UsersDTO {

    public String userName;
    public String email;
    public Role role;
    public Set<ProjectsDTO> projects;

}
