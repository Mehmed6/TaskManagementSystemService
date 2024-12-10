package com.doganmehmet.app.taskmanagementsystem.dal;

import com.doganmehmet.app.taskmanagementsystem.entity.Projects;
import com.doganmehmet.app.taskmanagementsystem.entity.AllTasks;
import com.doganmehmet.app.taskmanagementsystem.entity.Users;
import com.doganmehmet.app.taskmanagementsystem.repository.IProjectRepository;
import com.doganmehmet.app.taskmanagementsystem.repository.ITaskRepository;
import com.doganmehmet.app.taskmanagementsystem.repository.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityHelper {
    private final IProjectRepository m_projectRepository;
    private final ITaskRepository m_taskRepository;
    private final IUserRepository m_userRepository;

    public EntityHelper(IProjectRepository projectRepository, ITaskRepository taskRepository, IUserRepository userRepository)
    {
        m_projectRepository = projectRepository;
        m_taskRepository = taskRepository;
        m_userRepository = userRepository;
    }

    public Users saveUsers(Users users)
    {
        return m_userRepository.save(users);
    }

    public Projects saveProjects(Projects projects)
    {
        return m_projectRepository.save(projects);
    }

    public AllTasks saveTasks(AllTasks allTasks)
    {
        return m_taskRepository.save(allTasks);
    }

    public Optional<Users> findUserByUserName(String username)
    {
        return m_userRepository.findByUserName(username);
    }

    public Optional<Users> findUserById(long id)
    {
        return m_userRepository.findUserById(id);
    }

    public Optional<Projects> findProjectById(long id)
    {
        return m_projectRepository.findProjectById(id);
    }

    public Optional<AllTasks> findAllTaskById(long id)
    {
        return m_taskRepository.findAllTaskById(id);
    }

    public Iterable<Projects> findProjectsByUsername(String username)
    {
        var user = m_userRepository.findByUserName(username);

        if (user.isEmpty())
            throw new RuntimeException("User not found");

        return m_projectRepository.findProjectsByUser(user.get());
    }

    public Iterable<Users> findAllUsers()
    {
        return m_userRepository.findAllUsers();
    }

    public Iterable<Projects> findAllProjects()
    {
        return m_projectRepository.findAllProjects();
    }

    public Iterable<AllTasks> findAllTasks()
    {
        return m_taskRepository.findAllTasks();
    }

    public void deleteUserByUsername(String username)
    {
        m_userRepository.deleteUsersByUserName(username);
    }

    public void deleteUserById(long id)
    {
        m_userRepository.deleteById(id);
    }

    public void deleteProjectById(long id)
    {
        m_projectRepository.deleteById(id);
    }

    public void deleteAllTaskById(long id)
    {
        m_taskRepository.deleteById(id);
    }

}