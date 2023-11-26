package com.asherbakov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purpose_of_request")
@Getter
@Setter
public class PurposeOfRequest {
    @Id
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @OneToMany(mappedBy = "purposeOfRequestId")
    private Set<Request> requestSet = new HashSet<>();
}
