package com.codecool.teamup.model.role;

import com.codecool.teamup.model.entity.Role;
import com.codecool.teamup.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "roles")
public class RoleEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Setter
    @Getter
    private String name;

    @ManyToMany(mappedBy = "roles")
    @Setter
    @Getter
    private List<UserEntity> users = new ArrayList<>();

    public RoleEntity(String name) {
        this.name = name;
    }

    public RoleEntity() {
    }
}
