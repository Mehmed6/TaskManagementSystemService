package com.doganmehmet.app.taskmanagementsystem.service;

import com.doganmehmet.app.taskmanagementsystem.dal.EntityHelper;
import com.doganmehmet.app.taskmanagementsystem.entity.Users;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.AllTasksDTO;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.ProjectsDTO;
import com.doganmehmet.app.taskmanagementsystem.service.find.dto.UsersDTO;
import com.doganmehmet.app.taskmanagementsystem.service.mapper.IFindMapper;
import com.doganmehmet.app.taskmanagementsystem.service.mapper.ISaveMapper;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveAllTasksDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveProjectsDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.SaveUsersDTO;
import com.doganmehmet.app.taskmanagementsystem.service.save.dto.UpdateUsersDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class ServiceHelper {
    private final EntityHelper m_entityHelper;
    private final ISaveMapper m_saveMapper;
    private final IFindMapper m_findMapper;

    private UpdateUsersDTO updateUser(String username, SaveUsersDTO usersDTO)
    {
        var user = m_entityHelper.findUserByUserName(username);

        if (user.isEmpty())
            throw new RuntimeException("User not found");

        var newUser = user.get();

        newUser.userName = usersDTO.userName;
        newUser.email = usersDTO.email;
        newUser.password = usersDTO.password;
        newUser.role = usersDTO.role;

        m_entityHelper.saveUsers(newUser);

        return m_saveMapper.toUpdateUsersDTO(newUser);
    }
    public ServiceHelper(EntityHelper entityHelper, ISaveMapper saveMapper, IFindMapper findMapper)
    {
        m_entityHelper = entityHelper;
        m_saveMapper = saveMapper;
        m_findMapper = findMapper;
    }

    public SaveUsersDTO saveUser(SaveUsersDTO saveUsersDTO)
    {
        var user = m_saveMapper.toUsers(saveUsersDTO);

        return m_saveMapper.toSaveUsersDTO(m_entityHelper.saveUsers(user));
    }

    public SaveProjectsDTO saveProject(SaveProjectsDTO saveProjectsDTO, String userName)
    {
        var user = m_entityHelper.findUserByUserName(userName);

        if (user.isEmpty())
            throw new RuntimeException("User not found");

        var project = m_saveMapper.toProjects(saveProjectsDTO);
        project.user = user.get();

        m_entityHelper.saveProjects(project);

        return m_saveMapper.toSaveProjectsDTO(project);
    }

    public SaveAllTasksDTO saveAllTask(SaveAllTasksDTO saveAllTasksDTO)
    {
        var optProject = m_entityHelper.findProjectById(saveAllTasksDTO.projectId);

        if (optProject.isEmpty())
            throw new RuntimeException("Project not found");

        var allTasks = m_saveMapper.toAllTasks(saveAllTasksDTO);

        allTasks.project = optProject.get();
        allTasks.user = optProject.get().user;

        return m_saveMapper.toSaveAllTasksDTO(m_entityHelper.saveTasks(allTasks));

    }

    public Iterable<ProjectsDTO> findProjectsByUsername(String username)
    {
        return StreamSupport.stream(m_entityHelper.findProjectsByUsername(username).spliterator(), false)
                .map(m_findMapper::toProjectsDTO)
                .toList();
    }

    public Iterable<ProjectsDTO> findAllProjects()
    {
        return StreamSupport.stream(m_entityHelper.findAllProjects().spliterator(), false)
                .map(m_findMapper::toProjectsDTO)
                .toList();
    }

    public Iterable<UsersDTO> findAllUsers()
    {
        return m_findMapper.toUsersDTOs(m_entityHelper.findAllUsers());
    }

    public Iterable<AllTasksDTO> findAllTasks()
    {
        return StreamSupport.stream(m_entityHelper.findAllTasks().spliterator(), false)
                .map(m_findMapper::toAllTasksDTO)
                .toList();
    }

    public UsersDTO findUserById(long id)
    {
        var user = m_entityHelper.findUserById(id);

        if (user.isEmpty())
            throw new RuntimeException("User not found");

        return m_findMapper.toUsersDTO(user.get());
    }

    public ProjectsDTO findProjectById(long id)
    {
        var project = m_entityHelper.findProjectById(id);

        if (project.isEmpty())
            throw new RuntimeException("Project not found");

        return m_findMapper.toProjectsDTO(project.get());
    }

    public AllTasksDTO findAllTaskById(long id)
    {
        var allTasks = m_entityHelper.findAllTaskById(id);

        if (allTasks.isEmpty())
            throw new RuntimeException("Task not found");

        return m_findMapper.toAllTasksDTO(allTasks.get());
    }

    @Transactional
    public void deleteUserByUsername(String username)
    {
        m_entityHelper.deleteUserByUsername(username);
    }

    @Transactional
    public void deleteProjectById(long id)
    {
        m_entityHelper.deleteProjectById(id);
    }

    @Transactional
    public void deleteAllTaskById(long id)
    {
        m_entityHelper.deleteAllTaskById(id);
    }

    public UpdateUsersDTO updateUserByUserName(String username, SaveUsersDTO usersDTO)
    {
       return updateUser(username, usersDTO);
    }

}
