package com.shandycasteel.diderot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Set users;

    @ManyToMany(mappedBy = "roles")
    public  Set getUsers() {
        return users;
    }

}
