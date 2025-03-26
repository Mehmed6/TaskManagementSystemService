package com.doganmehmet.app.taskmanagementsystem.repository;

import com.doganmehmet.app.taskmanagementsystem.entity.AllTasks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITaskRepository extends CrudRepository<AllTasks, Long> {

    @Query("select at from AllTasks at left join fetch at.project left join fetch at.user")
    Iterable<AllTasks> findAllTasks();

    @Query("select at from AllTasks at left join fetch at.project where at.id = :id")
    Optional<AllTasks> findAllTaskById(Long id);

}
