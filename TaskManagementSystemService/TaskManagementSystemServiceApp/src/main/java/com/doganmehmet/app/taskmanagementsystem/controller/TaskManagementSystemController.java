package com.doganmehmet.app.taskmanagementsystem.controller;

import com.doganmehmet.app.taskmanagementsystem.service.ServiceHelper;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.AllTasksDTO;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.ProjectsDTO;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.UsersDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveAllTasksDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveProjectsDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveUsersDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/taskmanagementsystem")
public class TaskManagementSystemController {
    private final ServiceHelper m_serviceHelper;

    public TaskManagementSystemController(ServiceHelper serviceHelper)
    {
        m_serviceHelper = serviceHelper;
    }

    @PostMapping("user/save")
    public SaveUsersDTO saveUser(@RequestBody SaveUsersDTO usersDTO)
    {
        m_serviceHelper.saveUser(usersDTO);

        return usersDTO;
    }

    @PostMapping("project/save")
    public SaveProjectsDTO saveProject(@RequestBody SaveProjectsDTO saveProjectsDTO, @RequestParam String userName)
    {
        m_serviceHelper.saveProject(saveProjectsDTO, userName);
        return saveProjectsDTO;
    }

    @PostMapping("task/save")
    public SaveAllTasksDTO saveAllTask(@RequestBody SaveAllTasksDTO allTasksDTO)
    {
        m_serviceHelper.saveAllTask(allTasksDTO);
        return allTasksDTO;
    }

    @GetMapping("find/projects")
    public Iterable<ProjectsDTO> findProjectsByUsername(@RequestParam("u") String username)
    {
        return m_serviceHelper.findProjectsByUsername(username);
    }

    @GetMapping("find/all/users")
    public Iterable<UsersDTO> findAllUsers()
    {
        return m_serviceHelper.findAllUsers();
    }

    @GetMapping("find/all/projects")
    public Iterable<ProjectsDTO> findAllProjects()
    {
        return m_serviceHelper.findAllProjects();
    }

    @GetMapping("find/all/allTasks")
    public Iterable<AllTasksDTO> findAllTasks()
    {
        return m_serviceHelper.findAllTasks();
    }

    @GetMapping("find/user")
    public UsersDTO findUserById(long id)
    {
        return m_serviceHelper.findUserById(id);
    }

    @GetMapping("find/project")
    public ProjectsDTO findProjectById(long id)
    {
        return m_serviceHelper.findProjectById(id);
    }

    @GetMapping("find/allTask")
    public AllTasksDTO findAllTaskById(long id)
    {
        return m_serviceHelper.findAllTaskById(id);
    }

    @DeleteMapping("delete/user")
    public void deleteUserByUsername(@RequestParam("u") String username)
    {
        m_serviceHelper.deleteUserByUsername(username);
    }

    @DeleteMapping("delete/project")
    public void deleteProjectById(long id)
    {
        m_serviceHelper.deleteProjectById(id);
    }

    @DeleteMapping("delete/allTask")
    public void delete(long id)
    {
        m_serviceHelper.deleteAllTaskById(id);
    }

    @PostMapping("update/user")
    public SaveUsersDTO updateUser(@RequestParam("u") String username, @RequestBody SaveUsersDTO usersDTO)
    {
        return m_serviceHelper.updateUserByUserName(username, usersDTO);
    }
}
