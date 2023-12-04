package com.asherbakov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "type_of_request")
@Getter
@Setter
public class TypeOfRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 60, nullable = false)
    private String name;
    @Column(nullable = false)
    private int period;
    @Column(name = "day_type", length = 5, nullable = false)
    private String dayType;
    @Column(length = 20, nullable = false)
    private String associated;
    @OneToMany(mappedBy = "typeOfRequest")
    private Set<Request> requestSet = new HashSet<>();

}
