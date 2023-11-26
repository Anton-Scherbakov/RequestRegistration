package com.asherbakov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Location {
    @Id
    private int id;
    @Column(length = 10, nullable = false)
    private String code;
    @Column(length = 50, nullable = false)
    private String name;
    @OneToMany(mappedBy = "locationId")
    private Set<User> userList = new HashSet<>();
    @OneToMany(mappedBy = "locationId")
    private Set<Request> requestList = new HashSet<>();
}
