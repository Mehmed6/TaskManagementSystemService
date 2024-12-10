package com.doganmehmet.app.taskmanagementsystem.service.mapper;

import com.doganmehmet.app.taskmanagementsystem.entity.AllTasks;
import com.doganmehmet.app.taskmanagementsystem.entity.Projects;
import com.doganmehmet.app.taskmanagementsystem.entity.Users;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveAllTasksDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveProjectsDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveUsersDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.UpdateUsersDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "SaveMapperImpl", componentModel = "spring")
public interface ISaveMapper {
    Users toUsers(SaveUsersDTO saveUsersDTO);
    SaveUsersDTO toSaveUsersDTO(Users users);
    Projects toProjects(SaveProjectsDTO saveProjectsDTO);
    SaveProjectsDTO toSaveProjectsDTO(Projects projects);
    AllTasks toAllTasks(SaveAllTasksDTO saveAllTasksDTO);
    SaveAllTasksDTO toSaveAllTasksDTO(AllTasks allTasks);

    UpdateUsersDTO toUpdateUsersDTO(Users users);
}
