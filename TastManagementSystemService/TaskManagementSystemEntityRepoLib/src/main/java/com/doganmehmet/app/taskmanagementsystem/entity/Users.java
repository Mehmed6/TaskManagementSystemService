package com.doganmehmet.app.taskmanagementsystem.entity;

import com.doganmehmet.app.taskmanagementsystem.enums.Role;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Table
//@EqualsAndHashCode
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public long user_id;

    @Column(name = "user_name", unique = true, nullable = false)
    public String userName;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false)
    public String email;

    @Enumerated(EnumType.STRING)
    public Role role = Role.USER;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Projects> projects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    public Set<AllTasks> allTasks;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Users u && userName.equals(u.userName);
    }

    @Override
    public int hashCode()
    {
        return userName.hashCode();
    }

}
