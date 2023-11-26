package com.asherbakov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Upr {
    @Id
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    @OneToMany(mappedBy = "uprId")
    private List<StructuralDivision> structuralDivisionList = new ArrayList<>();
}
