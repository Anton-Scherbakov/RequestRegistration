package com.asherbakov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "structural_division")
@Getter
@Setter
public class StructuralDivision {
    @Id
    private int id;
    @Column(length = 10, nullable = false)
    private String code;
    @Column(length = 150, nullable = false)
    private String name;
    @Column(length = 20)
    private String phone;
    @Column(length = 100)
    private String address;
    @Column(name = "post_index", length = 150)
    private String postIndex;
    @ManyToOne
    @JoinColumn(name = "upr_id")
    private Upr uprId;
    @OneToMany(mappedBy = "structuralDivisionId")
    private List<User> userList = new ArrayList<>();
    @OneToMany(mappedBy = "structuralDivisionId")
    private List<Request> requestList = new ArrayList<>();
    // TODO: Добавить зависимости


}
