package com.asherbakov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    private int id;
    @Column(length = 20, nullable = false)
    private String username;
    @Column(length = 60, nullable = false)
    private String password;
    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;
    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;
    @Column(name = "middle_name", length = 30)
    private String middleName;
    @Column(length = 30)
    private String email;
    @Column(nullable = false)
    private boolean enabled;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location locationId;
    @ManyToOne
    @JoinColumn(name = "structural_division_id", nullable = false)
    private StructuralDivision structuralDivisionId;
    //    @ManyToOne
    //    @JoinColumn(name = "role_id", nullable = false)
    //    private int roleId;
    // TODO: Добавить зависимости
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet = new HashSet<>();
    @OneToMany(mappedBy = "userId")
    private Set<Request> requestSet = new HashSet<>();
}
