package com.asherbakov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10, nullable = false)
    private String code;
    @Column(length = 50, nullable = false)
    private String name;
    @OneToMany(mappedBy = "location")
    private Set<User> userList = new HashSet<>();
    @OneToMany(mappedBy = "location")
    private Set<Request> requestList = new HashSet<>();
}
