package com.best.great.entity;


import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
