package com.doganmehmet.app.taskmanagementsystem.repository;

import com.doganmehmet.app.taskmanagementsystem.entity.Projects;
import com.doganmehmet.app.taskmanagementsystem.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProjectRepository extends CrudRepository<Projects, Long> {
    @Query("select distinct p from Projects p left join fetch p.allTasks where p.user = :user")
    Iterable<Projects> findProjectsByUser(@Param("user") Users users);

    //@Query("SELECT p FROM Projects p JOIN FETCH p.user")
    @Query("select p from Projects p left join fetch p.allTasks left join fetch p.user")
    Iterable<Projects> findAllProjects();

    @Query("select p from Projects p left join fetch p.allTasks left join fetch p.user where p.project_id = :id")
    Optional<Projects> findProjectById(Long id);

}
