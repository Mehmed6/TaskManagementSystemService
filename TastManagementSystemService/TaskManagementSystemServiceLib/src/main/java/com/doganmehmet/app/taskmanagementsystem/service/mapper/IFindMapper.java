package com.doganmehmet.app.taskmanagementsystem.service.mapper;

import com.doganmehmet.app.taskmanagementsystem.entity.AllTasks;
import com.doganmehmet.app.taskmanagementsystem.entity.Projects;
import com.doganmehmet.app.taskmanagementsystem.entity.Users;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.AllTasksDTO;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.ProjectsDTO;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.UsersDTO;
import org.mapstruct.Mapper;
import org.springframework.format.datetime.DateFormatter;

import java.time.format.DateTimeFormatter;
import java.util.Set;

@Mapper(implementationName = "FindMapperImpl", componentModel = "spring")
public interface IFindMapper {
    Iterable<UsersDTO> toUsersDTOs(Iterable<Users> users);

    UsersDTO toUsersDTO(Users user);

    Users toUsers(UsersDTO usersDTO);
    Iterable<ProjectsDTO> toProjectsDTOs(Iterable<Projects> projects);
    Set<AllTasksDTO> toAllTasksDTOs(Iterable<AllTasks> allTasks);

    Set<AllTasks> toAllTasks(Iterable<AllTasksDTO> allTasksDTO);

    default ProjectsDTO toProjectsDTO(Projects project)
    {
        var projectDTO = new ProjectsDTO();
        projectDTO.name = project.name;
        projectDTO.description = project.description;
        projectDTO.allTasks = toAllTasksDTOs(project.allTasks);
        projectDTO.userName = project.user.userName;

        return projectDTO;
    }

    default AllTasksDTO toAllTasksDTO(AllTasks allTask)
    {
        var allTasksDTO = new AllTasksDTO();
        allTasksDTO.title = allTask.title;
        allTasksDTO.description = allTask.description;
        allTasksDTO.status = allTask.status;
        allTasksDTO.deadline = allTask.deadline;
        allTasksDTO.projectId = allTask.project.project_id;
        allTasksDTO.userName = allTask.project.user.userName;

        return allTasksDTO;
    }
}
