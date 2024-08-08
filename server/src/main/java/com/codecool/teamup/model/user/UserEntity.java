package com.codecool.teamup.model.user;

import com.codecool.teamup.model.guild.Guild;
import com.codecool.teamup.model.role.RoleEntity;
import com.codecool.teamup.model.weapon.Weapon;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private UUID publicId;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String username;

    @Column(nullable = false)
    @Getter
    @Setter
    private String password;

    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private LocalDate birthdate;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private int level;

    @Column(length = 2048)
    @Getter
    @Setter
    private String image;

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private List<Weapon> weapons = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_users",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    @Getter
    @Setter
    private List<RoleEntity> roles = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @Getter
    @Setter
    private Guild guild;

    @PrePersist
    public void prePersist() {
        if (publicId == null) {
            publicId = UUID.randomUUID();
        }
    }

    public UserEntity(String username, String password, String email, LocalDate birthdate, String title, int level, String image, Guild guild) {
        this.publicId = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.title = title;
        this.level = level;
        this.image = image;
        this.guild = guild;
    }

    public UserEntity() {
    }

}
