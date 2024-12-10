package com.doganmehmet.app.taskmanagementsystem.repository;

import com.doganmehmet.app.taskmanagementsystem.entity.Projects;
import com.doganmehmet.app.taskmanagementsystem.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<Users, Long> {
    boolean existsByUserName(String username);

    //@Query("SELECT u FROM Users u JOIN FETCH u.projects WHERE u.userName = :username")
    //Optional<Users> findByUserName(@Param("username") String username);

    @Query("select distinct u from Users u left join fetch u.projects where u.userName = :userName")
    Optional<Users> findByUserName(@Param("userName") String userName);

    // Iterable<Projects> findProjectsByUserName(String username);
    @Query("select u from Users u left join fetch u.projects")
    Iterable<Users> findAllUsers();

    @Query("select u from Users u left join fetch u.projects where u.user_id = :id")
    Optional<Users> findUserById(@Param("id") long id);

    void deleteUsersByUserName(String userName);

    //Users updateUsersByUserName(String userName, Users user);


}
